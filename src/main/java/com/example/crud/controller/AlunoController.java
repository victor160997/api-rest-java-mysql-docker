package com.example.crud.controller;

import com.example.crud.model.Aluno;
import com.example.crud.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> all() {
        return alunoService.getAllAlunos();
    }

    @GetMapping("/{matricula}")
    public Aluno get(@PathVariable Integer matricula) {
        return alunoService.getAlunoByMatricula(matricula);
    }

    @PostMapping
    public Aluno create(@RequestBody Aluno aluno) {
        return alunoService.createAluno(aluno);
    }

    @PutMapping("/{matricula}")
    public Aluno update(@PathVariable Integer matricula, @RequestBody Aluno aluno) {
        return alunoService.updateAluno(matricula, aluno);
    }

    @DeleteMapping("/{matricula}")
    public void delete(@PathVariable Integer matricula) {
        alunoService.deleteAluno(matricula);
    }
}