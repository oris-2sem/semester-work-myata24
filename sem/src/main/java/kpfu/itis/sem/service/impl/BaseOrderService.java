package kpfu.itis.sem.service.impl;

import kpfu.itis.sem.dto.request.OrderFormDto;
import kpfu.itis.sem.dto.request.ProductsDto;
import kpfu.itis.sem.entity.OrderEntity;
import kpfu.itis.sem.repository.OrderRepository;
import kpfu.itis.sem.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class BaseOrderService implements OrderService {

    private final OrderRepository orderRepository;

    private final BaseCartService cartService;


    @Override
    public void createOrder(OrderEntity order) {
        orderRepository.save(order);
    }

    //TODO: понять как сделать ебанину с кастомером через сессию

    @Override
    public OrderEntity createEntityByOrderInfo(OrderFormDto orderInfo, HashMap<ProductsDto, Integer> cart) {
        OrderEntity order = OrderEntity.builder()
                .address(orderInfo.getAddress())
                .comment(orderInfo.getComment())
                .cost(cartService.getSum(cart))
                .countProduct(cartService.getProductCount(cart))
                .customerName(orderInfo.getCustomerName())
                .customerId(null)
                .build();
        return order;
    }
}
