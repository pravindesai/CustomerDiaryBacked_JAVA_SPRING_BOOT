package com.customer.backend.project.model.data;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Customer {
    @Id
    @GeneratedValue
    long id;

    String name      ;
    String type      ;
    String email     ;
    String gender    ;

    @OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    Address address    ;

    String phone_number;
    String status      ;
    String password;

    @NotNull
    @NotFound(action = NotFoundAction.EXCEPTION)
    String adminUid;

    @NotNull
    @NotFound(action = NotFoundAction.EXCEPTION)
    long staffId;

    @NotFound(action = NotFoundAction.EXCEPTION)
    long batchId;

    private long joining_date;
    private long due_date;

    public Customer() {
    }

    public Customer(String name, String type, String email, String gender, Address address, String phone_number, String status, String password, @NotNull String adminUid, @NotNull long staffId, long batchId, long joining_date, long due_date) {
        this.name = name;
        this.type = type;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.phone_number = phone_number;
        this.status = status;
        this.password = password;
        this.adminUid = adminUid;
        this.staffId = staffId;
        this.batchId = batchId;
        this.joining_date = joining_date;
        this.due_date = due_date;
    }
}
