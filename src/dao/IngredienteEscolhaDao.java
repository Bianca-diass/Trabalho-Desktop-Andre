package dao;

import entidades.IngredienteEscolha;
import java.util.List;

public interface IngredienteEscolhaDao {
    public void salvar(IngredienteEscolhaDao ingredienteEscolha);
    
    public void editar(IngredienteEscolhaDao ingredienteEscolha);
    
    public void remover(IngredienteEscolhaDao ingredienteEscolha);
    
    public List listar(IngredienteEscolhaDao ingredienteEscolha); 
}
