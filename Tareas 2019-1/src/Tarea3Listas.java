import java.util.Scanner;

public class Tarea3Listas {

    //Estructuras de datos
    public static class Nodo{
        int info;
        Lista apunta;
        public Nodo(int curso, Lista esRequisitoDe){
            this.info = curso;
            this.apunta = esRequisitoDe;
        }
    }

    static class Lista{

        Nodo cabeza;
        Lista cola;

        public Lista(Nodo nodo){
            this.cabeza = nodo;
            this.cola = null;
        }
        public Lista(Nodo nodo, Lista cola){
            this.cabeza = nodo;
            this.cola = cola;
        }

    }

    //Métodos

    //retorna un puntero al Nodo que posee info i en la Lista
    static Nodo buscarEn(int i, Lista lista){
        Lista puntero = lista;
        while(puntero != null) {
            if (puntero.cabeza.info == i) return puntero.cabeza;
            puntero=puntero.cola;
        }
        return null;
    }

    //retorna un puntero al Nodo que posee info i en el arreglo de Listas
    static Nodo buscarEnArreglo(int target, Lista[] arreglo) {
        for (int i=0; i<arreglo.length ; i++){
            Nodo encontrado = buscarEn(target,arreglo[i]);
            if (encontrado!=null)return encontrado;
        }
        return null;
    }

    //retorna un puntero a "lista" sin "nodo"
    static Lista eliminarNodoDeLista(Nodo nodo, Lista lista){
        //si en la cabeza de la lista
        if(lista.cabeza == nodo)return lista.cola;

        //si esta en la cola
        Lista puntero = lista;
        while(puntero.cola!= null) {
            if (puntero.cola.cabeza == nodo){
                puntero.cola=puntero.cola.cola;
                return lista;
            }
            puntero=puntero.cola;
        }
        return null;



    }

    //retorna un puntero a "lista" con "nodo" al principio de ella
    static Lista agregarNodoALista(Nodo nodo, Lista lista) {return new Lista(nodo, lista);}

    //retorna el true si esta "nodo" en  "lista", si no false
    static boolean estaEnLista(Nodo nodo, Lista lista){
        Lista puntero =lista;
        while (puntero !=null){
            if (puntero.cabeza==nodo)return true;
            puntero=puntero.cola;
        }
        return false;


    }

    //retorna en que posicion del arreglo se encuentra la Lista que contiene a "nodo"
    static int numeroDelArregloEnQueEsta(Nodo nodo, Lista[] arreglo){
         //usar funcion booleana y un for
        for(int i=0; i<arreglo.length;i++){
            if (estaEnLista(nodo,arreglo[i]))return i;
        }
        return -99999;
    }

    //elimina el ultimo Nodo de la lista "Arreglo[indice]" de un arreglo de Listas y lo retorna
    static Nodo sacarUltimoDeLista(Lista[] Arreglo, int indice){
        Lista lista = Arreglo[indice];
        //si hay solo un nodo en la lista
        if (lista.cola == null){
            Nodo ultimo = lista.cabeza;
            Arreglo[indice] = null;
            return ultimo;
        }

        Lista puntero = lista;
        while(puntero.cola.cola != null){
            puntero = puntero.cola;
        }
        Nodo ultimo = puntero.cola.cabeza;
        puntero.cola = null;
        return ultimo;

        //usar eliminarNodoDeLista al final

    }

    //elimina el ultimo Nodo de la lista "nodo.apunta" que son a quienes apunta un nodo en el "grafico" y lo retorna
    static Nodo sacarUltimoDeRequisitos(Nodo nodo){
        Lista lista = nodo.apunta;
        //si hay solo un nodo en la lista
        if (lista.cola == null){
            Nodo ultimo = lista.cabeza;
            nodo.apunta = null;
            return ultimo;
        }

        Lista puntero = lista;
        while(puntero.cola.cola != null){
            puntero = puntero.cola;
        }
        Nodo ultimo = puntero.cola.cabeza;
        puntero.cola = null;
        return ultimo;

        //usar eliminarNodoDeLista al final

    }

    //elimina el ultimo valor del arreglo[0] y lo retorna
    static Nodo sacarUltimoDeArreglo0(Lista[] Arreglo){
        return sacarUltimoDeLista(Arreglo,0);
    }


    //Paso 1

    public static Lista[] Arreglo(){
        Scanner s = new Scanner(System.in);
        int cantidadCursos = Integer.parseInt(s.nextLine());
        Lista[] Arreglo= new Lista[cantidadCursos];
        Lista NodosLibres = null;

        for (int i=0; i<cantidadCursos;i++){
            String[] cursos = s.nextLine().split(" ");

            //primer digito, osea el curso
            int curso = Integer.parseInt(cursos[0]);

            Nodo NodoCurso = buscarEn(curso, NodosLibres);
            //si el nodo estaba en nodoslibres
            if (NodoCurso != null){
                NodosLibres = eliminarNodoDeLista(NodoCurso, NodosLibres);
                //sacarlo de la lista de nodos libres
                //y ponerlo en el arreglo en la posicion del largo de cursos-1
            }
            else{
                NodoCurso = new Nodo(curso,null);
                //poner al final de la lista del arreglo[en la pos de largo cursos-1] el nodo con info curso
            }
            Arreglo[cursos.length - 1] = agregarNodoALista(NodoCurso, Arreglo[cursos.length - 1]);

            //requisitos del curso
            for(int j=1; j<cursos.length;j++){
                int requisito = Integer.parseInt(cursos[j]);
                Nodo enLibres = buscarEn(requisito,NodosLibres);
                Nodo enArreglo = buscarEnArreglo(requisito, Arreglo);

                //si no estaba ni en libres ni en el arreglo
                if (enLibres==null && enArreglo == null){
                    // crear nodo
                    //agregar curso a sus requeridos
                    Nodo nodoRequerido = new Nodo(requisito, new Lista(NodoCurso));
                    // meterlo a nodoslibres
                    NodosLibres = agregarNodoALista(nodoRequerido, NodosLibres);
                }
                //si estaba en el arreglo
                else if (enArreglo != null){
                    //agregar curso a sus requeridos
                    enArreglo.apunta = agregarNodoALista(NodoCurso,enArreglo.apunta);
                }
                else
                    //si el nodo ya estaba en nodos libres, solo agrega curso actual a su lista de requeridos
                    enLibres.apunta = agregarNodoALista(NodoCurso,enLibres.apunta);
            }
/*
            if(NodosLibres != null){
                Lista puntero =NodosLibres;
                while (puntero!=null){
                    System.out.println(puntero.cabeza.info);
                    puntero=puntero.cola;
                }
            }
            else System.out.println("null");
            System.out.println(" ");
*/
        }


        return Arreglo;

    }

    //Paso 2

    public static void Imprimir(Lista[] arreglo){

        while(arreglo[0] != null){
            Nodo curso = sacarUltimoDeArreglo0(arreglo);
            System.out.println(curso.info);
            while(curso.apunta != null){
                Nodo esreq = sacarUltimoDeRequisitos(curso);

                int n= numeroDelArregloEnQueEsta(esreq,arreglo);
                //sacarlo de arreglo[n]
                arreglo[n]= eliminarNodoDeLista(esreq, arreglo[n]);
                //dejarlo en arreglo [n-1]
                arreglo[n-1] = agregarNodoALista(esreq, arreglo[n-1]);
            }

        }
    }




    public static void main(String[] args) {
        Imprimir(Arreglo());
    }
}
