package BaiTapSession02.demo.controller.bai3;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String showLoginForm(HttpSession session) {
        // Nếu đã đăng nhập rồi thì vào thẳng /orders, không hiện login nữa
        if (session.getAttribute("staffName") != null) {
            return "redirect:/orders";
        }
        return "bai3/login"; // Trả về login.jsp
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam ("username") String username,  // Thêm ("username")
                              @RequestParam ("password") String password,
                                HttpSession session, RedirectAttributes redirectAttr){
        if((username.equals("admin") && password.equals("admin123")) || (username.equals("staff") && password.equals("staff123"))){
            session.setAttribute("staffName", username);
            session.setAttribute("role", username.contains("admin") ? "admin" : "staff");
            return "redirect:/orders";
        }
        // đẩy thông báo lỗi vào scope
        // sử dụng addFlashAttribute để lưu dữ liệu tạm thời vào session trước khi redirect rồi tự động xóa khi có request tiếp theo
        // -- thông báo lỗi chỉ xuất hiện 1 lần duy nhất
        redirectAttr.addFlashAttribute("errorMessage", "Sai tài khoản hoặc mật khẩu");
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate(); // Xóa sạch các attribute đã lưu vào session trước đó khỏi bộ nhớ
                            // Đóng/xóa session
        return "redirect:/login";
    }
}
