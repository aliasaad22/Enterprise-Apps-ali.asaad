package be.ali.enterprise.ngo_anderlecht;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    private final MailService mailService;

    public ContactController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/contact")
    public String contactForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitForm(
            @Valid @ModelAttribute("contactForm") ContactForm form,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "contact";
        }

        // Mail versturen
        mailService.sendContactMail(form);

        // Succesbericht tonen
        model.addAttribute("success", "Je bericht is succesvol verzonden!");

        // FORMULIER LEEGMAKEN NA VERSTUREN
        model.addAttribute("contactForm", new ContactForm());

        return "contact";
    }
}
