package com.uespi.cadastro_aluno.util;

import com.uespi.cadastro_aluno.model.Aluno;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY = new Configuration().configure().addAnnotatedClass(Aluno.class).buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}

