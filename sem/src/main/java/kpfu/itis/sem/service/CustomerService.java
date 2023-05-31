package kpfu.itis.sem.service;

import kpfu.itis.sem.entity.CustomerEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CustomerService {

    void createCustomer(CustomerEntity customer);

    void updateCustomer(UUID id, CustomerEntity customer);

    CustomerEntity getCustomerByUserId(UUID id);

}
