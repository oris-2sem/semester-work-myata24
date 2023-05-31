package kpfu.itis.sem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.UUID;

@Entity
@Setter
@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity extends AbstractEntity{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer cost;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Boolean isAvailable;

    @Column(nullable = false)
    private Integer count;

//    @Column(nullable = false)
    private String Pictures;

//    @Column(nullable = false)
    @OneToMany(mappedBy = "productId")
    private List<OrderProduct> orderProduct;
}
