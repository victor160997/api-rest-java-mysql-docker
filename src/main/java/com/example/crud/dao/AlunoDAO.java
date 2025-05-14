package com.example.crud.dao;

import com.example.crud.model.Aluno;
import com.example.crud.repository.AlunoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AlunoDAO {

    private final AlunoRepository alunoRepository;

    public AlunoDAO(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findBymatricula(Integer matricula) {
        return alunoRepository.findBymatricula(matricula);
    }

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void deleteById(Integer matricula) {
        alunoRepository.deleteById(matricula);
    }
}