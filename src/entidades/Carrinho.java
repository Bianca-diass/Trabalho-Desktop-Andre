package entidades;

public class Carrinho {
    private Long id;
    private Produto produto;
    private int quantidade;
    private IngredienteEscolha ingredienteescolha;

    public Carrinho(){}
     
    public Carrinho(Long id, Produto produto, int quantidade, IngredienteEscolha ingredienteescolha) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.ingredienteescolha = ingredienteescolha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public IngredienteEscolha getIngredienteescolha() {
        return ingredienteescolha;
    }

    public void setIngredienteescolha(IngredienteEscolha ingredienteescolha) {
        this.ingredienteescolha = ingredienteescolha;
    }    
}
