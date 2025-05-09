package dao;

import entidades.Funcionario;
import java.util.List;

public interface FuncionarioDao {
    public void salvar(FuncionarioDao funcionario);
    
    public void editar(FuncionarioDao funcionario);
    
    public void remover(FuncionarioDao funcionario);
    
    public List listar(FuncionarioDao funcionario);
 
}
