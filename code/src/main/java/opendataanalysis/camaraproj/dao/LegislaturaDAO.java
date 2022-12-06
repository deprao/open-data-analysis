package opendataanalysis.camaraproj.dao;

import opendataanalysis.camaraproj.models.Legislatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
public class LegislaturaDAO {

    @Autowired
    JdbcTemplate template;

    public List<Legislatura> findAll(){
        String sql = "SELECT * FROM legislatura";
        RowMapper<Legislatura> rm = new RowMapper<Legislatura>(){
            @Override
            public Legislatura mapRow(ResultSet resultSet, int i) throws SQLException {
                Legislatura legislatura = new Legislatura(
                        resultSet.getInt("id"),
                        resultSet.getDate("data_inicio"),
                        resultSet.getDate("data_fim"),
                        resultSet.getInt("ano_eleicao")
                );
                return legislatura;
            }
        };

        return template.query(sql, rm);
    }

    public boolean upload(String filepath){
        try{
            Integer tuplas = template.update("COPY legislatura (id, data_inicio, data_fim, ano_eleicao) FROM "
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