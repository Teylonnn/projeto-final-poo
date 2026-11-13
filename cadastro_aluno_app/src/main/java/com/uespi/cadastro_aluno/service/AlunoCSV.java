package com.uespi.cadastro_aluno.service;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AlunoCSV {

    public static void salvarCSV(List<Aluno> alunos) {
        try(CSVWriter writer = new CSVWriter(new FileWriter("ListagemAlunos.txt")))
        {
            writer.writeNext(new String[]{"Matricula", "Nome", "Idade", "Idade", "Data Nascimento", "Numero"});

            for (Aluno x : alunos) {
                writer.writeNext(new String[]{String.valueOf(x.getMatricula()),
                        x.getNome(),
                        String.valueOf(x.getIdade()),
                        String.valueOf(x.getDataNascimento()),
                        x.getTelefone(),
                        x.getCPF()
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}