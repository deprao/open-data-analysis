package opendataanalysis.camaraproj.dao;

import opendataanalysis.camaraproj.models.DepOcupacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
public class DepOcupDAO {

    @Autowired
    JdbcTemplate template;

    public List<DepOcupacao> findAll(){
        String sql = "SELECT * FROM dep_ocupacao LIMIT 100";
        RowMapper<DepOcupacao> rm = new RowMapper<DepOcupacao>(){
            @Override
            public DepOcupacao mapRow(ResultSet resultSet, int i) throws SQLException {
                DepOcupacao ocupacao = new DepOcupacao(
                        resultSet.getString("titulo"),
                        resultSet.getString("entidade"),
                        resultSet.getString("ano_inicio"),
                        resultSet.getString("ano_fim"),
                        resultSet.getString("uf_entidade"),
                        resultSet.getString("pais_entidade"),
                        resultSet.getInt("id_dep")
                );
                return ocupacao;
            }
        };

        return template.query(sql, rm);
    }

    public boolean upload(String filepath){
        try{
            Integer tuplas = template.update("COPY dep_ocupacao (id_dep, titulo, entidade, uf_entidade, pais_entidade, ano_inicio, ano_fim) FROM "
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
