package br.com.alura.loja.controller;

import br.com.alura.loja.categoria.CategoriaRepository;
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

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/novo")
    public String carregarPaginaFormulario(Model model) {
        var categorias = categoriaRepository.findAll();

        model.addAttribute("categorias", categorias);

        return "produto/formulario";
    }

    @PostMapping
    @Transactional
    public String cadastrar(CadastroDeProdutoDto dto) {

        var categoria = categoriaRepository
                .getReferenceById(dto.categoria());

        repository.save(new Produto(dto, categoria));
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

        var categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);

        return "produto/formulario";
    }

    @PutMapping
    @Transactional
    public String atualizar(AtualizacaoDeProdutoDto dto) {
        var produto = repository.getReferenceById(dto.id());
        var categoria = categoriaRepository.getReferenceById(dto.categoria());

        produto.atualizar(dto, categoria);

        return "redirect:produtos";
    }

}
