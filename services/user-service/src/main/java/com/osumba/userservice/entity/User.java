package com.osumba.userservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.osumba.userservice.enumer.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email ;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;


    @ManyToOne
    @JoinColumn(name = "address_id") // Coluna no User que referencia Address
    private Address address; // Um usuário tem um endereço


}
