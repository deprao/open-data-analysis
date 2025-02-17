package opendataanalysis.camaraproj.dao;

import opendataanalysis.camaraproj.models.DepOrgao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
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
                        resultSet.getString("sigla_uf"),
                        resultSet.getString("cargo"),
                        resultSet.getDate("data_inicio"),
                        resultSet.getDate("data_fim")
                );
                return deporg;
            }
        };

        return template.query(sql, rm);
    }

    public boolean upload(String filepath){
        try{
            Integer tuplas = template.update("COPY dep_trabalha_orgao (id_org, id_dep, sigla_partido, sigla_uf, cargo, data_inicio, data_fim) FROM "
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
