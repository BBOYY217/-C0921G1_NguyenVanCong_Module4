package com.codegym.cms.controller;

import com.codegym.cms.model.Customer;
import com.codegym.cms.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ResponseEntity<Iterable<Customer>> findAllCustomer() {
        List<Customer> customers = (List<Customer>) customerService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(customerOptional.get().getId());
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }
}
//Sau ????y l?? controller d???a tr??n REST, thi h??nh REST API.
//
//GET request "/api/customers/" tr??? v??? danh s??ch c??c kh??ch h??ng
//GET request "/api/customers/1" tr??? v??? kh??ch h??ng v???i ID 1
//POST request "/api/customers/" v???i m???t JSON object t???o m???t kh??ch h??ng m???i
//PUT request "/api/customers/3" v???i m???t JSON object c???p nh???t kh??ch h??ng c?? ID 3
//DELETE request "/api/customers/3" x??a kh??ch h??ng c?? ID 3

//@RestController l?? k???t h???p c???a @Controller v?? @ResponseBody
//@RequestBody: N???u tham s??? ph????ng th???c ???????c ch?? th??ch b???ng @RequestBody, Spring s??? li??n k???t ph???n th??n y??u c???u HTTP ?????n v???i tham s??? ????.
//ResponseEntity ?????i di???n cho to??n b??? ph???n h???i HTTP
//@PathVariable ch??? ra r???ng tham s??? ph????ng th???c s??? ???????c li??n k???t v???i URI (id)