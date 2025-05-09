package entidades;

public class Cupom {
    private Long id;
    private int valorcupom;
    private int codigo;
    private Pagamento pagamento;
    private int validade;

    public Cupom(){}
    
    public Cupom(Long id, int valorcupom, int codigo, Pagamento pagamento, int validade) {
        this.id = id;
        this.valorcupom = valorcupom;
        this.codigo = codigo;
        this.pagamento = pagamento;
        this.validade = validade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValorcupom() {
        return valorcupom;
    }

    public void setValorcupom(int valorcupom) {
        this.valorcupom = valorcupom;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public int getValidade() {
        return validade;
    }

    public void setValidade(int validade) {
        this.validade = validade;
    }  
}
