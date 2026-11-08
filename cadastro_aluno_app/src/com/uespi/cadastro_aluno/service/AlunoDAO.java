package com.uespi.cadastro_aluno.service;

import java.util.List;

public interface AlunoDAO {
    List getTodosEstudantes(List<Aluno> l);

    void addEstudante(List<Aluno> l, Aluno a);

    void addEstudante(List<Aluno> l, Aluno a, int posicao);

    Aluno obterAluno(List<Aluno> l, int matricula);

    int qntdElementos(List<Aluno> l);

    int alunoMaisVelho(List<Aluno> l);

    List removerAluno(List<Aluno> l, Aluno a);

    int alunoMaisNovo(List<Aluno> l);

}
