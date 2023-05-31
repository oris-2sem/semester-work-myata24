package kpfu.itis.sem.repository;

import kpfu.itis.sem.entity.CustomerEntity;
import kpfu.itis.sem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    CustomerEntity getCustomerEntityByUserId(UserEntity entity);

}
