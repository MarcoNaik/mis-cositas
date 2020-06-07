import java.util.Scanner;

public class Main {


    //Estructuras
    public static class Nodo{
        char  info;
        Nodo izq;
        Nodo der;
        public Nodo(char info, Nodo izq,Nodo der){
            this.info = info;
            this.izq = izq;
            this.der = der;
        }
    }
    public static class Pila{
        Nodo[] arreglo;
        int i=0;
        public void push(Nodo u){
            arreglo[i] = u;
            i++;
        }
        Nodo pop(){
            i--;
            return arreglo[i];
        }
        public Pila(int largo){
            this.arreglo = new Nodo[largo];
        }

    }
    public static class Cola{
        char[] arreglo = new char[999999];
        int primero = 0;
        int ultimo = -1;
        int cantidad =0;
        void enqueue(char u){
            ultimo = (ultimo+1)%999999;
            arreglo[ultimo] = u;
            cantidad++;
        }
        char dequeue(){
            if(cantidad != 0) {
                cantidad--;
                char aux = arreglo[primero];
                primero = (primero + 1)%999999;
                return aux;
            }
            return 'F';
        }
    }


    //Funciones

    //recibe un str y  lo retorna returna como un arreglo de char
    static char[] deStringACharArray(String recorrido){
        String[] arregloEnString  = recorrido.split(" ");
        String recorridoSinEspacios ="";
        for(String n:arregloEnString){
            recorridoSinEspacios +=n;
        }
        char[] arreglo=recorridoSinEspacios.toCharArray();
        return arreglo;
    }

    //recibe un str correspondiente al recorrido en postorden y retorna un puntero a la raiz del arbol correspondiente
    static Nodo generaArbol(String recorrido){
        char[] recorridoChar = deStringACharArray(recorrido);
        Pila pila = new Pila(recorridoChar.length);
        for (char n : recorridoChar){
            if ( n =='.') pila.push(null);
            else{
                Nodo derecho = pila.pop();
                Nodo izquierdo = pila.pop();
                Nodo nodo = new Nodo(n, izquierdo, derecho);
                pila.push(nodo);
            }
        }
        return pila.pop();
    }

    //recibe una raiz y una cola y agrega todos los info del arbol a la cola en preorden
    static Nodo agregarACola(Nodo raiz, Cola cola){
        if (raiz == null)cola.enqueue('.');
        else{
            cola.enqueue(raiz.info);
            agregarACola(raiz.izq,cola);
            agregarACola(raiz.der,cola);
        }
        return raiz;
    }


    static String generaPreorden(Nodo raiz){
        Cola cola = new Cola();
        agregarACola(raiz,cola);
        String preorden = "";
        while (cola.cantidad != 0){
            preorden += cola.dequeue();
            preorden += " ";
        }
        return preorden;
    }


    //Programa

    //recibe el input e imprime el output
    static void dePostordenAPreorden(){
        Scanner s = new Scanner(System.in);
        String postorden = s.nextLine();
        Nodo Arbol = generaArbol(postorden);
        String preorden = generaPreorden(Arbol);
        System.out.println(preorden);
    }

    public static void main(String[] args) {

        dePostordenAPreorden();
    }
}
