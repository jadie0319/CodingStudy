package examples.daoexam.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DBConfig {

    private String driverClassName = "com.mysql.cj.jdbc.Driver";

    private String url="jdbc:mysql://localhost:3306/fastcampus?serverTimezone=Asia/Seoul&useSSL=false";

    private String username = "root";

    private String password = "1234";

//    private String url="jdbc:mysql://spring20181026.mysql.database.azure.com/oneweekboard?serverTimezone=Asia/Seoul&useSSL=false";
//
//    private String username = "spring@spring20181026";
//
//    private String password = "school1017!";

//    @Bean
//    public DataSource dataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        DatabasePopulatorUtils.execute(createDatabasePopulator(), dataSource);
        return dataSource;
    }
    private DatabasePopulator createDatabasePopulator() {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.setContinueOnError(true);
        databasePopulator.addScript(new ClassPathResource("schema.sql"));
        return databasePopulator;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }


}
