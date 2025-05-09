package dao;

import entidades.Reembolso;
import java.util.List;

public interface ReembolsoDao {
    public void salvar(ReembolsoDao Reembolso);
    
    public void editar(ReembolsoDao Reembolso);
    
    public void remover(ReembolsoDao Reembolso);
    
    public List listar(ReembolsoDao Reembolso);
}
