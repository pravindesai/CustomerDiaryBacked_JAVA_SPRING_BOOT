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
public class Batch {

    @Id @GeneratedValue
    long id;

    @NotNull
    @NotFound(action = NotFoundAction.EXCEPTION)
    String adminUid;

    @NotNull
    @NotFound(action = NotFoundAction.EXCEPTION)
    long staffId;

    private long duration_each_day;
    private String type;
    private int fee;
    private long start_Date;
    private long end_Date;
    private String description;

    public Batch() {
    }

    public Batch(String adminUid, long staffId, long duration_each_day,
                 String type, int fee, long start_Date, long end_Date, String description) {
        this.adminUid = adminUid;
        this.staffId = staffId;
        this.duration_each_day = duration_each_day;
        this.type = type;
        this.fee = fee;
        this.start_Date = start_Date;
        this.end_Date = end_Date;
        this.description = description;
    }
}
