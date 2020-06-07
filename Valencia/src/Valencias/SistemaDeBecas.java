package Valencias;

import java.util.ArrayList;

public class SistemaDeBecas {

    public SistemaDeBecas(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    private ArrayList<Universidad> arrayUniversidades = new ArrayList<Universidad>(0);

    private static IBeca Alta = new BecaAlta(50000, 10);
    private static IBeca Normal = new BecaNormal(40000, 20);
    private static IBeca Basica = new BecaBasica(32000, 30);

    private IBeca stringToAnIBeca(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "normal" -> Normal;
            case "alta" -> Alta;
            case "basica" -> Basica;
            default -> Normal;
        };
    }

    public ArrayList<Universidad> getArrayUniversidades() {
        return arrayUniversidades;
    }

    private Universidad searchUniversidad(String nombreUniversidad) {

        for (Universidad u : arrayUniversidades) {
            if (u.getName().equals(nombreUniversidad)) return u;
        }
        System.out.println("La Universidad " + nombreUniversidad + " no está registrada en el sistema \n");
        return null;
    }


    //COMANDOS PARA MODIFICAR BECAS
    public void setCupoTo(String becaStr, int cupo) {
        IBeca beca = stringToAnIBeca(becaStr);
        beca.setCupo(cupo);
    }

    public void setMontoTo(String becaStr, int monto) {
        IBeca beca = stringToAnIBeca(becaStr);
        beca.setMonto(monto);
    }


    //COMANDOS PARA AGREGAR O REMOVER CARRERAS UNIVERSIDAD O ALUMNOS DEL SISTEMA
    public void addUniversidad(String nombreUniversidad) {
        arrayUniversidades.add(new Universidad(nombreUniversidad));
        System.out.println("La Universidad " + nombreUniversidad + " ha sido agregada al sistema de manera exitosa.\n");
    }

    public void removedUniversidad(String nombreUniversidad) {
        Universidad u = searchUniversidad(nombreUniversidad);
        if (u== null) return;

        arrayUniversidades.remove(searchUniversidad(nombreUniversidad));
        System.out.println("La Universidad " + nombreUniversidad + " ha sido agregada al sistema de manera exitosa.\n");
    }

    public void addCarrera(String nombreUniversidad, String nombreCarrera) {
        Universidad u = searchUniversidad(nombreUniversidad);
        if (u==null) return;

        u.addCarrera(new Carrera(nombreCarrera));
        System.out.println("La carrera " + nombreCarrera + " de la universidad " + nombreUniversidad + " ha sido agregada al sistema de manera exitosa.\n");
    }

    public void removeCarrera(String nombreUniversidad, String nombreCarrera) {

        Universidad u = searchUniversidad(nombreUniversidad);
        if (u==null) return;
        Carrera c = u.searchCarrera(nombreCarrera);
        if (c==null) return;

        u.removeCarrera(c);
        System.out.println("La carrera " + nombreCarrera + " de la universidad " + nombreUniversidad + " ha sido eliminada del sistema de manera exitosa.\n");
    }

    public void addAlumno(String nombre, String apellido, String rut, String tipobeca, String u, String carrera) {
        IBeca suBeca = stringToAnIBeca(tipobeca);
        Universidad suUniversidad = searchUniversidad(u);
        if (suUniversidad == null) return;

        Carrera suCarrera = suUniversidad.searchCarrera(carrera);
        if (suCarrera == null) return;

        if (suUniversidad.quedanCuposDe(suBeca)) {
            System.out.println("no quedan cupos en esa beca");
            return;

        }

        Alumno a = new Alumno(nombre, apellido, rut, suBeca, suUniversidad, suCarrera);
        suUniversidad.addAlumno(a);
        suCarrera.addAlumno(a);

        System.out.println(nombre + " " + apellido + " ha sido agregadx al sistema de manera exitosa.\n");
    }

