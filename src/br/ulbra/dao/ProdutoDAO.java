package br.ulbra.dao;

import br.ulbra.model.Produto;
import br.ulbra.model.Fornecedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para operações com produtos
 */
public class ProdutoDAO extends AbstractDAO {

    public void salvar(Produto p) throws SQLException {
        String sql = "INSERT INTO tbproduto (nome, preco, idfor) VALUES (?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
           
            ps.setString(1, p.getNome());
            ps.setDouble(2, p.getPreco());
            ps.setInt(3, p.getFornecedor().getIdFor());
           
            int affected = ps.executeUpdate();
            if (affected == 0) throw new SQLException("Falha ao inserir produto.");
           
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) p.setId(rs.getInt(1));
            }
        }
    }

    public Produto buscarPorId(int id) throws SQLException {
        String sql = "SELECT p.id, p.nome, p.preco, f.idfor as f_idfor, f.nomerazao as f_nomerazao, f.nomefantasia, f.telefone, f.email " +
                     "FROM tbproduto p INNER JOIN tbfornecedor f ON p.idfor = f.idfor WHERE p.id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
           
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Fornecedor f = new Fornecedor(
                        rs.getInt("f_idfor"),
                        rs.getString("f_nomerazao"),
                        rs.getString("nomefantasia"),
                        rs.getString("email"),
                        rs.getString("telefone")
                    );
                    return new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        f
                    );
                }
            }
        }
        return null;
    }

    public List<Produto> listar() throws SQLException {
        String sql = "SELECT p.id, p.nome, p.preco, f.idfor as f_idfor, f.nomerazao as f_nomerazao, f.nomefantasia, f.telefone, f.email " +
                     "FROM tbproduto p INNER JOIN tbfornecedor f ON p.idfor = f.idfor ORDER BY p.nome";
        List<Produto> lista = new ArrayList<>();
       
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
           
            while (rs.next()) {
                Fornecedor f = new Fornecedor(
                    rs.getInt("f_idfor"),
                    rs.getString("f_nomerazao"),
                    rs.getString("nomefantasia"),
                    rs.getString("email"),
                    rs.getString("telefone")
                );
                Produto p = new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getDouble("preco"),
                    f
                );
                lista.add(p);
            }
        }
        return lista;
    }

    public void atualizar(Produto p) throws SQLException {
        String sql = "UPDATE tbproduto SET nome = ?, preco = ?, idfor = ? WHERE id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
           
            ps.setString(1, p.getNome());
            ps.setDouble(2, p.getPreco());
            ps.setInt(3, p.getFornecedor().getIdFor());
            ps.setInt(4, p.getId());
           
            ps.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM tbproduto WHERE id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
           
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}