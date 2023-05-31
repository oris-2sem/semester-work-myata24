package kpfu.itis.sem.controller.product;

import kpfu.itis.sem.dto.request.OrderFormDto;
import kpfu.itis.sem.dto.request.ProductsDto;
import kpfu.itis.sem.service.impl.BaseOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final BaseOrderService orderService;

    @GetMapping()
    public String showOrder(Model model, @RequestParam ("cart") HashMap<ProductsDto, Integer> cart) {
        model.addAttribute("cart", cart);
        OrderFormDto orderInfo = OrderFormDto.builder().build();
        model.addAttribute("orderInfo", orderInfo);
        return "order";
    }
//
//    @PostMapping("/save")
//    public String saveOrder() {
//        orderService.createOrder(order);
//    }
}
