package dao;

import entidades.Telefone;
import java.util.List;

public interface TelefoneDao {
    public void salvar(TelefoneDao Telefone);
    
    public void editar(TelefoneDao Telefone);
    
    public void remover(TelefoneDao Telefone);
    
    public List listar(TelefoneDao Telefone);

}
