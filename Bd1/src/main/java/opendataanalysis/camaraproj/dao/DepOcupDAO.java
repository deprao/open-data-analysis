package opendataanalysis.camaraproj.dao;

import opendataanalysis.camaraproj.models.DepOcupacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DepOcupDAO {

    @Autowired
    JdbcTemplate template;

    public List<DepOcupacao> findAll(){
        String sql = "SELECT * FROM dep_ocupacao";
        RowMapper<DepOcupacao> rm = new RowMapper<DepOcupacao>(){
            @Override
            public DepOcupacao mapRow(ResultSet resultSet, int i) throws SQLException {
                DepOcupacao ocupacao = new DepOcupacao(
                        resultSet.getString("titulo"),
                        resultSet.getString("entidade"),
                        resultSet.getString("ano_ini"),
                        resultSet.getString("ano_fim"),
                        resultSet.getString("Uf_ent"),
                        resultSet.getString("pais_entidade"),
                        resultSet.getInt("id_dep")
                );
                return ocupacao;
            }
        };

        return template.query(sql, rm);
    }
}
