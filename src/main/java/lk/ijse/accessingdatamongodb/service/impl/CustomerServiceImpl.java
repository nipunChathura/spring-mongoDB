package lk.ijse.accessingdatamongodb.service.impl;

import lk.ijse.accessingdatamongodb.advisor.LoggerHandler;
import lk.ijse.accessingdatamongodb.dto.CustomerDTO;
import lk.ijse.accessingdatamongodb.entity.Customer;
import lk.ijse.accessingdatamongodb.repository.CustomerRepository;
import lk.ijse.accessingdatamongodb.service.CustomerService;
import lk.ijse.accessingdatamongodb.util.CustomerMapper;
import lk.ijse.accessingdatamongodb.util.StandardLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 5/20/2021
 **/

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        if (!customerRepository.existsById(customerDTO.getId())){
            Customer customer = customerMapper.toCustomer(customerDTO);
            customerRepository.save(customer);
            StandardLogger logger =
                    new StandardLogger("info","Customer "+customerDTO.getId()+" added");
            LoggerHandler.handleLogger(logger);
        }else {
            StandardLogger logger =
                    new StandardLogger("error","Customer is already exists");
            LoggerHandler.handleLogger(logger);
            throw new RuntimeException("Customer already exists");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        if (customerRepository.existsById(customerDTO.getId())){
            Customer customer = customerMapper.toCustomer(customerDTO);
            customerRepository.save(customer);
            StandardLogger logger =
                    new StandardLogger("info","Customer "+customerDTO.getId()+" updated");
            LoggerHandler.handleLogger(logger);
        }else {
            StandardLogger logger =
                    new StandardLogger("error","Customer is not exists");
            LoggerHandler.handleLogger(logger);
            throw new RuntimeException("Customer not exists");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (customerRepository.existsById(id)){
            customerRepository.deleteById(id);
            StandardLogger logger =
                    new StandardLogger("info","Customer "+id+" deleted");
            LoggerHandler.handleLogger(logger);
        }else {
            StandardLogger logger =
                    new StandardLogger("error","Customer "+id+" not exists");
            LoggerHandler.handleLogger(logger);
            throw new RuntimeException("Customer not exist");
        }
    }

    @Override
    public CustomerDTO getCustomer(String id) {
        if (customerRepository.existsById(id)){
            Optional<Customer> byId = customerRepository.findById(id);
            CustomerDTO customerDTO = customerMapper.toCustomerDTO(byId.get());
            return customerDTO;
        } else {
            StandardLogger logger =
                    new StandardLogger("error","Customer "+id+" not exists");
            LoggerHandler.handleLogger(logger);
            throw new RuntimeException("Customer not exist");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> all = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = customerMapper.toAllCustomerDTO(all);
        return customerDTOS;
    }
}
