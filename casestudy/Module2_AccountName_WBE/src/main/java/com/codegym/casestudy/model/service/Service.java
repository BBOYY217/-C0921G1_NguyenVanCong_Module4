package com.codegym.casestudy.model.service;

import com.codegym.casestudy.model.RentType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int serviceId;
    private String ServiceName;
    private int  serviceArea;
    private double serviceCost;
    private int serviceMaxPeople;

    @OneToMany(mappedBy = "rentTypeId")
    private List<RentType> rentTypeId;

    @OneToMany(mappedBy = "serviceTypeId")
    private List<ServiceType> serviceTypeId;

    private String standRoom;
    private String descriptionOtherConvenience;
    private double poolArea;
    private int numberOfFloor;

    public Service() {
    }

    public Service(int serviceId, String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople, List<RentType> rentTypeId, List<ServiceType> serviceTypeId, String standRoom, String descriptionOtherConvenience, double poolArea, int numberOfFloor) {
        this.serviceId = serviceId;
        ServiceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standRoom = standRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public List<RentType> getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(List<RentType> rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public List<ServiceType> getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(List<ServiceType> serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getStandRoom() {
        return standRoom;
    }

    public void setStandRoom(String standRoom) {
        this.standRoom = standRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }
}
