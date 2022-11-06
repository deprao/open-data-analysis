package opendataanalysis.camaraproj.dao;

import opendataanalysis.camaraproj.models.Legislatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
                        resultSet.getDate("data_ini"),
                        resultSet.getDate("data_fim"),
                        resultSet.getInt("ano_elec")
                );
                return legislatura;
            }
        };

        return template.query(sql, rm);
    }
}