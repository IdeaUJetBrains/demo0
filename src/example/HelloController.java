package example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Value("${spring.application.name}")
    String appName;

    @RequestMapping("/")
    public String hello() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/homepage")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

}
