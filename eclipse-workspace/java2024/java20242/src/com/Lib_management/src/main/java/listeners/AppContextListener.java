package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Application started. Database config loading...");
    }
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Application shutdown.");
    }
}
