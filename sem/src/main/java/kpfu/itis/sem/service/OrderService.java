package kpfu.itis.sem.service;

import kpfu.itis.sem.dto.request.OrderFormDto;
import kpfu.itis.sem.dto.request.ProductsDto;
import kpfu.itis.sem.entity.OrderEntity;
import kpfu.itis.sem.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface OrderService {

    void createOrder(OrderEntity order);

    OrderEntity createEntityByOrderInfo(OrderFormDto orderInfo, HashMap<ProductsDto, Integer> cart);
}
