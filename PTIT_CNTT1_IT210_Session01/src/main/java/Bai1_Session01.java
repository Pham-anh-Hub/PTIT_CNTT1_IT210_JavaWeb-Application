// Phân tích:
// Vấn đề: " // Lỗi: Tự khởi tạo thủ công (Hard-code dependency)
//        this.gateway = new InternalPaymentGateway(); "

// - RechargeService đang tự khởi tạo ra InternalPaymentGateway thủ công qua từ khóa new,
//      thay vì nhận từ bên ngoài - vi phạm cơ chế IoC
// - Tự tạo và tự quản lý dependency của nó - vi phạm nguyên lý DI
// --> Dẫn đến: Không linh hoạt, khó mở rông, khó kiểm thử, vi phạm nguyên lý IoC

public class Bai1_Session01 {


}
