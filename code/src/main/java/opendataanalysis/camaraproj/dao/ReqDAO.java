package opendataanalysis.camaraproj.dao;

import opendataanalysis.camaraproj.models.Requerimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
public class ReqDAO {

    @Autowired
    JdbcTemplate template;

    public List<Requerimento> findAll(){
        String sql = "SELECT * FROM requerimento LIMIT 100";
        RowMapper<Requerimento> rm = new RowMapper<Requerimento>(){
            @Override
            public Requerimento mapRow(ResultSet resultSet, int i) throws SQLException {
                Requerimento requerimento = new Requerimento(
                        resultSet.getInt("id"),
                        resultSet.getString("titulo")
                );
                return requerimento;
            }
        };

        return template.query(sql, rm);
    }
}