    public void removeAlumno(String rut) {
        Alumno foundAlumno = null;
        for (Universidad u : arrayUniversidades) {
            foundAlumno = u.searchAlumno(rut);
            if (foundAlumno != null) {

                foundAlumno.eliminarDeUniversidad();

                System.out.println(foundAlumno.getName() + " ha sido elminadx del sistema de manera exitosa.\n");
                return;
            }
        }

        System.out.println("No se enontró al alumne en la wea");



    }



    //stats

    private void displayBecadosAt(Universidad universidad) {
        System.out.println("Alunmos becados en " + universidad.getName() + ":");
        universidad.displayAlumnosNames();
        System.out.println();
    }

    private Universidad universidadMasBecada(){
        Universidad masBecada = null;
        int matriculas = 0;

        for (Universidad u : arrayUniversidades) {
            if (u.getAlumnosMatriculados() > matriculas) {
                matriculas = u.getAlumnosMatriculados();
                masBecada = u;
            }
        }
        if (matriculas == 0) {
            return null;
        }
        return masBecada;
    }


    //COMANDOS

    public void displayBecados() {
        for (Universidad i : arrayUniversidades) {
            displayBecadosAt(i);
        }
    }

    public void displayBecadosEn(String nombreUniversidad) {
        Universidad universidad = searchUniversidad(nombreUniversidad);
        displayBecadosAt(universidad);

    }
    /*
        Alunmos becados en UCN:
        Brayan Valencia

        Alunmos becados en UCH:
        Marco Gómez
    */


    public void displayUniversidadesByBeca() {

        for (Universidad u : arrayUniversidades) {
            if (u.getAlumnosMatriculados() > 0) {
                System.out.println(u.getName() + " : " + u.getAlumnosMatriculados() + " Alumnos Becados");
                System.out.println("Beca Basica: " + u.alumnosCon("basica"));
                System.out.println("Beca Normal: " + u.alumnosCon("normal"));
                System.out.println("Beca Alta: " + u.alumnosCon("alta"));
                System.out.println();
            }
            else System.out.println(u.getAlumnosMatriculados());
        }
    }
     /*
        UA : 10 Alumnos Becados
        Beca Basica: 5
        Beca Normal: 3
        Beca Alta: 2

        UCN : 7 Alumnos Becados
        Beca Basica: 2
        Beca Normal: 4
        Beca Alta: 1
    */

    public void displayUniversidadMasBecada() {
        Universidad masBecada = universidadMasBecada();

        if (masBecada == null) {
            System.out.println("No hay alumnes becades en ninguna universidad");
            return;
        }

        System.out.println("La universidad con más alumnes becades es " + masBecada.getName() + " con " + masBecada.getAlumnosMatriculados() + " alumnes becades"  + "\n");

    }
    // La universidad con más alumnes becades es UA con 1 alumnes becades"


    public void displayCarreraMasBecada() {
        Carrera carreraMasBecada = null;
        Universidad universidadDeLaCarrera = null;
        Carrera carreraPibote;

        for (Universidad u : arrayUniversidades) {
            carreraPibote = u.carreraMasBecada();
            if (carreraPibote.hasMoreAlumnosThan(carreraMasBecada)) {
                carreraMasBecada = carreraPibote;
                universidadDeLaCarrera = u;
            }
        }
        System.out.println("La carrera con más alumnes becades es " + carreraMasBecada.getName() + " de la universidad " + universidadDeLaCarrera.getName() + "\n");
    }
    // La carrera con más alumnes becades es derecho de la universidad UCN


    public void displayCantidadBecadosPorBeca(String tipodebeca) {
        int becados = 0;
        for (Universidad u : arrayUniversidades) {
            becados += u.alumnosCon(tipodebeca);
        }
        System.out.println("la cantidad de alumnes con becas del tipo " + tipodebeca + " son :" + becados + "\n");

    }
    // la cantidad de alumnes con becas del tipo alta son : 3

}
