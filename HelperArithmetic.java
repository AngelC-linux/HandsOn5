/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handsOn5;

/**
 *
 * @author ANGEL
 */
public class HelperArithmetic {

    DataSet DS = new DataSet();

    double [][] aux = DS.getMatrizx();
    double [][] auy = DS.getMatrizy();

    double transpuesta[][];
    double producto[][];
    double inversa[][];

    public double[][] TranspuestaMatriz(double[][] matriz) {

        this.transpuesta = new double[matriz[0].length][matriz.length];

        for (int i = 0; i <= matriz[0].length - 1; i++) {

            for (int j = 0; j <= matriz.length - 1; j++) {

                transpuesta[i][j] = matriz[j][i];

            }

        }

        return transpuesta;

    }

    public void ProductoMatriz(double[][] matriz1, double[][] matriz2) {

        this.producto = new double[matriz1.length][matriz2[0].length];

        for (int x = 0; x <= matriz1.length - 1; x++) {

            for (int y = 0; y <= matriz2[0].length - 1; y++) {

                double n = 0;
                for (int c = 0; c <= matriz1[0].length - 1; c++) {

                    n = n + matriz1[x][c] * matriz2[c][y];

                }

                producto[x][y] = n;

            }

        }

    }

    public void InversaMatriz(double[][] matriz) {

        double inversa[][] = new double[matriz.length][matriz[0].length + 2];
        for (int i = 0; i <= matriz.length - 1; i++) {

            for (int j = 0; j <= matriz[0].length - 1; j++) {

                inversa[i][j] = matriz[i][j];

            }

        }

        inversa[0][3] = inversa[0][0];
        inversa[0][4] = inversa[0][1];

        inversa[1][3] = inversa[1][0];
        inversa[1][4] = inversa[1][1];

        inversa[2][3] = inversa[2][0];
        inversa[2][4] = inversa[2][1];

        double A, B, C, D, E, F;
        double determinante;

        A = inversa[0][0] * inversa[1][1] * inversa[2][2];
        B = inversa[0][1] * inversa[1][2] * inversa[2][3];
        C = inversa[0][2] * inversa[1][3] * inversa[2][4];

        D = inversa[0][4] * inversa[1][3] * inversa[2][2];
        E = inversa[0][3] * inversa[1][2] * inversa[2][1];
        F = inversa[0][2] * inversa[1][1] * inversa[2][0];

        determinante = (A + B + C - D - E - F);

        double TranspuestaAux[][] = new double[matriz[0].length][matriz.length];

        for (int i = 0; i <= matriz[0].length - 1; i++) {

            for (int j = 0; j <= matriz.length - 1; j++) {

                TranspuestaAux[i][j] = matriz[j][i];

            }

        }

        double adj[][] = new double[matriz.length][matriz[0].length];
        double aux[][] = new double[2][2];

        int AuxCorA = 0;
        int AuxCorB = 0;

        for (int h = 0; h <= 2; h++){

            for (int g = 0; g <= 2; g++){

                for (int m = 0; m <= 2; m++){

                    for (int n = 0; n <= 2; n++){

                        if (m != h && n != g){

                            if (AuxCorB <= 1){

                                aux[AuxCorA][AuxCorB] = TranspuestaAux[m][n];
                                AuxCorB++;
                                AuxCorA = 0;

                            }else{

                                AuxCorA++;
                                AuxCorB = 0;
                                aux[AuxCorA][AuxCorB] = TranspuestaAux[m][n];
                                AuxCorB++;

                            }

                        }

                    }

                }

                AuxCorA = 0;
                AuxCorB = 0;

                if (h == 0 && g == 0) {

                    adj[h][g] = (aux[0][0] * aux[1][1]) - (aux[0][1] * aux[1][0]);

                }

                if (h == 0 && g == 1) {

                    adj[h][g] = (-1) * ((aux[0][0] * aux[1][1]) - (aux[0][1] * aux[1][0]));

                }

                if (h == 0 && g == 2) {

                    adj[h][g] = (aux[0][0] * aux[1][1]) - (aux[0][1] * aux[1][0]);

                }

                if (h == 1 && g == 0) {

                    adj[h][g] = (-1) * ((aux[0][0] * aux[1][1]) - (aux[0][1] * aux[1][0]));

                }

                if (h == 1 && g == 1) {

                    adj[h][g] = (aux[0][0] * aux[1][1]) - (aux[0][1] * aux[1][0]);

                }

                if (h == 1 && g == 2) {

                    adj[h][g] = (-1) * ((aux[0][0] * aux[1][1]) - (aux[0][1] * aux[1][0]));

                }

                if (h == 2 && g == 0) {

                    adj[h][g] = (aux[0][0] * aux[1][1]) - (aux[0][1] * aux[1][0]);

                }

                if (h == 2 && g == 1) {

                    adj[h][g] = (-1) * ((aux[0][0] * aux[1][1]) - (aux[0][1] * aux[1][0]));

                }

                if (h == 2 && g == 2) {

                    adj[h][g] = (aux[0][0] * aux[1][1]) - (aux[0][1] * aux[1][0]);

                }

            }

        }

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                adj[i][j] = adj[i][j] / determinante;

            }

        }

        this.inversa = new double[adj.length][adj[0].length];

        for (int i = 0; i <= adj.length - 1; i++) {

            for (int j = 0; j <= adj[0].length - 1; j++) {

                this.inversa[i][j] = adj[i][j];

            }

        }

    }

    public boolean DoMLR(){

        TranspuestaMatriz(getMatrizX());
        ProductoMatriz(getTranspuesta(), getMatrizX());
        InversaMatriz(getProducto());
        ProductoMatriz(getTranspuesta(), getMatrizY());
        ProductoMatriz(getInversa(), getProducto());

        return true;

    }

    public double[][] getMatrizX() {

        return aux;

    }

    public double[][] getMatrizY() {

        return auy;

    }

    public double[][] getTranspuesta() {

        return transpuesta;

    }

    public double[][] getProducto() {

        return producto;

    }

    public double[][] getInversa() {

        return inversa;

    }

}
