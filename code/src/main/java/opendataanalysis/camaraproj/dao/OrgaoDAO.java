package opendataanalysis.camaraproj.dao;

import opendataanalysis.camaraproj.models.Orgao;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
public class OrgaoDAO {

    @Autowired
    JdbcTemplate template;

    public List<Orgao> findAll(){
        String sql = "SELECT * FROM orgao LIMIT 100";
        RowMapper<Orgao> rm = new RowMapper<Orgao>(){
            @Override
            public Orgao mapRow(ResultSet resultSet, int i) throws SQLException {
                Orgao orgao = new Orgao(
                        resultSet.getInt("id"),
                        resultSet.getString("sigla"),
                        resultSet.getString("nome"),
                        resultSet.getString("tipo"),
                        resultSet.getTimestamp("data_inicio"),
                        resultSet.getTimestamp("data_instalacao"),
                        resultSet.getTimestamp("data_fim"),
                        resultSet.getString("descricao_situacao"),
                        resultSet.getString("casa"),
                        resultSet.getString("sala")
                );
                return orgao;
            }
        };

        return template.query(sql, rm);
    }
}
