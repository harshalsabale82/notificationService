package com.brute_force.notificationService.repository;

import com.brute_force.notificationService.service.requestNotificationToInvestor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface requestNotificationToInvestorRepository extends MongoRepository<requestNotificationToInvestor,String> {

}
