package com.osumba.userservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.osumba.userservice.enumer.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String firstName;
    private String lastName;
    private String email ;
    private String password;
    private Date birthDate;
    private boolean isActive;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;



}
