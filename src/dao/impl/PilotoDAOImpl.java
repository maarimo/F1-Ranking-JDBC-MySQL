package dao.impl;

import dao.PilotoDAO;
import exceptions.DAOException;
import model.Piloto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PilotoDAOImpl implements PilotoDAO {
    private Connection conn;

    public PilotoDAOImpl(Connection conn) {
        this.conn = conn;
    }

//inserir
    @Override
    public void inserir(Piloto p) throws DAOException {
        String sql = "INSERT INTO ranking (nome, pontuacao) VALUES (?, ?)";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, p.getNome());
            ps.setInt(2, p.getPontuacao());
            ps.executeUpdate();

        }catch (SQLException e){
            throw new DAOException("ERRO AO INSERIR PILOTO.", e);
        }
    }

    //delete
    @Override
    public void deletar(int id) throws DAOException {
        String sql = "DELETE FROM ranking WHERE id=?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("ERRO AO DELETAR.", e);
        }

    }
//listar ranking
@Override
public List<Piloto> ranking() throws DAOException {
    List<Piloto> lista = new ArrayList<>();
    String sql = "SELECT id, nome, pontuacao FROM ranking ORDER BY pontuacao DESC";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Piloto piloto = new Piloto();
            piloto.setId(rs.getInt("id"));
            piloto.setNome(rs.getString("nome"));
            piloto.setPontuacao(rs.getInt("pontuacao"));
            lista.add(piloto);
        }

    } catch (SQLException e) {
        throw new DAOException("ERRO AO LISTAR RANKING.", e);
    }

    return lista;
}

    @Override
    public void atualizar(Piloto p) throws DAOException {
        String sql = "UPDATE ranking SET nome=?, pontuacao=? WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNome());
            ps.setInt(2, p.getPontuacao());
            ps.setInt(3, p.getId());

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new DAOException("Nenhum piloto encontrado com id=" + p.getId());
            }

        } catch (SQLException e) {
            throw new DAOException("ERRO AO ATUALIZAR.", e);
        }


    }
}
