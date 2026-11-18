package com.uespi.cadastro_aluno;

import com.uespi.cadastro_aluno.model.Aluno;
import com.uespi.cadastro_aluno.repository.AlunoDB;
import com.uespi.cadastro_aluno.util.HibernateUtil;

import java.util.List;

public class TesteLeitura {
    public static void main(String[] args) {
        try {
            List<Aluno> alunos = AlunoDB.ListarAlunos();
            System.out.println("Total no banco: " + alunos.size());
            alunos.forEach(System.out::println);
        } finally {
            HibernateUtil.shutdown();
        }
    }
}