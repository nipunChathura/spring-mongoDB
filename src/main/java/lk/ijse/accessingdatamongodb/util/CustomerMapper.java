package lk.ijse.accessingdatamongodb.util;

import lk.ijse.accessingdatamongodb.dto.CustomerDTO;
import lk.ijse.accessingdatamongodb.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 5/20/2021
 **/

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    Customer toCustomer(CustomerDTO dto);
    CustomerDTO toCustomerDTO(Customer customer);
    List<CustomerDTO> toAllCustomerDTO(List<Customer> customers);
}
