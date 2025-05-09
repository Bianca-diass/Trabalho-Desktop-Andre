package entidades;

public class Cartao {
    private Long id;
    private int numcartao;
    private String CVV;
    private int credito1;
    private int debito2;

    public Cartao(){}
    
    public Cartao(Long id, int numcartao, String CVV, int credito1, int debito2) {
        this.id = id;
        this.numcartao = numcartao;
        this.CVV = CVV;
        this.credito1 = credito1;
        this.debito2 = debito2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumcartao() {
        return numcartao;
    }

    public void setNumcartao(int numcartao) {
        this.numcartao = numcartao;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public int getCredito1() {
        return credito1;
    }

    public void setCredito1(int credito1) {
        this.credito1 = credito1;
    }

    public int getDebito2() {
        return debito2;
    }

    public void setDebito2(int debito2) {
        this.debito2 = debito2;
    }   
}
