package entidades;

public class IngredienteAdicional {
    private Long id;
    private String nome;
    private int valor;

    public IngredienteAdicional(){}
    
    public IngredienteAdicional(Long id, String nome, int valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}
