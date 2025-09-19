package app;

import config.Conexao;
import dao.PilotoDAO;
import dao.impl.PilotoDAOImpl;
import exceptions.DAOException;
import model.Piloto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]){
        try(Connection conn = Conexao.getConnection()){
            PilotoDAO dao = new PilotoDAOImpl(conn);

            //Piloto piloto = new Piloto("Valteri Bottas", 3);
            //dao.inserir(piloto);


            List<Piloto> ranking = new ArrayList<>();

            //atualizar
            if (!ranking.isEmpty()) {
                Piloto piloto = ranking.get(1);
                piloto.setPontuacao(407);
                dao.atualizar(piloto);
            }

            ranking = dao.ranking();
            ranking.forEach(System.out::println);


            //dao.deletar(41);






        } catch (SQLException | DAOException e){
            e.printStackTrace();
        }


    }
}
