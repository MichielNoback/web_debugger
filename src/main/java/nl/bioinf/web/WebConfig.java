package nl.bioinf.web;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletResponse;

@WebListener
public class WebConfig  implements ServletContextListener{
    private static TemplateEngine DEFAULT_TEMPLATE_ENGINE;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        createTemplateEngine(sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //pass
    }


    private static void createTemplateEngine(ServletContext servletContext) {
        ServletContextTemplateResolver templateResolver =
                new ServletContextTemplateResolver(servletContext);
        templateResolver.setTemplateMode("HTML");
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheTTLMs(3600000L);
        templateResolver.setCacheable(true);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        WebConfig.DEFAULT_TEMPLATE_ENGINE = templateEngine;
    }

    /**
     * serves the template engine that was created at application startup.
     * @return
     */
    public static TemplateEngine getDefaultTemplateEngine() {
        return DEFAULT_TEMPLATE_ENGINE;
    }

    /**
     * Configures the response in a standard way.
     * @param response
     */
    public static void configureResponse(HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
    }

}

