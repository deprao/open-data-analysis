package opendataanalysis.camaraproj.dao;

import opendataanalysis.camaraproj.models.Votacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
public class VotacaoDAO {

    @Autowired
    JdbcTemplate template;

    public List<Votacao> findAll(){
        String sql = "SELECT * FROM votacao";
        RowMapper<Votacao> rm = new RowMapper<Votacao>(){
            @Override
            public Votacao mapRow(ResultSet resultSet, int i) throws SQLException {
                Votacao votacao = new Votacao(
                        resultSet.getString("id_votacao"),
                        resultSet.getDate("data_votacao"),
                        resultSet.getInt("id_org"),
                        resultSet.getInt("aprovacao"),
                        resultSet.getInt("votos_favor"),
                        resultSet.getInt("votos_contra"),
                        resultSet.getString("desc_resultado"),
                        resultSet.getString("ultima_apresentacao_requerimento_descricao"),
                        resultSet.getInt("id_requerimento")
                );
                return votacao;
            }
        };

        return template.query(sql, rm);
    }

    public boolean upload(String filepath){
        try{
            Integer tuplas = template.update("COPY votacao (id_votacao, data_votacao, id_org, aprovacao, votos_favor, votos_contra, desc_resultado, ultima_apresentacao_requerimento_descricao, id_requerimento) FROM "
                    + "\'" + filepath +  "\'" +" DELIMITER ';' CSV HEADER;");

            String[] pathcomponents = filepath.split("\\\\");
            String filename = pathcomponents[pathcomponents.length - 1];

            template.update("INSERT INTO insert_log VALUES (?, CURRENT_TIMESTAMP , ?)", filename, tuplas);
            return true;
        }
        catch(Exception e){
            return false;
        }

    }
}
