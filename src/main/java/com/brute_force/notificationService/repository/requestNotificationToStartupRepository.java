package com.brute_force.notificationService.repository;

import com.brute_force.notificationService.service.requestNotificationToStartup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface requestNotificationToStartupRepository extends MongoRepository<requestNotificationToStartup,String> {

}
