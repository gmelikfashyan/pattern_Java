package com.example.pr17;

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
        return session.createQuery("from Footballer where id = :id", Footballer.class).setParameter("id",footballerId).getSingleResult().getTeam();
    }

    public List<Footballer> filterFootballersByFirstName(String firstName) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Footballer> criteriaQuery = builder.createQuery(Footballer.class);
        Root<Footballer> root = criteriaQuery.from(Footballer.class);
        //criteriaQuery.where(builder.equal(root.get("first_name"), firstName));
        criteriaQuery.where(builder.equal(root.get("firstName"), firstName));
        Query<Footballer> query = session.createQuery(criteriaQuery);
        return query.getResultList();

    }

    public List<Footballer> filterFootballerBySecondName(String secondName) {
        CriteriaBuilder builder2 = session.getCriteriaBuilder();
        CriteriaQuery<Footballer> criteriaQuery = builder2.createQuery(Footballer.class);
        Root<Footballer> root = criteriaQuery.from(Footballer.class);
        criteriaQuery.where(builder2.equal(root.get("lastName"), secondName));
        Query<Footballer> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List<Footballer> filterFootballerByTeam(Long team) {
        CriteriaBuilder builder3 = session.getCriteriaBuilder();
        CriteriaQuery<Footballer> criteriaQuery = builder3.createQuery(Footballer.class);
        Root<Footballer> root = criteriaQuery.from(Footballer.class);
        criteriaQuery.where(builder3.equal(root.get("team").get("id"), team));
        Query<Footballer> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
