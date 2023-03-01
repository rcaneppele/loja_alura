package br.com.alura.loja.controller;

import br.com.alura.loja.categoria.AtualizacaoDeCategoriaDto;
import br.com.alura.loja.categoria.CadastroDeCategoriaDto;
import br.com.alura.loja.categoria.Categoria;
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

@Controller
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping("/nova")
    public String carregarPaginaFormulario() {
        return "categoria/formulario";
    }

    @PostMapping
    @Transactional
    public String cadastrar(CadastroDeCategoriaDto dto) {
        repository.save(new Categoria(dto));
        return "redirect:categorias";
    }

    @GetMapping
    public String listar(Model model) {
        var lista = repository.findAll();
        model.addAttribute("categorias", lista);
        return "categoria/lista-categorias";
    }

    @DeleteMapping
    @Transactional
    public String remover(Long id) {
        repository.deleteById(id);
        return "redirect:categorias";
    }

    @GetMapping("/{id}")
    public String detalhar(@PathVariable Long id, Model model) {
        var categoria = repository.getReferenceById(id);

        model.addAttribute("categoria", categoria);

        return "categoria/formulario";
    }

    @PutMapping
    @Transactional
    public String atualizar(AtualizacaoDeCategoriaDto dto) {
        var categoria = repository.getReferenceById(dto.id());

        categoria.atualizar(dto);

        return "redirect:categorias";
    }

}
