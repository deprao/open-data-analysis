package opendataanalysis.camaraproj.dao;

import opendataanalysis.camaraproj.models.Votacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
public class VotacaoDAO {

    @Autowired
    JdbcTemplate template;

    public List<Votacao> findAll(){
        String sql = "SELECT * FROM votacao";
        RowMapper<Votacao> rm = new RowMapper<Votacao>(){
            @Override
            public Votacao mapRow(ResultSet resultSet, int i) throws SQLException {
                Votacao votacao = new Votacao(
                        resultSet.getString("id_votacao"),
                        resultSet.getDate("data_votacao"),
                        resultSet.getInt("id_org"),
                        resultSet.getInt("aprovacao"),
                        resultSet.getInt("votos_favor"),
                        resultSet.getInt("votos_contra"),
                        resultSet.getString("desc_resultado"),
                        resultSet.getString("ultima_apresentacao_requerimento_descricao"),
                        resultSet.getInt("id_requerimento")
                );
                return votacao;
            }
        };

        return template.query(sql, rm);
    }
}
