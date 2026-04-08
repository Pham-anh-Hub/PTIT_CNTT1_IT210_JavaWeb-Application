# SECURITY REPORT - EVENT SEARCH SYSTEM

### 1. XSS và Tầm quan trọng của c:out
* **XSS là gì?** Là lỗ hổng cho phép kẻ tấn công chèn mã script độc hại (JavaScript) vào trang web để thực thi trên trình duyệt người dùng.
* **Tại sao `<c:out>` an toàn hơn?** Vì nó tự động **escape** (mã hóa) các ký tự đặc biệt của HTML (như `<`, `>`), khiến trình duyệt hiểu đó là văn bản thuần thay vì lệnh điều khiển.
* **So sánh HTML Output với input `<script>alert(1)</script>`:**
    * Dùng `${keyword}`: `<script>alert(1)</script>` (Trình duyệt thực thi mã, hiện popup).
    * Dùng `<c:out>`: `&lt;script&gt;alert(1)&lt;/script&gt;` (Trình duyệt chỉ hiển thị dạng chữ).

### 2. So sánh c:if và c:choose
* **Khác biệt:**
    * `<c:if>`: Chỉ kiểm tra một điều kiện đơn (Đúng/Sai), không có nhánh "Else".
    * `<c:choose>`: Cấu trúc nhiều nhánh (tương đương if-elseif-else), xử lý các trường hợp loại trừ lẫn nhau.
* **Lựa chọn:** Nên dùng **`<c:choose>`** cho phần "Giá vé" và "Vé còn lại".
* **Tại sao?** Vì dữ liệu có nhiều trạng thái logic khác nhau (Miễn phí/Có phí; Hết vé/Sắp hết/Còn vé). Dùng `<c:choose>` giúp code sạch, dễ đọc và tránh lặp lại điều kiện ngược.

### 3. Ưu điểm của c:url
* **Vấn đề giải quyết:** Tự động quản lý đường dẫn tương đối và tự động thêm **Context Path** của ứng dụng vào URL.
* **So với hardcode:** Hardcode `/events/1/book` sẽ bị lỗi nếu ứng dụng không được triển khai tại thư mục gốc (root).
* **Khi deploy với context path `/ticketing`:**
    * **Hardcode:** Link vẫn là `/events/1/book` -> Bị lỗi 404 (do thiếu tiền tố `/ticketing`).
    * **`<c:url>`:** Tự động sinh ra `/ticketing/events/1/book` -> Hoạt động chính xác trên mọi môi trường.