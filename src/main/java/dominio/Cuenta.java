
package dominio;

/*
 * @Grupo5 
 */
public class Cuenta {
    private int nroCuenta;
    private double saldoCuenta;

    public Cuenta(int nroCuenta, double saldoCuenta) {
        this.nroCuenta = nroCuenta;
        this.saldoCuenta = saldoCuenta;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }
    
    public void depositar(double cantidad){
        saldoCuenta+=cantidad;
    }
    
    public void retirar(double cantidad){
        saldoCuenta-=cantidad;
    }
}
