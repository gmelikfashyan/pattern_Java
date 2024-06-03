package com.example.pr22;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FootballerRepository extends JpaRepository<Footballer, Long> {
    List<Footballer> findAllByFirstName(String firstName);
    List<Footballer> findAllByLastName(String lastName);
    List<Footballer> findAllByTeam_Id(Long id);
}
