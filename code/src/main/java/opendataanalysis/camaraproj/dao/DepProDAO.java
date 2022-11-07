package opendataanalysis.camaraproj.dao;
import opendataanalysis.camaraproj.models.DepProfissao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
public class DepProDAO {

    @Autowired
    JdbcTemplate template;

    public List<DepProfissao> findAll(){
        String sql = "SELECT * FROM dep_profissao LIMIT 100";
        RowMapper<DepProfissao> rm = new RowMapper<DepProfissao>(){
            @Override
            public DepProfissao mapRow(ResultSet resultSet, int i) throws SQLException {
                DepProfissao profissao = new DepProfissao(
                        resultSet.getInt("id_dep"),
                        resultSet.getInt("cod_tipo"),
                        resultSet.getString("titulo"),
                        resultSet.getTimestamp("data_hora_registro")
                );
                return profissao;
            }
        };

        return template.query(sql, rm);
    }
}