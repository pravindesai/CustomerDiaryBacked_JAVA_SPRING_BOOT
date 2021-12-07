package com.customer.backend.project.model.data;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Address {

    @NotNull
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String landmark;
    private String area;
    private String city;
    private String state;
    private String country;
    private int pincode;

    public Address() {
    }

    public Address(long id, String landmark, String area, String city, String state, String country, int pincode) {
        this.landmark = landmark;
        this.area = area;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }

    public Address(String landmark, String area, String city, String state, String country, int pincode) {
        this.landmark = landmark;
        this.area = area;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }

}
