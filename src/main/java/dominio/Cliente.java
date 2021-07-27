
package dominio;

/*
 * @Grupo5 
 */
public class Cliente {
    private String cedula;
    private String nombre;
    Cuenta cuentas[];

    public Cliente(String cedula, String nombre, Cuenta[] cuentas) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.cuentas = cuentas;
    }
//
    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void ingresarDinero(int nroCuenta, double cantidad){
        cuentas[nroCuenta].depositar(cantidad);
    }
    
    public void retirarDinero(int nroCuenta, double cantidad){
        cuentas[nroCuenta].retirar(cantidad);
    }
    
    public double consultarSaldo(int nroCuenta){
        return cuentas[nroCuenta].getSaldoCuenta();
    }
}
