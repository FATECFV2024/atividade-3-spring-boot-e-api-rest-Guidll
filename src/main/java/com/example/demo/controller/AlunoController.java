package com.example.demo.controller;


import com.example.demo.model.Aluno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private Aluno aluno;

    @PostMapping("/criar")
    public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno novoAluno) {
        this.aluno = novoAluno;
        return ResponseEntity.ok(this.aluno);
    }

    @GetMapping("/dados")
    public ResponseEntity<Aluno> getAluno() {
        return ResponseEntity.ok(this.aluno);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Aluno> atualizarAluno(@RequestBody Aluno novoAluno) {
        if (this.aluno != null) {
            this.aluno = novoAluno;
            return ResponseEntity.ok(this.aluno);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/remover")
    public ResponseEntity<Void> removerAluno() {
        this.aluno = null;
        return ResponseEntity.noContent().build();
    }
}