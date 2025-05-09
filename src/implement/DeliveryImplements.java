package implement;

import bancodedados.Conexao;
import dao.DeliveryDao;
import entidades.Delivery;
import entidades.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeliveryImplements implements DeliveryDao {

    private static final Logger LOGGER = Logger.getLogger(DeliveryImplements.class.getName());

    @Override
    public void salvar(DeliveryDao obj) {
        Delivery delivery = (Delivery) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "INSERT INTO delivery(id, chave_entrega, numero, complemento, endereco_id) VALUES (?, ?, ?, ?, ?)"
            );
            ps.setLong(1, delivery.getId());
            ps.setInt(2, delivery.getChaveEntrega());
            ps.setInt(3, delivery.getNumero());
            ps.setInt(4, delivery.getComplemento());
            ps.setLong(5, delivery.getEndereco().getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar delivery: " + delivery.toString(), ex);
            throw new RuntimeException("Erro ao salvar delivery", ex);
        }
    }

    @Override
    public void editar(DeliveryDao obj) {
        Delivery delivery = (Delivery) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "UPDATE delivery SET chave_entrega = ?, numero = ?, complemento = ?, endereco_id = ? WHERE id = ?"
            );
            ps.setInt(1, delivery.getChaveEntrega());
            ps.setInt(2, delivery.getNumero());
            ps.setInt(3, delivery.getComplemento());
            ps.setLong(4, delivery.getEndereco().getId());
            ps.setLong(5, delivery.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao editar delivery: " + delivery.toString(), ex);
            throw new RuntimeException("Erro ao editar delivery", ex);
        }
    }

    @Override
    public void remover(DeliveryDao obj) {
        Delivery delivery = (Delivery) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM delivery WHERE id = ?"
            );
            ps.setLong(1, delivery.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao remover delivery: " + delivery.toString(), ex);
            throw new RuntimeException("Erro ao remover delivery", ex);
        }
    }

    @Override
    public List<Delivery> listar(DeliveryDao obj) {
        List<Delivery> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM delivery");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Delivery delivery = new Delivery();
                delivery.setId(rs.getLong("id"));
                delivery.setChaveEntrega(rs.getInt("chave_entrega"));
                delivery.setNumero(rs.getInt("numero"));
                delivery.setComplemento(rs.getInt("complemento"));
                
                Endereco endereco = new Endereco();
                endereco.setId(rs.getLong("endereco_id"));
                delivery.setEndereco(endereco);

                lista.add(delivery);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao listar deliveries", ex);
            throw new RuntimeException("Erro ao listar deliveries", ex);
        }

        return lista;
    }
}
    
    
    
