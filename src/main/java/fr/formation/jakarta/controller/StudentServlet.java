package fr.formation.jakarta.controller;

import fr.formation.jakarta.model.dao.StudentDAO;
import fr.formation.jakarta.model.entity.Student;
import fr.formation.jakarta.utils.JpaUtils;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/student/*")
public class StudentServlet extends AbstractCRUDServlet<Student, Long> {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        String action = req.getPathInfo();
        switch (action) {
            case "/list"    -> this.showAll(req, resp);
            case "/show"    -> this.showOne(req, resp);
            case "/delete"  -> this.delete(req, resp);
            case "/create"  -> this.showForm(req, resp, false);
            case "/edit"    -> this.showForm(req, resp, true);
            default         -> resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getPathInfo()){
            case "/create"  -> this.create(req, resp);
            case "/edit"    -> this.update(req, resp);
            default         -> resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected StudentDAO getDAO(EntityManager em) {return new StudentDAO(em);}

    @Override
    protected String getEntityName() {return "student";}

    @Override
    protected void hydrateForm(HttpServletRequest req, Student entity) {
        context.put("entity", entity);
    }

    @Override
    protected Student hydrateEntity(HttpServletRequest req) {
        Student entity = new Student();
        Long id = Long.parseLong(req.getParameter("id"));
        entity.setId(id);
        entity.setName(req.getParameter("name"));
        return entity;
    }

    @Override
    protected Long getIdFromRequest(HttpServletRequest req) {
        return Long.parseLong(req.getParameter("id"));
    }
}
