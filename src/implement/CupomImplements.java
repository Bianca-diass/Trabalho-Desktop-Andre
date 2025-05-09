package implement;

import bancodedados.Conexao;
import dao.CupomDao;
import entidades.Cupom;
import entidades.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CupomImplements implements CupomDao {

    private static final Logger LOGGER = Logger.getLogger(CupomImplements.class.getName());

    @Override
    public void salvar(CupomDao obj) {
        Cupom cupom = (Cupom) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "INSERT INTO cupom(id, valorcupom, codigo, pagamento_id, validade) VALUES (?, ?, ?, ?, ?)"
            );
            ps.setLong(1, cupom.getId());
            ps.setInt(2, cupom.getValorcupom());
            ps.setInt(3, cupom.getCodigo());
            ps.setLong(4, cupom.getPagamento().getId());
            ps.setInt(5, cupom.getValidade());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar cupom: " + cupom.toString(), ex);
            throw new RuntimeException("Erro ao salvar cupom", ex);
        }
    }

    @Override
    public void editar(CupomDao obj) {
        Cupom cupom = (Cupom) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "UPDATE cupom SET valorcupom = ?, codigo = ?, pagamento_id = ?, validade = ? WHERE id = ?"
            );
            ps.setInt(1, cupom.getValorcupom());
            ps.setInt(2, cupom.getCodigo());
            ps.setLong(3, cupom.getPagamento().getId());
            ps.setInt(4, cupom.getValidade());
            ps.setLong(5, cupom.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao editar cupom: " + cupom.toString(), ex);
            throw new RuntimeException("Erro ao editar cupom", ex);
        }
    }

    @Override
    public void remover(CupomDao obj) {
        Cupom cupom = (Cupom) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM cupom WHERE id = ?"
            );
            ps.setLong(1, cupom.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao remover cupom: " + cupom.toString(), ex);
            throw new RuntimeException("Erro ao remover cupom", ex);
        }
    }

    @Override
    public List<Cupom> listar(CupomDao obj) {
        List<Cupom> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM cupom");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cupom cupom = new Cupom();
                cupom.setId(rs.getLong("id"));
                cupom.setValorcupom(rs.getInt("valorcupom"));
                cupom.setCodigo(rs.getInt("codigo"));
                
               
                Pagamento pagamento = new Pagamento();
                pagamento.setId(rs.getLong("pagamento_id"));
                cupom.setPagamento(pagamento);
                
                cupom.setValidade(rs.getInt("validade"));

                lista.add(cupom);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao listar cupons", ex);
            throw new RuntimeException("Erro ao listar cupons", ex);
        }

        return lista;
    }
}
    
    
    
    

