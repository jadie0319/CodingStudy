package examples.daoexam.dao;


import examples.daoexam.dto.Member;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Map;

@Repository
public class MemberDao {
    private NamedParameterJdbcTemplate jdbc;
    // insert
    private SimpleJdbcInsert insertAction;


    public MemberDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);

        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("member")
                .usingGeneratedKeyColumns("id"); // 자동생성되는 칼럼(id)이 있을경우
    }


    public Long addMember(Member member){

        SqlParameterSource params = new BeanPropertySqlParameterSource(member);

        // id가 자동으로 증가하지 않을 경우에는
        // 다음과 같이 execute() 메소드를 사용한다.
        // insertAction.execute(Map) or insertAction.execute(SqlParameterSource)
        // insert가 실행되고, 자동으로 증가한 id 값을 리턴한다.
        return insertAction.executeAndReturnKey(params).longValue();
    }

    public Member getMember(String email) {
        String sql = "select id, name, email, password, regdate     " +
                "from member where email = :email";
        try {
            RowMapper<Member> mapper = BeanPropertyRowMapper.newInstance(Member.class);
            Map<String, ?> params = Collections.singletonMap("email", email);
            return jdbc.queryForObject(sql,params,mapper);
        } catch(Exception e) {
            return null;
        }

    }
}
