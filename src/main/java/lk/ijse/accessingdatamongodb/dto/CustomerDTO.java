package lk.ijse.accessingdatamongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 5/20/2021
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {

    private String id;
    private String name;
    private String address;
    private int salary;

}
