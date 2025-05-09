package implement;

import bancodedados.Conexao;
import dao.CartaoDao;
import entidades.Cartao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CartaoImplements implements CartaoDao {

    private static final Logger LOGGER = Logger.getLogger(CartaoImplements.class.getName());

    @Override
    public void salvar(CartaoDao obj) {
        Cartao cartao = (Cartao) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "INSERT INTO cartao(id, numcartao, cvv, credito1, debito2) VALUES (?, ?, ?, ?, ?)"
            );
            ps.setLong(1, cartao.getId());
            ps.setInt(2, cartao.getNumcartao());
            ps.setString(3, cartao.getCVV());
            ps.setInt(4, cartao.getCredito1());
            ps.setInt(5, cartao.getDebito2());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar cartão: " + cartao.toString(), ex);
            throw new RuntimeException("Erro ao salvar cartão", ex);
        }
    }

    @Override
    public void editar(CartaoDao obj) {
        Cartao cartao = (Cartao) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "UPDATE cartao SET numcartao = ?, cvv = ?, credito1 = ?, debito2 = ? WHERE id = ?"
            );
            ps.setInt(1, cartao.getNumcartao());
            ps.setString(2, cartao.getCVV());
            ps.setInt(3, cartao.getCredito1());
            ps.setInt(4, cartao.getDebito2());
            ps.setLong(5, cartao.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao editar cartão: " + cartao.toString(), ex);
            throw new RuntimeException("Erro ao editar cartão", ex);
        }
    }

    @Override
    public void remover(CartaoDao obj) {
        Cartao cartao = (Cartao) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM cartao WHERE id = ?"
            );
            ps.setLong(1, cartao.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao remover cartão: " + cartao.toString(), ex);
            throw new RuntimeException("Erro ao remover cartão", ex);
        }
    }

    @Override
    public List<Cartao> listar(CartaoDao obj) {
        List<Cartao> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM cartao");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cartao cartao = new Cartao();
                cartao.setId(rs.getLong("id"));
                cartao.setNumcartao(rs.getInt("numcartao"));
                cartao.setCVV(rs.getString("cvv"));
                cartao.setCredito1(rs.getInt("credito1"));
                cartao.setDebito2(rs.getInt("debito2"));

                lista.add(cartao);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao listar cartões", ex);
            throw new RuntimeException("Erro ao listar cartões", ex);
        }

        return lista;
    }
}
    
    

