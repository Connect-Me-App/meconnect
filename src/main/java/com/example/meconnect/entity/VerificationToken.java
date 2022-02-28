package com.example.meconnect.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "TokenSystem")
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String token;

    @OneToOne
    private User user;
    //private Instant expiryDate;
}
