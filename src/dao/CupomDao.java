package dao;

import entidades.Cupom;
import java.util.List;

public interface CupomDao {
    public void salvar(CupomDao cupom);
    
    public void editar(CupomDao cupom);
    
    public void remover(CupomDao cupom);
    
    public List listar(CupomDao cupom);
}
