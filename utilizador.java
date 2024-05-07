public class utilizador {
    private String login;
    private String password;
    private String nome;
    private boolean estado; // true para ativo, false para inativo
    private String email;
    private String tipo;
    private String nif;
    private String morada;
    private String contactoTelefonico;

    // Construtor
    public utilizador(String login, String password, String nome, boolean estado, String email, String tipo) {
        this.login = login;
        this.password = password;
        this.nome = nome;
        this.estado = estado;
        this.email = email;
        this.tipo = tipo;
    }

    // Getters e setters para os campos existentes

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Getters e setters para os campos adicionais

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getContactoTelefonico() {
        return contactoTelefonico;
    }

    public void setContactoTelefonico(String contactoTelefonico) {
        this.contactoTelefonico = contactoTelefonico;
    }
}
