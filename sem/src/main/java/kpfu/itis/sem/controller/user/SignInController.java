package kpfu.itis.sem.controller.user;

import kpfu.itis.sem.dto.request.SignInForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signIn")
@RequiredArgsConstructor
public class SignInController {


    @GetMapping
    public String getSignInPage(Model model) {
        SignInForm signInForm = new SignInForm();
        signInForm.setLogin("login");
        signInForm.setPassword("password");
        model.addAttribute("signInForm", signInForm);
        return "signin";
    }

}
