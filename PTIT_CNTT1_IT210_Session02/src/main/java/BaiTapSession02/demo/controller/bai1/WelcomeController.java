package BaiTapSession02.demo.controller.bai1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class WelcomeController {

    @GetMapping("/welcome")
    public String showWelcome(Model model) {
        model.addAttribute("staffName", "Nguyễn Văn An");
        model.addAttribute("department", "Phòng Kỹ thuật");
        return "bai1/welcome";   // ViewResolver phải ghép: /WEB-INF/views/welcome.jsp
    }
}
