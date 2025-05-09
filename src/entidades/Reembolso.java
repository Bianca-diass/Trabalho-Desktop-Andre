package entidades;

public class Reembolso {
     private Long id;
     private Pedido pedido;
     private String motivo;

     public Reembolso(){}
     
    public Reembolso(Long id, Pedido pedido, String motivo) {
        this.id = id;
        this.pedido = pedido;
        this.motivo = motivo;
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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
     
     
}
