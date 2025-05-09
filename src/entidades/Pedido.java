package entidades;

public class Pedido {
    private Long id;
    private int horaPedido;
    private Cliente cliente;
    private int numeroPedido;
    private Carrinho carrinho;
    private int DataPedido;
    private String statusPedido;
    private Entrega entrega;
    private String estatusPedido;

    public Pedido(){}
    
    public Pedido(Long id, int horaPedido, Cliente cliente, int numeroPedido, Carrinho carrinho, int DataPedido, String statusPedido, Entrega entrega, String estatusPedido) {
        this.id = id;
        this.horaPedido = horaPedido;
        this.cliente = cliente;
        this.numeroPedido = numeroPedido;
        this.carrinho = carrinho;
        this.DataPedido = DataPedido;
        this.statusPedido = statusPedido;
        this.entrega = entrega;
        this.estatusPedido = estatusPedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(int horaPedido) {
        this.horaPedido = horaPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public int getDataPedido() {
        return DataPedido;
    }

    public void setDataPedido(int DataPedido) {
        this.DataPedido = DataPedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public String getEstatusPedido() {
        return estatusPedido;
    }

    public void setEstatusPedido(String estatusPedido) {
        this.estatusPedido = estatusPedido;
    }
    
    
            
}
