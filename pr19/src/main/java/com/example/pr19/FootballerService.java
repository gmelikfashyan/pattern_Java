package com.example.pr19;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FootballerService {
    private final FootballerRepository footballerRepository;
    public List<Footballer> getFootballers() {
        log.info("Find all footballers");
        return footballerRepository.findAll();
    }
    public void save(Footballer f) {
        log.info("Save footballer {}", f);
        footballerRepository.save(f);
    }
    public void delete(Long id) {
        log.info("Delete footballer {}", id);
        footballerRepository.delete(footballerRepository.getReferenceById(id));
    }
    public Team getTeamByFootballer(Long footballerId) {
        log.info("Find team by Footballer {}", footballerId);
        return footballerRepository.getReferenceById(footballerId).getTeam();
    }

    public List<Footballer> filterFootballersByFirstName(String firstName) {
        log.info("Find all footballers by Footballer first name");
        return footballerRepository.findAllByFirstName(firstName);

    }

    public List<Footballer> filterFootballerBySecondName(String secondName) {
        log.info("Find all footballers by Footballer second name");
        return footballerRepository.findAllByLastName(secondName);
    }

    public List<Footballer> filterFootballerByTeam(Long team) {
        log.info("Find all footballers by team");
        return footballerRepository.findAllByTeam_Id(team);
    }
}
