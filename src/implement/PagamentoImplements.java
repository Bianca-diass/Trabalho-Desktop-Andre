package implement;

import bancodedados.Conexao;
import dao.PagamentoDao;
import entidades.Pagamento;
import entidades.MetPagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PagamentoImplements implements PagamentoDao {

    private static final Logger LOGGER = Logger.getLogger(PagamentoImplements.class.getName());

    @Override
    public void salvar(PagamentoDao obj) {
        Pagamento pagamento = (Pagamento) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "INSERT INTO pagamento(id, metpagamento_id, cupom) VALUES (?, ?, ?)"
            );
            ps.setLong(1, pagamento.getId());
            ps.setLong(2, pagamento.getMetpagamento().getId());
            ps.setString(3, pagamento.getCupom());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar pagamento: " + pagamento.toString(), ex);
            throw new RuntimeException("Erro ao salvar pagamento", ex);
        }
    }

    @Override
    public void editar(PagamentoDao obj) {
        Pagamento pagamento = (Pagamento) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "UPDATE pagamento SET metpagamento_id = ?, cupom = ? WHERE id = ?"
            );
            ps.setLong(1, pagamento.getMetpagamento().getId());
            ps.setString(2, pagamento.getCupom());
            ps.setLong(3, pagamento.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao editar pagamento: " + pagamento.toString(), ex);
            throw new RuntimeException("Erro ao editar pagamento", ex);
        }
    }

    @Override
    public void remover(PagamentoDao obj) {
        Pagamento pagamento = (Pagamento) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM pagamento WHERE id = ?"
            );
            ps.setLong(1, pagamento.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao remover pagamento: " + pagamento.toString(), ex);
            throw new RuntimeException("Erro ao remover pagamento", ex);
        }
    }

    @Override
    public List<Pagamento> listar(PagamentoDao obj) {
        List<Pagamento> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM pagamento");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pagamento pagamento = new Pagamento();
                pagamento.setId(rs.getLong("id"));
                
                MetPagamento metPagamento = new MetPagamento();
                metPagamento.setId(rs.getLong("metpagamento_id"));
                pagamento.setMetpagamento(metPagamento);
                
                pagamento.setCupom(rs.getString("cupom"));

                lista.add(pagamento);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao listar pagamentos", ex);
            throw new RuntimeException("Erro ao listar pagamentos", ex);
        }

        return lista;
    }
}
    
    

