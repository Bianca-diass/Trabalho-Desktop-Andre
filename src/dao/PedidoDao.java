package dao;

import entidades.Pedido;
import java.util.List;

public interface PedidoDao {
    public void salvar(PedidoDao Pedido);   
    
    public void editar(PedidoDao Pedido);
    
    public void remover(PedidoDao Pedido);
    
    public List listar(PedidoDao Pedido);
        
}
