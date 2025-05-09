package implement;


import bancodedados.Conexao;
import dao.ReembolsoDao;
import entidades.Reembolso;
import entidades.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReembolsoImplements implements ReembolsoDao {

    private static final Logger LOGGER = Logger.getLogger(ReembolsoImplements.class.getName());

    @Override
    public void salvar(ReembolsoDao obj) {
        Reembolso reembolso = (Reembolso) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                "INSERT INTO reembolso(id, pedido_id, motivo) VALUES (?, ?, ?)"
            );
            
            ps.setLong(1, reembolso.getId());
            ps.setLong(2, reembolso.getPedido().getId());
            ps.setString(3, reembolso.getMotivo());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar reembolso: " + reembolso.toString(), ex);
            throw new RuntimeException("Erro ao salvar reembolso", ex);
        }
    }

    @Override
    public void editar(ReembolsoDao obj) {
        Reembolso reembolso = (Reembolso) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                "UPDATE reembolso SET pedido_id = ?, motivo = ? WHERE id = ?"
            );
            
            ps.setLong(1, reembolso.getPedido().getId());
            ps.setString(2, reembolso.getMotivo());
            ps.setLong(3, reembolso.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao editar reembolso: " + reembolso.toString(), ex);
            throw new RuntimeException("Erro ao editar reembolso", ex);
        }
    }

    @Override
    public void remover(ReembolsoDao obj) {
        Reembolso reembolso = (Reembolso) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM reembolso WHERE id = ?"
            );
            ps.setLong(1, reembolso.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao remover reembolso: " + reembolso.toString(), ex);
            throw new RuntimeException("Erro ao remover reembolso", ex);
        }
    }

    @Override
    public List<Reembolso> listar(ReembolsoDao obj) {
        List<Reembolso> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM reembolso");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reembolso reembolso = new Reembolso();
                reembolso.setId(rs.getLong("id"));
                
                Pedido pedido = new Pedido();
                pedido.setId(rs.getLong("pedido_id"));
                reembolso.setPedido(pedido);
                
                reembolso.setMotivo(rs.getString("motivo"));

                lista.add(reembolso);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao listar reembolsos", ex);
            throw new RuntimeException("Erro ao listar reembolsos", ex);
        }

        return lista;
    }
}
    
    
    
    

