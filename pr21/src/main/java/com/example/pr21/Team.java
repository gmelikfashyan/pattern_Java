package com.example.pr21;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name = "teams")
@Entity
public class Team {
    @Id
    @SequenceGenerator(name = "teams_seq", sequenceName = "teams_sequence", allocationSize = 1)
    @GeneratedValue(generator = "teams_seq", strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "creation_date")
    private String creationDate;

    public Team(String name, String creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    public Team() {
    }
    @OneToMany(mappedBy = "team")
    private List<Footballer> footballers;
}
