package dao;

import entidades.IngredienteRemover;
import java.util.List;

public interface IngredienteRemoverDao {
    public void salvar(IngredienteRemoverDao ingredienteRemover);
    
    public void editar(IngredienteRemoverDao ingredienteRemover);
    
    public void remover(IngredienteRemoverDao ingredienteRemover);
    
    public List listar(IngredienteRemoverDao ingredienteRemover); 
}
