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
        String sql = "SELECT * FROM orgao_realiza_evento";
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

    public boolean upload(String filepath){
        try{
            Integer tuplas = template.update("COPY orgao_realiza_evento (id_org, id_evento) FROM "
                    + "\'" + filepath +  "\'" +" DELIMITER ';' CSV HEADER;");

            String[] pathcomponents = filepath.split("\\\\");
            String filename = pathcomponents[pathcomponents.length - 1];

            template.update("INSERT INTO insert_log VALUES (?, CURRENT_TIMESTAMP , ?)", filename, tuplas);
            return true;
        }
        catch(Exception e){
            return false;
        }

    }
}
