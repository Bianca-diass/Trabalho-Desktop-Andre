
package implement;


import bancodedados.Conexao;
import dao.MetPagamentoDao;
import entidades.MetPagamento;
import entidades.Dinheiro;
import entidades.Cartao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MetPagamImplements implements MetPagamentoDao {

    private static final Logger LOGGER = Logger.getLogger(MetPagamImplements.class.getName());

    @Override
    public void salvar(MetPagamentoDao obj) {
        MetPagamento metPagamento = (MetPagamento) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "INSERT INTO met_pagamento(id, pix, dinheiro_id, cartao_id) VALUES (?, ?, ?, ?)"
            );
            ps.setLong(1, metPagamento.getId());
            ps.setInt(2, metPagamento.getPix());
            ps.setLong(3, metPagamento.getDinheiro().getId());
            ps.setLong(4, metPagamento.getCartao().getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar método de pagamento: " + metPagamento.toString(), ex);
            throw new RuntimeException("Erro ao salvar método de pagamento", ex);
        }
    }

    @Override
    public void editar(MetPagamentoDao obj) {
        MetPagamento metPagamento = (MetPagamento) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "UPDATE met_pagamento SET pix = ?, dinheiro_id = ?, cartao_id = ? WHERE id = ?"
            );
            ps.setInt(1, metPagamento.getPix());
            ps.setLong(2, metPagamento.getDinheiro().getId());
            ps.setLong(3, metPagamento.getCartao().getId());
            ps.setLong(4, metPagamento.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao editar método de pagamento: " + metPagamento.toString(), ex);
            throw new RuntimeException("Erro ao editar método de pagamento", ex);
        }
    }

    @Override
    public void remover(MetPagamentoDao obj) {
        MetPagamento metPagamento = (MetPagamento) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM met_pagamento WHERE id = ?"
            );
            ps.setLong(1, metPagamento.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao remover método de pagamento: " + metPagamento.toString(), ex);
            throw new RuntimeException("Erro ao remover método de pagamento", ex);
        }
    }

    @Override
    public List<MetPagamento> listar(MetPagamentoDao obj) {
        List<MetPagamento> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM met_pagamento");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MetPagamento metPagamento = new MetPagamento();
                metPagamento.setId(rs.getLong("id"));
                metPagamento.setPix(rs.getInt("pix"));
                
                Dinheiro dinheiro = new Dinheiro();
                dinheiro.setId(rs.getLong("dinheiro_id"));
                metPagamento.setDinheiro(dinheiro);
                
                Cartao cartao = new Cartao();
                cartao.setId(rs.getLong("cartao_id"));
                metPagamento.setCartao(cartao);

                lista.add(metPagamento);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao listar métodos de pagamento", ex);
            throw new RuntimeException("Erro ao listar métodos de pagamento", ex);
        }

        return lista;
    }
}

