package br.com.fecaf.model;

public class Jogo {

    // id, titulo, desenvolvedora, genero, plataforma, anoLancamento, preco, classificacao, nota, vendas, status
    private int id, anoLancamento, vendas;
    private String titulo, desenvolvedora, genero, plataforma, classificacao, status;
    private double preco, nota;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getVendas() {
        return vendas;
    }

    public void setVendas(int vendas) {
        this.vendas = vendas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "id=" + id +
                ", anoLancamento=" + anoLancamento +
                ", vendas=" + vendas +
                ", titulo='" + titulo + '\'' +
                ", desenvolvedora='" + desenvolvedora + '\'' +
                ", genero='" + genero + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", classificacao='" + classificacao + '\'' +
                ", status='" + status + '\'' +
                ", preco=" + preco +
                ", nota=" + nota +
                '}';
    }
}
