package com.example.pr18;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FootballerService {
    private final FootballerRepository footballerRepository;
    public List<Footballer> getFootballers() {
        return footballerRepository.findAll();
    }
    public void save(Footballer f) {
        footballerRepository.save(f);
    }
    public void delete(Long id) {
        footballerRepository.delete(footballerRepository.getReferenceById(id));
    }
    public Team getTeamByFootballer(Long footballerId) {
        return footballerRepository.getReferenceById(footballerId).getTeam();
    }

    public List<Footballer> filterFootballersByFirstName(String firstName) {
        return footballerRepository.findAllByFirstName(firstName);

    }

    public List<Footballer> filterFootballerBySecondName(String secondName) {
        return footballerRepository.findAllByLastName(secondName);
    }

    public List<Footballer> filterFootballerByTeam(Long team) {
        return footballerRepository.findAllByTeam_Id(team);
    }
}
