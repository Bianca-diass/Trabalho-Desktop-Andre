package dao;

import entidades.TaxaEntrega;
import java.util.List;

public interface TaxaEntregaDao {
    public void salvar(TaxaEntregaDao TaxaEntrega);
    
    public void editar(TaxaEntregaDao TaxaEntrega);
    
    public void remover(TaxaEntregaDao TaxaEntrega);
    
    public List listar(TaxaEntregaDao TaxaEntrega);

}
