package entidades;

public class Login {
    private Long id;
    private String senha;
    private Funcionario funcionario;

    public Login(Long id, String senha, Funcionario funcionario) {
        this.id = id;
        this.senha = senha;
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}


