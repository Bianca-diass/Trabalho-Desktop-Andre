package implement;

import bancodedados.Conexao;
import dao.StatusPedidoDao;
import entidades.StatusPedido;
import entidades.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StatusPedidoImplements implements StatusPedidoDao {

    private static final Logger LOGGER = Logger.getLogger(StatusPedidoImplements.class.getName());

    @Override
    public void salvar(StatusPedidoDao obj) {
        StatusPedido statusPedido = (StatusPedido) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                "INSERT INTO status_pedido(id, pedido_id, progresso) VALUES (?, ?, ?)"
            );
            
            ps.setLong(1, statusPedido.getId());
            ps.setLong(2, statusPedido.getPedido().getId());
            ps.setString(3, statusPedido.getProgresso());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar status do pedido: " + statusPedido.toString(), ex);
            throw new RuntimeException("Erro ao salvar status do pedido", ex);
        }
    }

    @Override
    public void editar(StatusPedidoDao obj) {
        StatusPedido statusPedido = (StatusPedido) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                "UPDATE status_pedido SET pedido_id = ?, progresso = ? WHERE id = ?"
            );
            
            ps.setLong(1, statusPedido.getPedido().getId());
            ps.setString(2, statusPedido.getProgresso());
            ps.setLong(3, statusPedido.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao editar status do pedido: " + statusPedido.toString(), ex);
            throw new RuntimeException("Erro ao editar status do pedido", ex);
        }
    }

    @Override
    public void remover(StatusPedidoDao obj) {
        StatusPedido statusPedido = (StatusPedido) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM status_pedido WHERE id = ?"
            );
            ps.setLong(1, statusPedido.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao remover status do pedido: " + statusPedido.toString(), ex);
            throw new RuntimeException("Erro ao remover status do pedido", ex);
        }
    }

    @Override
    public List<StatusPedido> listar(StatusPedidoDao obj) {
        List<StatusPedido> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM status_pedido");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                StatusPedido statusPedido = new StatusPedido();
                statusPedido.setId(rs.getLong("id"));
                
                Pedido pedido = new Pedido();
                pedido.setId(rs.getLong("pedido_id"));
                statusPedido.setPedido(pedido);
                
                statusPedido.setProgresso(rs.getString("progresso"));

                lista.add(statusPedido);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao listar status dos pedidos", ex);
            throw new RuntimeException("Erro ao listar status dos pedidos", ex);
        }

        return lista;
    }
}
    
    

