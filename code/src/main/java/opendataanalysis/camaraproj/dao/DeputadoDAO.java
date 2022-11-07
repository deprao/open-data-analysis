package opendataanalysis.camaraproj.dao;

import opendataanalysis.camaraproj.models.Deputado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class DeputadoDAO {

    @Autowired
    JdbcTemplate template;

    public List<Deputado> findAll(){
        String sql = "SELECT * FROM deputado LIMIT 100";
        RowMapper<Deputado> rm = new RowMapper<Deputado>(){
            @Override
            public Deputado mapRow(ResultSet resultSet, int i) throws SQLException {
                Deputado deputado = new Deputado(
                        resultSet.getInt("id_dep"),
                        resultSet.getString("nome_parlamentar"),
                        resultSet.getString("nome_civil"),
                        resultSet.getDate("data_nasc"),
                        resultSet.getDate("data_falec"),
                        resultSet.getString("sexo"),
                        resultSet.getString("uf_nasc"),
                        resultSet.getString("município_nasc"),
                        resultSet.getInt("id_ultima_legislatura")
                );
                return deputado;
            }
        };

        return template.query(sql, rm);
    }

    public boolean upload(String filepath){
        try{
            Integer tuplas = template.update("COPY deputado (id_dep, nome_parlamentar, id_ultima_legislatura, nome_civil, sexo, data_nasc, data_falec, uf_nasc, município_nasc) FROM "
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
