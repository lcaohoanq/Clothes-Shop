package clothingstore.module.email;

import clothingstore.constant.Regex;
import clothingstore.utils.EnvUtil;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

    private final String eFrom = EnvUtil.get("MAIL_HOST");
    private final String ePass = EnvUtil.get("MAIL_PASS");

    // check email
    public boolean isValidEmail(String email) {
        return Pattern.compile(Regex.emailRegex, Pattern.CASE_INSENSITIVE).matcher(email).matches();
    }

    private Authenticator getAuthenticator() {
        return new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(eFrom, ePass);
            }
        };
    }

    public void sendEmail(String subject, String messgage, String to) {
        // Properties
        Properties props = new Properties();

        //Su dung server nao de gui mail- smtp host
        props.put("mail.smtp.host", EnvUtil.get("SMTP_HOST"));

        // TLS 587 SSL 465
        props.put("mail.smtp.port", EnvUtil.get("SMTP_PORT"));

        // dang nhap
        props.put("mail.smtp.auth", EnvUtil.get("SMTP_AUTH"));

        props.put("mail.smtp.starttls.enable", EnvUtil.get("SMTP_STARTTLS_ENABLE"));

        //dang nhap tai khoan
        // phien lam viec
        Session session = Session.getInstance(props, getAuthenticator());

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML, charset=UTF-8");
            msg.setFrom(new InternetAddress(eFrom));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            // tieu de
            msg.setSubject(subject, "UTF-8");
            // Noi dung
            msg.setContent(messgage, "text/html; charset=UTF-8");
            // Gui email
            Transport.send(msg);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String subjectContact(String name) {
        return "ClothesShop - Chào " + name + " cảm ơn bạn vì đã liên hệ với chúng tôi";
    }
    
    public String subjectNewOrder() {
        return "ClothesShop - Đặt hàng thành công";
    }

    public String subjectSubsribe() {
        return "ClothesShop - bạn có thông báo mới";
    }

    public String subjectForgotPass() {
        return "ClothesShop - mã code xác nhận";
    }

    public String messageContact(String name) {
        return "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>Email Contact</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    </head>\n"
                + "    <body style=\"font-family:arial, helvetica, sans-serif;\n"
                + "          font-size:14px;\n"
                + "          line-height:20px;\n"
                + "          color: #444;\n"
                + "          background:#f2f2f2;\">\n"
                + "        <table width=\"100%\" class=\"wrapper\" style=\" margin:20px 0;\">\n"
                + "            <tr>\n"
                + "                <td class=\"container\"> \n"
                + "                    <div class=\"content\" style=\"display: block!important;\n"
                + "                         max-width: 600px!important;\n"
                + "                         margin: 0 auto!important;\n"
                + "                         clear: both!important;\n"
                + "                         background:white;\">\n"
                + "                        <table cellspacing=\"20\" width=\"100%\">\n"
                + "                            <tr>\n"
                + "                                <td>\n"
                + "                                    <p class=\"brand\" style=\"margin:5px 0 0; font-size:30px;\n"
                + "                                       margin:20px 0;\"><span style=\"color:#e67e22;\">Clothes</span>Shop</p> \n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                            <tr>\n"
                + "                                <td class=\"border\" style=\"border-top:2px solid #e67e22;\n"
                + "                                    border-bottom:2px solid #e67e22;\">\n"
                + "                                    <h1 style=\" font-size:24px;\n"
                + "                                        color:#e67e22;\n"
                + "                                        margin:30px 0;\">CẢM ƠN VÌ BẠN ĐÃ LIÊN HỆ CLOTHES SHOP</h1>\n"
                + "                                    <p style=\"margin:5px 0 0\">Chào " + name + ",</p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Cảm ơn bạn đã tin tưởng và sử dụng dịch vụ, chính sách mua hàng của chúng tôi. </p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Chúng tôi đã nhận được yêu cầu của bạn, chúng tôi sẽ gửi đến bạn thông tin sớm nhất. </p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Nếu bạn cần hỗ trợ gấp hãy liên hệ hotline: 1900 9090. </p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Xin cảm ơn. </p>\n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                            <tr class=\"contact\" style=\"font-size:11px; color:#999;\">\n"
                + "                                <td align=\"center\"> \n"
                + "                                    Clothes Shop Ho Chi Minh - 0123 456 789 - clothesshop@gmail.com\n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                        </table>\n"
                + "                    </div> \n"
                + "                </td>\n"
                + "            </tr>\n"
                + "        </table>\n"
                + "    </body>\n"
                + "</html>\n";
    }
    
    public String messageNewOrder(String name, int sl, double total) {
        return "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>Email Contact</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    </head>\n"
                + "    <body style=\"font-family:arial, helvetica, sans-serif;\n"
                + "          font-size:14px;\n"
                + "          line-height:20px;\n"
                + "          color: #444;\n"
                + "          background:#f2f2f2;\">\n"
                + "        <table width=\"100%\" class=\"wrapper\" style=\" margin:20px 0;\">\n"
                + "            <tr>\n"
                + "                <td class=\"container\"> \n"
                + "                    <div class=\"content\" style=\"display: block!important;\n"
                + "                         max-width: 600px!important;\n"
                + "                         margin: 0 auto!important;\n"
                + "                         clear: both!important;\n"
                + "                         background:white;\">\n"
                + "                        <table cellspacing=\"20\" width=\"100%\">\n"
                + "                            <tr>\n"
                + "                                <td>\n"
                + "                                    <p class=\"brand\" style=\"margin:5px 0 0; font-size:30px;\n"
                + "                                       margin:20px 0;\"><span style=\"color:#e67e22;\">Clothes</span>Shop</p> \n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                            <tr>\n"
                + "                                <td class=\"border\" style=\"border-top:2px solid #e67e22;\n"
                + "                                    border-bottom:2px solid #e67e22;\">\n"
                + "                                    <h1 style=\" font-size:24px;\n"
                + "                                        color:#e67e22;\n"
                + "                                        margin:30px 0;\">ĐẶT HÀNG THÀNH CÔNG</h1>\n"
                + "                                    <p style=\"margin:5px 0 0\">Khách hàng " + name + ",</p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Cảm ơn bạn đã tin tưởng và sử dụng dịch vụ, chính sách mua hàng của chúng tôi. </p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Thông tin đến bạn: </p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Số lượng sản phẩm: <span style=\"color:#e67e22;font-weight: bold;\"> " + sl + " </span></p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Số tiền sẽ thanh toán: <span style=\"color:#e67e22;font-weight: bold;\">" + total + "</span></p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Đơn hàng dự kiến sẽ giao đến bạn trong vòng 3 - 7 ngày tới. </p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Nếu bạn cần hỗ trợ gấp hãy liên hệ hotline: 1900 9090. </p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Xin cảm ơn. </p>\n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                            <tr class=\"contact\" style=\"font-size:11px; color:#999;\">\n"
                + "                                <td align=\"center\"> \n"
                + "                                    Clothes Shop Ho Chi Minh - 0123 456 789 - clothesshop@gmail.com\n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                        </table>\n"
                + "                    </div> \n"
                + "                </td>\n"
                + "            </tr>\n"
                + "        </table>\n"
                + "    </body>\n"
                + "</html>\n";
    }

    public String messageFogot(String name, int code) {
        return "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>Email Contact</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    </head>\n"
                + "    <body style=\"font-family:arial, helvetica, sans-serif;\n"
                + "          font-size:14px;\n"
                + "          line-height:20px;\n"
                + "          color: #444;\n"
                + "          background:#f2f2f2;\">\n"
                + "        <table width=\"100%\" class=\"wrapper\" style=\" margin:20px 0;\">\n"
                + "            <tr>\n"
                + "                <td class=\"container\"> \n"
                + "                    <div class=\"content\" style=\"display: block!important;\n"
                + "                         max-width: 600px!important;\n"
                + "                         margin: 0 auto!important;\n"
                + "                         clear: both!important;\n"
                + "                         background:white;\">\n"
                + "                        <table cellspacing=\"20\" width=\"100%\">\n"
                + "                            <tr>\n"
                + "                                <td>\n"
                + "                                    <p class=\"brand\" style=\"margin:5px 0 0; font-size:30px;\n"
                + "                                       margin:20px 0;\"><span style=\"color:#e67e22;\">Clothes</span>Shop</p> \n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                            <tr>\n"
                + "                                <td class=\"border\" style=\"border-top:2px solid #e67e22;\n"
                + "                                    border-bottom:2px solid #e67e22;\">\n"
                + "                                    <h1 style=\" font-size:24px;\n"
                + "                                        color:#e67e22;\n"
                + "                                        margin:30px 0;\">MÃ XÁC NHẬN CỦA BẠN</h1>\n"
                + "                                    <p style=\"margin:5px 0 0\">Chào " + name + ",</p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Mã khôi phục mật khẩu của bạn là:<span style=\"color:#e67e22;font-weight: bold;\">" + code + "</span></p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Nếu bạn cần hỗ trợ gấp hãy liên hệ hotline: 1900 9090. </p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Xin cảm ơn. </p>\n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                            <tr class=\"contact\" style=\"font-size:11px; color:#999;\">\n"
                + "                                <td align=\"center\"> \n"
                + "                                    Clothes Shop Ho Chi Minh - 0123 456 789 - clothesshop@gmail.com\n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                        </table>\n"
                + "                    </div> \n"
                + "                </td>\n"
                + "            </tr>\n"
                + "        </table>\n"
                + "    </body>\n"
                + "</html>\n";
    }

    public String messageSubscribe() {
        return "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>Email Contact</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    </head>\n"
                + "    <body style=\"font-family:arial, helvetica, sans-serif;\n"
                + "          font-size:14px;\n"
                + "          line-height:20px;\n"
                + "          color: #444;\n"
                + "          background:#f2f2f2;\">\n"
                + "        <table width=\"100%\" class=\"wrapper\" style=\" margin:20px 0;\">\n"
                + "            <tr>\n"
                + "                <td class=\"container\"> \n"
                + "                    <div class=\"content\" style=\"display: block!important;\n"
                + "                         max-width: 600px!important;\n"
                + "                         margin: 0 auto!important;\n"
                + "                         clear: both!important;\n"
                + "                         background:white;\">\n"
                + "                        <table cellspacing=\"20\" width=\"100%\">\n"
                + "                            <tr>\n"
                + "                                <td>\n"
                + "                                    <p class=\"brand\" style=\"margin:5px 0 0; font-size:30px;\n"
                + "                                       margin:20px 0;\"><span style=\"color:#e67e22;\">Clothes</span>Shop</p> \n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                            <tr>\n"
                + "                                <td class=\"border\" style=\"border-top:2px solid #e67e22;\n"
                + "                                    border-bottom:2px solid #e67e22;\">\n"
                + "                                    <h1 style=\" font-size:24px;\n"
                + "                                        color:#e67e22;\n"
                + "                                        text-height:36px;\n"
                + "                                        margin:30px 0;\">CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI CLOTHES SHOP</h1>\n"
                + "                                    <p style=\"margin:5px 0 0\">Hello clother,</p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Cảm ơn bạn đã tin tưởng và sử dụng dịch vụ, chính sách mua hàng của chúng tôi. </p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Bạn sẽ là một trong những người được nhận thông báo <span style=\"color:#e67e22;\">SALE, NEW PRODUCT</span> sớm nhất. </p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Nếu bạn cần hỗ trợ gấp hãy liên hệ hotline: 1900 9090. </p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Xin cảm ơn. </p>\n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                            <tr class=\"contact\" style=\"font-size:11px; color:#999;\">\n"
                + "                                <td align=\"center\"> \n"
                + "                                    Clothes Shop Ho Chi Minh - 0123 456 789 - clothesshop@gmail.com\n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                        </table>\n"
                + "                    </div> \n"
                + "                </td>\n"
                + "            </tr>\n"
                + "        </table>\n"
                + "    </body>\n"
                + "</html>\n";
    }

    public static void main(String[] args) {
        Email handleEmail = new Email();
        String email = "hoangclw@gmail.com";
        String sub = "Subject";
        String mess = "Check email";
        handleEmail.sendEmail(sub, mess, email);

    }
}
