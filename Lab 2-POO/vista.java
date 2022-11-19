import java.util.Scanner;

public class vista {

    controlador controlador = new controlador();
    modelo modelo = new modelo();
    Scanner sc = new Scanner(System.in);
    
    public vista(controlador c, modelo m){//constructor de la clase vista 
        this.controlador = c;
        this.modelo = m;
        programa();
    }

    public void programa(){ //funcion del menu 
        int menu = 1;
            System.out.println("De que tipo es su memoria:");
            System.out.println("1) SDR, 2) DDR");
            try {
                int memoria = sc.nextInt();
                if((memoria == 1)||(memoria == 2)){
                    if(memoria == 1){
                        modelo.setCiclo(1);
                    }else{
                        modelo.setCiclo(2);
                    }
                    System.out.println("Ingrese la ram que desea, unicamente el numero sin 'GB' ");
                    System.out.println("4GB, 8GB, 16GB, 32GB, 64GB");
                    int ram = sc.nextInt();
                    if((ram == 4)||(ram == 8)||(ram == 16)||(ram == 32)||(ram == 64)){
                        modelo.setCatnidadRam(ram);
                        modelo.setEspaciosTotales((ram*1024)/64);
                        while(menu != 0){
                            if(memoria == 2){
                                System.out.println("Seleccione la opcion 12 para que la ram aumente");
                            }
                            System.out.println("0) Salir\n1) Ingresar Programas, con los cuales inicia la memoria RAM.\n"+
                            "2) Ingresar cola memoria RAM\n"+
                            "3) Saber la cantidad de memoria RAM total\n"+
                            "4) Saber la cantidad de memoria RAM disponible.\n"+
                            "5) Saber la cantidad de memoria RAM en uso.\n"+
                            "6) Saber los programas en ejecución.\n"+
                            "7) Saber los programas en cola.\n"+
                            "8) Saber los espacios que ocupan un programa.\n"+
                            "9) Visualizar los ciclos de reloj, actualizaciones.\n"+
                            "10) Determinar los programas que pueden ser ingresados a la RAM de la lista de en cola.\n"+
                            "11) Finalizar programas según su tiempo de ejecución.\n");
                            if(memoria == 2){
                                System.out.println("12) Determinar si la memoria necesita aumentar o disminuir.");
                            }
                            menu = sc.nextInt();
                            if(menu == 1){
                                System.out.println("Ingrese el nombre del programa a ingresar: ");
                                String nombre = sc.nextLine();
                                System.out.println("Ingresar el tamaño del programa: ");
                                int tamanio = sc.nextInt();
                                System.out.println("Ingrese el tiempo de uso");
                                int tiempo = sc.nextInt();
                                if((Math.ceil((controlador.totalProgramas()+tamanio)/64)) <= modelo.getEspaciosTotales()){
                                    controlador.agregarRam(nombre, tamanio, tiempo);
                                    System.out.println("\n Se ingreso al ram. \n");
                                }else{
                                    controlador.moverEspera(nombre, tamanio, tiempo);
                                    System.out.println("\n Se ingreso a la cola.");                                    
                                }
                            }
                            if(menu == 2){
                                System.out.println("Ingrese el nombre del programa a ingresar: ");
                                String nombre = sc.nextLine();
                                System.out.println("Ingresar el tamaño del programa: ");
                                int tamanio = sc.nextInt();
                                System.out.println("Ingrese el tiempo de uso");
                                int tiempo = sc.nextInt();
                                controlador.moverEspera(nombre, tamanio, tiempo);
                                System.out.println("\n Se ingreso a la cola.");
                            }
                            if(menu == 3){
                                System.out.println("La memoria Ram total es de: "+modelo.getCatnidadRam()+" GB");
                            }
                            if(menu == 4){
                                System.out.println("La memoria Ram disponible es de: "+controlador.ramDisponible()+"MB");
                            }
                            if(menu == 5){
                                System.out.println("La memoria Ram es uso es de: "+controlador.totalProgramas());
                            }
                            if(menu == 6){
                                System.out.println("Los programas en funcionamiento son: ");
                                System.out.println(controlador.programasenRAM());
                            }
                            if(menu == 7){
                                System.out.println("Los programas en Espera son: ");
                                System.out.println(controlador.progrmasCola());
                            }
                            if(menu == 8){
                                System.out.println("Los programas ocupan: ");
                                System.out.println(controlador.espacioOcupado());
                            }
                            if(menu == 9){
                                System.out.println("Mostrando Ciclo");
                                System.out.println(controlador.posicionCero());//tiempo inicial 
                                if(memoria == 1){
                                    System.out.println(controlador.Ciclo());
                                }else{
                                    System.out.println("\n"+controlador.Ciclo());
                                }
                                
                            }
                            if(menu == 10){
                                System.out.println(controlador.revisarProgramas());
                            }
                            if(menu == 11){
                                try{
                                System.out.println(controlador.finalizarPrimeraTarea());
                                }catch(Exception e){
                                    System.err.println("No hay datos para finalizar");
                                }    
                            }
                            if(menu == 12){
                                String mensaje = controlador.cambioRam();
                                if(mensaje == ""){
                                    System.out.println("La ram no se vio modificada");
                                }else{
                                    System.out.println("La ram se modifico: "+mensaje);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) { // si el usuario ingresa un dato no aceptado, va a imprimir lo siguiente
                System.out.println("Ingrese correctamente los datos");
            }
    }
}
