package br.com.alura.loja.controller;

import br.com.alura.loja.produto.AtualizacaoDeProdutoDto;
import br.com.alura.loja.produto.CadastroDeProdutoDto;
import br.com.alura.loja.produto.Produto;
import br.com.alura.loja.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/novo")
    public String carregarPaginaFormulario() {
        return "produto/formulario";
    }

    @PostMapping
    @Transactional
    public String cadastrar(CadastroDeProdutoDto dto) {
        repository.save(new Produto(dto));
        return "redirect:produtos";
    }

    @GetMapping
    public String listar(Model model) {
        var lista = repository.findAll();
        model.addAttribute("produtos", lista);
        return "produto/lista-produtos";
    }

    @DeleteMapping
    @Transactional
    public String remover(Long id) {
        repository.deleteById(id);
        return "redirect:produtos";
    }

    @GetMapping("/{id}")
    public String detalhar(@PathVariable Long id, Model model) {
        var produto = repository.getReferenceById(id);

        model.addAttribute("produto", produto);

        return "produto/formulario";
    }

    @PutMapping
    @Transactional
    public String atualizar(AtualizacaoDeProdutoDto dto) {
        var produto = repository.getReferenceById(dto.id());

        produto.atualizar(dto);

        return "redirect:produtos";
    }

}
