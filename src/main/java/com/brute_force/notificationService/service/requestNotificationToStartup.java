package com.brute_force.notificationService.service;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "startup")
public class requestNotificationToStartup {
    @MongoId
    private ObjectId id;



    private String firstName;
    private String email;


    public requestNotificationToStartup(ObjectId id, String firstName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
    }

    public String getId() {
        return id.toHexString();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }
}
