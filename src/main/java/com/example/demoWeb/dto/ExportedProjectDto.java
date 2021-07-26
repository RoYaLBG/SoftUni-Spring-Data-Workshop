package com.example.demoWeb.dto;

import java.math.BigDecimal;

public class ExportedProjectDto {

    private String name;

    private String description;

    private BigDecimal payment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Project Name: " + this.getName() + "\n"
                + "\tDescription: " + this.getDescription() +"\n"
                + "\t" + this.getPayment().toString();
    }
}
