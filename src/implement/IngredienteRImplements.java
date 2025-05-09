package implement;


import bancodedados.Conexao;
import dao.IngredienteRemoverDao;
import entidades.IngredienteRemover;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IngredienteRImplements implements IngredienteRemoverDao {

    private static final Logger LOGGER = Logger.getLogger(IngredienteRImplements.class.getName());

    @Override
    public void salvar(IngredienteRemoverDao obj) {
        IngredienteRemover ingrediente = (IngredienteRemover) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "INSERT INTO ingrediente_remover(id, nome) VALUES (?, ?)"
            );
            ps.setLong(1, ingrediente.getId());
            ps.setString(2, ingrediente.getNome());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar ingrediente remover: " + ingrediente.toString(), ex);
            throw new RuntimeException("Erro ao salvar ingrediente remover", ex);
        }
    }

    @Override
    public void editar(IngredienteRemoverDao obj) {
        IngredienteRemover ingrediente = (IngredienteRemover) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "UPDATE ingrediente_remover SET nome = ? WHERE id = ?"
            );
            ps.setString(1, ingrediente.getNome());
            ps.setLong(2, ingrediente.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao editar ingrediente remover: " + ingrediente.toString(), ex);
            throw new RuntimeException("Erro ao editar ingrediente remover", ex);
        }
    }

    @Override
    public void remover(IngredienteRemoverDao obj) {
        IngredienteRemover ingrediente = (IngredienteRemover) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM ingrediente_remover WHERE id = ?"
            );
            ps.setLong(1, ingrediente.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao remover ingrediente remover: " + ingrediente.toString(), ex);
            throw new RuntimeException("Erro ao remover ingrediente remover", ex);
        }
    }

    @Override
    public List<IngredienteRemover> listar(IngredienteRemoverDao obj) {
        List<IngredienteRemover> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM ingrediente_remover");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                IngredienteRemover ingrediente = new IngredienteRemover();
                ingrediente.setId(rs.getLong("id"));
                ingrediente.setNome(rs.getString("nome"));

                lista.add(ingrediente);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao listar ingredientes remover", ex);
            throw new RuntimeException("Erro ao listar ingredientes remover", ex);
        }

        return lista;
    }
}
    
    
    

