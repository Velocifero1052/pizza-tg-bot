package uz.binartpro.pizzatgbot.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import uz.binartpro.pizzatgbot.constants.Drink;
import uz.binartpro.pizzatgbot.constants.OrderState;
import uz.binartpro.pizzatgbot.constants.Pizzas;
import uz.binartpro.pizzatgbot.constants.Size;

@Data
@Document("customers")
public class Customer {
    @Id
    @Field("_id")
    private ObjectId id;

    @Indexed
    private String chatId;

    private OrderState orderState;

    private Pizzas pizza;

    private Size size;

    private Drink drink;

}
