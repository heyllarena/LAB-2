public class main{
    /**
     * @param args la clase main es para ejecutar el simulador del sistema ram
     */
    public static void main(final String[] args) {
        modelo m = new modelo();
        controlador c = new controlador(m);
        vista v = new vista(c, m);
    }
}