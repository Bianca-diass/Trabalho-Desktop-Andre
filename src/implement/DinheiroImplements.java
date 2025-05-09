package implement;

import bancodedados.Conexao;
import dao.DinheiroDao;
import entidades.Dinheiro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DinheiroImplements implements DinheiroDao {

    private static final Logger LOGGER = Logger.getLogger(DinheiroImplements.class.getName());

    @Override
    public void salvar(DinheiroDao obj) {
        Dinheiro dinheiro = (Dinheiro) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "INSERT INTO dinheiro(id, valor_entregado) VALUES (?, ?)"
            );
            ps.setLong(1, dinheiro.getId());
            ps.setInt(2, dinheiro.getValorEntregado());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar dinheiro: " + dinheiro.toString(), ex);
            throw new RuntimeException("Erro ao salvar dinheiro", ex);
        }
    }

    @Override
    public void editar(DinheiroDao obj) {
        Dinheiro dinheiro = (Dinheiro) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "UPDATE dinheiro SET valor_entregado = ? WHERE id = ?"
            );
            ps.setInt(1, dinheiro.getValorEntregado());
            ps.setLong(2, dinheiro.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao editar dinheiro: " + dinheiro.toString(), ex);
            throw new RuntimeException("Erro ao editar dinheiro", ex);
        }
    }

    @Override
    public void remover(DinheiroDao obj) {
        Dinheiro dinheiro = (Dinheiro) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM dinheiro WHERE id = ?"
            );
            ps.setLong(1, dinheiro.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao remover dinheiro: " + dinheiro.toString(), ex);
            throw new RuntimeException("Erro ao remover dinheiro", ex);
        }
    }

    @Override
    public List<Dinheiro> listar(DinheiroDao obj) {
        List<Dinheiro> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM dinheiro");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Dinheiro dinheiro = new Dinheiro();
                dinheiro.setId(rs.getLong("id"));
                dinheiro.setValorEntregado(rs.getInt("valor_entregado"));
                lista.add(dinheiro);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao listar registros de dinheiro", ex);
            throw new RuntimeException("Erro ao listar registros de dinheiro", ex);
        }

        return lista;
    }
}
    
    
    

