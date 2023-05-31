package kpfu.itis.sem.service.impl;

import kpfu.itis.sem.entity.CustomerEntity;
import kpfu.itis.sem.repository.CustomerRepository;
import kpfu.itis.sem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BaseCustomerService implements CustomerService {

    private final CustomerRepository customerRepository;

    private final BaseUserService userService;



    @Override
    public void createCustomer(CustomerEntity customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(UUID id, CustomerEntity customer) {
        CustomerEntity customerEntity = customerRepository.getReferenceById(id);
        customerEntity.setName(customer.getName());
        customerEntity.setStatus(customer.getStatus());
        customerEntity.setPhoneNumber(customer.getPhoneNumber());
        customerRepository.save(customerEntity);
    }

    @Override
    public CustomerEntity getCustomerByUserId(UUID id) {
        return customerRepository.getCustomerEntityByUserId(userService.getUserById(id));
    }
}
