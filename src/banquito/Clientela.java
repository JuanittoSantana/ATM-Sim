package banquito;

public class Clientela {
    
    private String NoClientes;
    private String Nombre;
    private double Saldo;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    public String getNoClientes() {
        return NoClientes;
    }

    public void setNoClientes(String NoClientes) {
        this.NoClientes = NoClientes;
    }
}
