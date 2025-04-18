package fr.formation.jakarta.controller;

import fr.formation.jakarta.model.dao.GenericDAO;
import fr.formation.jakarta.model.dao.StudentDAO;
import fr.formation.jakarta.model.entity.Student;
import fr.formation.jakarta.utils.JpaUtils;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public abstract class AbstractCRUDServlet<T, ID> extends AbstractServlet {

    protected abstract GenericDAO<T, ID> getDAO(EntityManager em);
    protected abstract String getEntityName();
    protected abstract void hydrateForm(HttpServletRequest req, T entity);
    protected abstract T hydrateEntity(HttpServletRequest req);
    protected abstract ID getIdFromRequest(HttpServletRequest req);

    protected void showAll(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws IOException {
        EntityManager em = JpaUtils.getEntityManager();
        List<T> dataList = getDAO(em).findAll();

        context.put(getEntityName() + "sList", dataList);
        render(resp, req.getContextPath() + getEntityName() + "/list.peb");
    }

    protected void showOne(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        EntityManager em = JpaUtils.getEntityManager();
        ID id = getIdFromRequest(req);

        T entity = getDAO(em).findById(id);

        hydrateForm(req, entity);
        context.put(getEntityName(), id);
        render(resp, req.getContextPath() + getEntityName() + "/showOne.peb");
    }

    protected void create(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        EntityManager em = JpaUtils.getEntityManager();
        T entity = hydrateEntity(req);

        getDAO(em).persist(entity);

        em.close();
        resp.sendRedirect(req.getContextPath() + getEntityName() + "/list");
    }

    protected void update(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        EntityManager em = JpaUtils.getEntityManager();
        T entity = hydrateEntity(req);

        getDAO(em).update(entity);

        em.close();
        resp.sendRedirect(req.getContextPath() + getEntityName() + "/list");
    }

    protected void showForm(
            HttpServletRequest req,
            HttpServletResponse resp,
            boolean forEdit
    )  throws ServletException, IOException {
        if(forEdit) {
            EntityManager em = JpaUtils.getEntityManager();
            ID id = getIdFromRequest(req);

            T entity = getDAO(em).findById(id);
            em.close();

            if(entity != null) {
                hydrateForm(req, entity);
            }
        }
        render(resp, req.getContextPath() + getEntityName() + "/form.peb");
    }

    protected void delete(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        EntityManager em = JpaUtils.getEntityManager();
        ID id = getIdFromRequest(req);

        getDAO(em).deleteOneById(id);

        em.close();
        resp.sendRedirect("/" + getEntityName() + "/list");
    }
}
