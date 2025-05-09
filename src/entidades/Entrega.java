package entidades;

public class Entrega {
    private Long id;
    private Cliente cliente;
    private String tipoEntrega;
    private Delivery delivery;
    private Pedido pedido;
    private StatusPedido statuspedido;

     public Entrega(){}

    public Entrega(Long id, Cliente cliente, String tipoEntrega, Delivery delivery, Pedido pedido, StatusPedido statuspedido) {
        this.id = id;
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.delivery = delivery;
        this.pedido = pedido;
        this.statuspedido = statuspedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public StatusPedido getStatuspedido() {
        return statuspedido;
    }

    public void setStatuspedido(StatusPedido statuspedido) {
        this.statuspedido = statuspedido;
    }   
}
