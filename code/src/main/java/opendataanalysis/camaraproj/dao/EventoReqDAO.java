package opendataanalysis.camaraproj.dao;

import opendataanalysis.camaraproj.models.EventoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
public class EventoReqDAO {

    @Autowired
    JdbcTemplate template;

    public List<EventoReq> findAll(){
        String sql = "SELECT * FROM evento_requer_aprovacao LIMIT 100";
        RowMapper<EventoReq> rm = new RowMapper<EventoReq>(){
            @Override
            public EventoReq mapRow(ResultSet resultSet, int i) throws SQLException {
                EventoReq eventorequer = new EventoReq(
                        resultSet.getInt("id_evento"),
                        resultSet.getInt("id_requerimento")
                );
                return eventorequer;
            }
        };

        return template.query(sql, rm);
    }

    public boolean upload(String filepath){
        try{
            Integer tuplas = template.update("COPY evento_requer_aprovacao (id_evento, id_requerimento) FROM "
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
