import java.util.ArrayList;

public class controlador {
    
    modelo m = new modelo();

    public controlador(modelo m){// constructor con parametros del controlador
        this.m = m;
    }

    public controlador(){//constructor vacío

    }

    
  
    public String revisarProgramas(){
        String mensaje = "";
        ArrayList<Integer> aceptados = new ArrayList<>();
        for(int i =0; i<m.getRam().size();i++){
            String[] programa = m.getRam().get(i).split(",");
            if(((int) Math.ceil((Integer.parseInt(programa[1]))+totalProgramas())) <= m.getEspaciosTotales()){
                aceptados.add(i);
                mensaje+=programa[0]+"\n";
                m.getRam().add(m.getEspera().get(i));
            }
        }
        for(int i = 0; i<aceptados.size();i++){
            int index = aceptados.get(i);
            m.getEspera().remove(index);
        }
        if(mensaje != ""){
            mensaje = "Los Progra que fueron traslados a la ram son:\n"+mensaje;
        }else{
            mensaje = "La memoria ram esta completa";
        }
        return mensaje;
    }

    
   
    public String cambioRam(){
        String programa = "";
            int cantidad = 0;
            for(int i=0;i<m.getEspera().size();i++){
                String[] p = m.getEspera().get(i).split(",");
                cantidad+= Integer.parseInt(p[1]);
            }

            boolean flag = true;
            while(flag){
                if(m.getCatnidadRam() != 64){
                    if(Math.ceil(cantidad/64) <= m.getEspaciosTotales()){
                        int tempRam;
                        int tempEsapcios;
                        boolean finalizar = false;
                        while(!finalizar){
                            if(m.getCatnidadRam() != 4){
                                if(m.getCatnidadRam() <= 16){
                                    tempRam = m.getCatnidadRam()-4;
                                    tempEsapcios = (tempRam*1024)/64;
                                }else{
                                    tempRam = m.getCatnidadRam()/2;
                                    tempEsapcios = (tempRam*1024)/64;
                                }
                                if(Math.ceil(cantidad/64) <= tempEsapcios){
                                    m.setCatnidadRam((tempRam));
                                    m.setEspaciosTotales(tempEsapcios);
                                    programa = "bajo a: "+m.getCatnidadRam()+"GB";
                                }else{
                                    finalizar = false;
                                }
                            }else{
                                finalizar = false;
                            }
                        }
                        flag = false;
                    }else{
                        if(m.getCatnidadRam() < 16){
                            m.setCatnidadRam(m.getCatnidadRam()+4);
                            m.setEspaciosTotales((m.getCatnidadRam()*1024)/64);
                        }else{
                            m.setCatnidadRam(m.getCatnidadRam()*2);
                            m.setEspaciosTotales((m.getCatnidadRam()*1024)/64);
                        }
                        programa = "aumento a: "+m.getRam()+" GB"; 
                    }   
                }else{
                    int tempRam;
                    int tempEsapcios;
                    boolean finalizar = false;
                    while(!finalizar){
                        if(m.getCatnidadRam() != 4){
                            if(m.getCatnidadRam() <= 16){
                                tempRam = m.getCatnidadRam()-4;
                                tempEsapcios = (tempRam*1024)/64;
                            }else{
                                tempRam = m.getCatnidadRam()/2;
                                tempEsapcios = (tempRam*1024)/64;
                            }
                            if(Math.ceil(cantidad/64) <= tempEsapcios){
                                m.setCatnidadRam((tempRam));
                                m.setEspaciosTotales(tempEsapcios);
                                programa = "bajo a: "+m.getCatnidadRam()+"GB";
                            }else{
                                finalizar = false;
                            }
                        }else{
                            finalizar = false;
                        }
                    }
                }
            } 
        return programa;
    }

    
  
