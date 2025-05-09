package entidades;

public class Telefone {
    private Long id;
    private int numero;
    private Funcionario funcionario;
    private Cliente cliente;
    
    public Telefone(){}

    public Telefone(Long id, int numero, Funcionario funcionario, Cliente cliente) {
        this.id = id;
        this.numero = numero;
        this.funcionario = funcionario;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }  
}
