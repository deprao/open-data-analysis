package opendataanalysis.camaraproj.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import opendataanalysis.camaraproj.models.UploadLog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
public class UploadLogDAO {

    @Autowired
    JdbcTemplate template;

    public List<UploadLog> findAll(){
        String sql = "SELECT * FROM insert_log";
        RowMapper<UploadLog> rm = new RowMapper<UploadLog>() {
            @Override
            public UploadLog mapRow(ResultSet rs, int rowNum) throws SQLException {
                UploadLog log = new UploadLog(
                        rs.getString("nome_arquivo"),
                        rs.getTimestamp("data_hora_upload"),
                        rs.getInt("tuplas_carregadas")
                );

                return log;
            }
        };
        return template.query(sql, rm);
    }
}
