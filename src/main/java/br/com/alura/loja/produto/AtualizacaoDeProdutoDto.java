package br.com.alura.loja.produto;

import java.math.BigDecimal;

public record AtualizacaoDeProdutoDto(Long id, BigDecimal preco, String descricao) {
}
