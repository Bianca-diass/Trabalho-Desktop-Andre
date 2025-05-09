package dao;

import entidades.Pagamento;
import java.util.List;

public interface PagamentoDao {
    public void salvar(PagamentoDao Pagamento);
    
    public void editar(PagamentoDao Pagamento);
    
    public void remover(PagamentoDao Pagamento);
    
    public List listar(PagamentoDao Pagamento); 
}
