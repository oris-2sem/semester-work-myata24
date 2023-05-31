package kpfu.itis.sem.service;

import kpfu.itis.sem.dto.request.ProductsDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public interface CartService {

    void saveToCart(UUID id);

    HashMap<ProductsDto, Integer> getCart();

    void increaseCountInTheCart(UUID id);

    void decreaseCountInTheCart(UUID id);

    void deleteFromCart(UUID id);

    Integer getSum(HashMap<ProductsDto, Integer> cart);

    Integer getProductCount(HashMap<ProductsDto, Integer> cart);

}
