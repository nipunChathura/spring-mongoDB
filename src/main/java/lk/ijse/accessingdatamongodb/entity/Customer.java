package lk.ijse.accessingdatamongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 5/20/2021
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data

@Document(collection = "Customer")
public class Customer {
    @Id
    private String id;
    private String name;
    private String address;
    private int salary;
}
