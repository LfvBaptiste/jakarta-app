package fr.formation.jakarta.model.dao;

import fr.formation.jakarta.model.entity.Student;
import jakarta.persistence.EntityManager;

public class StudentDAO extends GenericDAO<Student, Long>{

    public StudentDAO(EntityManager em) {
        super(em, Student.class);
    }
}
