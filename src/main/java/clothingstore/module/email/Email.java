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
import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Slf4j
public class Email {

    private final String eFrom = EnvUtil.get("MAIL_HOST");
    private final String ePass = EnvUtil.get("MAIL_PASS");

    private final TemplateEngine templateEngine;

    public Email() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setPrefix("templates/emails/");
        templateResolver.setSuffix(".html");
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }

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
            log.info("Email sent successfully to {}", to);
        } catch (Exception e) {
            log.error("Failed to send email to {}: {}", to, e.getMessage());
        }
    }

    public String subjectContact(String name) {
        return "Clothes Shop - Xin Chào " + name + " cảm ơn bạn vì đã liên hệ với chúng tôi";
    }

    public String subjectNewOrder() {
        return "ClothesShop - Đặt hàng thành công";
    }

    public String subjectSubsribe() {
        return "Clothes Shop - bạn có thông báo mới";
    }

    public String subjectForgotPass() {
        return "Clothes Shop - mã code xác nhận";
    }

    //contact.html
    public String emailContact(String name){
        Context context = new Context();
        context.setVariable("name", name);
        return templateEngine.process("contact", context);
    }

    public String emailNewOrder(String name, int sl, double total){
        Context context = new Context();
        context.setVariable("name", name);
        context.setVariable("sl", sl);
        context.setVariable("total", total);
        return templateEngine.process("newOrder", context);
    }

    //newOrder.html
    public String emailForgotPassword(String name, int code){
        Context context = new Context();
        context.setVariable("name", name);
        context.setVariable("code", code);
        return templateEngine.process("forgotPassword", context);
    }

    //forgotPassword.html
    public String emailSubscribe(){
        Context context = new Context();
        return templateEngine.process("subscribe", context);
    }

    //subscribe.html
    public static void main(String[] args) {
        Email handleEmail = new Email();
        String email = "hoangclw@gmail.com";
        String sub = "Subject";
        String mess = "Check email";
        handleEmail.sendEmail(sub, handleEmail.emailSubscribe(), email);
    }
}
