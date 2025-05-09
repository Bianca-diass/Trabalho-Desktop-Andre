package entidades;

public class Delivery {
    private Long id;
    private int chaveEntrega;
    private int numero;
    private int complemento;
    private Endereco endereco;

    public Delivery(){}

    public Delivery(Long id, int chaveEntrega, int numero, int complemento, Endereco endereco) {
        this.id = id;
        this.chaveEntrega = chaveEntrega;
        this.numero = numero;
        this.complemento = complemento;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getChaveEntrega() {
        return chaveEntrega;
    }

    public void setChaveEntrega(int chaveEntrega) {
        this.chaveEntrega = chaveEntrega;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getComplemento() {
        return complemento;
    }

    public void setComplemento(int complemento) {
        this.complemento = complemento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }  
}
