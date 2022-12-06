package opendataanalysis.camaraproj.dao;

import opendataanalysis.camaraproj.models.ChartModel;
import opendataanalysis.camaraproj.models.Deputado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class DeputadoDAO {

    @Autowired
    JdbcTemplate template;

    public List<Deputado> findAll(){
        String sql = "SELECT * FROM deputado";
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

    public List<Deputado> findByName(String name){
        String sql = "SELECT * FROM deputado WHERE nome_parlamentar LIKE '"+"%"+name+"%"+"' OR nome_civil LIKE '"+"%"+name+"%"+"';";
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

    public List<Deputado> findForGenre(String genre){
        String sql = "SELECT * FROM deputado WHERE sexo='"+genre+"'";
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

    public List<Deputado> findRIPDeps(){
        String sql = "   SELECT * FROM deputado WHERE data_falec IS NOT NULL";
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

    public Integer findQtdDepsGenre(char genre){
        String sql = "SELECT COUNT(*)FROM deputado WHERE sexo='"+genre+"';";
        return template.queryForObject(sql, new Object [] {}, Integer.class);
    }

    public Integer findQtdDepsUF(String uf){
        String sql = "SELECT COUNT(*)FROM deputado WHERE uf_nasc='"+uf+"';";
        return template.queryForObject(sql, new Object [] {}, Integer.class);
    }


    public List<String> findPartidos(){
        String sql = "SELECT DISTINCT sigla_partido FROM dep_trabalha_orgao;";
        return template.queryForList(sql, String.class);
    }

    public List<String> findProfissoes(){
        String sql = "SELECT DISTINCT titulo FROM dep_profissao;";
        return template.queryForList(sql, String.class);
    }

    public Integer findQtdPorPartido(String partido){
        String sql = "SELECT COUNT(DISTINCT id_dep) FROM dep_trabalha_orgao WHERE sigla_partido='"+partido+"';";
        return template.queryForObject(sql, new Object [] {}, Integer.class);
    }

    public Integer findQtdPorProfissao(String prof){
        String sql = "SELECT COUNT(*) FROM dep_profissao WHERE titulo='"+prof+"';";
        return template.queryForObject(sql, new Object [] {}, Integer.class);
    }

    public boolean upload(String filepath){
        try{
            Integer tuplas = template.update("COPY deputados (id_dep, nome_parlamentar, nome_civil, data_nasc, data_falec, sexo, uf_nasc, municipio_nasc, id_ultima_legislatura) FROM "
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
