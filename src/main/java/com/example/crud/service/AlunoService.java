package com.example.crud.service;

import com.example.crud.dao.AlunoDAO;
import com.example.crud.model.Aluno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoDAO alunoDAO;

    public AlunoService(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public List<Aluno> getAllAlunos() {
        return alunoDAO.findAll();
    }

    public Aluno getAlunoByMatricula(Integer matricula) {
        return alunoDAO.findBymatricula(matricula).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    public Aluno createAluno(Aluno aluno) {
        return alunoDAO.save(aluno);
    }

    public Aluno updateAluno(Integer matricula, Aluno alunoAtualizado) {
        Aluno aluno = alunoDAO.findBymatricula(matricula)
                .orElseThrow(() -> new RuntimeException("Aluno não encontradoo"));
        aluno.setNome(alunoAtualizado.getNome());
        aluno.setIdade(alunoAtualizado.getIdade());
        aluno.setEmail(alunoAtualizado.getEmail());
        return alunoDAO.save(aluno);
    }

    public void deleteAluno(Integer matricula) {
        alunoDAO.deleteById(matricula);
    }
}