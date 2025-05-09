package implement;

import bancodedados.Conexao;
import dao.ProdutoDao;
import entidades.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoImplements implements ProdutoDao {

    private static final Logger LOGGER = Logger.getLogger(ProdutoImplements.class.getName());

    @Override
    public void salvar(ProdutoDao obj) {
        Produto produto = (Produto) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                "INSERT INTO produto(id, nome, valor_unitario) VALUES (?, ?, ?)"
            );
            
            ps.setLong(1, produto.getId());
            ps.setString(2, produto.getNome());
            ps.setInt(3, produto.getValorUnitario());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar produto: " + produto.toString(), ex);
            throw new RuntimeException("Erro ao salvar produto", ex);
        }
    }

    @Override
    public void editar(ProdutoDao obj) {
        Produto produto = (Produto) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                "UPDATE produto SET nome = ?, valor_unitario = ? WHERE id = ?"
            );
            
            ps.setString(1, produto.getNome());
            ps.setInt(2, produto.getValorUnitario());
            ps.setLong(3, produto.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao editar produto: " + produto.toString(), ex);
            throw new RuntimeException("Erro ao editar produto", ex);
        }
    }

    @Override
    public void remover(ProdutoDao obj) {
        Produto produto = (Produto) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM produto WHERE id = ?"
            );
            ps.setLong(1, produto.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao remover produto: " + produto.toString(), ex);
            throw new RuntimeException("Erro ao remover produto", ex);
        }
    }

    @Override
    public List<Produto> listar(ProdutoDao obj) {
        List<Produto> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM produto");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValorUnitario(rs.getInt("valor_unitario"));

                lista.add(produto);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao listar produtos", ex);
            throw new RuntimeException("Erro ao listar produtos", ex);
        }

        return lista;
    }
}
    
    
