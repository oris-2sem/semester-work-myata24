package kpfu.itis.sem.controller.product;


import kpfu.itis.sem.dto.request.DescriptionDto;
import kpfu.itis.sem.dto.request.ProductsDto;
import kpfu.itis.sem.service.impl.BaseDescriptionService;
import kpfu.itis.sem.service.impl.BaseProductService;
import kpfu.itis.sem.util.mapper.DescriptionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/description")
public class DescriptionController {

    private final BaseDescriptionService descriptionService;

    private final DescriptionMapper descriptionMapper;

    private final BaseProductService productService;

    @GetMapping("/{id}")
    public String showDescription(Model model, @PathVariable UUID id) {
        DescriptionDto descriptionDto = descriptionMapper.toDto(descriptionService.getDescriptionByProductId(id));
        model.addAttribute("description", descriptionDto);
        model.addAttribute("productForDescription", productService.getProductById(id));
        return "description";
    }

}
