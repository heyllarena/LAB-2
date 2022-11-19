import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class familia {
    /**
    * Se declaran atributos de la clase familia
    */
    public familia() {}
    public String apellido;
    public int integrantes;
    public int menores;
    public int mayores;
    public int mascotas;
    

    


    /**
    * Se realiza el constructor
    */

    public familia(String apellido, int integrantes, int menores, int mayores,int mascotas) {
        this.apellido = apellido;
        this.integrantes = integrantes;
        this.menores = menores;
        this.mayores = mayores;
        mascotas =0;
    }

    /**
    * Se realiza el constructor específico para familia
    */
    public static familia fset() {
        familia f = new familia(); 

        Scanner inputReader = new Scanner(System.in);
        System.out.println("Apellido de la familia");
        f.setApellido(inputReader.nextLine());

        /**
        * Se realiza la programación defensiva para que la persona no pueda ingresar 0 miembros o menos de 0
        */

        int respuesta = 1;
        while (respuesta == 1) {
            int fintegrantes = 0;
            System.out.println("Ingresar número de miembros de la familia: "+f.getApellido());
            f.setMiembros(inputReader.nextInt());
            fintegrantes = f.getIntegrantes();
            if (f.getIntegrantes() <= 0) {
                System.out.println("Ingresar una cantidad válida");
            } else {
                System.out.println("Ingrese la cantidad de personas menores a 10 años");
                f.setMenores(inputReader.nextInt());
                if (f.getMenores() < 0 || f.getMenores() > fintegrantes) {
                    System.out.println("Debe ingresar una cantidad valida ");
                } else {
                    fintegrantes = fintegrantes - f.getMenores();
                    System.out.println("Ingrese la cantidad de personas grandes");
                    f.setMayores(inputReader.nextInt());
                    if (f.getMayores() < 0 || f.getMayores() > fintegrantes) {
                        System.out.println("Debe ingresar una cantidad válida ");
                    } else {
                        
                        respuesta++;

                    }



                }


            }


        }

    return f;

    }
    /**
    * Se realizan los set y get de los atributos
    */
    public String getApellido() {

        return apellido;
    }

    public void setApellido(String apellido) {

        this.apellido = apellido;
    }

    public int getIntegrantes() {

        return integrantes;
    }

    public void setMiembros(int integrantes) {

        this.integrantes = integrantes;
    }

    public int getMenores() {

        return menores;
    }

    public void setMenores(int menores) {

        this.menores = menores;
    }

    public int getMayores() {

        return mayores;
    }

    public void setMayores(int mayores) {
        this.mayores = mayores;
    }

    public int getMascotas() {
        return mascotas;
    }
    public void setMascotas(int mascotas) {
        this.mascotas = mascotas;
    }


}














