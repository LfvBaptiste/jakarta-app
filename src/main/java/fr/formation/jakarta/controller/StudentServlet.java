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
import java.util.List;

@WebServlet("/student/*")
public class StudentServlet extends AbstractServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        String action = req.getPathInfo();
        switch (action) {
            case "/create"  -> this.create(req, resp);
            case "/list"    -> this.showAll(req, resp);
            case "/show"    -> this.showOne(req, resp);
            default         -> resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void showAll(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        EntityManager em = JpaUtils.getEntityManager();
        StudentDAO dao = new StudentDAO(em);
        List<Student> students = dao.findAll();

        context.put("students", students);
        render(resp, "student/list.peb");
    }

    private void create(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        EntityManager em = JpaUtils.getEntityManager();
        StudentDAO dao = new StudentDAO(em);

    }

    private void showOne(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        EntityManager em = JpaUtils.getEntityManager();
        StudentDAO dao = new StudentDAO(em);

        Long id = Long.parseLong(req.getParameter("id"));
        Student student = dao.findById(id);

        context.put("student", student);
        render(resp, "student/showOne.peb");
    }
}
