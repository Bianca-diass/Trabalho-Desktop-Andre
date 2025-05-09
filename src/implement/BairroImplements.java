package implement;

import bancodedados.Conexao;
import java.sql.Connection; // Importação correta para JDBC
import dao.BairroDao;
import entidades.Bairro;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BairroImplements implements BairroDao {

    public void salvar(Bairro bairro) {
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement preparedStatement = conexao.prepareStatement("insert into bairro(id,nome,endereco_id) values(?,?,?)");
            preparedStatement.setInt(1, Math.toIntExact(bairro.getId()));
            preparedStatement.setString(2, bairro.getNome());
            preparedStatement.setString(3, bairro.getEndereco_id());

            // Executar a query
            preparedStatement.executeUpdate();

            // Fechar recursos
            preparedStatement.close();
            // conexao.close(); // Descomente se você precisa fechar a conexão aqui

        } catch (SQLException ex) {
            Logger.getLogger(BairroImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editar(Bairro bairro) {
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement preparedStatement = conexao.prepareStatement("update bairro set nome = ?, endeco_id = ?, where id=? ");
            preparedStatement.setString(1, bairro.getNome());
            preparedStatement.setString(2, bairro.getEndereco_id());
             preparedStatement.setInt(3, Math.toIntExact(bairro.getId()));

        } catch (SQLException ex) {
            Logger.getLogger(BairroImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remover(Bairro bairro) {
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement preparedStatement = conexao.prepareStatement("delete from bairro where id=? ");
            preparedStatement.setInt(1, Math.toIntExact(bairro.getId()));
        }catch (SQLException ex) {
            Logger.getLogger(BairroImplements.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List listar(Bairro bairro) {
        List itens = new LinkedList();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement preparedStatement= conexao.prepareStatement("select * from bairro ");
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Bairro b = new Bairro();
                b.setId((long) resultSet.getInt("id"));
                itens.add(b);
            }
            while (resultSet.next()) {
                Bairro b = new Bairro();
                b.setNome(resultSet.getString("nome"));
                itens.add(b);
            }
            while (resultSet.next()) {
                Bairro b = new Bairro();
                b.setEndereco_id(resultSet.getString("endereco_id"));
                itens.add(b);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BairroImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itens;
    }

    @Override
    public void salvar(BairroDao bairro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editar(BairroDao bairro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remover(BairroDao bairro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List listar(BairroDao bairro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getEnderecoId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}