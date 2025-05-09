package dao;

import entidades.Login;
import java.util.List;

public interface LoginDao {
    public void salvar(LoginDao Login);
    
    public void editar(LoginDao Login);
    
    public void remover(LoginDao Login);
    
    public List listar(LoginDao Login);

}
