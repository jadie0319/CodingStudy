package examples.dice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExam01 {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("dicegame.xml");

        Game game = (Game)context.getBean("game");
        game.play();

    }
}
