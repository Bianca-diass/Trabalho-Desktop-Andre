package implement;

import bancodedados.Conexao;
import dao.TelefoneDao;
import entidades.Telefone;
import entidades.Funcionario;
import entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelefoneImplements implements TelefoneDao {

    private static final Logger LOGGER = Logger.getLogger(TelefoneImplements.class.getName());

    @Override
    public void salvar(TelefoneDao obj) {
        Telefone telefone = (Telefone) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                "INSERT INTO telefone(id, numero, funcionario_id, cliente_id) VALUES (?, ?, ?, ?)"
            );
            
            ps.setLong(1, telefone.getId());
            ps.setInt(2, telefone.getNumero());
            ps.setLong(3, telefone.getFuncionario() != null ? telefone.getFuncionario().getId() : null);
            ps.setLong(4, telefone.getCliente() != null ? telefone.getCliente().getId() : null);

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar telefone: " + telefone.toString(), ex);
            throw new RuntimeException("Erro ao salvar telefone", ex);
        }
    }

    @Override
    public void editar(TelefoneDao obj) {
        Telefone telefone = (Telefone) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                "UPDATE telefone SET numero = ?, funcionario_id = ?, cliente_id = ? WHERE id = ?"
            );
            
            ps.setInt(1, telefone.getNumero());
            ps.setLong(2, telefone.getFuncionario() != null ? telefone.getFuncionario().getId() : null);
            ps.setLong(3, telefone.getCliente() != null ? telefone.getCliente().getId() : null);
            ps.setLong(4, telefone.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao editar telefone: " + telefone.toString(), ex);
            throw new RuntimeException("Erro ao editar telefone", ex);
        }
    }

    @Override
    public void remover(TelefoneDao obj) {
        Telefone telefone = (Telefone) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM telefone WHERE id = ?"
            );
            ps.setLong(1, telefone.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao remover telefone: " + telefone.toString(), ex);
            throw new RuntimeException("Erro ao remover telefone", ex);
        }
    }

    @Override
    public List<Telefone> listar(TelefoneDao obj) {
        List<Telefone> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM telefone");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Telefone telefone = new Telefone();
                telefone.setId(rs.getLong("id"));
                telefone.setNumero(rs.getInt("numero"));
                
                if (rs.getLong("funcionario_id") != 0) {
                    Funcionario funcionario = new Funcionario();
                    funcionario.setId(rs.getLong("funcionario_id"));
                    telefone.setFuncionario(funcionario);
                }
                
                if (rs.getLong("cliente_id") != 0) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getLong("cliente_id"));
                    telefone.setCliente(cliente);
                }

                lista.add(telefone);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao listar telefones", ex);
            throw new RuntimeException("Erro ao listar telefones", ex);
        }

        return lista;
    }
}
    
    