    public String finalizarPrimeraTarea() throws NumberFormatException, InterruptedException{
        String finalizar = "";
        String[] programa = m.getRam().get(0).split(",");
        Thread.sleep(Integer.parseInt(programa[2]+"000"));
        finalizar= "Se finalizo el programa: "+programa[0];
        m.getRam().remove(0);
        return finalizar;
    }

   
    public String posicionCero(){
        String programa = "";
        String[] p = m.getRam().get(0).split(",");
        programa = p[0]+", tiempo incial: "+p[2]+"s";
        return programa;
    }

    public String Ciclo() throws InterruptedException{
        String Ciclo = "";
        String[] tarea = m.getRam().get(0).split(",");// lo convierte en arreglo
        tarea[2] = String.valueOf(Integer.parseInt(tarea[2]) - m.getCiclo());// lo pasa a int y le resta el ciclo
        if((Integer.parseInt(tarea[2])-m.getCiclo()) <= 0){// si es menor a cero que finalice el programa ya que no hay tiempo negativo
            Ciclo+=tarea[0]+", tiempo despues del ciclo: "+tarea[2]+"s"+"\n Se Finalizo";
            m.getRam().remove(0);
        } else{
            m.getRam().set(0, tarea[0]+","+tarea[1]+","+tarea[2]);
            Ciclo+=tarea[0]+", tiempo despues del ciclo: "+tarea[2]+"s";
        }
        Thread.sleep(1000);
        return Ciclo;
    }

    
    public int ramDisponible(){
        int cantidad = 0;
        for (int i = 0; i < m.getRam().size(); i++) {
            String[] tarea = m.getRam().get(i).split(",");
            cantidad+= Integer.parseInt(tarea[1]);
        }
        int tamanio = m.getCatnidadRam()*1000;
        cantidad = tamanio - cantidad;
        return cantidad;
    }

    
   
    public String espacioOcupado(){
        String programas = "Programas de la memoria: \n";
        for (int i = 0; i < m.getRam().size(); i++) {
            String[] programaActual = m.getRam().get(i).split(",");
            programas+= programaActual[0]+", ocupa: "+programaActual[1]+"\n";
        }
        programas+= "Programas de la Cola: \n";
        for (int i = 0; i < m.getEspera().size(); i++) {
            String[] programaActual = m.getEspera().get(i).split(",");
            programas+= programaActual[0]+", ocupa: "+programaActual[1]+"\n";
        }
        return programas; 
    }

    
    
    public String espacioProgramas(){
        String programas = "Programas de la memoria: \n";
        for (int i = 0; i < m.getRam().size(); i++) {
            String[] tarea = m.getRam().get(i).split(",");
            programas+= tarea[0]+", ocupa: "+tarea[1]+"\n";
        }
        programas+= "Programas de la Cola: \n";
        for (int i = 0; i < m.getEspera().size(); i++) {
            String[] tarea = m.getEspera().get(i).split(",");
            programas+= tarea[0]+", ocupa: "+tarea[1]+"\n";
        }
        return programas; 
    }

    
   
    public String programasenRAM(){
        String programas = "";
        for (int i = 0; i < m.getRam().size(); i++) {
            String[] tarea = m.getRam().get(i).split(",");
            programas+= tarea[0]+"\n";
        }
        return programas;
    }

    
    
    public String progrmasCola(){
        String programas = "";
        for (int i = 0; i < m.getEspera().size(); i++) {
            String[] tarea = m.getEspera().get(i).split(",");
            programas+= tarea[0]+"\n";
        }
        return programas;
    }

    
    
    public void agregarRam(String nombre, int tamanio, int tiempo){
        ArrayList<String> memoria = m.getRam();
        memoria.add(nombre+","+tamanio+","+tiempo);
        m.setRam(memoria);
    }

    

    public int totalProgramas(){
        int cantidad = 0;
        for (int i = 0; i < m.getRam().size(); i++) {
            String[] tarea = m.getRam().get(i).split(",");
            cantidad+= Integer.parseInt(tarea[1]);
        }
        return cantidad;
    }

    
   
    public void moverEspera(String nombre, int tamanio, int tiempo){
        ArrayList<String> cola = m.getEspera();
        cola.add(nombre+","+tamanio+","+tiempo);
        m.setEspera(cola);
    }

}
