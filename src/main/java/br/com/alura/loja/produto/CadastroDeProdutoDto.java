package br.com.alura.loja.produto;

import java.math.BigDecimal;

public record CadastroDeProdutoDto(String nome, BigDecimal preco, String descricao, Long categoria) {
}
