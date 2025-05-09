package implement;

import bancodedados.Conexao;
import dao.PedidoDao;
import entidades.Pedido;
import entidades.Cliente;
import entidades.Carrinho;
import entidades.Entrega;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoImplements implements PedidoDao {

    private static final Logger LOGGER = Logger.getLogger(PedidoImplements.class.getName());

    @Override
    public void salvar(PedidoDao obj) {
        Pedido pedido = (Pedido) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                "INSERT INTO pedido(id, hora_pedido, cliente_id, numero_pedido, carrinho_id, " +
                "data_pedido, status_pedido, entrega_id, estatus_pedido) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            
            ps.setLong(1, pedido.getId());
            ps.setInt(2, pedido.getHoraPedido());
            ps.setLong(3, pedido.getCliente().getId());
            ps.setInt(4, pedido.getNumeroPedido());
            ps.setLong(5, pedido.getCarrinho().getId());
            ps.setInt(6, pedido.getDataPedido());
            ps.setString(7, pedido.getStatusPedido());
            ps.setLong(8, pedido.getEntrega().getId());
            ps.setString(9, pedido.getEstatusPedido());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar pedido: " + pedido.toString(), ex);
            throw new RuntimeException("Erro ao salvar pedido", ex);
        }
    }

    @Override
    public void editar(PedidoDao obj) {
        Pedido pedido = (Pedido) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                "UPDATE pedido SET hora_pedido = ?, cliente_id = ?, numero_pedido = ?, " +
                "carrinho_id = ?, data_pedido = ?, status_pedido = ?, entrega_id = ?, " +
                "estatus_pedido = ? WHERE id = ?"
            );
            
            ps.setInt(1, pedido.getHoraPedido());
            ps.setLong(2, pedido.getCliente().getId());
            ps.setInt(3, pedido.getNumeroPedido());
            ps.setLong(4, pedido.getCarrinho().getId());
            ps.setInt(5, pedido.getDataPedido());
            ps.setString(6, pedido.getStatusPedido());
            ps.setLong(7, pedido.getEntrega().getId());
            ps.setString(8, pedido.getEstatusPedido());
            ps.setLong(9, pedido.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao editar pedido: " + pedido.toString(), ex);
            throw new RuntimeException("Erro ao editar pedido", ex);
        }
    }

    @Override
    public void remover(PedidoDao obj) {
        Pedido pedido = (Pedido) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM pedido WHERE id = ?"
            );
            ps.setLong(1, pedido.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao remover pedido: " + pedido.toString(), ex);
            throw new RuntimeException("Erro ao remover pedido", ex);
        }
    }

    @Override
    public List<Pedido> listar(PedidoDao obj) {
        List<Pedido> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM pedido");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getLong("id"));
                pedido.setHoraPedido(rs.getInt("hora_pedido"));
                
                Cliente cliente = new Cliente();
                cliente.setId(rs.getLong("cliente_id"));
                pedido.setCliente(cliente);
                
                pedido.setNumeroPedido(rs.getInt("numero_pedido"));
                
                Carrinho carrinho = new Carrinho();
                carrinho.setId(rs.getLong("carrinho_id"));
                pedido.setCarrinho(carrinho);
                
                pedido.setDataPedido(rs.getInt("data_pedido"));
                pedido.setStatusPedido(rs.getString("status_pedido"));
                
                Entrega entrega = new Entrega();
                entrega.setId(rs.getLong("entrega_id"));
                pedido.setEntrega(entrega);
                
                pedido.setEstatusPedido(rs.getString("estatus_pedido"));

                lista.add(pedido);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao listar pedidos", ex);
            throw new RuntimeException("Erro ao listar pedidos", ex);
        }

        return lista;
    }
}
    
    

