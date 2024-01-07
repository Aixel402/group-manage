package com.aixel.groupmanage.entity;

import com.aixel.groupmanage.core.entity.CoreEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "User")
@Data
public class User extends CoreEntity {

    private String username;
    private String password;
    private String email;
    private String name;
    private String surname;

}
