package com.osumba.userservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String country;
    private String state;
    private String city;
    private String street;
    private String immNumber;
    private String houseNumber;
    private int  zipCode;
    @ManyToOne
    @JoinColumn(name = "user_id") // Coluna no User que referencia Address
    private User user; // Um usuário tem um endereço
}
