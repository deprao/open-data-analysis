package opendataanalysis.camaraproj.dao;

import opendataanalysis.camaraproj.models.OrgaoEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
public class OrgaoEventoDAO {

    @Autowired
    JdbcTemplate template;

    public List<OrgaoEvento> findAll(){
        String sql = "SELECT * FROM orgao_realiza_evento LIMIT 100";
        RowMapper<OrgaoEvento> rm = new RowMapper<OrgaoEvento>(){
            @Override
            public OrgaoEvento mapRow(ResultSet resultSet, int i) throws SQLException {
                OrgaoEvento orgaofazevento = new OrgaoEvento(
                        resultSet.getInt("id_evento"),
                        resultSet.getInt("id_org")
                );
                return orgaofazevento;
            }
        };

        return template.query(sql, rm);
    }
}
