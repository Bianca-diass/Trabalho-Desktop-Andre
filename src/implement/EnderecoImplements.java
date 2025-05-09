package implement;

import bancodedados.Conexao;
import dao.EnderecoDao;
import entidades.Endereco;
import entidades.Bairro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnderecoImplements implements EnderecoDao {

    private static final Logger LOGGER = Logger.getLogger(EnderecoImplements.class.getName());

    @Override
    public void salvar(EnderecoDao obj) {
        Endereco endereco = (Endereco) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "INSERT INTO endereco(id, rua, cep, bairro_id, distancia) VALUES (?, ?, ?, ?, ?)"
            );
            ps.setLong(1, endereco.getId());
            ps.setInt(2, endereco.getRua());
            ps.setInt(3, endereco.getCep());
            ps.setLong(4, endereco.getBairro().getId());
            ps.setInt(5, endereco.getDistancia());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar endereço: " + endereco.toString(), ex);
            throw new RuntimeException("Erro ao salvar endereço", ex);
        }
    }

    @Override
    public void editar(EnderecoDao obj) {
        Endereco endereco = (Endereco) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "UPDATE endereco SET rua = ?, cep = ?, bairro_id = ?, distancia = ? WHERE id = ?"
            );
            ps.setInt(1, endereco.getRua());
            ps.setInt(2, endereco.getCep());
            ps.setLong(3, endereco.getBairro().getId());
            ps.setInt(4, endereco.getDistancia());
            ps.setLong(5, endereco.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao editar endereço: " + endereco.toString(), ex);
            throw new RuntimeException("Erro ao editar endereço", ex);
        }
    }

    @Override
    public void remover(EnderecoDao obj) {
        Endereco endereco = (Endereco) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM endereco WHERE id = ?"
            );
            ps.setLong(1, endereco.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao remover endereço: " + endereco.toString(), ex);
            throw new RuntimeException("Erro ao remover endereço", ex);
        }
    }

    @Override
    public List<Endereco> listar(EnderecoDao obj) {
        List<Endereco> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM endereco");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(rs.getLong("id"));
                endereco.setRua(rs.getInt("rua"));
                endereco.setCep(rs.getInt("cep"));
                
                Bairro bairro = new Bairro();
                bairro.setId(rs.getLong("bairro_id"));
                endereco.setBairro(bairro);
                
                endereco.setDistancia(rs.getInt("distancia"));

                lista.add(endereco);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao listar endereços", ex);
            throw new RuntimeException("Erro ao listar endereços", ex);
        }

        return lista;
    }
}
    
    
    

