package dao;

import entidades.MetPagamento;
import java.util.List;

public interface MetPagamentoDao {
    public void salvar(MetPagamentoDao MetPagamento);
    
    public void editar(MetPagamentoDao MetPagamento);
    
    public void remover(MetPagamentoDao MetPagamento);
    
    public List listar(MetPagamentoDao MetPagamento); 
}
