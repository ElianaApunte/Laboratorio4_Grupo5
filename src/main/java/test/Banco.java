
package test;

import dominio.Cliente;
import dominio.Cuenta;
import java.util.Scanner;

/*
 * @Grupo5
 */
public class Banco {
    public static int indice(Cuenta cuentas[], int n){
        int i=0, indice=0;
        boolean bandera = false;
        
        while((i<cuentas.length)&&(bandera==false)){
            if(cuentas[i].getNroCuenta()==n){
                bandera=true;
                indice=i;
            }
            i++;
        }
        if(bandera==false){
            indice=-1;
        }
        return indice;
    }
    public static void ingresarCuentas(Cuenta [] c){
            Scanner entrada = new Scanner(System.in);
            int nrcuenta;
            double saldo;
            for(int i=0;i<c.length;i++){
                System.out.println("Datos de la primera cuenta. "+(i+1));
                System.out.println("Numero de cuenta: ");
                nrcuenta = entrada.nextInt();
                System.out.println("Saldo de la cuenta: ");
                saldo = entrada.nextDouble();
                c[i] = new Cuenta(nrcuenta, saldo);
            }
        }
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        String cedula, nombres;
        int op, NumCuentas, indice = 0, NumCuen;
        double dinero;
        Cliente client;
        Cuenta cuentas[];
        
        System.out.println("para registrar un cliente primero digite el numero de cédula y despues el nombre");
        System.out.println("Ingrese el numero de cédula: ");
        cedula = entrada.nextLine();
        System.out.println("Ingrese el nombre del cliente: ");
        nombres = entrada.nextLine();
        System.out.println("Digite el numero de cuentas que desea asignar al cliente");
        NumCuentas = entrada.nextInt();
        
        cuentas = new Cuenta[NumCuentas];
        ingresarCuentas(cuentas);
        client = new Cliente(cedula, nombres, cuentas);
        
        
        do{
            System.out.println("1. Depositar\n2. Retirar\n3. Consultar Saldo\n4. Salir");
            System.out.println("Digite una opción: ");
            op = entrada.nextInt();
            
            
            switch(op){
                
                
                case 1:
                    System.out.println("Ingrese número de la cuenta donde desea depositar: ");
                    NumCuen = entrada.nextInt();
                    indice = indice(cuentas, NumCuen);
                    if(indice<0){
                        System.out.println("Número de cuenta no encontrado.");
                    }
                    else{
                        System.out.println("Ingrese la cantidad que desea depositar: ");
                        dinero = entrada.nextDouble();
                        client.ingresarDinero(indice, dinero);
                        System.out.println("El saldo de la cuenta es el siguiente: "+client.consultarSaldo(indice));
                    } 
                    break;
                    
                    
                case 2:
                    System.out.println("Ingrese número de la cuenta de donde desea retirar: ");
                    NumCuen = entrada.nextInt();
                    indice=indice(cuentas,NumCuen);
                    if(indice<0){
                        System.out.println("Número de cuenta no encontrado.");
                    }
                    else{
                        System.out.println("Ingrese la cantidad de dinero que desea retirar: ");
                        dinero = entrada.nextDouble();
                        if(dinero>client.consultarSaldo(indice)){
                            System.out.println("No tiene esa cantidad de dinero.");
                        }
                        else{
                            client.retirarDinero(indice, dinero);
                            System.out.println("El saldo de la cuenta es el siguiente: "+client.consultarSaldo(indice));
                        }
                    }
                    break;
                    
                    
                case 3:
                    System.out.println("Ingrese número de cuenta que desea consultar: ");
                    NumCuen = entrada.nextInt();
                    indice=indice(cuentas,NumCuen);
                    if(indice<0){
                        System.out.println("Número de cuenta no encontrado.");
                    }
                    else{
                        System.out.println("El saldo de la cuenta es el siguiente: "+client.consultarSaldo(indice));
                    }
                    break;
                    
                case 4: break;
                default: System.out.println("Error, no existe esa opción de menú.");
            }
            }while(op!=4);
    }
}
