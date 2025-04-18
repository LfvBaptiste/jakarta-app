package fr.formation.jakarta.model.dao;

import fr.formation.jakarta.model.entity.Course;
import jakarta.persistence.EntityManager;

public class CourseDAO extends GenericDAO<Course, Long> {

    public CourseDAO(EntityManager em) {
        super(em, Course.class);
    }
}
