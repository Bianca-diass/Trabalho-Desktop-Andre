package dao;

import entidades.Cliente;
import java.util.List;

public interface ClienteDao {
    public void salvar(ClienteDao cliente);
    
    public void editar(ClienteDao cliente);
    
    public void remover(ClienteDao cliente);
    
    public List listar(ClienteDao cliente);

}
