package com.customer.backend.project.model.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter @ToString @EqualsAndHashCode
public class Admin {

    @Id @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(unique = true)
    @NotNull
    String adminUid;
    String serviceName;
    String type       ;           //Paid or not
    String email      ;

    @OneToOne(optional = true ,targetEntity = Address.class, cascade = CascadeType.ALL)
    @JsonProperty("address")
    Address address    ;
    String phoneNumber ;
    String status      ;

    public Admin() {
    }

    public Admin(@NotNull String adminUid, String serviceName, String type, String email, Address address, String phoneNumber, String status) {
        this.adminUid = adminUid;
        this.serviceName = serviceName;
        this.type = type;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }
}
