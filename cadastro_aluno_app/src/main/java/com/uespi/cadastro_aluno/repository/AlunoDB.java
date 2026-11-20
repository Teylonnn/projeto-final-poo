package com.uespi.cadastro_aluno.repository;

import com.uespi.cadastro_aluno.model.Aluno;
import com.uespi.cadastro_aluno.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AlunoDB {

    // Salva (insere ou atualiza) uma lista de alunos
    public static void SalvarDb(List<Aluno> alunos) {
        Transaction t = null;
        try (Session sessao = HibernateUtil.getSessionFactory().openSession()) {
            t = sessao.beginTransaction();
            for (Aluno x : alunos) {
                sessao.merge(x);
            }
            t.commit();
        } catch (RuntimeException e) {
            if (t != null && t.isActive()) t.rollback();
            throw e;
        }
    }

    // Atualiza um aluno já existente (identificado pela matrícula).
    // Retorna false se não existir no banco.
    public static boolean AtualizarDb(Aluno aluno) {
        Transaction t = null;
        try (Session sessao = HibernateUtil.getSessionFactory().openSession()) {
            t = sessao.beginTransaction();

            if (sessao.find(Aluno.class, aluno.getMatricula()) == null) {
                t.rollback();
                return false;
            }

            sessao.merge(aluno);
            t.commit();
            return true;
        } catch (RuntimeException e) {
            if (t != null && t.isActive()) t.rollback();
            throw e;
        }
    }

    // Remove um aluno pela matrícula.
    // Retorna false se não existir no banco.
    public static boolean RemoverDb(int matricula) {
        Transaction t = null;
        try (Session sessao = HibernateUtil.getSessionFactory().openSession()) {
            t = sessao.beginTransaction();

            Aluno aluno = sessao.find(Aluno.class, matricula);
            if (aluno == null) {
                t.rollback();
                return false;
            }

            sessao.remove(aluno);
            t.commit();
            return true;
        } catch (RuntimeException e) {
            if (t != null && t.isActive()) t.rollback();
            throw e;
        }
    }

    // Busca um aluno pela matrícula (null se não existir)
    public static Aluno BuscarPorMatricula(int matricula) {
        try (Session sessao = HibernateUtil.getSessionFactory().openSession()) {
            return sessao.find(Aluno.class, matricula);
        }
    }

    // Função para receber a lista de alunos que estão no bd
    public static List<Aluno> ListarAlunos() {
        try (Session sessao = HibernateUtil.getSessionFactory().openSession()) {
            return sessao.createQuery("FROM Aluno", Aluno.class).getResultList();

        }
    }
}