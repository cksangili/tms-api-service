package com.tms.runner;
import com.tms.config.TaskConfiguration;
import com.tms.dao.TaskDao;
import com.tms.entity.TaskEntity;
import com.tms.resource.TaskController;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class TaskRunner extends Application<TaskConfiguration>{


    public static void main(String[] args) throws Exception {
        //System.out.println("Hello Main.. "+args.length+" "+args[0]+" "+args[1]);
        //String configFile = args.length > 1
         //       ? args[1]
          //      : ClassLoader.getSystemClassLoader().getResource("dbconfig.yaml").toString();
       // args[1] = ClassLoader.getSystemClassLoader().getResourceAsStream("dbconfig.yaml").toString();

               new TaskRunner().run(args);
    }

    @Override
    public void run(TaskConfiguration configuration, Environment environment) throws Exception {
        System.out.println("Hello TMS..");

        // Enable CORS headers
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        TaskDao taskDao = new TaskDao(hibernateBundle.getSessionFactory());
        environment.jersey().register(new TaskController(taskDao));

    }

    HibernateBundle<TaskConfiguration> hibernateBundle = new HibernateBundle<TaskConfiguration>(TaskEntity.class) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(TaskConfiguration taskConfiguration) {
            return taskConfiguration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<TaskConfiguration> bootstrap){
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
        bootstrap.addBundle(hibernateBundle);
    }
}
