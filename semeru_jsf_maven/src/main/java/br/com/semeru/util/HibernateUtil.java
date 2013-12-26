package br.com.semeru.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static final String HIBERNATE_SESSION = "Hibernate_Session";

    static {
        try {
            System.out.println("Tentando abrir uma SessionFactory");
            Configuration configuration = new Configuration().configure();

            ServiceRegistry sr = new ServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(sr);
            System.out.println("SessionFactory criado com sucesso!");
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
