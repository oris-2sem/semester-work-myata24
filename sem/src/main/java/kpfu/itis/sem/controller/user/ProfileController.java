package kpfu.itis.sem.controller.user;


import kpfu.itis.sem.dto.request.CustomerDto;
import kpfu.itis.sem.entity.CustomerEntity;
import kpfu.itis.sem.security.details.BaseUserDetails;
import kpfu.itis.sem.service.impl.BaseCustomerService;
import kpfu.itis.sem.service.impl.BaseUserService;
import kpfu.itis.sem.util.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ProfileController {

    private final CustomerMapper customerMapper;

    private final BaseCustomerService customerService;

    private final BaseUserService userService;

    @GetMapping("/profile")
    public String getProfilePage(Model model, Authentication authentication) {
        BaseUserDetails user = (BaseUserDetails) authentication.getPrincipal();
        CustomerEntity customerEntity = customerService.getCustomerByUserId(userService
                .findUserByName(user.getUsername()).get().getId());
        CustomerDto customerDto = customerMapper.toDto(customerEntity);
        model.addAttribute("customer", customerDto);
        return "profile";

    }
}
