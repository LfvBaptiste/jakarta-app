package fr.formation.jakarta.controller;


import io.pebbletemplates.pebble.PebbleEngine;
import io.pebbletemplates.pebble.template.PebbleTemplate;
import io.pebbletemplates.pebble.loader.ClasspathLoader;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractServlet extends HttpServlet {
    private PebbleEngine pebbleEngine;

    protected Map<String, Object> context;


    @Override
    public void init() {
        ClasspathLoader loader = new ClasspathLoader();
        loader.setPrefix("templates");

        pebbleEngine = new PebbleEngine.Builder()
                .loader(loader)
                .build();

        // Initialisation du contexte
        context = new HashMap<>();
    }




    protected void render(
            HttpServletResponse response,
            String templateName
    ) throws IOException {

        // Obtenir le template Pebble
        PebbleTemplate template = pebbleEngine.getTemplate(
                templateName
        );

        // Evaluer le template et envoyer la réponse HTTP
        response.setContentType("text/html");
        Writer writer = response.getWriter();
        template.evaluate(writer, context);
        writer.close();
    }
}
