package fr.formation.jakarta.controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@WebServlet("/upload")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
public class UploadServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("upload.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException
    {
        // Récupérer le chemin de sauvegarde
        String applicationPath = getServletContext().getRealPath("");
        String uploadPath = applicationPath + File.separator + UPLOAD_DIR;

        // Créer le dossier si nécessaire
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        for (Part part : request.getParts()) {
            String originalFileName = Paths.get(part.getSubmittedFileName())
                    .getFileName()
                    .toString();

            String fileExtension = getFileExtension(originalFileName);
            String uniqueFileName = UUID.randomUUID().toString()
                    + fileExtension;

            // Chemin complet du fichier à enregistrer
            String filePath = uploadPath
                    + File.separator
                    + uniqueFileName;

            System.out.println(filePath);

            //File newUploadeDir = new File("uploads");
            //if(! newUploadeDir.exists()) newUploadeDir.mkdirs();

            // Enregistrement du fichier
            part.write(filePath);
            //part.write(applicationPath + File.separator + uniqueFileName);

            System.out.println(applicationPath + File.separator + uniqueFileName);

            response.getWriter().println(
                    "Fichier uploadé avec succès : " + uniqueFileName
            );
        }
    }

    // Méthode pour extraire l'extension du fichier
    private String getFileExtension(String fileName) {
        Path path = Paths.get(fileName);
        String name = path.getFileName().toString();
        int dotIndex = name.lastIndexOf(".");
        return (dotIndex == -1) ? "" : name.substring(dotIndex);
    }


}