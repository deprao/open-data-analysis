package opendataanalysis.camaraproj.dao;


import opendataanalysis.camaraproj.models.EventoPresenca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
public class EventoPresDAO {

    @Autowired
    JdbcTemplate template;

    public List<EventoPresenca> findAll(){
        String sql = "SELECT * FROM deputado_participa_evento";
        RowMapper<EventoPresenca> rm = new RowMapper<EventoPresenca>(){
            @Override
            public EventoPresenca mapRow(ResultSet resultSet, int i) throws SQLException {
                EventoPresenca presencas = new EventoPresenca(
                        resultSet.getInt("id_dep"),
                        resultSet.getInt("id_evento")
                );
                return presencas;
            }
        };

        return template.query(sql, rm);
    }

    public boolean upload(String filepath){
        try{
            Integer tuplas = template.update("COPY deputado_participa_evento (id_evento, id_dep) FROM "
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
