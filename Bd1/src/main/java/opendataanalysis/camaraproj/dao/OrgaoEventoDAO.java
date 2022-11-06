package opendataanalysis.camaraproj.dao;

import opendataanalysis.camaraproj.models.OrgaoEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class OrgaoEventoDAO {

    @Autowired
    JdbcTemplate template;

    public List<OrgaoEvento> findAll(){
        String sql = "SELECT * FROM OrgaoEvento";
        RowMapper<OrgaoEvento> rm = new RowMapper<OrgaoEvento>(){
            @Override
            public OrgaoEvento mapRow(ResultSet resultSet, int i) throws SQLException {
                OrgaoEvento orgaofazevento = new OrgaoEvento(
                        resultSet.getInt("id_eve"),
                        resultSet.getInt("id_org")
                );
                return orgaofazevento;
            }
        };

        return template.query(sql, rm);
    }
}
