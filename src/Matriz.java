public class Matriz {

    private String nombre;
    private double[][] matriz;

    public Matriz(String nombre, double[][] matriz){
        this.nombre = nombre;
        this.matriz = matriz;
    }

    public Matriz(){
        this.nombre = "";
        this.matriz = null;
    }

    public void setNombre(String nomb){
        this.nombre = nomb;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setMatriz(double[][] arreglo){
        this.matriz = arreglo;
    }

    public double [][] getMatriz(){
        return this.matriz;
    }

}
