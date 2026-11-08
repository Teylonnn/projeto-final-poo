package com.uespi.cadastro_aluno.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Aluno {
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String nome;
    private int idade, matricula;
    private LocalDate dataNascimento;
    private String telefone;
    private String CPF;
    //Construtor
    public Aluno(String nome, String CPF, int matricula, LocalDate dataNascimento, String telefone) {
        this.nome = nome;
        this.CPF = CPF;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        this.telefone = telefone;
    }

    //método imprimir alunos
    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", telefone=" + telefone +
                ", CPF=" + CPF +
                ", matricula=" + matricula +
                ", dataNascimento= " + dataNascimento.format(formato);
    }

    //Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
