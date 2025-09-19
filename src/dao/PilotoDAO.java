package dao;

import exceptions.DAOException;
import model.Piloto;

import java.util.List;

public interface PilotoDAO {

    void inserir(Piloto p) throws DAOException;
    void deletar(int id) throws DAOException;
    List<Piloto> ranking() throws DAOException;
    void atualizar(Piloto p) throws DAOException;

}
