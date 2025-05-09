package implement;

import bancodedados.Conexao;
import dao.ClienteDao;
import entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteImplements implements ClienteDao {

    private static final Logger LOGGER = Logger.getLogger(ClienteImplements.class.getName());

    @Override
    public void salvar(ClienteDao obj) {
        Cliente cliente = (Cliente) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "INSERT INTO cliente(id, nome, telefone) VALUES (?, ?, ?)"
            );
            ps.setLong(1, cliente.getId());
            ps.setString(2, cliente.getNome());
            ps.setInt(3, cliente.getTelefone());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar cliente: " + cliente.toString(), ex);
            throw new RuntimeException("Erro ao salvar cliente", ex);
        }
    }

    @Override
    public void editar(ClienteDao obj) {
        Cliente cliente = (Cliente) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "UPDATE cliente SET nome = ?, telefone = ? WHERE id = ?"
            );
            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getTelefone());
            ps.setLong(3, cliente.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao editar cliente: " + cliente.toString(), ex);
            throw new RuntimeException("Erro ao editar cliente", ex);
        }
    }

    @Override
    public void remover(ClienteDao obj) {
        Cliente cliente = (Cliente) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM cliente WHERE id = ?"
            );
            ps.setLong(1, cliente.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao remover cliente: " + cliente.toString(), ex);
            throw new RuntimeException("Erro ao remover cliente", ex);
        }
    }

    @Override
    public List<Cliente> listar(ClienteDao obj) {
        List<Cliente> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getLong("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getInt("telefone"));

                lista.add(cliente);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao listar clientes", ex);
            throw new RuntimeException("Erro ao listar clientes", ex);
        }

        return lista;
    }
}
    
    
    