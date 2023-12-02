package com.example.avaliacoesrestaurante.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.avaliacoesrestaurante.model.Avaliacao;
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{
    @Query("SELECT a FROM Avaliacao a WHERE a.nome = :nome")
    List<Avaliacao> findAvaliacoesByName(@Param("nome") String nome);
    Optional<Avaliacao> findById(Long id);


}
