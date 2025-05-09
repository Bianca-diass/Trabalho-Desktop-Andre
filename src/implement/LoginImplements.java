package implement;

import bancodedados.Conexao;
import dao.LoginDao;
import entidades.Login;
import entidades.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginImplements implements LoginDao {

    private static final Logger LOGGER = Logger.getLogger(LoginImplements.class.getName());

    @Override
    public void salvar(LoginDao obj) {
        Login login = (Login) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "INSERT INTO login(id, senha, funcionario_id) VALUES (?, ?, ?)"
            );
            ps.setLong(1, login.getId());
            ps.setString(2, login.getSenha());
            ps.setLong(3, login.getFuncionario().getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar login: " + login.toString(), ex);
            throw new RuntimeException("Erro ao salvar login", ex);
        }
    }

    @Override
    public void editar(LoginDao obj) {
        Login login = (Login) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "UPDATE login SET senha = ?, funcionario_id = ? WHERE id = ?"
            );
            ps.setString(1, login.getSenha());
            ps.setLong(2, login.getFuncionario().getId());
            ps.setLong(3, login.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao editar login: " + login.toString(), ex);
            throw new RuntimeException("Erro ao editar login", ex);
        }
    }

    @Override
    public void remover(LoginDao obj) {
        Login login = (Login) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM login WHERE id = ?"
            );
            ps.setLong(1, login.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao remover login: " + login.toString(), ex);
            throw new RuntimeException("Erro ao remover login", ex);
        }
    }

    @Override
    public List<Login> listar(LoginDao obj) {
        List<Login> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM login");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Login login = new Login();
                login.setId(rs.getLong("id"));
                login.setSenha(rs.getString("senha"));
                
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getLong("funcionario_id"));
                login.setFuncionario(funcionario);

                lista.add(login);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao listar logins", ex);
            throw new RuntimeException("Erro ao listar logins", ex);
        }

        return lista;
    }
}
    
    
    
    

