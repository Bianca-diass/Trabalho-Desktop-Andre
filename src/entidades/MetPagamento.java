package entidades;

public class MetPagamento {
    private Long id;
    private int pix;
    private Dinheiro dinheiro;
    private Cartao cartao;

    public MetPagamento(){}
    
    public MetPagamento(Long id, int pix, Dinheiro dinheiro, Cartao cartao) {
        this.id = id;
        this.pix = pix;
        this.dinheiro = dinheiro;
        this.cartao = cartao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPix() {
        return pix;
    }

    public void setPix(int pix) {
        this.pix = pix;
    }

    public Dinheiro getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(Dinheiro dinheiro) {
        this.dinheiro = dinheiro;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
    
    
}
