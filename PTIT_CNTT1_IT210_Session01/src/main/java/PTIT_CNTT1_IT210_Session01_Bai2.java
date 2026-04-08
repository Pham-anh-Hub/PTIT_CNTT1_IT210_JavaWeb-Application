// Phân tích:
// Nguyên nhân: Đoạn code sử dụng Annotation @Component, mà không có khai báo scope
//      --> Spring mặc định Scope sẽ là Singleton
// --> Dẫn đến chỉ có 1 instance duy nhật cho toàn hệ thống <--> Tất cả máy trạm (user)
// đều dùng chung object - phiên chơi này



public class PTIT_CNTT1_IT210_Session01_Bai2 {
}
