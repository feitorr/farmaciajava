import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class farmacia {
    private List<utilizador> utilizadores;
    private static final String FILE_PATH = "utilizadores.txt"; // Caminho do arquivo de texto

    public farmacia() {
        this.utilizadores = new ArrayList<>();
        carregarutilizadores(); // Carregar utilizadores do arquivo ao iniciar a aplicação
    }

    // Método para carregar utilizadores do arquivo de texto
    private void carregarutilizadores() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] partes = line.split(",");
                utilizador utilizador = new utilizador(partes[0], partes[1], partes[2], Boolean.parseBoolean(partes[3]), partes[4], partes[5]);
                this.utilizadores.add(utilizador);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar utilizadores do arquivo: " + e.getMessage());
        }
    }

    // Método para salvar utilizadores no arquivo de texto
    private void salvarutilizadores() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (utilizador utilizador : this.utilizadores) {
                bw.write(utilizador.getLogin() + "," + utilizador.getPassword() + "," + utilizador.getNome() + ","
                        + utilizador.isEstado() + "," + utilizador.getEmail() + "," + utilizador.getTipo());
                
                // Adicionar informações adicionais se o tipo for "farmaceutico" ou "cliente"
                if (utilizador.getTipo().equals("farmaceutico") || utilizador.getTipo().equals("cliente")) {
                    bw.write("," + utilizador.getNif() + "," + utilizador.getMorada() + "," + utilizador.getContactoTelefonico());
                }
                
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar utilizadores no arquivo: " + e.getMessage());
        }
    }
    

    // Método para permitir que os utilizadores se registrem
    public void registarutilizador(utilizador utilizador, Scanner scanner) {
        if (!existeLogin(utilizador.getLogin()) && !existeEmail(utilizador.getEmail())) {
            if (utilizador.getTipo().equals("farmaceutico") || utilizador.getTipo().equals("cliente")) {
                System.out.print("NIF: ");
                String nif = scanner.nextLine();
                System.out.print("Morada: ");
                String morada = scanner.nextLine();
                System.out.print("Número de Telemóvel: ");
                String numeroTelemovel = scanner.nextLine();
                utilizador.setNif(nif);
                utilizador.setMorada(morada);
                utilizador.setContactoTelefonico(numeroTelemovel);
            }
            this.utilizadores.add(utilizador);
            salvarutilizadores(); // Salvar utilizadores após cada registo
            System.out.println("utilizador registado com sucesso!");
        } else {
            System.out.println("Login ou email já existente. Registo falhou.");
        }
    }
    

    // Método para autenticar utilizadores
    public utilizador autenticarutilizador(String login, String password) {
        for (utilizador utilizador : this.utilizadores) {
            if (utilizador.getLogin().equals(login) && utilizador.getPassword().equals(password)) {
                return utilizador;
            }
        }
        return null; // utilizador não encontrado ou password incorreta
    }

    // Verifica se já existe um login
    private boolean existeLogin(String login) {
        for (utilizador utilizador : this.utilizadores) {
            if (utilizador.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    // Verifica se já existe um email
    private boolean existeEmail(String email) {
        for (utilizador utilizador : this.utilizadores) {
            if (utilizador.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    private static void registarutilizador(farmacia farmacia, Scanner scanner) {
        System.out.println("Registo de utilizador:");
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Tipo (gestor, farmaceutico, cliente): ");
        String tipo = scanner.nextLine();

        utilizador utilizador = new utilizador(login, password, nome, true, email, tipo);
        farmacia.registarutilizador(utilizador, scanner);
    }

    private static void autenticarutilizador(farmacia farmacia, Scanner scanner) {
        System.out.println("Autenticação de utilizador:");
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        utilizador utilizadorAutenticado = farmacia.autenticarutilizador(login, password);
        if (utilizadorAutenticado != null) {
            System.out.println("utilizador autenticado com sucesso!");
            System.out.println("Nome: " + utilizadorAutenticado.getNome());
            System.out.println("Tipo: " + utilizadorAutenticado.getTipo());
        } else {
            System.out.println("Login ou password incorretos!");
        }
    }


    public static void main(String[] args) {
        farmacia farmacia = new farmacia();
        Scanner scanner = new Scanner(System.in);

        boolean sair = false;
        while (!sair) {
            System.out.println("Bem-vindo à Farmácia!");
            System.out.println("1. Registar utilizador");
            System.out.println("2. Autenticar utilizador");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcao) {
                case 1:
                    registarutilizador(farmacia, scanner);
                    break;
                case 2:
                    autenticarutilizador(farmacia, scanner);
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }

    
}
