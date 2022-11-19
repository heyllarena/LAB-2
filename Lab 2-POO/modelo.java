/*
 * @author Fernando Enrique Echeverria Leal, 22610
 * @date 20/09/2022
 * @Universidad del Valle de Guatemala
 * @Programación Orientada a objetos
  */
import java.util.ArrayList;

public class modelo {
    ArrayList<String> ram = new ArrayList<>();
    ArrayList<String> espera = new ArrayList<>();
    int catnidadRam;
    int ciclo;
    int espaciosTotales;
    public int getCiclo() {
        return ciclo;
    }
    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }
    public ArrayList<String> getRam() {
        return ram;
    }
    public void setRam(ArrayList<String> ram) {
        this.ram = ram;
    }
    public ArrayList<String> getEspera() {
        return espera;
    }
    public void setEspera(ArrayList<String> espera) {
        this.espera = espera;
    }
    public int getCatnidadRam() {
        return catnidadRam;
    }
    public void setCatnidadRam(int catnidadRam) {
        this.catnidadRam = catnidadRam;
    }
    public int getEspaciosTotales() {
        return espaciosTotales;
    }
    public void setEspaciosTotales(int espaciosTotales) {
        this.espaciosTotales = espaciosTotales;
    }
}
