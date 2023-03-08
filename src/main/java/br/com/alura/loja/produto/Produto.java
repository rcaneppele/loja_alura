package br.com.alura.loja.produto;

import br.com.alura.loja.categoria.Categoria;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@Entity(name = "Produto")
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal preco;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Produto(CadastroDeProdutoDto dto, Categoria categoria) {
        this.nome = dto.nome();
        this.preco = dto.preco();
        this.descricao = dto.descricao();
        this.categoria = categoria;
    }

    public void atualizar(AtualizacaoDeProdutoDto dto, Categoria categoria) {
        this.descricao = dto.descricao();
        this.preco = dto.preco();
        this.categoria = categoria;
    }
}
