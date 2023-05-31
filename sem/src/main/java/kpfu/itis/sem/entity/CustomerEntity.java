package kpfu.itis.sem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity()
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity extends AbstractEntity{

    @Column(nullable = false, unique = true)
    private String name;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String status;

}
