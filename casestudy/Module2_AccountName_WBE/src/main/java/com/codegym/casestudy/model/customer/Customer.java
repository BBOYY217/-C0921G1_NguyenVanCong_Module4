package com.codegym.casestudy.model.customer;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(generator = "id_gen_customer")
    @GenericGenerator(name = "id_gen_customer", parameters = @Parameter(name = "prefix", value = "KH-"), strategy = "com.codegym.casestudy.model.customer.IdGenerator")
    private String customerId;

    @ManyToOne
    @JoinColumn(name = "customer_type_id" ,referencedColumnName = "customerTypeId")
    private CustomerType customerTypeId;

    private  String CustomerName;
    private  String CustomerBirth;
    private  String CustomerGender;
    private  String CustomerIdCard;
    private  String CustomerPhone;
    private  String CustomerEmail;
    private  String CustomerAddress;
    private boolean flag;

    public Customer() {
    }

    public Customer(String customerId, CustomerType customerTypeId, String customerName, String customerBirth, String customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, boolean flag) {
        this.customerId = customerId;
        this.customerTypeId = customerTypeId;
        CustomerName = customerName;
        CustomerBirth = customerBirth;
        CustomerGender = customerGender;
        CustomerIdCard = customerIdCard;
        CustomerPhone = customerPhone;
        CustomerEmail = customerEmail;
        CustomerAddress = customerAddress;
        this.flag = flag;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(CustomerType customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerBirth() {
        return CustomerBirth;
    }

    public void setCustomerBirth(String customerBirth) {
        CustomerBirth = customerBirth;
    }

    public String getCustomerGender() {
        return CustomerGender;
    }

    public void setCustomerGender(String customerGender) {
        CustomerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return CustomerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        CustomerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return CustomerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        CustomerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        CustomerAddress = customerAddress;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
