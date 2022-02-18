package com.codegym.casestudy.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contractDetail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contractDetailId;

    @OneToMany(mappedBy = "contractId")
    private List<Contract> contractId;

    @OneToMany(mappedBy = "attachServiceId")
    private List<AttachService> attachServiceId;

    private int quantity;

    public ContractDetail() {
    }

    public ContractDetail(int contractDetailId, List<Contract> contractId, List<AttachService> attachServiceId, int quantity) {
        this.contractDetailId = contractDetailId;
        this.contractId = contractId;
        this.attachServiceId = attachServiceId;
        this.quantity = quantity;
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public List<Contract> getContractId() {
        return contractId;
    }

    public void setContractId(List<Contract> contractId) {
        this.contractId = contractId;
    }

    public List<AttachService> getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(List<AttachService> attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
