package com.uespi.cadastro_aluno.service;

import java.util.List;
import java.util.NoSuchElementException;

public class CadastroAluno implements AlunoDAO{

    @Override
    public List getTodosEstudantes(List<Aluno> l) {
        return l;
    }

    @Override
    public List removerAluno(List<Aluno> l, Aluno a) {
        l.remove(a);
        return l;
    }

    //Método adicionar o aluno
    @Override
    public void addEstudante(List<Aluno> l, Aluno a) {
        for (Aluno x : l){
            if(x.getMatricula() == a.getMatricula()){
                throw new IllegalArgumentException("Matrícula já Cadastrada");
            }
        }
        l.add(a);
    }

    //Método adicionar o aluno com base na posição
    @Override
    public void addEstudante(List<Aluno> l, Aluno a, int posicao) {
        for (Aluno x : l){
            if(x.getMatricula() == a.getMatricula()){
                throw new IllegalArgumentException("Matrícula já Cadastrada");
            }
        }
        l.add(posicao,a);
    }

    //obter aluno com base na matricula
    @Override
    public Aluno obterAluno(List<Aluno> l, int matricula){
        for(Aluno x : l){
            if(x.getMatricula() == matricula) {
                return x;
            }
        }
        throw new NoSuchElementException("Aluno não encontrado");
    }

    //quantidade de elementos na lista
    @Override
    public int qntdElementos(List<Aluno> l){
        return l.size();
    }

    //retorna a matricula do aluno mais velho
    @Override
    public int alunoMaisVelho(List<Aluno> l) {
        int id = 0;
        int idade = 0;
        for(Aluno x : l){
            if(x.getIdade() > idade  ){
                idade = x.getIdade();
                id = x.getMatricula();
            }
        }
        return id;
    }

    //retorna a matricula do aluno mais novo
    @Override
    public int alunoMaisNovo(List<Aluno> l) {
        int id = 0;
        int idade = 300;
        for(Aluno x : l){
            if(x.getIdade() < idade  ){
                idade = x.getIdade();
                id = x.getMatricula();
            }
        }
        return id;
    }
}
