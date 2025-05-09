package implement;

import bancodedados.Conexao;
import dao.TaxaEntregaDao;
import entidades.TaxaEntrega;
import entidades.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaxaEntregaImplements implements TaxaEntregaDao {

    private static final Logger LOGGER = Logger.getLogger(TaxaEntregaImplements.class.getName());

    @Override
    public void salvar(TaxaEntregaDao obj) {
        TaxaEntrega taxaEntrega = (TaxaEntrega) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                "INSERT INTO taxa_entrega(id, endereco_id, taxa_entrega) VALUES (?, ?, ?)"
            );
            
            ps.setLong(1, taxaEntrega.getId());
            ps.setLong(2, taxaEntrega.getEndereco().getId());
            ps.setInt(3, taxaEntrega.getTaxaEntrega());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar taxa de entrega: " + taxaEntrega.toString(), ex);
            throw new RuntimeException("Erro ao salvar taxa de entrega", ex);
        }
    }

    @Override
    public void editar(TaxaEntregaDao obj) {
        TaxaEntrega taxaEntrega = (TaxaEntrega) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                "UPDATE taxa_entrega SET endereco_id = ?, taxa_entrega = ? WHERE id = ?"
            );
            
            ps.setLong(1, taxaEntrega.getEndereco().getId());
            ps.setInt(2, taxaEntrega.getTaxaEntrega());
            ps.setLong(3, taxaEntrega.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao editar taxa de entrega: " + taxaEntrega.toString(), ex);
            throw new RuntimeException("Erro ao editar taxa de entrega", ex);
        }
    }

    @Override
    public void remover(TaxaEntregaDao obj) {
        TaxaEntrega taxaEntrega = (TaxaEntrega) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM taxa_entrega WHERE id = ?"
            );
            ps.setLong(1, taxaEntrega.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao remover taxa de entrega: " + taxaEntrega.toString(), ex);
            throw new RuntimeException("Erro ao remover taxa de entrega", ex);
        }
    }

    @Override
    public List<TaxaEntrega> listar(TaxaEntregaDao obj) {
        List<TaxaEntrega> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM taxa_entrega");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TaxaEntrega taxaEntrega = new TaxaEntrega();
                taxaEntrega.setId(rs.getLong("id"));
                
                Endereco endereco = new Endereco();
                endereco.setId(rs.getLong("endereco_id"));
                taxaEntrega.setEndereco(endereco);
                
                taxaEntrega.setTaxaEntrega(rs.getInt("taxa_entrega"));

                lista.add(taxaEntrega);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao listar taxas de entrega", ex);
            throw new RuntimeException("Erro ao listar taxas de entrega", ex);
        }

        return lista;
    }
}

