package com.example.pr16;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FootballerService {
    private final SessionFactory sessionFactory;
    private Session session;
    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }
    public List<Footballer> getFootballers() {
        return session.createQuery("select f from Footballer f", Footballer.class).getResultList();
    }
    public void save(Footballer f) {
        var transaction = session.beginTransaction();
        session.saveOrUpdate(f);
        transaction.commit();
    }
    public void delete(Long id) {
        var transaction = session.beginTransaction();
        Footballer footballer = session.get(Footballer.class, id);
        if (footballer != null) {
            session.delete(footballer);
        }
        transaction.commit();
    }
    public Team getTeamByFootballer(Long footballerId) {
        return session.createQuery("from Footballer where id = :id", Footballer.class)
                .setParameter("id",footballerId).getSingleResult().getTeam();
    }
}
