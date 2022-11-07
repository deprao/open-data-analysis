package opendataanalysis.camaraproj.dao;

import java.sql.Timestamp;
import opendataanalysis.camaraproj.models.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
public class EventoDAO {

    @Autowired
    JdbcTemplate template;

    public List<Evento> findAll(){
        String sql = "SELECT * FROM evento LIMIT 100";
        RowMapper<Evento> rm = new RowMapper<Evento>(){
            @Override
            public Evento mapRow(ResultSet resultSet, int i) throws SQLException {
                Evento evento = new Evento(
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("data_hora_inicio"),
                        resultSet.getTimestamp("data_hora_fim"),
                        resultSet.getString("situacao"),
                        resultSet.getString("descricao"),
                        resultSet.getString("descricao_tipo"),
                        resultSet.getString("localizacao")
                );
                return evento;
            }
        };

        return template.query(sql, rm);
    }

    public void upload(String filepath){
        Integer tuplas = template.update("COPY evento (id, data_hora_inicio, data_hora_fim, situacao, descricao, descricao_tipo, localizacao) FROM "
                + "\'" + filepath +  "\'" +" DELIMITER ';' CSV HEADER;");

        String[] pathcomponents = filepath.split("\\\\");
        String filename = pathcomponents[pathcomponents.length - 1];

        template.update("INSERT INTO insert_log VALUES (?, CURRENT_TIMESTAMP , ?)", filename, tuplas);

    }
}
