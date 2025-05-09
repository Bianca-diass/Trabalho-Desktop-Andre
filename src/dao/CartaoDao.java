package dao;

import entidades.Cartao;
import java.util.List;

public interface CartaoDao {
    public void salvar(CartaoDao cartao);
    
    public void editar(CartaoDao cartao);
    
    public void remover(CartaoDao cartao);
    
    public List listar(CartaoDao cartao);
}
