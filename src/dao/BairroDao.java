package dao;

import entidades.Bairro;
import java.util.List;

public interface BairroDao {
    public void salvar(BairroDao bairro);
    
    public void editar(BairroDao bairro);
    
    public void remover(BairroDao bairro);
    
    public List listar(BairroDao bairro);

    public String getNome();

    public int getId();

    public int getEnderecoId();

}
