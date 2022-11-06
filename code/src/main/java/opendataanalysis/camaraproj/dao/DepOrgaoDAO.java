package opendataanalysis.camaraproj.dao;

import opendataanalysis.camaraproj.models.DepOrgao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DepOrgaoDAO {

    @Autowired
    JdbcTemplate template;

    public List<DepOrgao> findAll(){
        String sql = "SELECT * FROM dep_trabalha_orgao";
        RowMapper<DepOrgao> rm = new RowMapper<DepOrgao>(){
            @Override
            public DepOrgao mapRow(ResultSet resultSet, int i) throws SQLException {
                DepOrgao deporg  = new DepOrgao(
                        resultSet.getInt("id_org"),
                        resultSet.getInt("id_dep"),
                        resultSet.getString("sigla_partido"),
                        resultSet.getString("UF"),
                        resultSet.getString("cargo"),
                        resultSet.getDate("data_ini"),
                        resultSet.getDate("data_fim")
                );
                return deporg;
            }
        };

        return template.query(sql, rm);
    }
}
