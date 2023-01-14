public class MatrizValidacion {

    public static void ordenarMatrices(Matriz matriz){
        switch (matriz.getNombre().toUpperCase()){
            case "A":
                CalculoMatricial.matriz[0]= matriz;
                break;
            case "B":
                CalculoMatricial.matriz[1]= matriz;
                break;
            case "C":
                CalculoMatricial.matriz[2]= matriz;
                break;
            case "D":
                CalculoMatricial.matriz[3]= matriz;
                break;
            case "E":
                CalculoMatricial.matriz[4]= matriz;
                break;
            case "F":
                CalculoMatricial.matriz[5]= matriz;
                break;
            case "G":
                CalculoMatricial.matriz[6]= matriz;
                break;
            case "H":
                CalculoMatricial.matriz[7]= matriz;
                break;
            case "I":
                CalculoMatricial.matriz[8]= matriz;
                break;
            case "J":
                CalculoMatricial.matriz[9]= matriz;
                break;
            case "K":
                CalculoMatricial.matriz[10]= matriz;
                break;
            case "L":
                CalculoMatricial.matriz[11]= matriz;
                break;
            case "M":
                CalculoMatricial.matriz[12]= matriz;
                break;
            case "N":
                CalculoMatricial.matriz[13]= matriz;
                break;
            case "O":
                CalculoMatricial.matriz[14]= matriz;
                break;
            case "P":
                CalculoMatricial.matriz[15]= matriz;
                break;
            case "Q":
                CalculoMatricial.matriz[16]= matriz;
                break;
            case "R":
                CalculoMatricial.matriz[17]= matriz;
                break;
            case "S":
                CalculoMatricial.matriz[18]= matriz;
                break;
            case "T":
                CalculoMatricial.matriz[19]= matriz;
                break;
            case "U":
                CalculoMatricial.matriz[20]= matriz;
                break;
            case "V":
                CalculoMatricial.matriz[21]= matriz;
                break;
            case "W":
                CalculoMatricial.matriz[22]= matriz;
                break;
            case "X":
                CalculoMatricial.matriz[23]= matriz;
                break;
            case "Y":
                CalculoMatricial.matriz[24]= matriz;
                break;
            case "Z":
                CalculoMatricial.matriz[25]= matriz;
                break;
            default:
                System.out.println("No se ha podido determinar la posicion de una matriz");
                break;
        }
    }

}
