package dao;

import entidades.Delivery;
import java.util.List;

public interface DeliveryDao {
    public void salvar(DeliveryDao delivery);
    
    public void editar(DeliveryDao delivery);
    
    public void remover(DeliveryDao delivery);
    
    public List listar(DeliveryDao delivery);  
}
