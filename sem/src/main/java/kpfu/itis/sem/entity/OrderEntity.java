package kpfu.itis.sem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Setter
@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    @Id
    @Column(insertable = false, updatable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(nullable = false)
    private String customerName;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerId;

    @Column(nullable = false)
    private Integer countProduct;

    @Column(nullable = false)
    private Integer cost;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    @OneToMany(mappedBy = "orderId")
    private List<OrderProduct> orderProduct;
}
