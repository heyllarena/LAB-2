import java.util.ArrayList;
import java.util.List;
public class perrera {
        /**
    * Verificar si está disponible el proceso para adoptar o no
    */

    public boolean perroAdoptar(ArrayList perroo) {
        if (perroo.size() > 0) {
            System.out.println("Hay perros para adoptar");
            return true;
        } else if (perroo.size() <= 0) {
            System.out.println("Ingrese la información del perro");
            return false;
        }
        return false;
    }

        /**
        * Se declara un método para ver si hay o no perros
        */
    public boolean existenciaPerros(ArrayList perroo) {
        if (perroo.size() == 0) {
            System.out.println("No hay perros aún");
            return false;
        } else if (perroo.size() > 0) {
            System.out.println("Buscano un perro ideal");
            return true;
        }
        return false;
    }



        /**
        * Se realizan las condiciones para ver si una familia segun sus integrantes puede adoptar cierto perro o no
        */

    public boolean sePuedeAdoptar(perro perro, ArrayList<familia> familias) {
        List<String> rpeligrosas = List.of(perro.getRazasPeligrosas()); 
        for (int i = 0; i < familias.size(); i++) {
            if (familias.get(i).getMenores() > 0 & perro.getTamano().equals("Pequeño")) {
                for (int razaplg = 0; i < rpeligrosas.size(); i++) {
                    if (perro.getRaza().equals(rpeligrosas.get(razaplg + 1))) {
                        System.out.println("Raza peligrosa encontrda: " + perro.getRaza());
                        System.out.println("No se puede adoptar debido a que es una raza peligrosa\n");
                        return false;
                    }
                }
                return true;
            }
        /**
         * Se realizan las condiciones para ver si una familia puede adoptar según el tamaño del perro
        */
            
            if ((familias.get(i).getMayores() > 0) & (familias.get(i).getMenores() == 0)) {
                
                if ((perro.getTamano().equals("Pequeño") || (perro.getTamano().equals("Mediano")))) {
                    for (int raza = 0; i < rpeligrosas.size(); i++) {
                        if (perro.getRaza().equals(rpeligrosas.get(raza + 1))) {
                            System.out.println("Raza peligrosa encontrada: " + perro.getRaza());
                            System.out.println("No se puede adoptar debido a que es una raza peligrosa\n");
                            return false;
                        }
                    }
                    return true;
                }
            }
        /**
        * Si la familia no hay menores entonces no hay restricciones
        */
            if ((familias.get(i).getMenores() == 0) & (familias.get(i).getMayores() == 0)) {
                return true;
            }
        }
        return false;
    }

        /**
        * Se agrega o indexa el perro a la familia
        */

    public int getIndexarPerro(perro perro, ArrayList<familia> familias) {
        for (int i = 0; i < familias.size(); i++) {
            if (familias.get(i).getMenores() > 0 & perro.getTamano().equals("Pequeño")) {
                return familias.indexOf(familias.get(i));
            }
            if ((familias.get(i).getMayores() > 0) & (familias.get(i).getMenores() == 0)) {

                if ((perro.getTamano().equals("Pequeño") || (perro.getTamano().equals("Mediano")))) {
                    return familias.indexOf(familias.get(i));
                }
            }
            if ((familias.get(i).getMenores() == 0) & (familias.get(i).getMayores() == 0)) {
                return familias.indexOf(familias.get(i));

            }
        }
        return 0;
    }

        /**
        * Acá se filtra para que no puedan adoptar más de cuatro perros
        */
    public boolean Disponible(familia familia){
        if (familia.mascotas<=4){
            System.out.println("Pueden adoptar al perro");
            return true;
        }
        return false;
    }
}