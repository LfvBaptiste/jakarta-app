package fr.formation.jakarta.model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.function.Consumer;

public abstract class GenericDAO<T, ID> implements GenericDAOInterface<T, ID>{

    protected EntityManager em;
    protected Class<T> givenClass;

    public GenericDAO(EntityManager em, Class<T> givenClass) {
        this.em = em;
        this.givenClass = givenClass;
    }

    private void ExecuteInTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            action.accept(em);
            tx.commit();
        } catch (Exception ex){
            tx.rollback();
        }
    }

    @Override
    public List<T> findAll() {
        String jpql = "SELECT e FROM " + givenClass.getSimpleName() + " e";
        TypedQuery query = em.createQuery(jpql, givenClass);
        return query.getResultList();
    }

    public T findById(ID id) {
        return em.find(givenClass, id);
    }

    public void persist(T entity) {
        ExecuteInTransaction(em -> {em.persist(entity);});
    }

    public void update(T entity){
        ExecuteInTransaction(em -> {em.merge(entity);});
    }

    public void deleteOneById(ID id) {
        ExecuteInTransaction(em -> {em.remove(em.find(givenClass, id));});
    }
}
