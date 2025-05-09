package entidades;

public class IngredienteEscolha {
    private Long id;
    private IngredienteEscolha ingredienteescolha;
    private IngredienteRemover ingredienteremover;

    public IngredienteEscolha(){}
    
    public IngredienteEscolha(Long id, IngredienteEscolha ingredienteescolha, IngredienteRemover ingredienteremover) {
        this.id = id;
        this.ingredienteescolha = ingredienteescolha;
        this.ingredienteremover = ingredienteremover;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IngredienteEscolha getIngredienteescolha() {
        return ingredienteescolha;
    }

    public void setIngredienteescolha(IngredienteEscolha ingredienteescolha) {
        this.ingredienteescolha = ingredienteescolha;
    }

    public IngredienteRemover getIngredienteremover() {
        return ingredienteremover;
    }

    public void setIngredienteremover(IngredienteRemover ingredienteremover) {
        this.ingredienteremover = ingredienteremover;
    }
    
    
}
