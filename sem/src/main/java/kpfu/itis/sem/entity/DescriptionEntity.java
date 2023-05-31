package kpfu.itis.sem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DescriptionEntity extends AbstractEntity{

    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productId;

    @Column(nullable = false)
    private Integer minWeight;

    @Column(nullable = false)
    private String metal;

    @Column(nullable = false)
    private String insertion;

    @Column(nullable = false)
    private String mechanism;

    @Column(nullable = false)
    private String gender;
}
