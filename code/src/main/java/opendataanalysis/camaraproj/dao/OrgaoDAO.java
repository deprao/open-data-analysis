package opendataanalysis.camaraproj.dao;

import opendataanalysis.camaraproj.models.Orgao;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class OrgaoDAO {

    @Autowired
    JdbcTemplate template;

    public List<Orgao> findAll(){
        String sql = "SELECT * FROM Orgao";
        RowMapper<Orgao> rm = new RowMapper<Orgao>(){
            @Override
            public Orgao mapRow(ResultSet resultSet, int i) throws SQLException {
                Orgao orgao = new Orgao(
                        resultSet.getInt("id"),
                        resultSet.getString("sigla"),
                        resultSet.getString("nome"),
                        resultSet.getString("tipo"),
                        resultSet.getDate("data_ini"),
                        resultSet.getDate("data_inst"),
                        resultSet.getDate("data_fim"),
                        resultSet.getString("desc_situacao"),
                        resultSet.getString("casa"),
                        resultSet.getString("sala")
                );
                return orgao;
            }
        };

        return template.query(sql, rm);
    }
}
