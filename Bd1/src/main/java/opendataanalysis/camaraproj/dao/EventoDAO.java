package opendataanalysis.camaraproj.dao;

import opendataanalysis.camaraproj.models.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class EventoDAO {

    @Autowired
    JdbcTemplate template;

    public List<Evento> findAll(){
        String sql = "SELECT * FROM Evento";
        RowMapper<Evento> rm = new RowMapper<Evento>(){
            @Override
            public Evento mapRow(ResultSet resultSet, int i) throws SQLException {
                Evento evento = new Evento(
                        resultSet.getInt("id"),
                        resultSet.getDate("data_hora_ini"),
                        resultSet.getDate("data_hora_fim"),
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
}
