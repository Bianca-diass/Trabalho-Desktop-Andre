package entidades;

public class StatusPedido {
    private Long id;
    private Pedido pedido;
    private String progresso;

    public StatusPedido(){}
    
    public StatusPedido(Long id, Pedido pedido, String progresso) {
        this.id = id;
        this.pedido = pedido;
        this.progresso = progresso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getProgresso() {
        return progresso;
    }

    public void setProgresso(String progresso) {
        this.progresso = progresso;
    }
}
