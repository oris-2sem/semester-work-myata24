package kpfu.itis.sem.controller.admin;


import kpfu.itis.sem.dto.request.ProductsDto;
import kpfu.itis.sem.entity.ProductEntity;
import kpfu.itis.sem.service.impl.BaseProductService;
import kpfu.itis.sem.util.mapper.BaseListProductMapper;
import kpfu.itis.sem.util.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final BaseProductService productService;
    private final ProductMapper mapper;
    private final BaseListProductMapper listProductMapper;


    @GetMapping
    public String getProfilePage(Model model) {
        List<ProductEntity> allProducts = productService.showAllProducts();
        List<ProductsDto> products = listProductMapper.mupStruct(allProducts);
        ProductsDto productForm = ProductsDto.builder().build();
        model.addAttribute("products", products);
        model.addAttribute("productForm", productForm);
        return "admin";
    }

    @PostMapping
    public String addNewProduct(Model model, @ModelAttribute("productForm") ProductsDto productsDto) {
        if (productService.isNotNullProductDto(productsDto)) {
            productService.createProduct(mapper.toEntity(productsDto));
        }
        return "admin";
    }
}
