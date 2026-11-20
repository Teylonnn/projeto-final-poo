package com.uespi.cadastro_aluno.util;

import com.uespi.cadastro_aluno.model.Aluno;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY = new Configuration()
            .configure()
            .addAnnotatedClass(Aluno.class)
            .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    // Chamar ao final do programa para garantir que tudo seja gravado em disco
    public static void shutdown() {
        if (SESSION_FACTORY != null && !SESSION_FACTORY.isClosed()) {
            SESSION_FACTORY.close();
        }
    }
}