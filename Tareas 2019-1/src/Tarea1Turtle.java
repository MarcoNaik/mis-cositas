import java.util.Scanner;

public class Tarea1Turtle{
    static Turtle tortuga = new Turtle(960,540, 0 ,1920,1080);
    static int LMIN = 7;
    public static void curvaDeKoch(Turtle tortuga, int largo) {
        int L = largo;
            if (LMIN > L) tortuga.goForward(L);
            else {
                L=L/3;
                curvaDeKoch(tortuga, L);
                tortuga.turnLeft(60);
                curvaDeKoch(tortuga, L);
                tortuga.turnLeft(240);
                curvaDeKoch(tortuga, L);
                tortuga.turnLeft(60);
                curvaDeKoch(tortuga, L);
            }
    }

    public static void trianguloKoch(Turtle tortuga, int angulo){
        int Largo = 500;
        tortuga.turnLeft(angulo);
        curvaDeKoch(tortuga, Largo);
        tortuga.turnLeft(240);
        curvaDeKoch(tortuga, Largo);
        tortuga.turnLeft(240);
        curvaDeKoch(tortuga, Largo);



    }

    public static void main(String[] args) {

        Scanner A = new Scanner(System.in);
        System.out.println("Inserte un angulo");
        int x = A.nextInt();
        trianguloKoch(tortuga, x);
    }
}
