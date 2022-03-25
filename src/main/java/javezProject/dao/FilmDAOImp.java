package javezProject.dao;

import javezProject.model.Films;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilmDAOImp implements FilmDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Films> allFilms(int page) {
        Session session = sessionFactory.getCurrentSession();
        List<Films> films = session.createQuery("from Films", Films.class).setFirstResult(10 * (page - 1)).setMaxResults(10).list();
        return films;
    }

    @Override
    public void add(Films films) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(films);
    }

    @Override
    public void delete(Films films) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(films);
    }

    @Override
    public void edit(Films films) {
        Session session = sessionFactory.getCurrentSession();
        session.update(films);
    }

    @Override
    public Films getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Films.class, id);
    }

    @Override
    public int filmsCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Films", Number.class).getSingleResult().intValue();
    }

    @Override
    public boolean checkTitle(String title) {
        Session session = sessionFactory.getCurrentSession();
        Query query;
        query = session.createQuery("from Films where title = :title");
        query.setParameter("title", title);
        return query.list().isEmpty();
    }
}