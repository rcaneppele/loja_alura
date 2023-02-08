package br.com.alura.loja.controller;

import br.com.alura.loja.produto.CadastroDeProdutoDto;
import br.com.alura.loja.produto.Produto;
import br.com.alura.loja.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Controller
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public String carregarPaginaFormulario() {
        return "produto/formulario";
    }

    @PostMapping
    @Transactional
    public String cadastrar(CadastroDeProdutoDto dto) {
        repository.save(new Produto(dto));
        return "produto/formulario";
    }

}
