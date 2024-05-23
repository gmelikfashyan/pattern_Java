package com.example.pr15;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "footballers")
public class Footballer {
    @Id
    @SequenceGenerator(name = "footballers_seq", sequenceName = "footballers_sequence", allocationSize = 1)
    @GeneratedValue(generator = "footballers_seq", strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public Footballer() {
    }
}
