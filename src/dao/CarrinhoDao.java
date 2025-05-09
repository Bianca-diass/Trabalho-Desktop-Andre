package dao;

import entidades.Carrinho;
import java.util.List;

public interface CarrinhoDao {
    public void salvar(CarrinhoDao carrinho);
    
    public void editar(CarrinhoDao carrinho);
    
    public void remover(CarrinhoDao carrinho);
    
    public List listar(CarrinhoDao carrinho);
}
