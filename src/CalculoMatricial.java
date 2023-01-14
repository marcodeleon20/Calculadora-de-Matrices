import java.io.*;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class CalculoMatricial {
    //Variables
    public static Scanner entrada=new Scanner(System.in);
    public static Matriz[] matriz = new Matriz[26];
    static String[] indice;
    //Matrices temporales
    //Variable globales para reportes
    public static String letraMatriz;
    public static String letraMatrizSuma1;
    public static String letraMatrizSuma2;
    public static String letraMatrizResta1;
    public static String letraMatrizResta2;
    public static String letraMatrizDivision1;
    public static String letraMatrizDivision2;
    public static String letraMatrizInversa;
    public static String letraMatrizPotencia;
    public static String letraMatrizDeterminante;
    public static double matrizProductoPorUnNumero;
    public static double matrizNumeroPotencia;
    public static double matrizDeterminante;
    public static String letraMatrizProducto1;
    public static String letraMatrizProducto2;
    public static String letraMatrizProductoPorUnNumero;
    public static double[][] matrizOriginal;
    public static double[][] matrizOriginalSuma1;
    public static double[][] matrizOriginalSuma2;
    public static double[][] matrizOriginalResta1;
    public static double[][] matrizOriginalResta2;
    public static double[][] matrizOriginalInversa;
    public static double[][] matrizOriginalProductoPorUnNumero;
    public static double[][] matrizOriginalProducto1;
    public static double[][] matrizOriginalProducto2;
    public static double[][] matrizOriginalDivision1;
    public static double[][] matrizInversaDivision;
    public static double[][] matrizOriginalDivision2;
    public static double[][] matrizOriginalDeterminante;
    public static double[][] matrizOriginalPotencia;
    public static double[][] matrizSumaR;
    public static double[][] matrizRestaR;
    public static double[][] matrizProductoR;
    public static double[][] matrizTransR;
    public static double[][] matrizInversaR;
    public static double[][] matrizProductoPorUnNumeroR;
    public static double[][] matrizPotenciaR;
    public static double[][] matrizDivisionR;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner s = new Scanner(System.in, "ISO-8859-1");
        int opcion = 0;
        do {
            try {

                System.out.println("*****************BIENVENIDO A LA PRACTICA 1*********************");
                System.out.println("Escoja una de las siguientes opciones en orden");
                System.out.println("Opcion 1: Carga de las Matrices");
                System.out.println("Opcion 2: Sumar Matrices");
                System.out.println("Opcion 3: Restar Matrices");
                System.out.println("Opcion 4: Multiplicar Matrices");
                System.out.println("Opcion 5: Dividir Matrices");
                System.out.println("Opcion 6: Transpuesta de una Matriz");
                System.out.println("Opcion 7: Matriz Inversa");
                System.out.println("Opcion 8: Potencia de una Matriz");
                System.out.println("Opcion 9: Determinante de una Matriz");
                System.out.println("Opcion 10: Mostrar matriz R");
                System.out.println("Opcion 11: Generar Reportes");
                System.out.println("Opcion 12: Salir                   ");
                System.out.print("Elija una opción del menú: ");
                opcion = s.nextInt();

                switch (opcion) {
                    case 1:
                        cargarArchivo();
                        break;
                    case 2:
                        sumaDeMatriceds();
                        break;
                    case 3:
                        restaDeMatriceds();
                        break;
                    case 4:
                          multiplicarMatrices();
                        break;
                    case 5:
                        dividirMatrices();
                        break;
                    case 6:
                        transpuestadeMatriz();
                        break;
                    case 7:
                        inversaDeUnaMatriz();
                        break;
                    case 8:
                        potenciaMatriz();
                        break;
                    case 9:
                        determinanteMatriz();
                        break;
                    case 10:
                        mostrarMatrizR();
                        break;
                    case 11:
                        menuReportes();
                        break;
                    case 12:
                        System.out.println("\nGracias por utilizar el programa.");
                        break;
                    default:
                        System.out.println("\nLa opcion no es valida");

                }

            } catch (Exception e) {

                System.out.println("Opción no valida");
                s.nextLine();
            }

        } while (opcion != 12);
    }

    public static void menuReportes(){
        Scanner s = new Scanner(System.in, "ISO-8859-1");
        int opcion = 0;
        do {

            try {
                System.out.println("*****************GENERAR REPORTES*********************");
                System.out.println("Escoja una de las siguientes opciones en orden");
                System.out.println("Opcion 1: Reporte sumar matrices");
                System.out.println("Opcion 2: Reporte restar matrices");
                System.out.println("Opcion 3: Reporte multiplicar matriz por otra matriz");
                System.out.println("Opcion 4: Reporte multiplicar matriz por un numero");
                System.out.println("Opcion 5: Reporte dividir matrices");
                System.out.println("Opcion 6: Reporte tranpuesta de matriz");
                System.out.println("Opcion 7: Reporte inversa de una matriz");
                System.out.println("Opcion 8: Reporte potencia de una matriz");
                System.out.println("Opcion 9: Reporte determinante de una matriz");
                System.out.println("Opcion 10: Salir del menu");
                System.out.print("Elija una opción del menú: ");
                opcion = s.nextInt();

                switch (opcion) {
                    case 1:
                        reporteSuma();
                        break;
                    case 2:
                        reporteResta();
                        break;
                    case 3:
                        reporteMultiplicacionPorOtraMatriz();
                        break;
                    case 4:
                        reporteMultiplicacionPorUnNumero();
                        break;
                    case 5:
                        reporteDivision();
                        break;
                    case 6:
                        reporteMatrizTrans();
                        break;
                    case 7:
                        reporteMatrizInversa();
                        break;
                    case 8:
                        reporteMatrizPotencia();
                        break;
                    case 9:
                        reporteMatrizDeterminante();
                        break;
                    case 10:
                        System.out.println("\nGracias por utilizar el menú Reportes.");
                        break;

                    default:
                        System.out.println("\nLa opcion no es valida");

                }

            } catch (Exception e) {

                System.out.println("No se ha podido generar el reporte... :(");
                s.nextLine();
            }

        } while (opcion != 10);
    }

    public static void cargarArchivo() {
        Scanner sc = new Scanner(System.in);
        File archivo;
        FileReader fr = null;
        BufferedReader br;

        try {
            System.out.println("Ingrese la ruta del archivo :");
            String direccion = sc.nextLine();
            archivo = new File(direccion);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] numeros = linea.split("\n");

                for (int i = 0; i < numeros.length; i++) {

                    indice = numeros[i].split(":");

                    String nombreMatriz = indice[0].trim();

                    String matrizLinealizada = indice[1].trim();

                    String[] filas = matrizLinealizada.split(";");
                    int contColumnas = filas[0].split(",").length;

                    double[][] matrizAux = new double[filas.length][contColumnas];

                    for (int j = 0; j < filas.length; j++) {
                        filas[j].trim();
                        String[] columnas = filas[j].split(",");
                        for (int k = 0; k < columnas.length; k++) {
                            columnas[k].trim();
                            matrizAux[j][k] = Double.valueOf(columnas[k]);
                        }
                    }
                    //Crear un objeto  de tipo matriz que se almacene en el arreglo de matrices. Para acceder a su nombre y el arreglo se usan los get
                    Matriz aux = new Matriz(nombreMatriz, matrizAux);
                    MatrizValidacion.ordenarMatrices(aux);
                }

            }

            System.out.println("---------------------------------------------------------------------");
            System.out.println("Matrices disponibles");
            for (int i = 0; i < matriz.length; i++) {

                if (matriz[i] != null) {
                    System.out.println("\n uMATRIZ:" + matriz[i].getNombre());

                    for (int k = 0; k < matriz[i].getMatriz().length; k++) {
                        for (int l = 0; l < matriz[i].getMatriz()[k].length; l++) {
                            System.out.print("[" + matriz[i].getMatriz()[k][l] + "]" + "\t");
                        }
                        System.out.println("");
                    }
                }

            }

            System.out.println();

        } catch (Exception e) {
            System.out.println("Ocurrio el error: " + e.getMessage());
        } finally {

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static double[][] sumarMatrices(double[][] matriz1, double[][] matriz2) {

        double[][] primera = new double[matriz1.length][matriz1[0].length];
        double[][] segunda = new double[matriz2.length][matriz2[0].length];
        double[][] suma = new double[primera.length][primera[0].length];

        for (int i = 0; i < primera.length; i++) {
            for (int j = 0; j < primera[i].length; j++) {
                primera[i][j] = matriz1[i][j];
                segunda[i][j] = matriz2[i][j];
            }
        }

        for (int i = 0; i < primera.length; i++) {
            for (int j = 0; j < primera[i].length; j++) {
                suma[i][j] = primera[i][j] + segunda[i][j];
            }
        }
        return suma;
    }

    public static double[][] restarMatrices(double[][] matriz1, double[][] matriz2) {

        double[][] primera = new double[matriz1.length][matriz1[0].length];
        double[][] segunda = new double[matriz2.length][matriz2[0].length];
        double[][] suma = new double[primera.length][primera[0].length];

        for (int i = 0; i < primera.length; i++) {
            for (int j = 0; j < primera[i].length; j++) {
                primera[i][j] = matriz1[i][j];
                segunda[i][j] = matriz2[i][j];
            }
        }

        for (int i = 0; i < primera.length; i++) {
            for (int j = 0; j < primera[i].length; j++) {
                suma[i][j] = primera[i][j] - segunda[i][j];
            }
        }
        return suma;
    }

    public static double[][] multiplicarMatrices(double[][] matriz1, double[][] matriz2) {
        int filasMatrizProducto = matriz1.length;
        int columnasMatrizProducto = matriz2[0].length;
        double[][] matrizProducto = new double[filasMatrizProducto][columnasMatrizProducto];
        double[][] matrizProductoEntera = new double[matrizProducto.length][matrizProducto[0].length];

        for (int i = 0; i < matriz1.length; i++) {//filas arreglo1
            for (int j = 0; j < matriz2[i].length; j++) {//filas arreglo2
                double valor = 0;
                for (int k = 0; k < matriz2.length; k++) {//columnas arreglo2
                    valor += (matriz1[i][k] * matriz2[k][j]);
                }
                matrizProducto[i][j] = valor;
            }
        }

        for (int i = 0; i < matrizProductoEntera.length; i++) {
            for (int j = 0; j < matrizProductoEntera[i].length; j++) {
                matrizProductoEntera[i][j] = (int) Math.round(matrizProducto[i][j]);
            }
        }
        return matrizProductoEntera;
    }

    public static double[][] multiplicarMatrices2(double[][] matriz1, int numero) {
        int filaMatriz = matriz1.length;
        int columnaMatriz = matriz1[0].length;
        double multiplicar = numero;
        double[][] matrizProducto = new double[filaMatriz][columnaMatriz];
        double[][] matrizProductoEntera = new double[matrizProducto.length][matrizProducto[0].length];

        for (int i = 0; i < matriz1.length; i++) {//filas arreglo1
            for (int j = 0; j < matriz1[i].length; j++) {//filas arreglo2
                double valor = 0;
                valor += (matriz1[i][j] * numero);
                matrizProducto[i][j] = valor;
            }

        }

        for (int i = 0; i < matrizProductoEntera.length; i++) {
            for (int j = 0; j < matrizProductoEntera[i].length; j++) {
                matrizProductoEntera[i][j] = (int) Math.round(matrizProducto[i][j]);
            }
        }
        return matrizProductoEntera;

    }

    public static double[][] inversaMatriz(double[][] matriz) {
        double[][] arreglo = new double[matriz.length][matriz[0].length];
        double[][] inversa = new double[matriz.length][matriz[0].length];
        //Llenar el arreglo para trabajar el método Gauss-Jordan
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                arreglo[i][j] = (double) matriz[i][j];
                if (i == j) {
                    inversa[i][j] = 1;
                } else {
                    inversa[i][j] = 0;
                }
            }
        }

        //Intercambiar filas si el primer elemento de la primera fila es 0
        if (arreglo[0][0] == 0) {
            double valor = 0;
            int fila = 0;
            for (int i = 0; i < arreglo.length - 1; i++) {
                boolean cero = false;
                if (arreglo[i][0] == 0) {
                    cero = true;
                    fila = i;
                }
                // 0 1 2 3              1  7  9  0
                //                      4  5  7  9
                // 1 7 9 0              0  1  2  3
                // 4 5 7 9

                if (cero == true) {
                    for (int l = 0; l < arreglo[fila].length; l++) {
                        valor = arreglo[fila][l];
                        arreglo[fila][l] = arreglo[fila + 1][l];
                        arreglo[fila + 1][l] = valor;
                    }
                }
            }
        }

        //Operar hasta obtener ceros bajo la diagonal principal
        double numero = 0;
        for (int i = 0; i < arreglo.length; i++) {
            //Obtener el valor del coeficiente de la diagonal en la fila base
            numero = arreglo[i][i];
            for (int j = 0; j < arreglo[i].length; j++) {
                //Dividir todos los elementos de la fila base entre el coeficiente guardado, para que el primer coeficiente sea 1
                arreglo[i][j] = arreglo[i][j] / numero;
                inversa[i][j] = inversa[i][j] / numero;
            }
            //Convertir los números bajo la diagonal principal en 0
            if (i < arreglo.length - 1) {
                for (int k = i + 1; k < arreglo.length; k++) {
                    //Almacenar coeficiente principal de fila siguiente
                    numero = arreglo[k][i] * -1;
                    for (int l = 0; l < arreglo[k].length; l++) {
                        arreglo[k][l] = (arreglo[k][l] + (numero * arreglo[i][l]));
                        inversa[k][l] = (inversa[k][l] + (numero * inversa[i][l]));
                    }
                }
            }
        }

        // 1  5  7 | 1  0  0
        // 0  1  5 | 0  1  0
        // 0  0  1 | 0  0  1
        //Operar hasta obtener ceros sobre la diagonal principal
        for (int i = arreglo.length - 1; i > 0; i--) {
            for (int j = i - 1; j > -1; j--) {
                numero = arreglo[j][i] * -1;
                for (int k = arreglo[i].length - 1; k > -1; k--) {
                    arreglo[j][k] = arreglo[j][k] + (numero * arreglo[i][k]);
                    inversa[j][k] = inversa[j][k] + (numero * inversa[i][k]);
                }
            }
        }

        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                if (arreglo[i][j] == -0.0) {
                    arreglo[i][j] = 0.0;
                }
            }
        }

        return inversa;
    }

    public static double [][] calculoMatrizTranspuesta(double [][] matriz1){
        double [][] matrizTemp = new double[matriz1[0].length][matriz1.length];
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                matrizTemp[j][i]= matriz1[i][j];
            }
        }
        return  matrizTemp;
    }

    public static double [][] calcularPotenciaMatriz(double [][] matriz1, int potencia){
        double matrizMult[][]= new double[matriz1.length][matriz1[0].length];
        double matrizAux[][]= new double[matriz1.length][matriz1[0].length];
        int contador=1;
        System.out.println("Matriz Mult");
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                matrizAux[i][j] = matriz1[i][j];
                matrizMult[i][j] = matriz1[i][j];
            }
        }
        if (potencia == 1) {
            return matriz1;
        }else {
            do{
                for (int i = 0; i < matriz1.length; i++) {
                    for (int j = 0; j < matriz1[0].length; j++) {
                        matrizAux[i][j] = matrizMult[i][j];
                    }
                }
                for(int i=0;i<matrizMult.length;i++){
                    for(int j=0;j<matrizMult[0].length;j++){
                        double MatrizTemp=0;
                        for(int k=0;k<matrizMult.length;k++){
                            MatrizTemp+=matrizAux[i][k]*matriz1[k][j]*1.00;
                        }
                        matrizMult[i][j]=Math.round(MatrizTemp);
                    }
                }
                contador++;
            }while(contador<potencia);
            return matrizMult;
        }
    }

    public static double calcularDeterminante(double [][] matrizDet){

        if (matrizDet.length==3 && matrizDet[0].length==3){
            double determinante=((matrizDet[0][0]*matrizDet[1][1]*matrizDet[2][2])+(matrizDet[0][1]*matrizDet[1][2]*matrizDet[2][0])+(matrizDet[1][0]*matrizDet[2][1]*matrizDet[0][2]))-
                    ((matrizDet[2][0]*matrizDet[1][1]*matrizDet[0][2])+(matrizDet[2][1]*matrizDet[1][2]*matrizDet[0][0])+(matrizDet[1][0]*matrizDet[0][1]*matrizDet[2][2]));
            return determinante;
        } if(matrizDet.length==3 && matrizDet[0].length==3){
            double determinante=(matrizDet[0][0]*matrizDet[1][1])-(matrizDet[1][0]*matrizDet[0][1]);
            return determinante;
        }else{
            System.out.println("Solo se pueden operar matrices con un tamano MAX de: 3X3");
            return 0;
        }

    }

    public static void sumaDeMatriceds() {
        Scanner s = new Scanner(System.in, "ISO-8859-1");

//        Sumar matrices
//1. Se solicita al usuario ingresar la letra de la primera matriz: Ejemplo: A
//2. Se solicita al usuario ingresar la letra de la segunda matriz: Ejemplo: B
//3. Se realiza la operación A + Bs,
//4. Se muestra el resultado en consola en forma de matriz (no linealizada)
        int opcion = 0;
        int indMat1 = 0;
        int indMat2 = 0;
        String matriz1;
        String matriz2;
        do {

            try {

                System.out.println("*****************SUMA DE MATRICES*********************");
                System.out.println("Escoja una de las siguientes opciones en orden");
                System.out.println("Opcion 1: Ingresar la letra de la matriz 1:");
                System.out.println("Opcion 2: Ingresar la letra de la matriz 2:");
                System.out.println("Opcion 3: Sumar");
                System.out.println("Opcion 4: Salir");
                System.out.print("Elija una opción del menú: ");
                opcion = s.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("\nIngrese la letra de la matriz 1:");
                        matriz1 = s.next();
                        letraMatrizSuma1=matriz1.toUpperCase();

                        //Buscar la letra en la matriz de letras (puse una matriz para que los índices coincidad)
                        for (int i = 0; i < matriz.length; i++) {
                            if (matriz[i] != null) {
                                if (matriz[i].getNombre().equalsIgnoreCase(matriz1)) {
                                    indMat1 = i;
                                    matrizOriginalSuma1 = matriz[indMat1].getMatriz();
                                    break;
                                }
                            }

                        }

                        break;
                    case 2:
                        System.out.println("\nIngrese la letra de la matriz 2:");
                        matriz2 = s.next();
                        letraMatrizSuma2=matriz2.toUpperCase();

                        //Buscar la letra en la matriz de letras (puse una matriz para que los índices coincidad)
                        for (int i = 0; i < matriz.length; i++) {
                            if (matriz[i] != null) {
                                if (matriz[i].getNombre().equalsIgnoreCase(matriz2)) {
                                    indMat2 = i;
                                    matrizOriginalSuma2 = matriz[indMat2].getMatriz();
                                    break;
                                }
                            }
                        }

                        break;
                    case 3:
                        int matrizAfila=matriz[indMat1].getMatriz().length;
                        int matrizAcolumna=matriz[indMat1].getMatriz()[0].length;
                        int matrizBfila=matriz[indMat2].getMatriz().length;
                        int matrizBcolumna=matriz[indMat2].getMatriz()[0].length;

                        if (matrizAfila==matrizBfila && matrizAcolumna== matrizBcolumna){

                            double[][] matrizSuma = sumarMatrices(matriz[indMat1].getMatriz(), matriz[indMat2].getMatriz());
                            //Se manda a imprimir la matriz
                            guardarR(matrizSuma);
                            matrizSumaR=matrizSuma;
                            imprimirMatriz(matrizSuma);
                            break;
                        }else{
                            System.out.println("Las matriz: "+matriz[indMat1].getNombre() + " tiene un tamano = " + matrizAfila + "X" + matrizAcolumna);
                            System.out.println("Las matriz: "+matriz[indMat2].getNombre() + " tiene un tamano = " + matrizBfila + "X" + matrizBcolumna);
                            System.out.println("No poseen el mismo tamano para realizar la operacion");
                            System.out.println("Por favor elija otras matrices ha operar...");
                            break;
                        }

                    case 4:
                        System.out.println("\nGracias por utilizar el menú sumas.");
                        break;
                    default:
                        System.out.println("\nLa opcion no es valida");

                }

            } catch (Exception e) {

                System.out.println("Opción no valida");
                s.nextLine();
            }

        } while (opcion != 4);
    }

    public static void restaDeMatriceds() {
        Scanner s = new Scanner(System.in, "ISO-8859-1");

//Restar matrices
//1. Se solicita al usuario ingresar la letra de la primera matriz: Ejemplo: A
//2. Se solicita al usuario ingresar la letra de la segunda matriz: Ejemplo: B
//3. Se realiza la operación A - B
//4. Se muestra el resultado en consola en forma de matriz (no linealizada)
        int opcion = 0;
        int indMat1 = 0;
        int indMat2 = 0;
        String matriz1;
        String matriz2;
        do {

            try {

                System.out.println("*****************RESTA DE MATRICES*********************");
                System.out.println("Escoja una de las siguientes opciones en orden");
                System.out.println("Opcion 1: Ingresar la letra de la matriz 1:");
                System.out.println("Opcion 2: Ingresar la letra de la matriz 2:");
                System.out.println("Opcion 3: Restar");
                System.out.println("Opcion 4: Salir");
                System.out.print("Elija una opción del menú: ");
                opcion = s.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("\nIngrese la letra de la matriz 1:");
                        matriz1 = s.next();
                        letraMatrizResta1=matriz1.toUpperCase();

                        //Buscar la letra en la matriz de letras (puse una matriz para que los índices coincidad)
                        for (int i = 0; i < matriz.length; i++) {
                            if (matriz[i] != null) {
                                if (matriz[i].getNombre().equalsIgnoreCase(matriz1)) {
                                    indMat1 = i;
                                    matrizOriginalResta1 = matriz[indMat1].getMatriz();
                                }
                            }
                        }

                        break;
                    case 2:
                        System.out.println("\nIngrese la letra de la matriz 2:");
                        matriz2 = s.next();
                        letraMatrizResta2=matriz2.toUpperCase();

                        //Buscar la letra en la matriz de letras (puse una matriz para que los índices coincidad)
                        for (int i = 0; i < matriz.length; i++) {
                            if (matriz[i] != null) {
                                if (matriz[i].getNombre().equalsIgnoreCase(matriz2)) {
                                    indMat2 = i;
                                    matrizOriginalResta2 = matriz[indMat2].getMatriz();
                                }
                            }
                        }

                        break;
                    case 3:
                        int matrizAfila=matriz[indMat1].getMatriz().length;
                        int matrizAcolumna=matriz[indMat1].getMatriz()[0].length;
                        int matrizBfila=matriz[indMat2].getMatriz().length;
                        int matrizBcolumna=matriz[indMat2].getMatriz()[0].length;
                        if (matrizAfila==matrizBfila && matrizAcolumna== matrizBcolumna) {
                            double[][] matrizResta = restarMatrices(matriz[indMat1].getMatriz(), matriz[indMat2].getMatriz());
                            //Se manda a imprimir la matriz
                            imprimirMatriz(matrizResta);
                            guardarR(matrizResta);
                            matrizRestaR=matrizResta;
                            break;
                        }else{
                            System.out.println("Las matriz: "+matriz[indMat1].getNombre() + " tiene un tamano = " + matrizAfila + "X" + matrizAcolumna);
                            System.out.println("Las matriz: "+matriz[indMat2].getNombre() + " tiene un tamano = " + matrizBfila + "X" + matrizBcolumna);
                            System.out.println("No poseen el mismo tamano para realizar la operacion");
                            System.out.println("Por favor elija otras matrices ha operar...");
                            break;
                        }
                    case 4:
                        System.out.println("\nGracias por utilizar el menú sumas.");
                        break;
                    default:
                        System.out.println("\nLa opcion no es valida");

                }

            } catch (Exception e) {

                System.out.println("Opción no valida");
                s.nextLine();
            }

        } while (opcion != 4);
    }

    public static void multiplicarMatrices() {
        Scanner s = new Scanner(System.in, "ISO-8859-1");
        int opcion = 0;

        do {
            try {
                System.out.println("*****************MULTIPLICACIÓN DE MATRICES*********************");
                System.out.println("Escoja una de las siguientes opciones en orden");
                System.out.println("Opcion 1: Por un numero");
                System.out.println("Opcion 2: Por otra matriz");
                System.out.println("Opcion 3: Salir");
                System.out.print("Elija una opción del menú: ");
                opcion = s.nextInt();

                switch (opcion) {
                    case 1:
                        prodcutoDeMatrices();
                        break;
                    case 2:
                        prodcutoDeMatrices2();
                        break;
                    case 3:
                        System.out.println("\nGracias por utilizar el menú multiplicar.");
                        break;
                    default:
                        System.out.println("\nLa opcion no es valida");
                }
            } catch (Exception e) {

                System.out.println("Opción no valida");
                s.nextLine();
            }

        } while (opcion != 3);
    }

    public static void prodcutoDeMatrices() {
        Scanner s = new Scanner(System.in, "ISO-8859-1");

//Por un numero
//1. Se solicita al usuario ingresar la letra de la matriz: Ejemplo: R
//2. Se solicita al usuario ingresar el numero a multiplicar la matriz: Ejemplo: -5
//3. Se realiza la operación -5 * R
//4. Se muestra el resultado en consola en forma de matriz (no linealizada)
        int opcion = 0;
        int indMat1 = 0;
        int indMat2 = 0;
        String matriz1;

        do {

            try {

                System.out.println("*****************PRODUCTO DE MATRICES*********************");
                System.out.println("Escoja una de las siguientes opciones en orden");
                System.out.println("Opcion 1: Ingresar la letra de la matriz:");
                System.out.println("Opcion 2: Ingrese el número a multiplicar:");
                System.out.println("Opcion 3: Multiplicar");
                System.out.println("Opcion 4: Salir");
                System.out.print("Elija una opción del menú: ");
                opcion = s.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("\nIngrese la letra de la matriz:");
                        matriz1 = s.next();
                        letraMatrizProductoPorUnNumero=matriz1.toUpperCase();

                        //Buscar la letra en la matriz de letras (puse una matriz para que los índices coincidad)
                        for (int i = 0; i < matriz.length; i++) {
                            if (matriz[i] != null) {
                                if (matriz[i].getNombre().equalsIgnoreCase(matriz1)) {
                                    indMat1 = i;
                                    matrizOriginalProductoPorUnNumero = matriz[indMat1].getMatriz();
                                }
                            }
                        }

                        break;
                    case 2:
                        System.out.println("\nIngrese el número a multiplicar:");
                        indMat2 = s.nextInt();
                        matrizProductoPorUnNumero = indMat2;
                        break;

                    case 3:
                        double[][] matrizProducto = multiplicarMatrices2(matriz[indMat1].getMatriz(), indMat2);

                        System.out.println("La mutlplicación de la matriz es:");
                        guardarR(matrizProducto);
                        imprimirMatriz(matrizProducto);
                        matrizProductoPorUnNumeroR=matrizProducto;
                    case 4:
                        System.out.println("\nGracias por utilizar el menú multiplicar.");
                        break;
                    default:
                        System.out.println("\nLa opcion no es valida");

                }

            } catch (Exception e) {

                System.out.println("Opción no valida");
                s.nextLine();
            }

        } while (opcion != 4);
    }

    public static void prodcutoDeMatrices2() {
        Scanner s = new Scanner(System.in, "ISO-8859-1");

//Por otra matriz
//1. Se solicita al usuario ingresar la letra de la primera matriz: Ejemplo: A
//2. Se solicita al usuario ingresar la letra de la segunda matriz: Ejemplo: R
//3. Se realiza la operación A * R
//4. Se muestra el resultado en consola en forma de matriz (no linealizada)
        int opcion = 0;
        int indMat1 = 0;
        int indMat2 = 0;
        String matriz1;
        String matriz2;
        do {

            try {

                System.out.println("*****************PRODUCTO DE MATRICES*********************");
                System.out.println("Escoja una de las siguientes opciones en orden");
                System.out.println("Opcion 1: Ingresar la letra de la matriz 1:");
                System.out.println("Opcion 2: Ingresar la letra de la matriz 2:");
                System.out.println("Opcion 3: Multiplicar");
                System.out.println("Opcion 4: Salir");
                System.out.print("Elija una opción del menú: ");
                opcion = s.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("\nIngrese la letra de la matriz 1:");
                        matriz1 = s.next();
                        letraMatrizProducto1=matriz1.toUpperCase();

                        //Buscar la letra en la matriz de letras (puse una matriz para que los índices coincidad)
                        for (int i = 0; i < matriz.length; i++) {
                            if (matriz[i] != null) {
                                if (matriz[i].getNombre().equalsIgnoreCase(matriz1)) {
                                    indMat1 = i;
                                    matrizOriginalProducto1 = matriz[indMat1].getMatriz();
                                }
                            }
                        }

                        break;
                    case 2:
                        System.out.println("\nIngrese la letra de la matriz 2:");
                        matriz2 = s.next();
                        letraMatrizProducto2=matriz2.toUpperCase();

                        //Buscar la letra en la matriz de letras (puse una matriz para que los índices coincidad)
                        for (int i = 0; i < matriz.length; i++) {
                            if (matriz[i] != null) {
                                if (matriz[i].getNombre().equalsIgnoreCase(matriz2)) {
                                    indMat2 = i;
                                    matrizOriginalProducto2 = matriz[indMat2].getMatriz();
                                }
                            }
                        }

                        break;
                    case 3:
                        int matrizAfila=matriz[indMat1].getMatriz().length;
                        int matrizAcolumna=matriz[indMat1].getMatriz()[0].length;
                        int matrizBfila=matriz[indMat2].getMatriz().length;
                        int matrizBcolumna=matriz[indMat2].getMatriz()[0].length;
                        if (matriz[indMat1].getMatriz()[0].length == matriz[indMat2].getMatriz().length) {
                            double[][] productoMatriz = multiplicarMatrices(matriz[indMat1].getMatriz(), matriz[indMat2].getMatriz());
                            //Se manda a imprimir la matriz
                            imprimirMatriz(productoMatriz);
                            guardarR(productoMatriz);
                            matrizProductoR=productoMatriz;
                        }else {
                            System.out.println("Las matrices elegidas no cumplen las caracteristicas para poder ser operadas...");
                            System.out.println("La matriz: " + matriz[indMat1].getNombre() + "tiene un orden "+ matrizAfila+"X"+matrizAcolumna);
                            System.out.println("La matriz: " + matriz[indMat2].getNombre() + "tiene un orden "+ matrizBfila+"X"+matrizBcolumna);
                        }
                    case 4:
                        System.out.println("\nGracias por utilizar el menú multiplicar.");
                        break;
                    default:
                        System.out.println("\nLa opcion no es valida");

                }

            } catch (Exception e) {

                System.out.println("Opción no valida");
                s.nextLine();
            }

        } while (opcion != 4);
    }

    public static void dividirMatrices() {

        Scanner s = new Scanner(System.in, "ISO-8859-1");

        //1. Se solicita al usuario ingresar la letra de la primera matriz: Ejemplo: A
        //2. Se solicita al usuario ingresar la letra de la segunda matriz: Ejemplo: B
        //3. Se realiza la operación A / B
        // 4. Se muestra el resultado en consola en forma de matriz (no linealizada)
        int opcion = 0;
        int indMat1 = 0;
        int indMat2 = 0;
        String matriz1;
        String matriz2;
        double[][] matrizInversa = null;
        do {

            try {

                System.out.println("*****************DIVISION DE MATRICES*********************");
                System.out.println("Escoja una de las siguientes opciones en orden");
                System.out.println("Opcion 1: Ingresar la letra de la matriz 1:");
                System.out.println("Opcion 2: Ingresar la letra de la matriz 2:");
                System.out.println("Opcion 3: DIVIDIR");
                System.out.println("Opcion 4: Salir");
                System.out.print("Elija una opción del menú: ");
                opcion = s.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("\nIngrese la letra de la matriz 1:");
                        matriz1 = s.next();
                        letraMatrizDivision1 = matriz1.toUpperCase();

                        //Buscar la letra en la matriz de letras (puse una matriz para que los índices coincidad)
                        for (int i = 0; i < matriz.length; i++) {
                            if (matriz[i] != null) {
                                if (matriz[i].getNombre().equalsIgnoreCase(matriz1)) {
                                    indMat1 = i;
                                    matrizOriginalDivision1 = matriz[indMat1].getMatriz();
                                    break;
                                }
                            }
                        }
                        break;
                    case 2:
                        System.out.println("\nIngrese la letra de la matriz 2:");
                        matriz2 = s.next();
                        letraMatrizDivision2 = matriz2.toUpperCase();

                        //Buscar la letra en la matriz de letras (puse una matriz para que los índices coincidad)
                        for (int i = 0; i < matriz.length; i++) {
                            if (matriz[i] != null) {
                                if (matriz[i].getNombre().equalsIgnoreCase(matriz2)) {
                                    indMat2 = i;
                                    matrizOriginalDivision2 = matriz[indMat2].getMatriz();
                                    break;
                                }
                            }
                        }
                        if (matriz[indMat2].getMatriz().length == matriz[indMat2].getMatriz()[0].length) {
                            double determinante = calcularDeterminante(matriz[indMat2].getMatriz());
                            if (determinante >= 0) {
                                matrizInversa = inversaMatriz(matriz[indMat2].getMatriz());

                                System.out.println("La inversa de la matriz es:");
                                imprimirMatriz(matrizInversa);
                                matrizInversaDivision = matrizInversa;
                            } else {
                                System.out.println("La matriz " + matriz[indMat2].getNombre() + " no tiene inversa por favor elija otra matriz");
                            }

                        } else {
                            System.out.println("\nLa matriz tiene un tamano:" + matriz[indMat2].getMatriz().length + "X" + matriz[indMat2].getMatriz()[0].length);
                            System.out.println("Por lo tanto no puede calcularse la inversa...");
                        }

                        break;
                    case 3:
                        int matrizAfila = matriz[indMat1].getMatriz().length;
                        int matrizAcolumna = matriz[indMat1].getMatriz()[0].length;
                        int matrizBfila = matrizInversa.length;
                        int matrizBcolumna = matrizInversa[0].length;
                        if (matriz[indMat1].getMatriz()[0].length == matrizInversa.length) {
                            double[][] productoMatriz = multiplicarMatrices(matriz[indMat1].getMatriz(), matrizInversa);
                            //Se manda a imprimir la matriz
                            imprimirMatriz(productoMatriz);
                            guardarR(productoMatriz);
                            matrizDivisionR = productoMatriz;
                        } else {
                            System.out.println("Las matrices elegidas no cumplen las caracteristicas para poder ser operadas...");
                            System.out.println("La matriz: " + matriz[indMat1].getNombre() + "tiene un orden " + matrizAfila + "X" + matrizAcolumna);
                            System.out.println("La matriz: " + matriz[indMat2].getNombre() + "tiene un orden " + matrizBfila + "X" + matrizBcolumna);
                        }
                    case 4:
                        System.out.println("\nGracias por utilizar el menú dividir.");
                        break;
                    default:
                        System.out.println("\nLa opcion no es valida");

                }

            } catch (Exception e) {

                System.out.println("Opción no valida");
                s.nextLine();
            }
        } while (opcion != 4);
    }

    public static void transpuestadeMatriz() {
        Scanner s = new Scanner(System.in, "ISO-8859-1");

//        Sumar matrices
//1. Se solicita al usuario ingresar la letra de la matriz: Ejemplo: A
//2. Se calcula la transpuesta de la matriz,
//3. Se muestra el resultado en consola en forma de matriz (no linealizada)
        int opcion = 0;
        int indMat1 = 0;
        String matriz1;
        do {
            try {

                System.out.println("*****************CALCULO DE MATRIZ TRANSPUESTA*********************");
                System.out.println("Escoja una de las siguientes opciones en orden");
                System.out.println("Opcion 1: Ingresar la letra de la matriz:");
                System.out.println("Opcion 2: Calcular Transpuesta");
                System.out.println("Opcion 3: Salir");
                System.out.print("Elija una opción del menú: ");
                opcion = s.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("\nIngrese la letra de la matriz 1:");
                        matriz1 = s.next();
                        letraMatriz=matriz1.toUpperCase();

                        //Buscar la letra en la matriz de letras (puse una matriz para que los índices coincidad)
                        for (int i = 0; i < matriz.length; i++) {
                            if (matriz[i] != null) {
                                if (matriz[i].getNombre().equalsIgnoreCase(matriz1)) {
                                    indMat1 = i;
                                    matrizOriginal = matriz[indMat1].getMatriz();
                                    break;
                                }
                            }
                        }
                        break;
                    case 2:
                        double[][] matrizTranspuesta = calculoMatrizTranspuesta(matriz[indMat1].getMatriz());
                        //Se manda a leer el resultado obtenido
                        imprimirMatriz(matrizTranspuesta);
                        guardarR(matrizTranspuesta);
                        matrizTransR=matrizTranspuesta;
                        break;
                    case 3:
                        System.out.println("\nGracias por utilizar el menú calcula matriz Transpuesta.");
                        break;
                    default:
                        System.out.println("\nLa opcion no es valida");
                }
            } catch (Exception e) {
                System.out.println("Opción no valida");
                s.nextLine();
            }
        } while (opcion != 3);
    }

    public static void inversaDeUnaMatriz() {
        Scanner s = new Scanner(System.in, "ISO-8859-1");

//Por otra matriz
//1. Se solicita al usuario ingresar la letra de la primera matriz: Ejemplo: A
//2. Se solicita al usuario ingresar la letra de la segunda matriz: Ejemplo: R
//3. Se realiza la operación A * R
//4. Se muestra el resultado en consola en forma de matriz (no linealizada)
        int opcion = 0;
        int indMat1 = 0;
        //    int indMat2 = 0;
        String matriz1;
        //  String matriz2;
        do {
            try {
                System.out.println("*****************INVERSA DE MATRICES*********************");
                System.out.println("Escoja una de las siguientes opciones en orden");
                System.out.println("Opcion 1: Ingresar la letra de la matriz 1:");
                System.out.println("Opcion 2: Inversa");
                System.out.println("Opcion 3: Salir");
                System.out.print("Elija una opción del menú: ");
                opcion = s.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("\nIngrese la letra de la matriz 1:");
                        matriz1 = s.next();
                        letraMatrizInversa=matriz1.toUpperCase();

                        //Buscar la letra en la matriz de letras (puse una matriz para que los índices coincidad)
                        for (int i = 0; i < matriz.length; i++) {
                            if (matriz[i] != null) {
                                if (matriz[i].getNombre().equalsIgnoreCase(matriz1)) {
                                    indMat1 = i;
                                    matrizOriginalInversa = matriz[indMat1].getMatriz();
                                    break;
                                }
                            }
                        }
                        break;
                    case 2:
                        if (matriz[indMat1].getMatriz().length==matriz[indMat1].getMatriz()[0].length) {
                            double determinante = calcularDeterminante(matriz[indMat1].getMatriz());
                            if (determinante > 0){
                                double[][] matrizInversa = inversaMatriz(matriz[indMat1].getMatriz());

                                System.out.println("La inversa de la matriz es:");
                                guardarR(matrizInversa);
                                imprimirMatriz(matrizInversa);
                                matrizInversaR=matrizInversa;
                            }else{
                                System.out.println("El determinante de la matriz es 0 por");
                                System.out.println("lo tanto la matriz no tiene inversa");
                            }
                        }else{
                            System.out.println("\nLa matriz tiene un tamano:" + matriz[indMat1].getMatriz().length+"X"+matriz[indMat1].getMatriz()[0].length);
                            System.out.println("Por lo tanto no puede calcularse la inversa...");
                        }
                    case 3:
                        System.out.println("\nGracias por utilizar el menú calculo de matriz inversa.");
                        break;
                    default:
                        System.out.println("\nLa opcion no es valida");

                }

            } catch (Exception e) {

                System.out.println("Opción no valida");
                s.nextLine();
            }

        } while (opcion != 3);
    }

    public static void potenciaMatriz() {
        Scanner s = new Scanner(System.in, "ISO-8859-1");

//        Potencia de matrices
//1. Se solicita al usuario ingresar la letra de la matriz: Ejemplo: A
//2. Se realiza calcula la potencia de la matriz,
//3. Se muestra el resultado en consola en forma de matriz (no linealizada)
        int opcion = 0;
        int indMat = 0;
        int potenciaMat = 0;
        String matriz1;
        do {
            try {

                System.out.println("*****************CALCULO DE  POTENCIA DE MATRIZ*********************");
                System.out.println("Escoja una de las siguientes opciones en orden");
                System.out.println("Opcion 1: Ingresar la letra de la matriz:");
                System.out.println("Opcion 2: Elegir a que potencia elevar");
                System.out.println("Opcion 3: Calcular Potencia");
                System.out.println("Opcion 4: Salir");
                System.out.print("Elija una opción del menú: ");
                opcion = s.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("\nIngrese la letra de la matriz 1:");
                        matriz1 = s.next();
                        letraMatrizPotencia = matriz1.toUpperCase();

                        //Buscar la letra en la matriz de letras (puse una matriz para que los índices coincidad)
                        for (int i = 0; i < matriz.length; i++) {
                            if (matriz[i] != null) {
                                if (matriz[i].getNombre().equalsIgnoreCase(matriz1)) {
                                    indMat = i;
                                    matrizOriginalPotencia = matriz[indMat].getMatriz();
                                    break;
                                }
                            }
                        }
                        break;
                    case 2:
                        System.out.println("\nIngrese el numero por el cual desea elevar la matriz:");
                        potenciaMat = s.nextInt();
                        s.nextLine();
                        matrizNumeroPotencia = potenciaMat;
                        break;
                    case 3:
                        if (matriz[indMat].getMatriz().length == matriz[indMat].getMatriz()[0].length) {
                            double[][] matrizPotenciada = calcularPotenciaMatriz(matriz[indMat].getMatriz(), potenciaMat);
                            //Se manda a leer el resultado obtenido
                            imprimirMatriz(matrizPotenciada);
                            guardarR(matrizPotenciada);
                            matrizPotenciaR = matrizPotenciada;
                            break;
                        } else {
                            System.out.println("La matriz elegida no cumple con las caracteristicas");
                            System.out.println("para poder calcular la potencia de la misma...\n");
                            break;
                        }
                    case 4:
                        System.out.println("\nGracias por utilizar el menú potencia.");
                        break;
                    default:
                        System.out.println("\nLa opcion no es valida");
                }
            } catch (Exception e) {
                System.out.println("Opción no valida");
                s.nextLine();
            }
        } while (opcion != 4);
    }

    public static void determinanteMatriz() {
        Scanner s = new Scanner(System.in, "ISO-8859-1");

//        Determinante matrices
//1. Se solicita al usuario ingresar la letra de la matriz: Ejemplo: A
//2. Se realiza calcula el determinante de la matriz,
//3. Se muestra el resultado en consola en forma de matriz (no linealizada)
        int opcion = 0;
        int indMat = 0;
        String matriz1;
        do {
            try {

                System.out.println("*****************CALCULO DEL DETERMINANTE DE UNA MATRIZ*********************");
                System.out.println("Escoja una de las siguientes opciones en orden");
                System.out.println("Opcion 1: Ingresar la letra de la matriz:");
                System.out.println("Opcion 2: Calcular Determinante");
                System.out.println("Opcion 3: Salir");
                System.out.print("Elija una opción del menú: ");
                opcion = s.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("\nIngrese la letra de la matriz 1:");
                        matriz1 = s.next();
                        letraMatrizDeterminante = matriz1.toUpperCase();

                        //Buscar la letra en la matriz de letras (puse una matriz para que los índices coincidad)
                        for (int i = 0; i < matriz.length; i++) {
                            if (matriz[i] != null) {
                                if (matriz[i].getNombre().equalsIgnoreCase(matriz1)) {
                                    indMat = i;
                                    matrizOriginalDeterminante = matriz[indMat].getMatriz();
                                    break;
                                }
                            }
                        }
                        break;
                    case 2:
                        if (matriz[indMat].getMatriz().length == matriz[indMat].getMatriz()[0].length) {
                            double detMatriz = calcularDeterminante(matriz[indMat].getMatriz());
                            //Se manda a leer el resultado obtenido
                            System.out.println("Resultado:");
                            System.out.println("Determinante = " + detMatriz);
                            matrizDeterminante = detMatriz;
                            break;
                        } else {
                            System.out.println("La matriz elegida no cumple con las caracteristicas para poder");
                            System.out.println("calcular su determinante...\n");
                            break;
                        }
                    case 3:
                        System.out.println("\nGracias por utilizar el menú determinante.");
                        break;
                    default:
                        System.out.println("\nLa opcion no es valida");
                }
            } catch (Exception e) {
                System.out.println("Opción no valida");
                s.nextLine();
            }
        } while (opcion != 3);
    }

    public static void mostrarMatrizR(){
        if (matriz[17] != null) {
            System.out.print("\nMATRIZ-R---->");
            imprimirMatriz(matriz[17].getMatriz());
        }else {
            System.out.println("Aun no hay datos guardados en la matriz R");
        }

    }

    public static void guardarR(double [][] matrizGuardar){
        Matriz R = new Matriz("R",matrizGuardar );
        matriz[17] = R;

    }

    public static  void imprimirMatriz(double [][] imprimirMatriz){
        if (imprimirMatriz != null) {
            System.out.println("Resultado=");
            for (int i = 0; i < imprimirMatriz.length; i++) {
                for (int j = 0; j < imprimirMatriz[i].length; j++) {
                    System.out.print("[" + imprimirMatriz[i][j] + "]\t");
                }
                System.out.println("");
            }
        }else{
            System.out.println("Aun no hay datos...");
        }

    }


    //************REPORTES*************

    public static void reporteMatrizTrans() {
        if (matrizOriginal == null) {
            System.out.println("No se ha cargado la matriz M");
        }
        if (matrizTransR == null) {
            System.out.println("No se ha calculado la matriz Transpuesta");
        } else {
            FileWriter fichero = null;
            PrintWriter pw = null;
            Date date = new Date();
            String fecha = String.valueOf(date);
            try {
                fichero = new FileWriter("Reporte_Calculo_Matriz_Transpuesta.html");
                pw = new PrintWriter(fichero);
                pw.println(fecha);

                pw.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "\n"
                        + "<head>\n"
                        + "    <title>Reporte Calculo Matriz Transpuesta</title>\n"
                        + "    <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                        + "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n"
                        + "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n"
                        + "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n"
                        + "</head>\n"
                        + "\n"
                        + "<body>\n"
                        + "    <div class=\"jumbotron text-center\">\n"
                        + "        <h1><b><u>REPORTE DE MATRIZ TRANSPUESTA</u></b></h1>\n"
                        + "<h2>Pasos para poder realizar la matriz transpuesta</h2>"
                        + "<body  bgcolor=\"0E7ADA\">\n"
                        + " <font size =\"4\" color=\"white\" face=\"Comic Sans MS,arial\">"
                        + "        </div>\n"
                        + "        <br>\n"
                        + "        <div class=\"well well-sm\" style=\"background-color: rgb(47, 62, 95);\">\n"
                        + "            <center>\n"
                        + "<h3>Paso No. 1</h3>"
                        + "<p>Se le solicita el usuario que elija una letra para identificar la matriz No. 1.</p>"
                        + "<p>en este caso el usuario eligio la Matriz: </p>" + letraMatriz
                        + "<p><i> Se muestra la matriz en pantalla:</i><p>");

                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizOriginal.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizOriginal[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizOriginal[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("<br><br><h3>Paso No. 2</h3>\n"
                        + "<p>Se procede a cambiar las filas por columnas y columnas por las filas:</p>");
                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizTransR.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizTransR[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizTransR[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("</font>"
                        + "</body>"
                        + "        <div class=\"well well-sm\" style=\"background-color: rgb(47, 62, 95);\">\n"
                        + "            <center>\n"
                        + "                <h4>\""
                        + "                </center>\n"
                        + "            </div>\n"
                        + "\n"
                        + "        </div>\n"
                        + "\n"
                        + "<br>\n"
                        + "<br>\n"
                        + "<hr><footer>\n"
                        + " <font size=5 color=\"Black\" face=\"Comic Sans MS,arial\">"
                        + "<center>"
                        + "    <br><p>Facultad de Ingeniería</p>\n"
                        + "    <br>\n"
                        + "    <p>Escuela de Ciencias y Sistemas</p>\n"
                        + "    <br>\n"
                        + "    <p>Introducción a la Programación y Computación 1</p>\n"
                        + "    <br>\n"
                        + "    <p>Sección N</p>\n"
                        + "    <br>\n"
                        + "    <p>Catedrático: Ing. Marlon Orellana</p>\n"
                        + "    <br>\n"
                        + "    <p>Tutor académico: Darwin Arevalo</p>\n"
                        + "    <br>\n"
                        + "    <p>Grupo No. 15</p>\n"
                        + "    <br>\n"
                        + "    <p>UNIVERSIDAD DE SAN CARLOS DE GUATEMALA.</p>\n"
                        + "</center>"
                        + "</font>"
                        + "</footer></body>\n"
                        + "\n"
                        + "</html>");
                fichero.close();
                System.out.println("!!!!Se ha generado el reporte con exito!!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void reporteSuma() {
        if (matrizOriginalSuma1 == null) {
            System.out.println("No se ha cargado la matriz 1");
        }
        if (matrizOriginalSuma2 == null) {
            System.out.println("No se ha cargado la matriz 2");
        }
        if (matrizSumaR == null) {
            System.out.println("No se ha calculado la matriz Suma");
        } else {
            FileWriter fichero = null;
            PrintWriter pw = null;
            Date date = new Date();
            String fecha = String.valueOf(date);
            try {
                fichero = new FileWriter("Reporte_de_Suma.html");
                pw = new PrintWriter(fichero);
                pw.println(fecha);

                pw.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "\n"
                        + "<head>\n"
                        + "    <title>Reporte de Suma de Matrices</title>\n"
                        + "    <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                        + "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n"
                        + "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n"
                        + "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n"
                        + "</head>\n"
                        + "\n"
                        + "<body>\n"
                        + "    <div class=\"jumbotron text-center\">\n"
                        + "        <h1><b><u>REPORTE DE SUMA DE MATRICES</u></b></h1>\n"
                        + "<h2>Pasos para poder realizar la suma</h2>"
                        + "<body  bgcolor=\"0E7ADA\">\n"
                        + " <font size =\"4\" color=\"white\" face=\"Comic Sans MS,arial\">"
                        + "        </div>\n"
                        + "        <br>\n"
                        + "        <div class=\"well well-sm\" style=\"background-color: rgb(47, 62, 95);\">\n"
                        + "            <center>\n"
                        + "<h3>Paso No. 1</h3>"
                        + "<p>Se le solicita el usuario que elija una letra para identificar la matriz No. 1.</p>"
                        + "<p>en este caso el usuario eligio la Matriz: </p>" + letraMatrizSuma1
                        + "<p><i> Se muestra la matriz en pantalla:</i><p>");

                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizOriginalSuma1.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizOriginalSuma1[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizOriginalSuma1[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("<br><br><h3>Paso No. 2</h3>\n"
                        + "<p>Se le solicita el usuario que elija una letra para identificar la matriz No. 2.</p>");
                pw.println("<p> en este caso el usuario eligio la Matriz: </p>" + letraMatrizSuma2);
                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizOriginalSuma2.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizOriginalSuma2[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizOriginalSuma2[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("<br><br><h3>Paso No. 3</h3>\n"
                        + "<p>Se procede a realizar las sumas y el resultado es:</p>");
                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizSumaR.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizSumaR[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizSumaR[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("</font>"
                        + "</body>"
                        + "        <div class=\"well well-sm\" style=\"background-color: rgb(47, 62, 95);\">\n"
                        + "            <center>\n"
                        + "                <h4>\""
                        + "                </center>\n"
                        + "            </div>\n"
                        + "\n"
                        + "        </div>\n"
                        + "\n"
                        + "<br>\n"
                        + "<br>\n"
                        + "<hr><footer>\n"
                        + " <font size=5 color=\"Black\" face=\"Comic Sans MS,arial\">"
                        + "<center>"
                        + "    <br><p>Facultad de Ingeniería</p>\n"
                        + "    <br>\n"
                        + "    <p>Escuela de Ciencias y Sistemas</p>\n"
                        + "    <br>\n"
                        + "    <p>Introducción a la Programación y Computación 1</p>\n"
                        + "    <br>\n"
                        + "    <p>Sección N</p>\n"
                        + "    <br>\n"
                        + "    <p>Catedrático: Ing. Marlon Orellana</p>\n"
                        + "    <br>\n"
                        + "    <p>Tutor académico: Darwin Arevalo</p>\n"
                        + "    <br>\n"
                        + "    <p>Grupo No. 15</p>\n"
                        + "    <br>\n"
                        + "    <p>UNIVERSIDAD DE SAN CARLOS DE GUATEMALA.</p>\n"
                        + "</center>"
                        + "</font>"
                        + "</footer></body>\n"
                        + "\n"
                        + "</html>");
                fichero.close();
                System.out.println("!!!!Se ha generado el reporte con exito!!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void reporteResta() {
        if (matrizOriginalResta1 == null) {
            System.out.println("No se ha cargado la matriz 1");
        }
        if (matrizOriginalResta2 == null) {
            System.out.println("No se ha cargado la matriz 2");
        }
        if (matrizRestaR == null) {
            System.out.println("No se ha calculado la matriz Suma");
        } else {
            FileWriter fichero = null;
            PrintWriter pw = null;
            Date date = new Date();
            String fecha = String.valueOf(date);
            try {
                fichero = new FileWriter("Reporte_de_Resta.html");
                pw = new PrintWriter(fichero);
                pw.println(fecha);

                pw.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "\n"
                        + "<head>\n"
                        + "    <title>Reporte de Resta de Matrices</title>\n"
                        + "    <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                        + "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n"
                        + "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n"
                        + "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n"
                        + "</head>\n"
                        + "\n"
                        + "<body>\n"
                        + "    <div class=\"jumbotron text-center\">\n"
                        + "        <h1><b><u>REPORTE DE RESTA DE MATRICES</u></b></h1>\n"
                        + "<h2>Pasos para poder realizar la resta.</h2>"
                        + "<body  bgcolor=\"0E7ADA\">\n"
                        + " <font size =\"4\" color=\"white\" face=\"Comic Sans MS,arial\">"
                        + "        </div>\n"
                        + "        <br>\n"
                        + "        <div class=\"well well-sm\" style=\"background-color: rgb(47, 62, 95);\">\n"
                        + "            <center>\n"
                        + "<h3>Paso No. 1</h3>"
                        + "<p>Se le solicita el usuario que elija una letra para identificar la matriz No. 1.</p>"
                        + "<p>en este caso el usuario eligio la Matriz: </p>" + letraMatrizResta1
                        + "<p><i> Se muestra la matriz en pantalla:</i><p>");

                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizOriginalResta1.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizOriginalResta1[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizOriginalResta1[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("<br><br><h3>Paso No. 2</h3>\n"
                        + "<p>Se le solicita el usuario que elija una letra para identificar la matriz No. 2.</p>");
                pw.println("<p> en este caso el usuario eligio la Matriz: </p>" + letraMatrizResta2);
                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizOriginalResta2.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizOriginalResta2[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizOriginalResta2[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("<br><br><h3>Paso No. 3</h3>\n"
                        + "<p>Se procede a realizar las restas de las matrices y el resultado es:</p>");
                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizRestaR.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizRestaR[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizRestaR[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("</font>"
                        + "</body>"
                        + "        <div class=\"well well-sm\" style=\"background-color: rgb(47, 62, 95);\">\n"
                        + "            <center>\n"
                        + "                <h4>\""
                        + "                </center>\n"
                        + "            </div>\n"
                        + "\n"
                        + "        </div>\n"
                        + "\n"
                        + "<br>\n"
                        + "<br>\n"
                        + "<hr><footer>\n"
                        + " <font size=5 color=\"Black\" face=\"Comic Sans MS,arial\">"
                        + "<center>"
                        + "    <br><p>Facultad de Ingeniería</p>\n"
                        + "    <br>\n"
                        + "    <p>Escuela de Ciencias y Sistemas</p>\n"
                        + "    <br>\n"
                        + "    <p>Introducción a la Programación y Computación 1</p>\n"
                        + "    <br>\n"
                        + "    <p>Sección N</p>\n"
                        + "    <br>\n"
                        + "    <p>Catedrático: Ing. Marlon Orellana</p>\n"
                        + "    <br>\n"
                        + "    <p>Tutor académico: Darwin Arevalo</p>\n"
                        + "    <br>\n"
                        + "    <p>Grupo No. 15</p>\n"
                        + "    <br>\n"
                        + "    <p>UNIVERSIDAD DE SAN CARLOS DE GUATEMALA.</p>\n"
                        + "</center>"
                        + "</font>"
                        + "</footer></body>\n"
                        + "\n"
                        + "</html>");
                fichero.close();
                System.out.println("!!!!Se ha generado el reporte con exito!!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void reporteMultiplicacionPorOtraMatriz() {
        if (matrizOriginalProducto1 == null) {
            System.out.println("No se ha cargado la matriz 1");
        }
        if (matrizOriginalProducto2 == null) {
            System.out.println("No se ha cargado la matriz 2");
        }
        if (matrizProductoR == null) {
            System.out.println("No se ha calculado la matriz Suma");
        } else {
            FileWriter fichero = null;
            PrintWriter pw = null;
            Date date = new Date();
            String fecha = String.valueOf(date);
            try {
                fichero = new FileWriter("Reporte_de_Producto_de_dos_matrices.html");
                pw = new PrintWriter(fichero);
                pw.println(fecha);

                pw.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "\n"
                        + "<head>\n"
                        + "    <title>Reporte de Producto de Matrices</title>\n"
                        + "    <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                        + "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n"
                        + "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n"
                        + "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n"
                        + "</head>\n"
                        + "\n"
                        + "<body>\n"
                        + "    <div class=\"jumbotron text-center\">\n"
                        + "        <h1><b><u>REPORTE DE PRODUCTO DE DOS MATRICES</u></b></h1>\n"
                        + "<h2>Pasos para poder realizar la multiplicación.</h2>"
                        + "<body  bgcolor=\"0E7ADA\">\n"
                        + " <font size =\"4\" color=\"white\" face=\"Comic Sans MS,arial\">"
                        + "        </div>\n"
                        + "        <br>\n"
                        + "        <div class=\"well well-sm\" style=\"background-color: rgb(47, 62, 95);\">\n"
                        + "            <center>\n"
                        + "<h3>Paso No. 1</h3>"
                        + "<p>Se le solicita el usuario que elija una letra para identificar la matriz No. 1.</p>"
                        + "<p>en este caso el usuario eligio la Matriz: </p>" + letraMatrizProducto1
                        + "<p><i> Se muestra la matriz en pantalla:</i><p>");

                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizOriginalProducto1.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizOriginalProducto1[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizOriginalProducto1[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("<br><br><h3>Paso No. 2</h3>\n"
                        + "<p>Se le solicita el usuario que elija una letra para identificar la matriz No. 2.</p>");
                pw.println("<p> en este caso el usuario eligio la Matriz: </p>" + letraMatrizProducto2);
                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizOriginalProducto2.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizOriginalProducto2[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizOriginalProducto2[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("<br><br><h3>Paso No. 3</h3>\n"
                        + "<p>Se procede a realizar la multiplicación entre las dos matrices y el resultado es:</p>");
                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizProductoR.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizProductoR[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizProductoR[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("</font>"
                        + "</body>"
                        + "        <div class=\"well well-sm\" style=\"background-color: rgb(47, 62, 95);\">\n"
                        + "            <center>\n"
                        + "                <h4>\""
                        + "                </center>\n"
                        + "            </div>\n"
                        + "\n"
                        + "        </div>\n"
                        + "\n"
                        + "<br>\n"
                        + "<br>\n"
                        + "<hr><footer>\n"
                        + " <font size=5 color=\"Black\" face=\"Comic Sans MS,arial\">"
                        + "<center>"
                        + "    <br><p>Facultad de Ingeniería</p>\n"
                        + "    <br>\n"
                        + "    <p>Escuela de Ciencias y Sistemas</p>\n"
                        + "    <br>\n"
                        + "    <p>Introducción a la Programación y Computación 1</p>\n"
                        + "    <br>\n"
                        + "    <p>Sección N</p>\n"
                        + "    <br>\n"
                        + "    <p>Catedrático: Ing. Marlon Orellana</p>\n"
                        + "    <br>\n"
                        + "    <p>Tutor académico: Darwin Arevalo</p>\n"
                        + "    <br>\n"
                        + "    <p>Grupo No. 15</p>\n"
                        + "    <br>\n"
                        + "    <p>UNIVERSIDAD DE SAN CARLOS DE GUATEMALA.</p>\n"
                        + "</center>"
                        + "</font>"
                        + "</footer></body>\n"
                        + "\n"
                        + "</html>");
                fichero.close();
                System.out.println("!!!!Se ha generado el reporte con exito!!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void reporteMultiplicacionPorUnNumero() {
        if (matrizOriginalProductoPorUnNumero == null) {
            System.out.println("No se ha cargado la matriz 1.");
        }

        if (matrizProductoPorUnNumeroR == null) {
            System.out.println("No se ha calculado la matriz Producto");
        } else {
            FileWriter fichero = null;
            PrintWriter pw = null;
            Date date = new Date();
            String fecha = String.valueOf(date);
            try {
                fichero = new FileWriter("Reporte_de_Producto_de_matriz_por_numero.html");
                pw = new PrintWriter(fichero);
                pw.println(fecha);

                pw.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "\n"
                        + "<head>\n"
                        + "    <title>Reporte de Producto de Matrices</title>\n"
                        + "    <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                        + "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n"
                        + "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n"
                        + "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n"
                        + "</head>\n"
                        + "\n"
                        + "<body>\n"
                        + "    <div class=\"jumbotron text-center\">\n"
                        + "        <h1><b><u>REPORTE DE PRODUCTO DE UNA MATRIZ POR UN NÚMERO</u></b></h1>\n"
                        + "<h2>Pasos para poder realizar la multiplicación.</h2>"
                        + "<body  bgcolor=\"0E7ADA\">\n"
                        + " <font size =\"4\" color=\"white\" face=\"Comic Sans MS,arial\">"
                        + "        </div>\n"
                        + "        <br>\n"
                        + "        <div class=\"well well-sm\" style=\"background-color: rgb(47, 62, 95);\">\n"
                        + "            <center>\n"
                        + "<h3>Paso No. 1</h3>"
                        + "<p>Se le solicita el usuario que elija una letra para identificar la matriz No. 1.</p>"
                        + "<p>en este caso el usuario eligio la Matriz: </p>" + letraMatrizProductoPorUnNumero
                        + "<p><i> Se muestra la matriz en pantalla:</i><p>");

                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizOriginalProductoPorUnNumero.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizOriginalProductoPorUnNumero[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizOriginalProductoPorUnNumero[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("<br><br><h3>Paso No. 2</h3>\n"
                        + "<p>Se le solicita el usuario que elija un número para multiplicar con la matriz.</p>");
                pw.println("<p> en este caso el usuario eligio el número: </p>");
                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");

                pw.println("<td><font size =\"4\", color =\"white\">" + matrizProductoPorUnNumero + "</font></td>");

                pw.println("</tr>");

                pw.println("</table><br><br>");

                pw.println("<br><br><h3>Paso No. 3</h3>\n"
                        + "<p>Se procede a realizar la multiplicación entre el número y la  matriz y el resultado es:</p>");
                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizProductoPorUnNumeroR.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizProductoPorUnNumeroR[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizProductoPorUnNumeroR[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("</font>"
                        + "</body>"
                        + "        <div class=\"well well-sm\" style=\"background-color: rgb(47, 62, 95);\">\n"
                        + "            <center>\n"
                        + "                <h4>\""
                        + "                </center>\n"
                        + "            </div>\n"
                        + "\n"
                        + "        </div>\n"
                        + "\n"
                        + "<br>\n"
                        + "<br>\n"
                        + "<hr><footer>\n"
                        + " <font size=5 color=\"Black\" face=\"Comic Sans MS,arial\">"
                        + "<center>"
                        + "    <br><p>Facultad de Ingeniería</p>\n"
                        + "    <br>\n"
                        + "    <p>Escuela de Ciencias y Sistemas</p>\n"
                        + "    <br>\n"
                        + "    <p>Introducción a la Programación y Computación 1</p>\n"
                        + "    <br>\n"
                        + "    <p>Sección N</p>\n"
                        + "    <br>\n"
                        + "    <p>Catedrático: Ing. Marlon Orellana</p>\n"
                        + "    <br>\n"
                        + "    <p>Tutor académico: Darwin Arevalo</p>\n"
                        + "    <br>\n"
                        + "    <p>Grupo No. 15</p>\n"
                        + "    <br>\n"
                        + "    <p>UNIVERSIDAD DE SAN CARLOS DE GUATEMALA.</p>\n"
                        + "</center>"
                        + "</font>"
                        + "</footer></body>\n"
                        + "\n"
                        + "</html>");
                fichero.close();
                System.out.println("!!!!Se ha generado el reporte con exito!!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void reporteMatrizInversa() {
        if (matrizOriginalInversa == null) {
            System.out.println("No se ha cargado la matriz M");
        }
        if (matrizInversaR == null) {
            System.out.println("No se ha calculado la matriz Transpuesta");
        } else {
            FileWriter fichero = null;
            PrintWriter pw = null;
            Date date = new Date();
            String fecha = String.valueOf(date);
            try {
                fichero = new FileWriter("Reporte_Calculo_Matriz_Inversa.html");
                pw = new PrintWriter(fichero);
                pw.println(fecha);

                pw.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "\n"
                        + "<head>\n"
                        + "    <title>Reporte Calculo Matriz Inversa</title>\n"
                        + "    <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                        + "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n"
                        + "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n"
                        + "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n"
                        + "</head>\n"
                        + "\n"
                        + "<body>\n"
                        + "    <div class=\"jumbotron text-center\">\n"
                        + "        <h1><b><u>REPORTE DE MATRIZ INVERSA</u></b></h1>\n"
                        + "<h2>Pasos para poder realizar la matriz inversa</h2>"
                        + "<body  bgcolor=\"0E7ADA\">\n"
                        + " <font size =\"4\" color=\"white\" face=\"Comic Sans MS,arial\">"
                        + "        </div>\n"
                        + "        <br>\n"
                        + "        <div class=\"well well-sm\" style=\"background-color: rgb(47, 62, 95);\">\n"
                        + "            <center>\n"
                        + "<h3>Paso No. 1</h3>"
                        + "<p>Se le solicita el usuario que elija una letra para identificar la matriz No. 1.</p>"
                        + "<p>en este caso el usuario eligio la Matriz: </p>" + letraMatrizInversa
                        + "<p><i> Se muestra la matriz en pantalla:</i><p>");

                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizOriginalInversa.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizOriginalInversa[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizOriginalInversa[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("<br><br><h3>Paso No. 2</h3>\n"
                        + "<p>Se procede a aplicar Gauss-Jordan:</p>");
                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizInversaR.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizInversaR[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizInversaR[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("</font>"
                        + "</body>"
                        + "        <div class=\"well well-sm\" style=\"background-color: rgb(47, 62, 95);\">\n"
                        + "            <center>\n"
                        + "                <h4>\""
                        + "                </center>\n"
                        + "            </div>\n"
                        + "\n"
                        + "        </div>\n"
                        + "\n"
                        + "<br>\n"
                        + "<br>\n"
                        + "<hr><footer>\n"
                        + " <font size=5 color=\"Black\" face=\"Comic Sans MS,arial\">"
                        + "<center>"
                        + "    <br><p>Facultad de Ingeniería</p>\n"
                        + "    <br>\n"
                        + "    <p>Escuela de Ciencias y Sistemas</p>\n"
                        + "    <br>\n"
                        + "    <p>Introducción a la Programación y Computación 1</p>\n"
                        + "    <br>\n"
                        + "    <p>Sección N</p>\n"
                        + "    <br>\n"
                        + "    <p>Catedrático: Ing. Marlon Orellana</p>\n"
                        + "    <br>\n"
                        + "    <p>Tutor académico: Darwin Arevalo</p>\n"
                        + "    <br>\n"
                        + "    <p>Grupo No. 15</p>\n"
                        + "    <br>\n"
                        + "    <p>UNIVERSIDAD DE SAN CARLOS DE GUATEMALA.</p>\n"
                        + "</center>"
                        + "</font>"
                        + "</footer></body>\n"
                        + "\n"
                        + "</html>");
                fichero.close();
                System.out.println("!!!!Se ha generado el reporte con exito!!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void reporteMatrizPotencia() {
        if (matrizOriginalPotencia == null) {
            System.out.println("No se ha cargado la matriz 1.");
        }

        if (matrizPotenciaR == null) {
            System.out.println("No se ha calculado la matriz Potencia");
        } else {
            FileWriter fichero = null;
            PrintWriter pw = null;
            Date date = new Date();
            String fecha = String.valueOf(date);
            try {
                fichero = new FileWriter("Reporte_de_Potencia_de_matriz_por_numero.html");
                pw = new PrintWriter(fichero);
                pw.println(fecha);

                pw.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "\n"
                        + "<head>\n"
                        + "    <title>Reporte de Potencia de Matrices</title>\n"
                        + "    <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                        + "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n"
                        + "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n"
                        + "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n"
                        + "</head>\n"
                        + "\n"
                        + "<body>\n"
                        + "    <div class=\"jumbotron text-center\">\n"
                        + "        <h1><b><u>REPORTE DE POTENCIA DE UNA MATRIZ POR UN NÚMERO</u></b></h1>\n"
                        + "<h2>Pasos para poder realizar la potencia de una matriz.</h2>"
                        + "<body  bgcolor=\"0E7ADA\">\n"
                        + " <font size =\"4\" color=\"white\" face=\"Comic Sans MS,arial\">"
                        + "        </div>\n"
                        + "        <br>\n"
                        + "        <div class=\"well well-sm\" style=\"background-color: rgb(47, 62, 95);\">\n"
                        + "            <center>\n"
                        + "<h3>Paso No. 1</h3>"
                        + "<p>Se le solicita el usuario que elija una letra para identificar la matriz No. 1.</p>"
                        + "<p>en este caso el usuario eligio la Matriz: </p>" + letraMatrizPotencia
                        + "<p><i> Se muestra la matriz en pantalla:</i><p>");

                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizOriginalPotencia.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizOriginalPotencia[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizOriginalPotencia[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("<br><br><h3>Paso No. 2</h3>\n"
                        + "<p>Se le solicita el usuario que elija un número para elevar la matriz.</p>");
                pw.println("<p> en este caso el usuario eligio el número: </p>");
                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");

                pw.println("<td><font size =\"4\", color =\"white\">" + matrizNumeroPotencia + "</font></td>");

                pw.println("</tr>");

                pw.println("</table><br><br>");

                pw.println("<br><br><h3>Paso No. 3</h3>\n"
                        + "<p>Se procede a realizar la potenciación del número y la  matriz y el resultado es:</p>");
                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizPotenciaR.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizPotenciaR[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizPotenciaR[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("</font>"
                        + "</body>"
                        + "        <div class=\"well well-sm\" style=\"background-color: rgb(47, 62, 95);\">\n"
                        + "            <center>\n"
                        + "                <h4>\""
                        + "                </center>\n"
                        + "            </div>\n"
                        + "\n"
                        + "        </div>\n"
                        + "\n"
                        + "<br>\n"
                        + "<br>\n"
                        + "<hr><footer>\n"
                        + " <font size=5 color=\"Black\" face=\"Comic Sans MS,arial\">"
                        + "<center>"
                        + "    <br><p>Facultad de Ingeniería</p>\n"
                        + "    <br>\n"
                        + "    <p>Escuela de Ciencias y Sistemas</p>\n"
                        + "    <br>\n"
                        + "    <p>Introducción a la Programación y Computación 1</p>\n"
                        + "    <br>\n"
                        + "    <p>Sección N</p>\n"
                        + "    <br>\n"
                        + "    <p>Catedrático: Ing. Marlon Orellana</p>\n"
                        + "    <br>\n"
                        + "    <p>Tutor académico: Darwin Arevalo</p>\n"
                        + "    <br>\n"
                        + "    <p>Grupo No. 15</p>\n"
                        + "    <br>\n"
                        + "    <p>UNIVERSIDAD DE SAN CARLOS DE GUATEMALA.</p>\n"
                        + "</center>"
                        + "</font>"
                        + "</footer></body>\n"
                        + "\n"
                        + "</html>");
                fichero.close();
                System.out.println("!!!!Se ha generado el reporte con exito!!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void reporteMatrizDeterminante() {
        if (matrizOriginalDeterminante == null) {
            System.out.println("No se ha cargado la matriz 1.");
        }

        if (letraMatrizDeterminante == null) {
            System.out.println("No se ha calculado la matriz");
        } else {
            FileWriter fichero = null;
            PrintWriter pw = null;
            Date date = new Date();
            String fecha = String.valueOf(date);
            try {
                fichero = new FileWriter("Reporte_determinante_de_una_matriz.html");
                pw = new PrintWriter(fichero);
                pw.println(fecha);

                pw.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "\n"
                        + "<head>\n"
                        + "    <title>Reporte de determinante de Matrices</title>\n"
                        + "    <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                        + "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n"
                        + "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n"
                        + "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n"
                        + "</head>\n"
                        + "\n"
                        + "<body>\n"
                        + "    <div class=\"jumbotron text-center\">\n"
                        + "        <h1><b><u>REPORTE DETERMINANTE DE UNA MATRIZ</u></b></h1>\n"
                        + "<h2>Pasos para poder calcular la determinante de una matriz.</h2>"
                        + "<body  bgcolor=\"0E7ADA\">\n"
                        + " <font size =\"4\" color=\"white\" face=\"Comic Sans MS,arial\">"
                        + "        </div>\n"
                        + "        <br>\n"
                        + "        <div class=\"well well-sm\" style=\"background-color: rgb(47, 62, 95);\">\n"
                        + "            <center>\n"
                        + "<h3>Paso No. 1</h3>"
                        + "<p>Se le solicita el usuario que elija una letra para identificar la matriz No. 1.</p>"
                        + "<p>en este caso el usuario eligio la Matriz: </p>" + letraMatrizDeterminante
                        + "<p><i> Se muestra la matriz en pantalla:</i><p>");

                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizOriginalDeterminante.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizOriginalDeterminante[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizOriginalDeterminante[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("<br><br><h3>El determinante de una matriz de dimensión mxn es el resultado de restar la</h3>\n"
                        + "<p>multiplicación de los elementos de la diagonal principal con la multiplicación de los</p>");
                pw.println("<p>elementos de la diagonal secundaria. </p>");

                pw.println("<br><br><h3>Paso No. 2</h3>\n"
                        + "<p>Se realizan los pasos para calcular la determinate de una matriz.</p>");
                pw.println("<p>Solo podrá calcularse para matrices cuadradas hasta orden 3. </p>");
                pw.println("<p> en este caso la determinante de la matriz es: </p>");
                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");

                pw.println("<td><font size =\"4\", color =\"white\">" + matrizDeterminante + "</font></td>");

                pw.println("</tr>");

                pw.println("</table><br><br>");

                pw.println("</font>"
                        + "</body>"
                        + "        <div class=\"well well-sm\" style=\"background-color: rgb(47, 62, 95);\">\n"
                        + "            <center>\n"
                        + "                <h4>\""
                        + "                </center>\n"
                        + "            </div>\n"
                        + "\n"
                        + "        </div>\n"
                        + "\n"
                        + "<br>\n"
                        + "<br>\n"
                        + "<hr><footer>\n"
                        + " <font size=5 color=\"Black\" face=\"Comic Sans MS,arial\">"
                        + "<center>"
                        + "    <br><p>Facultad de Ingeniería</p>\n"
                        + "    <br>\n"
                        + "    <p>Escuela de Ciencias y Sistemas</p>\n"
                        + "    <br>\n"
                        + "    <p>Introducción a la Programación y Computación 1</p>\n"
                        + "    <br>\n"
                        + "    <p>Sección N</p>\n"
                        + "    <br>\n"
                        + "    <p>Catedrático: Ing. Marlon Orellana</p>\n"
                        + "    <br>\n"
                        + "    <p>Tutor académico: Darwin Arevalo</p>\n"
                        + "    <br>\n"
                        + "    <p>Grupo No. 15</p>\n"
                        + "    <br>\n"
                        + "    <p>UNIVERSIDAD DE SAN CARLOS DE GUATEMALA.</p>\n"
                        + "</center>"
                        + "</font>"
                        + "</footer></body>\n"
                        + "\n"
                        + "</html>");
                fichero.close();
                System.out.println("!!!!Se ha generado el reporte con exito!!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void reporteDivision() {
        if (matrizOriginalDivision1 == null) {
            System.out.println("No se ha cargado la matriz 1");
        }
        if (matrizOriginalDivision2 == null) {
            System.out.println("No se ha cargado la matriz 2");
        }
        if (matrizDivisionR == null) {
            System.out.println("No se ha calculado la matriz División");
        } else {
            FileWriter fichero = null;
            PrintWriter pw = null;
            Date date = new Date();
            String fecha = String.valueOf(date);
            try {
                fichero = new FileWriter("Reporte_de_Division.html");
                pw = new PrintWriter(fichero);
                pw.println(fecha);

                pw.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "\n"
                        + "<head>\n"
                        + "    <title>Reporte de División de Matrices</title>\n"
                        + "    <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                        + "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n"
                        + "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n"
                        + "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n"
                        + "</head>\n"
                        + "\n"
                        + "<body>\n"
                        + "    <div class=\"jumbotron text-center\">\n"
                        + "        <h1><b><u>REPORTE DE DIVISIÓN ENTRE MATRICES</u></b></h1>\n"
                        + "<h2>Pasos para poder realizar la divsión</h2>"
                        + "<body  bgcolor=\"0E7ADA\">\n"
                        + " <font size =\"4\" color=\"white\" face=\"Comic Sans MS,arial\">"
                        + "        </div>\n"
                        + "        <br>\n"
                        + "        <div class=\"well well-sm\" style=\"background-color: rgb(47, 62, 95);\">\n"
                        + "            <center>\n"
                        + "<h3>Paso No. 1</h3>"
                        + "<p>Se le solicita el usuario que elija una letra para identificar la matriz No. 1.</p>"
                        + "<p>en este caso el usuario eligio la Matriz: </p>" + letraMatrizDivision1
                        + "<p><i> Se muestra la matriz en pantalla:</i><p>");

                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizOriginalDivision1.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizOriginalDivision1[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizOriginalDivision1[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("<br><br><h3>Paso No. 2</h3>\n"
                        + "<p>Se le solicita el usuario que elija una letra para identificar la matriz No. 2.</p>");
                pw.println("<p> en este caso el usuario eligio la Matriz: </p>" + letraMatrizDivision2);
                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizOriginalDivision2.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizOriginalDivision2[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizOriginalDivision2[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("<br><br><h3>Paso No. 3</h3>\n"
                        + "<p>Posteriormente se calculó la inversa de la matriz 2.</p>");
                pw.println("<p> en este caso el resultado de la inversa de la matriz 2 es: </p>");
                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizInversaDivision.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizInversaDivision[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizInversaDivision[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("<br><br><h3>Paso No. 4</h3>\n"
                        + "<p>Se procede a realizar las multiplicación entre la matriz 1 y la inversa encontrada anteriormente, el resultado es:</p>");
                pw.println("<table class=\"table table-bordered \" style=\"width:200px; margin: auto;\">");
                for (int i = 0; i < matrizDivisionR.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < matrizDivisionR[0].length; j++) {
                        pw.println("<td><font size =\"4\", color =\"white\">" + matrizDivisionR[i][j] + "</font></td>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table><br><br>");

                pw.println("</font>"
                        + "</body>"
                        + "        <div class=\"well well-sm\" style=\"background-color: rgb(47, 62, 95);\">\n"
                        + "            <center>\n"
                        + "                <h4>\""
                        + "                </center>\n"
                        + "            </div>\n"
                        + "\n"
                        + "        </div>\n"
                        + "\n"
                        + "<br>\n"
                        + "<br>\n"
                        + "<hr><footer>\n"
                        + " <font size=5 color=\"Black\" face=\"Comic Sans MS,arial\">"
                        + "<center>"
                        + "    <br><p>Facultad de Ingeniería</p>\n"
                        + "    <br>\n"
                        + "    <p>Escuela de Ciencias y Sistemas</p>\n"
                        + "    <br>\n"
                        + "    <p>Introducción a la Programación y Computación 1</p>\n"
                        + "    <br>\n"
                        + "    <p>Sección N</p>\n"
                        + "    <br>\n"
                        + "    <p>Catedrático: Ing. Marlon Orellana</p>\n"
                        + "    <br>\n"
                        + "    <p>Tutor académico: Darwin Arevalo</p>\n"
                        + "    <br>\n"
                        + "    <p>Grupo No. 15</p>\n"
                        + "    <br>\n"
                        + "    <p>UNIVERSIDAD DE SAN CARLOS DE GUATEMALA.</p>\n"
                        + "</center>"
                        + "</font>"
                        + "</footer></body>\n"
                        + "\n"
                        + "</html>");
                fichero.close();
                System.out.println("!!!!Se ha generado el reporte con exito!!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
