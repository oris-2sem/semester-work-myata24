package kpfu.itis.sem.controller.product;//package kpfu.itis.sem.controller;
//
//
//import kpfu.itis.sem.dto.request.ProductsDto;
//import kpfu.itis.sem.service.impl.BaseProductService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//
//@SessionAttributes("cart")
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/cart")
//public class CartController {
//
//    private final BaseProductService productService;
//
//    @GetMapping
//    public String showCart(Model model) {
//        HashMap<ProductsDto, Integer> cart = new HashMap<>();
//        model.addAttribute("cart", cart);
//        return "cart";
//    }
//
//    @PostMapping("/addToCart")
//    void updateCart(Model model, @ModelAttribute HashMap<ProductsDto, Integer> cart){
//        productService.addProductToCart(productService.getProductById(), cart);
//
//    }
//
//
//
//}

import kpfu.itis.sem.dto.request.ProductsDto;
import kpfu.itis.sem.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@SessionAttributes("cart")
@RequiredArgsConstructor
@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @GetMapping
    public String viewCart(Model model) {
        HashMap<ProductsDto, Integer> cart = cartService.getCart();
        model.addAttribute("cart", cart);
        Integer generalCost = cartService.getSum(cart);
        model.addAttribute("generalCost", generalCost);
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam("productId") UUID id) {
        cartService.saveToCart(id);
        return "redirect:/main";
    }
    @PostMapping("/remove")
    public String removeFromCart(@RequestParam("productIdToRemove") UUID id) {
        cartService.deleteFromCart(id);
        return "redirect:/cart";
    }
    @PostMapping("/increaseCount")
    public String increaseCountInCart(@RequestParam("productIdToInc") UUID id) {
        cartService.increaseCountInTheCart(id);
        return "redirect:/cart";
    }
    @PostMapping("/decreaseCount")
    public String decreaseCountInCart(@RequestParam("productIdToDic") UUID id) {
        cartService.decreaseCountInTheCart(id);
        return "redirect:/cart";
    }
}
