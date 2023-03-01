package br.com.alura.loja.categoria;

import br.com.alura.loja.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}