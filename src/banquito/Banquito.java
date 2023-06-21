package banquito;

import javax.swing.JOptionPane;

public class Banquito {

    static Clientela[] clnt = new Clientela[1000];
    static Depositos[] dep = new Depositos[1000];
    static Retirar[] ret = new Retirar[1000];
    static int pClientela = 0;
    static int pDepositos = 0;
    static int pRetirar = 0;

    
    static String cliente;
    static String nombre;
    static double saldo;
    static String fecha;
    static double deposito;
    static double retiro;

    public static void main(String[] args) {

        int opcion = 0;
        while (opcion != 7) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "**** MENU PRINCIPAL DEL SISTEMA **** \n"
                    + "[1].- Nuevo Cliente \n"
                    + "[2].- Depositar \n"
                    + "[3].- Retirar \n"
                    + "[4].- Ver Saldo \n"
                    + "[5].- Ver Depositados  \n"
                    + "[6].- Ver Retirados \n"
                    + "[7].- Salir"));
            switch (opcion) {
                case 1:
                    SubMenuClientela();
                    break;
                case 2:
                    Depositos();
                    break;
                case 3:
                    Retirar();
                    break;
                case 4:
                    VerSaldo();
                    break;
                case 5:
                    VerDepositados();
                    break;
                case 6:
                    VerRetirados();
                    break;
                default:
            }

        }
    }

    static void SubMenuClientela() {

        cliente = JOptionPane.showInputDialog(null, "Agregar número del cliente");
        nombre = JOptionPane.showInputDialog(null, "Nombre del Cliente");
        saldo = Double.parseDouble(JOptionPane.showInputDialog(null, "Insertar el Saldo del Cliente"));

        clnt[pClientela] = new Clientela();
        clnt[pClientela].setNoClientes(cliente);
        clnt[pClientela].setNombre(nombre);
        clnt[pClientela].setSaldo(saldo);
        pClientela++;
    }

    static void Depositos() {

        cliente = JOptionPane.showInputDialog(null, "Número de Cliente");
        fecha = JOptionPane.showInputDialog(null, "Fecha de Deposito");

        for (int i = 0; i < clnt.length; i++) {

            if (cliente.contains(clnt[i].getNoClientes())) {
                System.out.println("******************************");
                System.out.println("*  MOVIMIENTO DE DEPOSITO DE " + fecha);
                System.out.println("******************************");
                System.out.println("Nombre :" + clnt[i].getNombre());
                System.out.println("Saldo actual: " + clnt[i].getSaldo());
                deposito = Integer.parseInt(JOptionPane.showInputDialog(null, "Insertar cantidad a depositar"));
                saldo = clnt[i].getSaldo() + deposito; //toma el saldo actual y le suma el deposito
                clnt[i].setSaldo(saldo); // afecta al saldo, poniendo el total de la suma

                System.out.println("A depositado: " + deposito);
                System.out.println("Su saldo a la fecha: " + clnt[i].getSaldo());

                break;
            }
        }
        // Guarda en la clase depositos todas las variables
        dep[pDepositos] = new Depositos();
        dep[pDepositos].setNoCliente(cliente);
        dep[pDepositos].setFecha(fecha);
        dep[pDepositos].setCantidadDeposito(deposito);
        pDepositos++;

    }

    static void Retirar() {

        cliente = JOptionPane.showInputDialog(null, "Número de Cliente");
        fecha = JOptionPane.showInputDialog(null, "Fecha de retiro");

        for (int i = 0; i < clnt.length; i++) {

            if (cliente.contains(clnt[i].getNoClientes())) {
                System.out.println("******************************");
                System.out.println("*  MOVIMIENTO DE RETIRO DE " + fecha);
                System.out.println("******************************");
                System.out.println("Nombre :" + clnt[i].getNombre());
                System.out.println("Saldo actual: " + clnt[i].getSaldo());
                retiro = Double.parseDouble(JOptionPane.showInputDialog(null, "Insertar cantidad a retirar"));
                saldo = clnt[i].getSaldo() - retiro; //toma el saldo actual y le resta el deposito
                clnt[i].setSaldo(saldo); // afecta al saldo, poniendo el total de la suma

                System.out.println("A depositado: " + retiro);
                System.out.println("Su saldo a la fecha: " + clnt[i].getSaldo());

                break;
            }
        }

        // Guarda en la clase retiros ls variables
        ret[pRetirar] = new Retirar();
        ret[pRetirar].setFecha(fecha);
        ret[pRetirar].setCantidadRetiro(retiro);
        pRetirar++;

    }

    static void VerSaldo() {
        cliente = JOptionPane.showInputDialog(null, "No. de clientes");
        for (int i = 0; i < clnt.length; i++) {
            if (cliente.contains(clnt[i].getNoClientes())) {
                System.out.println("******************************");
                System.out.println("*  VER SALDO  *");
                System.out.println("******************************");
                System.out.println("Numero clientes " + clnt[i].getNoClientes());
                System.out.println("Nombre :" + clnt[i].getNombre());
                System.out.println("Saldo :" + clnt[i].getSaldo());
                break;
            }
        }
    }

    static void VerDepositados() {

        cliente = JOptionPane.showInputDialog(null, "No. de Cliente");
        for (int i = 0; i < clnt.length; i++) {
            if (cliente.contains(clnt[i].getNoClientes())) {

                System.out.println("****************************************************");
                System.out.println("No. Cliente: " + clnt[i].getNoClientes() + "Nombre: " + clnt[i].getNombre());
                System.out.println("****************************************************");
                System.out.println("FECHA           CANTIDAD DEPOSITADA");
                break;
            }
        }
        for (int i = 0; i < dep.length; i++) {
            if (dep[i] == null) {
                break;
            } else {
                if (cliente.contains(dep[i].getNoCliente())) {
                    System.out.println(dep[i].getFecha() + "    " + dep[i].getCantidadDeposito());
                }
            }
        }
    }

    static void VerRetirados() {

        cliente = JOptionPane.showInputDialog(null, "No. de Cliente");
        for (int i = 0; i < clnt.length; i++) {
            if (cliente.contains(clnt[i].getNoClientes())) {

                System.out.println("****************************************************");
                System.out.println("No. Cliente: " + clnt[i].getNoClientes() + "Nombre: " + clnt[i].getNombre());
                System.out.println("****************************************************");
                System.out.println("FECHA           CANTIDAD RETIRADA");
                break;
            }
        }
        for (int i = 0; i < ret.length; i++) {
            if (ret[i] == null) {
                break;
            } else {
                if (cliente.contains(clnt[i].getNoClientes())) {
                    System.out.println(ret[i].getFecha() + "    " + ret[i].getCantidadRetiro());
                }
            }
        }
    }
    
}
