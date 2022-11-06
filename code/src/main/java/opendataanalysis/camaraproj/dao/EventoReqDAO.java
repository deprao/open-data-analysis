package opendataanalysis.camaraproj.dao;

import opendataanalysis.camaraproj.models.EventoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class EventoReqDAO {

    @Autowired
    JdbcTemplate template;

    public List<EventoReq> findAll(){
        String sql = "SELECT * FROM EventoReq";
        RowMapper<EventoReq> rm = new RowMapper<EventoReq>(){
            @Override
            public EventoReq mapRow(ResultSet resultSet, int i) throws SQLException {
                EventoReq eventorequer = new EventoReq(
                        resultSet.getInt("id_dep"),
                        resultSet.getInt("id_req")
                );
                return eventorequer;
            }
        };

        return template.query(sql, rm);
    }
}
