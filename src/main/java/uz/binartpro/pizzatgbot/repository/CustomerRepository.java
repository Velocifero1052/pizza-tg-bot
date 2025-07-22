package uz.binartpro.pizzatgbot.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uz.binartpro.pizzatgbot.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, ObjectId> {

    boolean existsByChatId(String chatId);

    Customer findByChatId(String chatId);

}
