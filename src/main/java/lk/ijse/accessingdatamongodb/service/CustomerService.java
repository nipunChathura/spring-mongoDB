package lk.ijse.accessingdatamongodb.service;

import lk.ijse.accessingdatamongodb.dto.CustomerDTO;

import java.util.List;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 5/20/2021
 **/
public interface CustomerService {
    public void saveCustomer(CustomerDTO customerDTO);
    public void updateCustomer(CustomerDTO customerDTO);
    public void deleteCustomer(String id);
    public CustomerDTO getCustomer(String id);
    public List<CustomerDTO> getAllCustomer();
}
