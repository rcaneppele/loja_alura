package br.com.alura.loja.produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    boolean existsByCategoriaId(Long id);
}