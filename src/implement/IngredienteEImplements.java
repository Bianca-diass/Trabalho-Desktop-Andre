package implement;

import bancodedados.Conexao;
import dao.IngredienteEscolhaDao;
import entidades.IngredienteEscolha;
import entidades.IngredienteRemover;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IngredienteEImplements implements IngredienteEscolhaDao {

    private static final Logger LOGGER = Logger.getLogger(IngredienteEImplements.class.getName());

    @Override
    public void salvar(IngredienteEscolhaDao obj) {
        IngredienteEscolha ingrediente = (IngredienteEscolha) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "INSERT INTO ingrediente_escolha(id, ingrediente_escolha_id, ingrediente_remover_id) VALUES (?, ?, ?)"
            );
            ps.setLong(1, ingrediente.getId());
            ps.setLong(2, ingrediente.getIngredienteescolha().getId());
            ps.setLong(3, ingrediente.getIngredienteremover().getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar ingrediente escolha: " + ingrediente.toString(), ex);
            throw new RuntimeException("Erro ao salvar ingrediente escolha", ex);
        }
    }

    @Override
    public void editar(IngredienteEscolhaDao obj) {
        IngredienteEscolha ingrediente = (IngredienteEscolha) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "UPDATE ingrediente_escolha SET ingrediente_escolha_id = ?, ingrediente_remover_id = ? WHERE id = ?"
            );
            ps.setLong(1, ingrediente.getIngredienteescolha().getId());
            ps.setLong(2, ingrediente.getIngredienteremover().getId());
            ps.setLong(3, ingrediente.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao editar ingrediente escolha: " + ingrediente.toString(), ex);
            throw new RuntimeException("Erro ao editar ingrediente escolha", ex);
        }
    }

    @Override
    public void remover(IngredienteEscolhaDao obj) {
        IngredienteEscolha ingrediente = (IngredienteEscolha) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM ingrediente_escolha WHERE id = ?"
            );
            ps.setLong(1, ingrediente.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao remover ingrediente escolha: " + ingrediente.toString(), ex);
            throw new RuntimeException("Erro ao remover ingrediente escolha", ex);
        }
    }

    @Override
    public List<IngredienteEscolha> listar(IngredienteEscolhaDao obj) {
        List<IngredienteEscolha> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM ingrediente_escolha");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                IngredienteEscolha ingrediente = new IngredienteEscolha();
                ingrediente.setId(rs.getLong("id"));
                
                IngredienteEscolha ingredienteEscolha = new IngredienteEscolha();
                ingredienteEscolha.setId(rs.getLong("ingrediente_escolha_id"));
                ingrediente.setIngredienteescolha(ingredienteEscolha);
                
                IngredienteRemover ingredienteRemover = new IngredienteRemover();
                ingredienteRemover.setId(rs.getLong("ingrediente_remover_id"));
                ingrediente.setIngredienteremover(ingredienteRemover);

                lista.add(ingrediente);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao listar ingredientes escolha", ex);
            throw new RuntimeException("Erro ao listar ingredientes escolha", ex);
        }

        return lista;
    }
}
    
    
    

