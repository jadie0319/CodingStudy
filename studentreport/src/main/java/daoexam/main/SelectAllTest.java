package daoexam.main;

import daoexam.config.ApplicationConfig;
import daoexam.dao.RoleDao;
import daoexam.dto.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SelectAllTest {

    public static void main(String[] args) throws Exception {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        RoleDao roleDao =ac.getBean(RoleDao.class);
        List<Role> list = roleDao.selectAll();

        for(Role role: list) {
            System.out.println(role);
        }
    }



}
