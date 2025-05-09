package entidades;

public class Pagamento {
     private Long id;
     private MetPagamento metpagamento;
     private String cupom;

     public Pagamento(){}
     
    public Pagamento(Long id, MetPagamento metpagamento, String cupom) {
        this.id = id;
        this.metpagamento = metpagamento;
        this.cupom = cupom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MetPagamento getMetpagamento() {
        return metpagamento;
    }

    public void setMetpagamento(MetPagamento metpagamento) {
        this.metpagamento = metpagamento;
    }

    public String getCupom() {
        return cupom;
    }

    public void setCupom(String cupom) {
        this.cupom = cupom;
    }
     
     
}
