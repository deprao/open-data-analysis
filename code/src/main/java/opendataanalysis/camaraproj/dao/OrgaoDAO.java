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
        String sql = "SELECT * FROM orgao";
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

    public List<Orgao> findByName(String name){
        String sql = "SELECT * FROM orgao WHERE sigla LIKE '%"+name+"%' OR nome LIKE '%"+name+"%' ";
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

    public List<Integer> findOrgaosEventos(){
        String sql = "SELECT DISTINCT id_org FROM orgao_realiza_evento;";
        return template.queryForList(sql, new Object[] {}, Integer.class);
    }

    public String findOrgaosById(Integer id){
        String sql = "SELECT sigla FROM orgao WHERE id="+id;
        return template.queryForObject(sql, String.class);
    }

    public Integer findQtdEveByOrg(Integer id_org){
        String sql = "SELECT COUNT(*) FROM orgao_realiza_evento WHERE id_org='"+id_org+"';";
        return template.queryForObject(sql, new Object [] {}, Integer.class);
    }

    public boolean upload(String filepath){
        try{
            Integer tuplas = template.update("COPY orgao (id, sigla, nome, tipo, data_inicio, data_instalacao, data_fim, descricao_situacao, casa, sala) FROM "
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
