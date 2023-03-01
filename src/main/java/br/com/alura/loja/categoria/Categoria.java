package br.com.alura.loja.categoria;

import br.com.alura.loja.produto.AtualizacaoDeProdutoDto;
import br.com.alura.loja.produto.CadastroDeProdutoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@Entity(name = "Categoria")
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Categoria(CadastroDeCategoriaDto dto) {
        this.nome = dto.nome();
    }

    public void atualizar(AtualizacaoDeCategoriaDto dto) {
        this.nome = dto.nome();
    }
}
