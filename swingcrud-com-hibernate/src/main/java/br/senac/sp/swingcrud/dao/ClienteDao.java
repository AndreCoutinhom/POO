package br.senac.sp.swingcrud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.senac.sp.swingcrud.model.Cliente;
import br.senac.sp.swingcrud.repository.GenericRepository;

public class ClienteDao implements GenericRepository<Cliente> {

    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, email, endereco) values (?,?,?)";
        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getEndereco());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, email = ?, endereco = ? WHERE id = ?";
        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getEndereco());
            stmt.setLong(4, cliente.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Long id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> listar(String parametro) {
        List<Cliente> lista = new ArrayList<Cliente>();
        String sql = "SELECT * FROM cliente WHERE nome like ? ORDER BY nome";
        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();) {
            stmt.setString(1, "%" + parametro + "%");
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getLong("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setEndereco(rs.getString("endereco"));
                lista.add(c);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<Cliente>();
        String sql = "SELECT * FROM cliente ORDER BY nome";
        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getLong("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setEndereco(rs.getString("endereco"));
                lista.add(c);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
