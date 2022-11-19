import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        /**
         * Se declaran los objetos como los arrays
         */

        
        Scanner optionsReader = new Scanner(System.in);
        perrera perrera = new perrera();

        ArrayList<familia> familias = new ArrayList<>();
        ArrayList<perro> perroo = new ArrayList<>();




        int opcion = 1;

        /**
         * Empieza el menú mostrando una pequeña introducción
         */

        System.out.println("FORMULARIO HOGAR PARA PERROS");


        for (int i = 0;i<3;i++) {
            familia newfamilia = familia.fset();
            familias.add(newfamilia); 
        }

        perro perroX = new perro();

        /**
         * Realizo mi ciclo para la asignación de los perros y para ingresar los datos del perro
         */
        while (opcion == 1){
            System.out.println("Ingrese la opción ");
            System.out.println("1.Perro ha llegado a la perrera");
            System.out.println("2.Asignar Perro");

            int decision = optionsReader.nextInt();

            switch(decision){



                case 1:
                    if(!perrera.perroAdoptar(perroo)) { 
                        perro nuevoPerro = perro.setNuevoPerro(optionsReader, perroX);
                        perroo.add(nuevoPerro);
                    }
                    break;





                case 2:
                    System.out.println("Proceso para asignar un perro a la familia");
                    if (perrera.existenciaPerros(perroo)){
                        if (perrera.sePuedeAdoptar(perroX,familias)){
                            System.out.println("Pueden adoptar");
                            
                            int indexNewCanFamily = perrera.getIndexarPerro(perroo.get(0),familias);
                            System.out.println("Familia que puede adoptar "+familias.get(indexNewCanFamily).getApellido());
                            System.out.println("El nuevo miembro de su  familia: ");
                            System.out.println("Nombre: "+perroo.get(0).getNombre());
                            System.out.println("Raza : "+perroo.get(0).getRaza());

                            familias.get(indexNewCanFamily).setMayores(familias.get(indexNewCanFamily).getMascotas()+1);
                            
                            
                            if (perrera.Disponible(familias.get(indexNewCanFamily))){
                                System.out.println("Los "+familias.get(indexNewCanFamily).getApellido()+" han adoptado correctamente a "+perroo.get(0).getNombre());
                                perroo.clear();



                                
                            } else {
                                System.out.println("Ya no se pueden adoptar más perros");
                                perroo.clear();
                            }



                        } else{
                            System.out.println("Ninguna familia ha podido adoptar a un perro");
                            System.out.println(perroo.size());
                            perroo.clear();
                            System.out.println(perroo.size());
                        }
                    }
                    break;



                default:
                    System.out.println("ADIÓS, ESPERAMOS QUE SEAN FELICES CON SU NUEVA MASCOTA");
                    decision++;
            }

        }
    }
    
}