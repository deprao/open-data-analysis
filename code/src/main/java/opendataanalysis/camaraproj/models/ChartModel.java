package opendataanalysis.camaraproj.models;

public class ChartModel {
    public String sample;
    public Integer qtd;

    public ChartModel(String sample, Integer qtd) {
        this.sample = sample;
        this.qtd = qtd;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }
}
