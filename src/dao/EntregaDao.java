package dao;

import entidades.Entrega;
import java.util.List;

public interface EntregaDao {
    public void salvar(EntregaDao entrega);
    
    public void editar(EntregaDao entrega);
    
    public void remover(EntregaDao entrega);
    
    public List listar(EntregaDao entrega);
}
