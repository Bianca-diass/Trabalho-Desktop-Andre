package implement;

import bancodedados.Conexao;
import dao.IngredienteAdicionalDao;
import entidades.IngredienteAdicional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IngredienteAImplements implements IngredienteAdicionalDao {

    private static final Logger LOGGER = Logger.getLogger(IngredienteAImplements.class.getName());

    @Override
    public void salvar(IngredienteAdicionalDao obj) {
        IngredienteAdicional ingrediente = (IngredienteAdicional) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "INSERT INTO ingrediente_adicional(id, nome, valor) VALUES (?, ?, ?)"
            );
            ps.setLong(1, ingrediente.getId());
            ps.setString(2, ingrediente.getNome());
            ps.setInt(3, ingrediente.getValor());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar ingrediente adicional: " + ingrediente.toString(), ex);
            throw new RuntimeException("Erro ao salvar ingrediente adicional", ex);
        }
    }

    @Override
    public void editar(IngredienteAdicionalDao obj) {
        IngredienteAdicional ingrediente = (IngredienteAdicional) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "UPDATE ingrediente_adicional SET nome = ?, valor = ? WHERE id = ?"
            );
            ps.setString(1, ingrediente.getNome());
            ps.setInt(2, ingrediente.getValor());
            ps.setLong(3, ingrediente.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao editar ingrediente adicional: " + ingrediente.toString(), ex);
            throw new RuntimeException("Erro ao editar ingrediente adicional", ex);
        }
    }

    @Override
    public void remover(IngredienteAdicionalDao obj) {
        IngredienteAdicional ingrediente = (IngredienteAdicional) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM ingrediente_adicional WHERE id = ?"
            );
            ps.setLong(1, ingrediente.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao remover ingrediente adicional: " + ingrediente.toString(), ex);
            throw new RuntimeException("Erro ao remover ingrediente adicional", ex);
        }
    }

    @Override
    public List<IngredienteAdicional> listar(IngredienteAdicionalDao obj) {
        List<IngredienteAdicional> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM ingrediente_adicional");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                IngredienteAdicional ingrediente = new IngredienteAdicional();
                ingrediente.setId(rs.getLong("id"));
                ingrediente.setNome(rs.getString("nome"));
                ingrediente.setValor(rs.getInt("valor"));

                lista.add(ingrediente);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao listar ingredientes adicionais", ex);
            throw new RuntimeException("Erro ao listar ingredientes adicionais", ex);
        }

        return lista;
    }
}
    
    
    

