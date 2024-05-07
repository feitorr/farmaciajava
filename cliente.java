public class cliente extends utilizador {
    private String nif;
    private String morada;
    private String contactoTelefonico;

    public cliente(String login, String password, String nome, boolean estado, String email, String tipo, String nif, String morada, String contactoTelefonico) {
        super(login, password, nome, estado, email, tipo);
        this.nif = nif;
        this.morada = morada;
        this.contactoTelefonico = contactoTelefonico;
    }
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