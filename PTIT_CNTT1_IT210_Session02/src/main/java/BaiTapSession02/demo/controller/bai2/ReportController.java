package BaiTapSession02.demo.controller.bai2;

import BaiTapSession02.demo.model.Student;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class ReportController {

    @Autowired
    private ServletContext application;

    @GetMapping("/report")
    public String showReport(Model model) {

        // Áp dụng đồng bộ xử  lý bộ đếm lượt xem toàn hệ thống
        synchronized (application) {
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if (count == null) {
                count = 0;
            }
            count++;
            application.setAttribute("totalViewCount", count);
            // Đảm bảo giá trị mới nhất được gửi thẳng vào Request hiện có
            model.addAttribute("currentViewCount", count);
        }

        List<Student> students = new ArrayList<>();
        students.add(new Student("Nguyễn Thị Bình", 92));
        students.add(new Student("Trần Minh Khoa", 75));
        students.add(new Student("Lê Thu Hà", 55));
        students.add(new Student("Phạm Duy An", 48));

        model.addAttribute("studentList", students);
        model.addAttribute("reportTitle", "Báo cáo điểm cuối kỳ");
        return "bai2/report";
    }
}
