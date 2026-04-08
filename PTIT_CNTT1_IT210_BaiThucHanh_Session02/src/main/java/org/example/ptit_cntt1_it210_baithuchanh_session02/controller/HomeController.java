package org.example.ptit_cntt1_it210_baithuchanh_session02.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

// Đánh dấu là Controller (trang chủ)
@Controller
// Định nghĩa các
@RequestMapping("/home")// ngách, điều hướng
public class HomeController {
    // Định nghĩa các HTTP Method (GET | POST | ...)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "redirect:/home/cntt4";
    }

    @RequestMapping(value = "/cntt4", method = RequestMethod.GET)
    public String cntt4_list(Model model){
        // Model để gửi dữ liệu sang view
        model.addAttribute("fullname", "Tran Van C");

        // Gửi danh sách sang
        List<String> names = new ArrayList<>(
                List.of("Nguyễn Đăng Khoa", "Trần Khánh Linh", "Lê Trung Kiên", "Nguyễn Quốc Bảo", "Lê Thanh Bình")
        );
        model.addAttribute("ds_ten", names);
        return "hn-ks24-cntt4";
    }
}
