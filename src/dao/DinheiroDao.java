package dao;

import entidades.Dinheiro;
import java.util.List;

public interface DinheiroDao {
    public void salvar(DinheiroDao dinheiro);
    
    public void editar(DinheiroDao dinheiro);
    
    public void remover(DinheiroDao dinheiro);
    
    public List listar(DinheiroDao dinheiro);

}
