package com.example.avaliacoesrestaurante.controller;
import java.net.URI;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import com.example.avaliacoesrestaurante.model.Avaliacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.avaliacoesrestaurante.repository.AvaliacaoRepository;

@RestController
@RequestMapping("/avaliacoes-restaurantes")
public class AvaliacaoController {
    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoController(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @GetMapping
    public List<Avaliacao> getAllAvaliacao(){
        return avaliacaoRepository.findAll();
    }

    @GetMapping("/avaliacoes-restaurantes/byName/{nome}")
    public List<Avaliacao> getAvaliacoesByName(@PathVariable String nome) {
        return avaliacaoRepository.findAvaliacoesByName(nome);
    }

    @PostMapping
    public ResponseEntity<Avaliacao> createProduct(@RequestBody Avaliacao avaliacao) {
        Avaliacao newAvaliacao = avaliacaoRepository.save(avaliacao);
        return ResponseEntity.created(URI.create("/avaliacoes-restaurantes/" + newAvaliacao.getId())).body(newAvaliacao);
    }

    @DeleteMapping("/{avaliacaoId}")
    public ResponseEntity<Void> deleteAvaliacao(@PathVariable Long avaliacaoId) {
        Optional<Avaliacao> product = avaliacaoRepository.findById(avaliacaoId);

        if (product.isPresent()) {
            avaliacaoRepository.deleteById(avaliacaoId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
