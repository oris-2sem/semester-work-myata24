package kpfu.itis.sem.entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class OrderProduct extends AbstractEntity{

    @NotNull
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productId;

    private Integer count;
}
