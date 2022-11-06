package opendataanalysis.camaraproj.dao;

import opendataanalysis.camaraproj.models.Votacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class VotacaoDAO {

    @Autowired
    JdbcTemplate template;

    public List<Votacao> findAll(){
        String sql = "SELECT * FROM Votacao";
        RowMapper<Votacao> rm = new RowMapper<Votacao>(){
            @Override
            public Votacao mapRow(ResultSet resultSet, int i) throws SQLException {
                Votacao votacao = new Votacao(
                        resultSet.getString("id_vot"),
                        resultSet.getDate("data_vot"),
                        resultSet.getInt("id_org"),
                        resultSet.getInt("aprov"),
                        resultSet.getInt("vote_up"),
                        resultSet.getInt("vote_down"),
                        resultSet.getString("desc_result"),
                        resultSet.getString("ultima_req"),
                        resultSet.getInt("id_req")
                );
                return votacao;
            }
        };

        return template.query(sql, rm);
    }
}
