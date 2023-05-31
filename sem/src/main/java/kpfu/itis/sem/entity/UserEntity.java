package kpfu.itis.sem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@Entity
@Setter
@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends AbstractEntity{

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String hashPassword;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private State state;

    @OneToOne(mappedBy = "userId")
    private CustomerEntity customer;

    public enum Role {
        USER, ADMIN
    }

    public enum State {
        ACTIVE, BANNED
    }

    public boolean isActive() {
        return this.state == State.ACTIVE;
    }

    public boolean isBanned() {
        return this.state == State.BANNED;
    }

    public boolean isAdmin() {
        return this.role == Role.ADMIN;
    }

}
