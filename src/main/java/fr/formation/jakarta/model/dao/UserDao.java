package fr.formation.jakarta.model.dao;

import fr.formation.jakarta.model.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao {
    private static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());
    private EntityManager em;

    public UserDao(EntityManager em) {
        this.em = em;
    }

    // Méthode utilitaire pour exécuter une opération en transaction
    private void executeInTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.accept(em);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            LOGGER.log(Level.SEVERE, "Transaction failed", e);
        }
    }

    // Retourne tous les utilisateurs
    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    // Recherche un utilisateur par son ID
    public User findById(Long id) {
        return em.find(User.class, id);
    }

    // Met à jour un utilisateur
    public void update(User user) {
        executeInTransaction(em -> em.merge(user));
    }

    // Enregistre un utilisateur
    public void save(User user) {
        executeInTransaction(em -> em.persist(user));
    }

    // Supprime un utilisateur par ID
    public void deleteById(Long id) {
        executeInTransaction(em -> {
            User user = em.find(User.class, id);
            if (user != null) {
                em.remove(user);
            }
        });
    }
}
