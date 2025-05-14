package com.example.crud.repository;

import com.example.crud.model.Aluno;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    Optional<Aluno> findBymatricula(Integer matricula);
}