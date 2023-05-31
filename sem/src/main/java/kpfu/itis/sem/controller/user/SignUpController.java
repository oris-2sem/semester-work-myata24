package kpfu.itis.sem.controller.user;


import kpfu.itis.sem.dto.request.SignUpForm;
import kpfu.itis.sem.service.impl.BaseUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequiredArgsConstructor
@RequestMapping("/signUp")
public class SignUpController {

    private final BaseUserService userService;

    @GetMapping
    public String showForm(Model model) {
        SignUpForm signUpForm = new SignUpForm();
        signUpForm.setLogin("login");
        signUpForm.setPassword("password");
        model.addAttribute("signupForm", signUpForm);
        return "signup";
    }

    @PostMapping
    public String signUp(Model model, @ModelAttribute("signupForm") SignUpForm signUpForm) {
        if (signUpForm.getLogin() != null && signUpForm.getPassword() != null) {
            userService.signUp(signUpForm.getLogin(), signUpForm.getPassword());
            model.addAttribute("message", "успешно");
        }
            return "redirect:signIn";
    }

//    @PostMapping
//    public void signUp(@RequestParam String login, @RequestParam String password) {
//        userService.signUp(login, password);
//
//    }


}
