package com.uespi.cadastro_aluno.repository;

import com.uespi.cadastro_aluno.model.Aluno;
import com.uespi.cadastro_aluno.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AlunoDB {
    public static void SalvarDb(List<Aluno> alunos) {
        Transaction t = null;
        try (Session sessao = HibernateUtil.getSessionFactory().openSession()) { //abre uma sessão com o banco
            t = sessao.beginTransaction(); //começa transação
            try {
                for (Aluno x : alunos) { //prepara cada aluno dentro da lista para o commit
                    sessao.persist(x);
                }
                t.commit(); //confirma o envio

            } catch (Exception e) {
                if (t.isActive()) {
                    t.rollback();
                }
                e.printStackTrace();
            }
        }
    }

    //método que usei para testar se tava sendo salvo corretamente no BD, vou deixar para a função funcionar na Main
    public static List<Aluno> ListarAlunos() {

        try (Session sessao = HibernateUtil.getSessionFactory().openSession()) {

            return sessao.createQuery("FROM Aluno", Aluno.class)
                    .getResultList();

        }
    }
}
