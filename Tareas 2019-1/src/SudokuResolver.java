import java.util.Scanner;

public class SudokuResolver {


    static int[][][] SudokuCandidatos = new int[9][9][9];

    public static int[][] leerSudoku() {
        Scanner s = new Scanner(System.in);
        //matriz[fila][columna]
        int[][] matriz = new int[9][9];
        //como el input siempre es igual, leemos 9 lineas
        for (int i = 0; i < 9; i++) {
            //separamos cada linea en un arreglo de strings, con espacio como separador
            String[] linea = s.nextLine().split(" ");
            //leemos el arreglo de lineas
            for (int j = 0; j < linea.length; j++) {
                matriz[i][j] = Integer.parseInt(linea[j]); //para pasar de String a int
            }
        }
        s.close();
        return matriz;
    }

    static int[][] Sudoku;

    public static boolean estaEnFilasColumnas(int i, int j, int valor) {
        for (int k = 0; k < 9; k++) {

            if (Sudoku[i][k] == valor || Sudoku[k][j] == valor) return true;
        }
        return false;
    }

    public static boolean estaEnCaja(int i, int j, int valor) {
        int a = i - (i % 3);
        int b = j - (j % 3);
        for (int m = a; m < a + 3; m++) {
            for (int n = b; n < b + 3; n++) {
                if (Sudoku[m][n] == valor)
                    return true;
            }
        }
        return false;
    }

    //dice si un numero cumple con condiciones para estar en tal casilla
    public static boolean EstaBien(int i, int j, int valor) {
        return !(estaEnCaja(i, j, valor) || estaEnFilasColumnas(i, j, valor));

    }

    //saca todos los candidatos que estan en la misma fila columna o 3x3  de una casilla
    public static void LimpiarCandidatos(int m, int n) {
        int numero = Sudoku[m][n];
        if (numero != 0) {

            for (int k = 0; k < 9; k++) {                SudokuCandidatos[m][k][numero - 1] = 1; //cerramos ese candidato en cada fila y columna poniendo un 1
                SudokuCandidatos[k][n][numero - 1] = 1;
                SudokuCandidatos[m][n][k] = 1;// tambien cerramos todas las posibilidades de esa misma casilla ya que ya hay un numero en ella
            }

            int a = m - m % 3;
            int b = n - n % 3;
            for (int k = a; k < (a + 3); k++) {
                for (int p = b; p < (b + 3); p++) {
                    SudokuCandidatos[k][p][numero - 1] = 1;
                }
            }
        }
    }


    //recorre el sudoku limpiando candidatos
    public static void recorrerLimpiarCandidatos() {
        for (int m = 0; m < 9; m++) {
            for (int n = 0; n < 9; n++) {
                if (Sudoku[m][n] != 0) {
                    LimpiarCandidatos(m, n);
                }

            }
        }
    }


    //cuando solo tiene 1 candidato, lo pone en el sudoku final
    public static int rellenarEspacios() {

        int x = 0; //contador de veces que rellena  una casilla
        for (int m = 0; m < 9; m++) {
            for (int n = 0; n < 9; n++) {
               if (Sudoku[m][n]== 0){ //recorre el sudoku para casillas vacias
                   int aux = -1;
                   int contador = 0; // este contador verá cuantas candidatos abiertos hay

                   for (int i = 0; i < 9; i++) {
                       int candidato = SudokuCandidatos[m][n][i];
                       if (candidato == 0) { // ve si el candidato esta disponible (0) o no (1)
                           aux = i + 1; //reemplaza aux por el candidato
                           contador += 1;
                       }
                       if (contador ==2) break;
                   }
                   if (contador == 1) { //si hay solo un candidato posible
                       Sudoku[m][n] = aux;
                       x++;
                   }

               }

            }

        }
        return x;
    }


    //va sacando los candidatos posibles y rellenando el sudoku con el unico candidato posible, esto hasta que ya no hayan
//casillas con un solo candidato
    public static int RellenarYLimpiar() {

        int rellenadas= -1;
        int total = 0;

        while (rellenadas != 0) {
            recorrerLimpiarCandidatos();
            rellenadas = rellenarEspacios();
            total += rellenadas;
        }
        return total;

    }

    public static boolean backTracking() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int valorcasilla = Sudoku[i][j];
                if (valorcasilla == 0) {
                    for (int z=0; z<9; z++) {
                        if(SudokuCandidatos [i][j][z] ==0) {

                            if (EstaBien(i, j, z+1)) {
                                Sudoku[i][j] = z+1;
                                if (backTracking()) {
                                    return true;
                                } else {
                                    Sudoku[i][j] = 0;
                                }
                            }
                        }
                    }

                    return false;

                }

            }

        }

        return true;
    }

    public static void resolver() {
        RellenarYLimpiar();
        backTracking();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.println(Sudoku[i][j]);
            }
            System.out.println(" ");
        }
        System.out.println("ññ");

    }


    public static void main(String[] args) {
        Sudoku = leerSudoku();

       //PASO RELLENAR MATRIZ Y LIMPIAR MATRIZ DE CANDIDATOS//
        int operaciones = RellenarYLimpiar();


        //PASO BACKTRACKING UTILIZANDO CANDIDATOS
        backTracking();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(" " + Sudoku[i][j]);
            }
            System.out.println(" ");
        }
        System.out.println(operaciones);

    }
}
