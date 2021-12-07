package com.customer.backend.project.model.data;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String name  ;
    String type  ;
    String email ;
    String gender;


    @OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    Address address    ;

    String phoneNumber ;
    String status      ;
    String password;

    @NotFound(action = NotFoundAction.EXCEPTION)
    String adminUid;

    int experience;

    @NotFound(action = NotFoundAction.EXCEPTION)
    @OneToMany(targetEntity = Batch.class, cascade = CascadeType.ALL)
    List<Batch> batches;

    public Staff() {
    }

    public Staff(String name, String type, String email, String gender, Address address, String phoneNumber, String status, String password, String adminUid, int experience, List<Batch> batches) {
        this.name = name;
        this.type = type;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.password = password;
        this.adminUid = adminUid;
        this.experience = experience;
        this.batches = batches;
    }
}
