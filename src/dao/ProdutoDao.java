package dao;

import entidades.Produto;
import java.util.List;

public interface ProdutoDao {
    public void salvar(ProdutoDao Produto);
    
    public void editar(ProdutoDao Produto);
    
    public void remover(ProdutoDao Produto);
    
    public List listar(ProdutoDao Produto);
}
