package clothingstore.controller;

import clothingstore.utils.LogUtil;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;

@Slf4j
@WebListener
public class AppStartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Call the method to ensure the logs folder exists
        LogUtil.ensureLogsFolderExists();

        try {
            // Initialize Flyway and run the migrations
            Flyway flyway = Flyway.configure()
                .dataSource(
                    "jdbc:jtds:sqlserver://localhost:1433/ClothesShop",
                    "sa",
                    "Luucaohoang1604^^")
                .baselineOnMigrate(true)
                .load();

            // Run Flyway migrations
            flyway.migrate();
            log.info("migration success");
        } catch (Exception e) {
            log.error("migration fail");
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // You can also add code here to perform cleanup tasks when the application stops
    }
}