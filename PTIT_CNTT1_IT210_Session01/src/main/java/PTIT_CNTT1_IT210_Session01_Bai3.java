// Phân tích:
// Dữ liệu đâu vào - input: - userId: mã người dùng - từ đây có thể kiểm tra ra tên, khu vực ngồi, số dư
//                          - dishId: mã món - kiểm tra được tên món, tồn kho, giá
//                          - quantity: Số lượng người dùng muốn gọi từ món trên

//                 - output: - Đặt món thành công -> Trừ tiền của user thành công
//                                                -> Giảm số lượng tồn kho

// Các bước xử lý:
//    - yêu cầu nhập vào từ người dùng (userId, dishId, quantity)
//    - Kiểm tra tồn kho của món ăn: + Còn - tiếp tục xử lý
//                                   + Hết - trả về thông báo
//    - Lấy giá của món:   giá * số lượng => tổng tiền
//                                        => Kiểm tra số dư người dùng: + số dư < tổng tiền --> thông báo không đủ
//                                                                      + số dư >= tổng tiền --> giảm số lượng tồn kho
//                                                                                           --> trừ số dư của user
//                                                       (Áp dụng transaction) - không bước nào bị rollback - trả về thông báo thành công



public class PTIT_CNTT1_IT210_Session01_Bai3 {
}
