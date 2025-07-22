package uz.binartpro.pizzatgbot.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("customers")
public class Customer {
    @Id
    @Field("_id")
    ObjectId id;

    OrderState orderState;

}
