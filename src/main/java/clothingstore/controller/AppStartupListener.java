package clothingstore.controller;

import clothingstore.utils.LogUtil;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener
public class AppStartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Call the method to ensure the logs folder exists
        LogUtil.ensureLogsFolderExists();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // You can also add code here to perform cleanup tasks when the application stops
    }
}