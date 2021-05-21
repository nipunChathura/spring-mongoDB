package lk.ijse.accessingdatamongodb.api;

import lk.ijse.accessingdatamongodb.dto.CustomerDTO;
import lk.ijse.accessingdatamongodb.entity.Customer;
import lk.ijse.accessingdatamongodb.repository.CustomerRepository;
import lk.ijse.accessingdatamongodb.service.CustomerService;
import lk.ijse.accessingdatamongodb.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Nipun Chathuranga <nipunc1999@gmail.com>
 * @since : 5/20/2021
 **/

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO dto){
        customerService.saveCustomer(dto);
        StandardResponse response = new StandardResponse(200, "success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO dto){
        customerService.updateCustomer(dto);
        StandardResponse response = new StandardResponse(200, "success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCustomer(@RequestParam String id){
        customerService.deleteCustomer(id);
        StandardResponse response = new StandardResponse(200, "success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(params = {"id"})
    public ResponseEntity getCustomer(@RequestParam String id){
        CustomerDTO customer = customerService.getCustomer(id);
        StandardResponse response = new StandardResponse(200, "success", customer);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getAllCustomer(){
        List<CustomerDTO> allCustomer = customerService.getAllCustomer();
        StandardResponse response = new StandardResponse(200, "success", allCustomer);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
