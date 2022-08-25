package ru.geekbrains.lesson5.task.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

//public class StudentDao<T> implements EntityDao<T> {
public class EntityDao {

    private final SessionFactory sessionFactory;

    public EntityDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public <T> T find(Class<T> type, Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            T entity = (T) session.get(type, id);
            session.getTransaction().commit();
            return entity;
        }
    }

    public <T> List<T> findAll(Class<T> type) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<T> entities = session.createQuery("FROM " + type.getName(), type).getResultList();
            session.getTransaction().commit();
            return entities;
        }
    }

    public <T> void save(T entity) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        }

    }

    public <T> void delete(T entity) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.remove(entity);
            session.getTransaction().commit();
        }
    }

    public <T> T update(T entity) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            T lentity = session.merge(entity);
            session.getTransaction().commit();
            return lentity;
        }
    }
}
