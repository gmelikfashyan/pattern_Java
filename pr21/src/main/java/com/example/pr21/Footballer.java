package com.example.pr21;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "footballers")
@Entity
public class Footballer {
    @Id
    @SequenceGenerator(name = "footballers_seq", sequenceName = "footballers_sequence", allocationSize = 1)
    @GeneratedValue(generator = "footballers_seq", strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @JsonBackReference
    @ManyToOne
    private Team team;

    public Footballer() {
    }

    @Override
    public String toString() {
        return "Footballer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", team=" + team +
                '}';
    }
}
