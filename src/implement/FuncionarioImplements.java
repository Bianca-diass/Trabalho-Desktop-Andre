package implement;

import bancodedados.Conexao;
import dao.FuncionarioDao;
import entidades.Funcionario;
import entidades.Telefone;
import entidades.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioImplements implements FuncionarioDao {

    private static final Logger LOGGER = Logger.getLogger(FuncionarioImplements.class.getName());

    @Override
    public void salvar(FuncionarioDao obj) {
        Funcionario funcionario = (Funcionario) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "INSERT INTO funcionario(id, nome, cpf, rg, telefone_id, login_id) VALUES (?, ?, ?, ?, ?, ?)"
            );
            ps.setLong(1, funcionario.getId());
            ps.setString(2, funcionario.getNome());
            ps.setInt(3, funcionario.getCpf());
            ps.setInt(4, funcionario.getRg());
            ps.setLong(5, funcionario.getTelefone().getId());
            ps.setLong(6, funcionario.getLogin().getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar funcionário: " + funcionario.toString(), ex);
            throw new RuntimeException("Erro ao salvar funcionário", ex);
        }
    }

    @Override
    public void editar(FuncionarioDao obj) {
        Funcionario funcionario = (Funcionario) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "UPDATE funcionario SET nome = ?, cpf = ?, rg = ?, telefone_id = ?, login_id = ? WHERE id = ?"
            );
            ps.setString(1, funcionario.getNome());
            ps.setInt(2, funcionario.getCpf());
            ps.setInt(3, funcionario.getRg());
            ps.setLong(4, funcionario.getTelefone().getId());
            ps.setLong(5, funcionario.getLogin().getId());
            ps.setLong(6, funcionario.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao editar funcionário: " + funcionario.toString(), ex);
            throw new RuntimeException("Erro ao editar funcionário", ex);
        }
    }

    @Override
    public void remover(FuncionarioDao obj) {
        Funcionario funcionario = (Funcionario) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM funcionario WHERE id = ?"
            );
            ps.setLong(1, funcionario.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao remover funcionário: " + funcionario.toString(), ex);
            throw new RuntimeException("Erro ao remover funcionário", ex);
        }
    }

    @Override
    public List<Funcionario> listar(FuncionarioDao obj) {
        List<Funcionario> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM funcionario");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getLong("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getInt("cpf"));
                funcionario.setRg(rs.getInt("rg"));
                
                Telefone telefone = new Telefone();
                telefone.setId(rs.getLong("telefone_id"));
                funcionario.setTelefone(telefone);
                
                Login login = new Login();
                login.setId(rs.getLong("login_id"));
                funcionario.setLogin(login);

                lista.add(funcionario);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao listar funcionários", ex);
            throw new RuntimeException("Erro ao listar funcionários", ex);
        }

        return lista;
    }
}
    
    
    
    
    

