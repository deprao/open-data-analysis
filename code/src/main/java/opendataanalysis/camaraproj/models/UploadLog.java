package opendataanalysis.camaraproj.models;

import java.sql.Timestamp;

public class UploadLog {
    public String nome_arquivo;
    public Timestamp data_hora_upload;
    public Integer tuplas_carregadas;

    public UploadLog(String nome_arquivo, Timestamp data_hora_upload, Integer tuplas_carregadas) {
        this.nome_arquivo = nome_arquivo;
        this.data_hora_upload = data_hora_upload;
        this.tuplas_carregadas = tuplas_carregadas;
    }
}
