# Báo cáo phân tích
### 1. Tại sao thông báo lỗi đăng nhập phải lưu vào Request Scope mà không phải Session Scope?
 - Thông báo lỗi là dữ liệu mang tính tạm thời và ngắn hạn. Nó chỉ có giá trị ngay tại thời điểm người dùng thực hiện hành vi sai (nhập sai mật khẩu) và cần hiển thị ngay lập tức sau đó.
 - Nếu lưu nhầm vào Sesion Scope:
   - Thông báo lỗi sẽ tồn tại vĩnh viễn trong Session cho đến khi bị ghi đè hoặc Session kết thúc.
   - Nếu người dùng đăng nhập sai, sau đó tải lại trang hoặc mở một tab mới, thông báo lỗi vẫn sẽ luôn xuất hiện dù họ chưa thực hiện hành động sai nào mới.
   - Dẫn đến trải nghiệm người dùng kém
   - lãng phí tài nguyên 
### 2. Tại sao totalViewCount phải lưu vào- Application Scope? Nếu lưu vào Session Scope, mỗi nhân viên sẽ thấy con số khác nhau như thế nào?
 - Lý do chọn application scope: Yêu cầu của hệ thống là đếm tổng số đơn hàng được xem trên toàn hệ thống (Tất cả nhân viên có thể xem)
 - Nếu lưu vào Session Scope:
   - Bộ đếm sẽ bị cô lập theo từng nhân viên.

### 3. Race Condition là gì và tại sao đoạn code dưới đây có thể gây ra Race Condition trong môi trường nhiều người dùng đồng thời? Đề xuất cách phòng tránh:
 - Race Condition (Điều kiện chạy đua) xảy ra khi nhiều luồng (threads/users) cùng truy cập và cố gắng thay đổi một dữ liệu dùng chung tại cùng một thời điểm. Kết quả cuối cùng phụ thuộc vào việc "ai chạy nhanh hơn", từ đó khiến dữ liệu bị sai lệch?
 - Phân tích lỗi:

   // 1: Đọc giá trị từ bộ nhớ
   Integer count = (Integer) application.getAttribute("totalViewCount");
   if (count == null) count = 0;

   // 2: Tăng giá trị trong RAM của Thread hiện tại
   count++;

   //  3: Ghi ngược giá trị trở lại bộ nhớ dùng chung
   application.setAttribute("totalViewCount", count);

--> cải thiện, sử dụng đồng bộ hoặc Atomatic Integer
