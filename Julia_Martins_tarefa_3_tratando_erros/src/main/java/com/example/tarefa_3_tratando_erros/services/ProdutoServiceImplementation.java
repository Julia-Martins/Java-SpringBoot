package com.example.tarefa_3_tratando_erros.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.tarefa_3_tratando_erros.dtos.CategoriaProdutoDTO;
import com.example.tarefa_3_tratando_erros.dtos.DadosProdutoDTO;
import com.example.tarefa_3_tratando_erros.dtos.ProdutoDTO;
import com.example.tarefa_3_tratando_erros.exceptions.RegraNegocioException;
import com.example.tarefa_3_tratando_erros.models.CategoriaProduto;
import com.example.tarefa_3_tratando_erros.models.Produto;
import com.example.tarefa_3_tratando_erros.repository.CategoriaProdutoRepository;
import com.example.tarefa_3_tratando_erros.repository.ProdutoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImplementation implements ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final CategoriaProdutoRepository categoriaProdutoRepository;
    
    @Override
    public Produto salvar(ProdutoDTO produtoDTO) {
        CategoriaProduto categoriaProduto = categoriaProdutoRepository.findById(
            produtoDTO.getId_categoriaProd()).orElseThrow(
                () -> new RegraNegocioException("Código da categoria não foi encontrado!")
        );

        Produto p = new Produto();
        p.setCategoriaProduto(categoriaProduto);
        p.setNome(produtoDTO.getNome());
        p.setPreco(produtoDTO.getPreco());

        return produtoRepository.save(p);
    }

    @Override
    public List<ProdutoDTO> listAll() {
        List<ProdutoDTO> produtos = produtoRepository.findAll().stream().map(
            (Produto p) -> {
                return ProdutoDTO.builder()
                .id(p.getId())
                .nome(p.getNome())
                .preco(p.getPreco())
                .id_categoriaProd(p.getCategoriaProduto() != null ? p.getCategoriaProduto().getId_categoria(): 0)
                .build();
            }
        ).collect(Collectors.toList());

        return produtos;
    }

    @Override
    public DadosProdutoDTO obtainById(Integer id) {
        return produtoRepository.findById(id).map(
            (Produto p) -> {
                return 
                    DadosProdutoDTO.builder()
                    .id(p.getId())
                    .nome(p.getNome())
                    .preco(p.getPreco())
                    .categoria(
                        p.getCategoriaProduto() != null ?
                        CategoriaProdutoDTO.builder()
                        .id_categoria(p.getCategoriaProduto().getId_categoria())
                        .name(p.getCategoriaProduto().getName())
                        .build() : null
                ).build();
            }
        ).orElseThrow(
            () -> new RegraNegocioException("Produto não encontrado com o ID Fornecido!")
        );
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public void update(Integer id, ProdutoDTO dto) {
        Produto produto = produtoRepository.findById(id).orElseThrow(
            () -> new RegraNegocioException("Código usuário não encontrado."));

        CategoriaProduto categoriaProduto = categoriaProdutoRepository.findById(dto.getId_categoriaProd())
        .orElseThrow(
            () -> new RegraNegocioException("Categoria não Encontrada.")
        );

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setCategoriaProduto(categoriaProduto);
        produtoRepository.save(produto);
    }
}
