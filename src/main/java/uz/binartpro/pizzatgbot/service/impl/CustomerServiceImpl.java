package uz.binartpro.pizzatgbot.service.impl;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import uz.binartpro.pizzatgbot.model.Customer;
import uz.binartpro.pizzatgbot.constants.OrderState;
import uz.binartpro.pizzatgbot.repository.CustomerRepository;
import uz.binartpro.pizzatgbot.service.CustomerService;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public boolean existsByChatId(String chatId) {
        return customerRepository.existsByChatId(chatId);
    }

    @Override
    public  boolean customerExists(ObjectId id) {
        return customerRepository.existsById(id);
    }

    @Override
    public Customer updateStatus(ObjectId id, OrderState orderState) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            return null;
        }
        customer.setOrderState(orderState);
        return customerRepository.save(customer);
    }

}
