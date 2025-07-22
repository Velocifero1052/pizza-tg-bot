package uz.binartpro.pizzatgbot.service;

import org.bson.types.ObjectId;
import uz.binartpro.pizzatgbot.model.Customer;
import uz.binartpro.pizzatgbot.constants.OrderState;

public interface CustomerService {

    boolean existsByChatId(String chatId);

    boolean customerExists(ObjectId id);

    Customer updateStatus(ObjectId id, OrderState orderState);

}
