package dao;

import entidades.Endereco;
import java.util.List;

public interface EnderecoDao {
    public void salvar(EnderecoDao endereco);
    
    public void editar(EnderecoDao endereco);
    
    public void remover(EnderecoDao endereco);
    
    public List listar(EnderecoDao endereco);   
}
