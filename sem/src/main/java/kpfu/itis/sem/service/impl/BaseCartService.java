package kpfu.itis.sem.service.impl;

import kpfu.itis.sem.dto.request.ProductsDto;
import kpfu.itis.sem.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class BaseCartService implements CartService {

    private final HttpSession session;

    private final BaseProductService productService;


    @Override
    public void saveToCart(UUID id) {

        if (session.getAttribute("cart") != null) {
            HashMap<ProductsDto, Integer> cart = (HashMap<ProductsDto, Integer>) session.getAttribute("cart");
            ProductsDto productsDto = productService.getProductsDtoById(id);
            boolean flag = false;
            for (Map.Entry<ProductsDto, Integer> entry : cart.entrySet()) {
                if (entry.getKey().getId().equals(id)) {
                    entry.setValue(entry.getValue() + 1);
                    flag = true;
                }
            }
            if (!flag) {
                cart.put(productsDto, 1);
            }
            session.setAttribute("cart", cart);
        } else {
            HashMap<ProductsDto, Integer> cart = new HashMap<>();
            cart.put(productService.getProductsDtoById(id), 1);
            session.setAttribute("cart", cart);
        }
    }


    @Override
    public void increaseCountInTheCart(UUID id) {
        if (session.getAttribute("cart") != null) {
            HashMap<ProductsDto, Integer> cart = (HashMap<ProductsDto, Integer>) session.getAttribute("cart");
            ProductsDto productsDto = productService.getProductsDtoById(id);
            if (cart.containsKey(productsDto)) {
                int count = cart.get(productsDto);
                cart.put(productsDto, count + 1);
                session.setAttribute("cart", cart);
            }
        }
    }

    @Override
    public void decreaseCountInTheCart(UUID id) {
        if (session.getAttribute("cart") != null) {
            HashMap<ProductsDto, Integer> cart = (HashMap<ProductsDto, Integer>) session.getAttribute("cart");
            ProductsDto productsDto = productService.getProductsDtoById(id);
            if (cart.containsKey(productsDto)) {
                int count = cart.get(productsDto);
                cart.put(productsDto, count - 1);
                session.setAttribute("cart", cart);
            }
        }
    }

    @Override
    public void deleteFromCart(UUID id) {
        if (session.getAttribute("cart") != null) {
            HashMap<ProductsDto, Integer> cart = (HashMap<ProductsDto, Integer>) session.getAttribute("cart");
            ProductsDto productsDto = productService.getProductsDtoById(id);
            if (cart.containsKey(productsDto)) {

                cart.remove(productsDto);
                session.setAttribute("cart", cart);

            }
        }
    }

    @Override
    public Integer getSum(HashMap<ProductsDto, Integer> cart) {
        Integer sum = 0;
        for (Map.Entry<ProductsDto, Integer> entry : cart.entrySet()) {
             sum += entry.getKey().getCost() * entry.getValue();
        }
        return sum;
    }

    @Override
    public Integer getProductCount(HashMap<ProductsDto, Integer> cart) {
        Integer count = 0;
        for (Map.Entry<ProductsDto, Integer> entry : cart.entrySet()) {
            count += entry.getValue();
        }
        return count;
    }

    @Override
    public HashMap<ProductsDto, Integer> getCart() {
        if (session.getAttribute("cart") != null) {
            HashMap<ProductsDto, Integer> cart = (HashMap<ProductsDto, Integer>) session.getAttribute("cart");
        } else {
            session.setAttribute("cart", null);
        }
        return (HashMap<ProductsDto, Integer>) session.getAttribute("cart");
    }
}

