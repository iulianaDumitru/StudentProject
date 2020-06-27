package persistence.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import persistence.dto.*;

import java.util.Properties;

public class GenericDaoSingleton {

    private SessionFactory sessionFactory;
    private static GenericDaoSingleton genericDaoSingleton;

   private GenericDaoSingleton() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.URL,
                "jdbc:mysql://localhost:3306/studentproject?serverTimezone=UTC");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "parolamysql@1990");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.put(Environment.SHOW_SQL, "true");//
        properties.put(Environment.HBM2DDL_AUTO, "update");

        configuration.setProperties(properties);


        configuration.addAnnotatedClass(ClassroomsModel.class);
        configuration.addAnnotatedClass(ScheduleModel.class);
        configuration.addAnnotatedClass(CoursesModel.class);
        configuration.addAnnotatedClass(ProfessorsModel.class);
        configuration.addAnnotatedClass(StudentsModel.class);


        sessionFactory = configuration.buildSessionFactory();
    }

    public static GenericDaoSingleton getInstance() {
        if (genericDaoSingleton == null) {
            genericDaoSingleton = new GenericDaoSingleton();
        }
        return genericDaoSingleton;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
