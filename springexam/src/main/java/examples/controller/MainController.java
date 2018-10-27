package examples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    public MainController() {
        System.out.println("main controller");
    }

    @RequestMapping("/")
    public String main() {
        return "index";
    }

}
