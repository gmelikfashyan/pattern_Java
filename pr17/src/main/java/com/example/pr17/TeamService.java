package com.example.pr17;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final SessionFactory sessionFactory;
    private Session session;
    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }
    public List<Team> getTeams() {
        return session.createQuery("select t from Team t", Team.class).getResultList();
    }
    public void save(Team t) {
        var transaction = session.beginTransaction();
        session.saveOrUpdate(t);
        transaction.commit();
    }
    public void delete(Long id) {
        var transaction = session.beginTransaction();
        Team team = session.get(Team.class, id);
        if (team != null) {
            session.delete(team);
        }
        transaction.commit();
    }

}
