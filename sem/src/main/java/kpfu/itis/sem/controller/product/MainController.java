package kpfu.itis.sem.controller.product;


import kpfu.itis.sem.dto.request.ProductsDto;
import kpfu.itis.sem.entity.ProductEntity;
import kpfu.itis.sem.security.details.BaseUserDetails;
import kpfu.itis.sem.service.impl.BaseProductService;
import kpfu.itis.sem.util.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {

    private final BaseProductService productService;
    private final ProductMapper mapper;



    @GetMapping
    public String getSignInPage(Model model, Authentication auth) {
//        BaseUserDetails userDetails = (BaseUserDetails) auth.getPrincipal();
//        userDetails.getUsername();
        List<ProductEntity> allProducts = productService.showAllProducts();
        List<ProductsDto> products = new ArrayList<>();
        for (ProductEntity product : allProducts) {
            products.add(mapper.toDto(product));
        }
        model.addAttribute("products", products);

//        model.addAttribute("")

        return "main";
    }

}
