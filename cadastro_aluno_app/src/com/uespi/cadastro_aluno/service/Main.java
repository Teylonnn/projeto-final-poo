package com.uespi.cadastro_aluno.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() throws ParseException {
        AlunoDAO cadastro = new CadastroAluno();
        List<Aluno> alunos = new ArrayList();

        int n = 3;
        for(int i = 0; i < n; i ++){
            String nome = "Jesus" + i;
            String CPF = "000.000.000-000";
            int matricula = i;
            String telefone = "(86)994607168";
            LocalDate dataNascimento = LocalDate.of(2012,11,8);

            Aluno a = new Aluno(nome, CPF, matricula,dataNascimento, telefone);
            cadastro.addEstudante(alunos, a);
        }

        System.out.println("Aluno mais novo: " + cadastro.alunoMaisNovo(alunos));
        System.out.println("Aluno mais velho: " + cadastro.alunoMaisVelho(alunos));
        System.out.println(cadastro.obterAluno(alunos, 2));

        System.out.println("------------------------------------");

        for (Aluno x : alunos){
            System.out.println(x);
        }
        System.out.println("Quantidade alunos:" + cadastro.qntdElementos(alunos));

        System.out.println("------------------------------------");

        cadastro.removerAluno(alunos, cadastro.obterAluno(alunos, 1));
        System.out.println("Quantidade alunos:" + cadastro.qntdElementos(alunos));

        for (Aluno x : alunos){
            System.out.println(x);
        }

        AlunoCSV.salvarCSV(alunos);
    }
}
