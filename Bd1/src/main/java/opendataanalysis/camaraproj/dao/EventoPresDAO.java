package opendataanalysis.camaraproj.dao;


import opendataanalysis.camaraproj.models.EventoPresenca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class EventoPresDAO {

    @Autowired
    JdbcTemplate template;

    public List<EventoPresenca> findAll(){
        String sql = "SELECT * FROM EventoPresenca";
        RowMapper<EventoPresenca> rm = new RowMapper<EventoPresenca>(){
            @Override
            public EventoPresenca mapRow(ResultSet resultSet, int i) throws SQLException {
                EventoPresenca presencas = new EventoPresenca(
                        resultSet.getInt("id_dep"),
                        resultSet.getInt("id_eve")
                );
                return presencas;
            }
        };

        return template.query(sql, rm);
    }
}
