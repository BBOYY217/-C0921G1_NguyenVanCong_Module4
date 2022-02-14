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
//Sau đây là controller dựa trên REST, thi hành REST API.
//
//GET request "/api/customers/" trả về danh sách các khách hàng
//GET request "/api/customers/1" trả về khách hàng với ID 1
//POST request "/api/customers/" với một JSON object tạo một khách hàng mới
//PUT request "/api/customers/3" với một JSON object cập nhật khách hàng có ID 3
//DELETE request "/api/customers/3" xóa khách hàng có ID 3

//@RestController là kết hợp của @Controller và @ResponseBody
//@RequestBody: Nếu tham số phương thức được chú thích bằng @RequestBody, Spring sẽ liên kết phần thân yêu cầu HTTP đến với tham số đó.
//ResponseEntity đại diện cho toàn bộ phản hồi HTTP
//@PathVariable chỉ ra rằng tham số phương thức sẽ được liên kết với URI (id)