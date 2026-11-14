package com.uespi.cadastro_aluno.model;

import com.uespi.cadastro_aluno.model.Aluno;
import java.util.List;

public interface AlunoDAO {
    List getTodosEstudantes(List<Aluno> l);

    boolean addEstudante(List<Aluno> l, Aluno a);

    boolean addEstudante(List<Aluno> l, Aluno a, int posicao);

    Aluno obterAluno(List<Aluno> l, int matricula);

    int qntdElementos(List<Aluno> l);

    int alunoMaisVelho(List<Aluno> l);

    List removerAluno(List<Aluno> l, Aluno a);

    int alunoMaisNovo(List<Aluno> l);

}
