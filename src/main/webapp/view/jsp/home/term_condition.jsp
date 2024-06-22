<%-- 
    Document   : term_condition
    Created on : Jun 15, 2024, 9:00:14 PM
    Author     : lmao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../../common/web/add_css.jsp"%>
        <title>Term and Condition</title>
    </head>
    <body>
        <div class="container">
            <%@include file="../../common/web/header.jsp"%>
            <div style="margin-top: 80px;">
                <h3>ĐIỀU KIỆN &amp; ĐIỀU KHOẢN</h3>
                <p>Chào mừng quý khách đến với trang web bán quần áo của chúng tôi. Khi sử dụng trang web này, quý khách đồng ý với các điều khoản và điều kiện sau đây. Vui lòng đọc kỹ trước khi tiếp tục.</p>
                <h4>1. Giới thiệu</h4>
                <p>Trang web này được vận hành bởi ClothesShop. Bằng cách truy cập và sử dụng trang web này, quý khách đồng ý tuân thủ các điều khoản và điều kiện dưới đây.</p>
                <h4>2. Quyền sở hữu trí tuệ</h4>
                <p>Toàn bộ nội dung trên trang web, bao gồm nhưng không giới hạn bởi văn bản, hình ảnh, logo, biểu tượng và phần mềm, là tài sản của ClothesShop và được bảo vệ bởi luật bản quyền và các luật sở hữu trí tuệ khác.</p>
                <h4>3. Đăng ký tài khoản</h4>
                <ul>
                    <li>Quý khách có thể đăng ký tài khoản trên trang web để sử dụng một số tính năng nhất định.</li>
                    <li>Quý khách phải cung cấp thông tin chính xác và đầy đủ khi đăng ký.</li>
                    <li>Quý khách chịu trách nhiệm bảo mật thông tin tài khoản của mình và mọi hoạt động xảy ra dưới tài khoản của quý khách.</li>
                </ul>
                <h4>4. Sản phẩm và giá cả</h4>
                <ul>
                    <li>Chúng tôi cố gắng cung cấp thông tin sản phẩm và giá cả chính xác nhất có thể.</li>
                    <li>Giá cả có thể thay đổi mà không cần thông báo trước.</li>
                    <li>Màu sắc và hình ảnh sản phẩm trên trang web có thể khác so với sản phẩm thực tế do các yếu tố kỹ thuật.</li>
                </ul>
                <h4>5. Đặt hàng và thanh toán</h4>
                <ul><li>Đơn hàng của quý khách sẽ được xác nhận qua email sau khi đặt hàng thành công.</li>
                    <li>Chúng tôi chấp nhận các hình thức thanh toán như thẻ tín dụng, chuyển khoản ngân hàng, và các phương thức khác được liệt kê trên trang web.</li>
                    <li>Nếu có vấn đề với thanh toán, chúng tôi sẽ liên hệ với quý khách để giải quyết.</li>
                </ul>
                <h4>6. Giao hàng và vận chuyển</h4>
                <ul>
                    <li>Chúng tôi cung cấp các dịch vụ giao hàng trong và ngoài nước.</li>
                    <li>Thời gian giao hàng có thể thay đổi tùy thuộc vào vị trí và phương thức vận chuyển.</li>
                    <li>Phí vận chuyển sẽ được thông báo trước khi quý khách hoàn tất đơn hàng.</li>
                </ul>
                <h4>7. Đổi trả và hoàn tiền</h4>
                <ul>
                    <li>Quý khách có thể đổi hoặc trả sản phẩm trong vòng 15 ngày kể từ ngày nhận hàng.</li>
                    <li>Sản phẩm phải còn nguyên tem, nhãn mác, chưa qua sử dụng và trong tình trạng như khi nhận hàng.</li>
                    <li>Phí vận chuyển đổi trả sẽ do quý khách chịu, trừ khi sản phẩm bị lỗi do nhà sản xuất.</li>
                </ul>
                <h4>8. Bảo mật thông tin</h4>
                <ul><li>Chúng tôi cam kết bảo mật thông tin cá nhân của quý khách.</li>
                    <li>Thông tin của quý khách sẽ không được tiết lộ cho bên thứ ba trừ khi có sự đồng ý của quý khách hoặc theo yêu cầu của pháp luật.</li>
                </ul>
                <h4>9. Giới hạn trách nhiệm</h4>
                <ul>
                    <li>Chúng tôi không chịu trách nhiệm về bất kỳ tổn thất hay thiệt hại nào phát sinh từ việc sử dụng trang web này.</li>
                    <li>Chúng tôi không bảo đảm rằng trang web sẽ không có lỗi, virus hay các thành phần có hại khác.</li>
                </ul>
                <h4>10. Điều chỉnh điều khoản</h4>
                <ul>
                    <li>Chúng tôi có quyền điều chỉnh các điều khoản và điều kiện này bất cứ lúc nào mà không cần thông báo trước.</li>
                    <li>Quý khách nên thường xuyên kiểm tra điều khoản và điều kiện để cập nhật các thay đổi mới nhất.</li>
                </ul>
                <h4>11. Liên hệ</h4>
                <p>Nếu có bất kỳ câu hỏi nào về các điều khoản và điều kiện này, vui lòng liên hệ với chúng tôi qua ClothesShop@gmail.com hoặc 0 (1234) 567 789.</p>
                <hr>
                <p>Các điều khoản và điều kiện này được cập nhật lần cuối vào 21/6/2024.</p>
            </div>
        </div>
    </body>
</html>
