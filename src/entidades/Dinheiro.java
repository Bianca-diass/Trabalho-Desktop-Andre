package entidades;

public class Dinheiro {
    private Long id;
    private int valorEntregado;

    public Dinheiro(){}
    
    public Dinheiro(Long id, int valorEntregado) {
        this.id = id;
        this.valorEntregado = valorEntregado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValorEntregado() {
        return valorEntregado;
    }

    public void setValorEntregado(int valorEntregado) {
        this.valorEntregado = valorEntregado;
    }   
}
