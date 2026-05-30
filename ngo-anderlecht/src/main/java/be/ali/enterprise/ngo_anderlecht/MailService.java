package be.ali.enterprise.ngo_anderlecht;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendContactMail(ContactForm form) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("admin@ngo-anderlecht.be"); // ontvanger
        message.setSubject("Nieuw contactbericht van " + form.getName());
        message.setText(
                "Naam: " + form.getName() + "\n" +
                "Email: " + form.getEmail() + "\n\n" +
                "Bericht:\n" + form.getMessage()
        );

        mailSender.send(message);
    }
}
