import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class perro {
/**
 Se declaran atributos.
 */
    public String nombre; 
    public String raza; 
    public String tamano;
    public int edad;
    public int salud;
    public String color;

    public static String[] tamPerro = {"Pequeño","Mediano","Grande"};
    public static String[] razasPeligrosas = {"Pit bull terrier","American Staffordshire terrier", "Tosa Inu",
            "Dogo argentino","Dogo Guatemalteco","Fila brasileño","Presa canario","Dóberman","Gran perro japonés"
    ,"Mastín napolitano","Presa Mallorqui","Dogo de burdeos","Bullmastiff","Bull terrier inglés","Bulldog americano","Rhodesiano","Rottweiler "};





/**
    Se da un valor inicial en el constructor
 */

        public perro() {
            nombre="";
            raza ="";
            tamano = "";
            edad = 0;
            salud= 0;
            color = "";
        }

/**
 * Se crea un constructor específico para perro
 */
    public static perro setNuevoPerro(Scanner reader,perro perroX){
        /**
        * Se pide la información del perro
        */
        reader.nextLine();
        System.out.println("Ingresar el nombre del perro: ");
        perroX.setNombre(reader.nextLine());

        System.out.println("Ingresar edad del perro");
        perroX.setEdad(reader.nextInt());


        System.out.println("Ingresar salud del perro");
        perroX.setSalud(reader.nextInt());

        System.out.println("Razas de los perros: ");
         /**
        * Búsqueda de razas peligrosas
        */
        for(int i = 0;i<razasPeligrosas.length;i++){
            System.out.println((i+1)+". "+razasPeligrosas[i]);
        }
        System.out.println("Ingresar la raza del perro:");
        int indexRaza = reader.nextInt()-1;
        perroX.setRaza(razasPeligrosas[indexRaza]);
        System.out.println("Raza que se ha escogido :"+perroX.getRaza()+"\n");

        for (int i = 0;i<tamPerro.length;i++){
            System.out.println("Seleccione el tamaño de perro: \n");
            System.out.println((i+1)+". "+tamPerro[i]);
        }
        int tamanoIndex = reader.nextInt();
        perroX.setTamano(tamPerro[tamanoIndex-1]);
        System.out.println("Tamaño designado : "+perroX.getTamano());
        return perroX;
    }



 /**
* Se realizan los set y get de las listas como de los atributos
*/

    public String[] getRazasPeligrosas() {return razasPeligrosas;}
    public void setRazasPeligrosas(String[] razasPeligrosas) {perro.razasPeligrosas = razasPeligrosas;}

    public String getTamano() {
        return tamano;
    }
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor(){
        return color;
    }

   
    public void setColor(perro perro){
        perro.color = color;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getEdad() {
        return edad;
    }

    public void setEdad(int  edad) {
        this.edad = edad;
    }

    public double getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }
}