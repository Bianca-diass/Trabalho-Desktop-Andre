package dao;

import entidades.IngredienteAdicional;
import java.util.List;

public interface IngredienteAdicionalDao {
    public void salvar(IngredienteAdicionalDao ingredienteAdicional);
    
    public void editar(IngredienteAdicionalDao ingredienteAdicional);
    
    public void remover(IngredienteAdicionalDao ingredienteAdicional);
    
    public List listar(IngredienteAdicionalDao ingredienteAdicional);
}
