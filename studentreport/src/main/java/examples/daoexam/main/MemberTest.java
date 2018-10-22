package examples.daoexam.main;

import examples.daoexam.config.ApplicationConfig;
import examples.daoexam.dto.Member;
import examples.daoexam.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class MemberTest {
    public static void main(String[] args) throws Exception {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        MemberService memberService = context.getBean(MemberService.class);

//        Member member = new Member();
//        member.setEmail("heheaqq@naver.com");
//        member.setName("kakada");
//        member.setPassword("11234");
//        member.setRegdate(new Date());
//
//        Member result = memberService.addMember(member);
//        System.out.println(result);


        Member member2 = memberService.getMember("hehe@naver.com");
        System.out.println(member2);


    }
}
