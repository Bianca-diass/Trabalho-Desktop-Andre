package implement;

import bancodedados.Conexao;
import dao.EntregaDao;
import entidades.Entrega;
import entidades.Cliente;
import entidades.Delivery;
import entidades.Pedido;
import entidades.StatusPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EntregaImplements implements EntregaDao {

    private static final Logger LOGGER = Logger.getLogger(EntregaImplements.class.getName());

    @Override
    public void salvar(EntregaDao obj) {
        Entrega entrega = (Entrega) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "INSERT INTO entrega(id, cliente_id, tipo_entrega, delivery_id, pedido_id, statuspedido_id) VALUES (?, ?, ?, ?, ?, ?)"
            );
            ps.setLong(1, entrega.getId());
            ps.setLong(2, entrega.getCliente().getId());
            ps.setString(3, entrega.getTipoEntrega());
            ps.setLong(4, entrega.getDelivery().getId());
            ps.setLong(5, entrega.getPedido().getId());
            ps.setLong(6, entrega.getStatuspedido().getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar entrega: " + entrega.toString(), ex);
            throw new RuntimeException("Erro ao salvar entrega", ex);
        }
    }

    @Override
    public void editar(EntregaDao obj) {
        Entrega entrega = (Entrega) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "UPDATE entrega SET cliente_id = ?, tipo_entrega = ?, delivery_id = ?, pedido_id = ?, statuspedido_id = ? WHERE id = ?"
            );
            ps.setLong(1, entrega.getCliente().getId());
            ps.setString(2, entrega.getTipoEntrega());
            ps.setLong(3, entrega.getDelivery().getId());
            ps.setLong(4, entrega.getPedido().getId());
            ps.setLong(5, entrega.getStatuspedido().getId());
            ps.setLong(6, entrega.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao editar entrega: " + entrega.toString(), ex);
            throw new RuntimeException("Erro ao editar entrega", ex);
        }
    }

    @Override
    public void remover(EntregaDao obj) {
        Entrega entrega = (Entrega) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM entrega WHERE id = ?"
            );
            ps.setLong(1, entrega.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao remover entrega: " + entrega.toString(), ex);
            throw new RuntimeException("Erro ao remover entrega", ex);
        }
    }

    @Override
    public List<Entrega> listar(EntregaDao obj) {
        List<Entrega> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM entrega");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Entrega entrega = new Entrega();
                entrega.setId(rs.getLong("id"));
                
                Cliente cliente = new Cliente();
                cliente.setId(rs.getLong("cliente_id"));
                entrega.setCliente(cliente);
                
                entrega.setTipoEntrega(rs.getString("tipo_entrega"));
                
                Delivery delivery = new Delivery();
                delivery.setId(rs.getLong("delivery_id"));
                entrega.setDelivery(delivery);
                
                Pedido pedido = new Pedido();
                pedido.setId(rs.getLong("pedido_id"));
                entrega.setPedido(pedido);
                
                StatusPedido statuspedido = new StatusPedido();
                statuspedido.setId(rs.getLong("statuspedido_id"));
                entrega.setStatuspedido(statuspedido);

                lista.add(entrega);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao listar entregas", ex);
            throw new RuntimeException("Erro ao listar entregas", ex);
        }

        return lista;
    }
}
    
    
    

