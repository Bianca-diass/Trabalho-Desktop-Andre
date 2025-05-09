package implement;

import bancodedados.Conexao;
import dao.CarrinhoDao;
import entidades.Carrinho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarrinhoImplements implements CarrinhoDao {

    @Override
    public void salvar(CarrinhoDao obj) {
        Carrinho carrinho = (Carrinho) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "INSERT INTO carrinho(id, produto_id, quantidade, ingredienteescolha_id) VALUES (?, ?, ?, ?)"
            );
            ps.setLong(1, carrinho.getId());
            ps.setLong(2, carrinho.getProduto().getId());
            ps.setInt(3, carrinho.getQuantidade());
            ps.setLong(4, carrinho.getIngredienteescolha().getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(CarrinhoDao obj) {
        Carrinho carrinho = (Carrinho) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "UPDATE carrinho SET produto_id = ?, quantidade = ?, ingredienteescolha_id = ? WHERE id = ?"
            );
            ps.setLong(1, carrinho.getProduto().getId());
            ps.setInt(2, carrinho.getQuantidade());
            ps.setLong(3, carrinho.getIngredienteescolha().getId());
            ps.setLong(4, carrinho.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(CarrinhoDao obj) {
        Carrinho carrinho = (Carrinho) obj;
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(
                    "DELETE FROM carrinho WHERE id = ?"
            );
            ps.setLong(1, carrinho.getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Carrinho> listar(CarrinhoDao obj) {
        List<Carrinho> lista = new LinkedList<>();
        try {
            Connection conexao = (Connection) Conexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM carrinho");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Carrinho carrinho = new Carrinho();
                carrinho.setId(rs.getLong("id"));

                // Supondo que Produto e IngredienteEscolha tenham apenas ID aqui
                carrinho.setQuantidade(rs.getInt("quantidade"));

                carrinho.setProduto(new entidades.Produto());
                carrinho.getProduto().setId(rs.getLong("produto_id"));

                carrinho.setIngredienteescolha(new entidades.IngredienteEscolha());
                carrinho.getIngredienteescolha().setId(rs.getLong("ingredienteescolha_id"));

                lista.add(carrinho);
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(CarrinhoImplements.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
}