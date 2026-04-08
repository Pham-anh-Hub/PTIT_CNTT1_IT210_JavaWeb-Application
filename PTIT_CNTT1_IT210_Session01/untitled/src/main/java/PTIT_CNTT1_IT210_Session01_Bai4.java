// Cách tiêm tối ưu nhất - Constructor Injection
// So sánh 2 cách tiêm: - Constructor Injection: + Rõ ràng dependency
//                                               + Dễ test
//                                               + An toàn (không null)
//                                               + Dễ xử lý lỗi SMS riêng
//                                          ==> Khuyến nghị & ưu tiên sử dụng
//                       - Field Injection:  + Dependency không rõ ràng
//                                           + Cũng có hỗ trợ unit test nhưng khó an toàn
//                                           + Có thể gây null exception
//                                           + Có hỗ trợ xử lý Dep Circle
//                                          ==> Không khuyến khích sử dụng
// ==>   Constructor Injection là lựa chọn tối ưu vì rõ ràng, an toàn và dễ xử lý lỗi hơn Field Injection khi SMS có thể bị lỗi.



public class PTIT_CNTT1_IT210_Session01_Bai4 {
}
