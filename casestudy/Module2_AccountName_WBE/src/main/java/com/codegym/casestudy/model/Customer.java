package com.codegym.casestudy.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int customerId;

    @OneToMany(mappedBy = "customerTypeId")
    private List<CustomerType> customerTypeId;

    private  String CustomerName;
    private  String CustomerBirth;
    private  String CustomerGender;
    private  String CustomerIdCard;
    private  String CustomerPhone;
    private  String CustomerEmail;
    private  String CustomerAddress;

    public Customer() {
    }

    public Customer(int customerId, List<CustomerType> customerTypeId, String customerName, String customerBirth, String customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress) {
        this.customerId = customerId;
        this.customerTypeId = customerTypeId;
        CustomerName = customerName;
        CustomerBirth = customerBirth;
        CustomerGender = customerGender;
        CustomerIdCard = customerIdCard;
        CustomerPhone = customerPhone;
        CustomerEmail = customerEmail;
        CustomerAddress = customerAddress;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<CustomerType> getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(List<CustomerType> customerTypId) {
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
}
