package lk.ijse.accessingdatamongodb.repository;

import lk.ijse.accessingdatamongodb.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 5/20/2021
 **/

@EnableMongoRepositories
public interface CustomerRepository extends MongoRepository<Customer, String> {
}
