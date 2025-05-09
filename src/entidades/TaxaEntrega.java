package entidades;

public class TaxaEntrega {
    private Long id;
    private Endereco endereco;
    private int taxaEntrega;

    public TaxaEntrega(){}
    
    public TaxaEntrega(Long id, Endereco endereco, int taxaEntrega) {
        this.id = id;
        this.endereco = endereco;
        this.taxaEntrega = taxaEntrega;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getTaxaEntrega() {
        return taxaEntrega;
    }

    public void setTaxaEntrega(int taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }
    
    
}
