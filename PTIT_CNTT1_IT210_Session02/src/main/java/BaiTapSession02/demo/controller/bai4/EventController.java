package BaiTapSession02.demo.controller.bai4;

import BaiTapSession02.demo.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class EventController {



    @GetMapping("/events/search")
    public String search(@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword, Model model) {
        // mock — đại diện cho kết quả tìm kiếm
         List<Event> events = new ArrayList<>();

        events.add(new Event(1, "Hội thảo 1", "2026-06-15", 250000.0, 50));
        events.add(new Event(2, "Workshop xss", "2026-07-20", 0.0, 0));
        events.add(new Event(3, "Tech Summit Hà Nội", "2026-08-10", 1500000.0, 200));

        // 1. Logic lọc dữ liệu (Business Logic)
        String searchKey = keyword.trim().toLowerCase();

        List<Event> filteredResults = events.stream().filter(e -> e.getName().toLowerCase().contains(searchKey)).collect(Collectors.toList());

        // 2. Logic tính toán bổ sung (nếu cần)
        int totalFound = filteredResults.size();

        // 3. Đẩy dữ liệu sang View (JSP)
        model.addAttribute("events", filteredResults);
        model.addAttribute("keyword", keyword); // Gửi lại keyword gốc để hiển thị trong ô input
        model.addAttribute("totalFound", totalFound);

        return "bai4/events.search";
    }
}
