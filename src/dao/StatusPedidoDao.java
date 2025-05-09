package dao;

import entidades.StatusPedido;
import java.util.List;

public interface StatusPedidoDao {
    public void salvar(StatusPedidoDao StatusPedido);
    
    public void editar(StatusPedidoDao StatusPedido);
    
    public void remover(StatusPedidoDao StatusPedido);
    
    public List listar(StatusPedidoDao StatusPedido);  
}
