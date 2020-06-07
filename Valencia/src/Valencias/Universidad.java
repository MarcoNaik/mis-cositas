package Valencias;

import java.util.ArrayList;

public class Universidad {

    private final String name;
    public Universidad(String nombre) {
        this.name = nombre;
    }

    private ArrayList<Alumno> arrayAlumnos = new ArrayList<Alumno>(0);
    private ArrayList<Carrera> arrayCarreras = new ArrayList<Carrera>(0);

    private ArrayList<Alumno> getArrayAlumnos() {
        return arrayAlumnos;
    }
    private ArrayList<Carrera> getArrayCarreras() {
        return arrayCarreras;
    }

    public int getAlumnosMatriculados() {
        return arrayAlumnos.size();
    }
    public String getName() {
        return name;
    }

    public void displayAlumnosNames(){
        for (Alumno alumno:getArrayAlumnos()){
            System.out.println(alumno.getName());
        }
    }

    public Carrera carreraMasBecada(){
        Carrera carreraMax = null;

        for (Carrera c : getArrayCarreras()){
            if (c.hasMoreAlumnosThan(carreraMax)) {
                carreraMax = c;
            }
        }
        return carreraMax;
    }


    public int alumnosCon(String tipoDeBeca) {
        int contador = 0;
        for (Alumno alumno : arrayAlumnos) {
            if (alumno.hasBeca(tipoDeBeca)) contador++;
        }
        return contador;
    }

    public Carrera searchCarrera(String nombreCarrera){
        for (Carrera c : arrayCarreras) {
            if (c.getName().equals(nombreCarrera)) {
                return c;
            }
        }
        System.out.println("La carrera " + nombreCarrera + " no está registrada en el sistema");
        return null;
    }
    public Carrera searchCarrera(Carrera targetCarrera){

        for (Carrera c : arrayCarreras) {
            if (c.equals(targetCarrera)) {
                return c;
            }
        }
        System.out.println("La carrera " + targetCarrera.getName() + " no está registrada en el sistema");
        return null;
    }

    public Alumno searchAlumno(String rut){
        for (Alumno a : getArrayAlumnos()){
            if (a.hasRut(rut)){
                return a;
            }
        }
        return null;
    }

    public void addCarrera(Carrera c){
        getArrayCarreras().add(c);
    }
    public void addAlumno(Alumno a){
        arrayAlumnos.add(a);
    }

    public void removeCarrera(Carrera c) {
        getArrayCarreras().remove(c);
        System.out.println("La carrera " + c.getName() + " de la universidad " + getName() + " ha sido eliminada del sistema de manera exitosa.\n");
    }
    public void removeAlumno(Alumno alumno) {
        getArrayAlumnos().remove(alumno);
    }

    public boolean quedanCuposDe(IBeca becaa) {
        return (getAlumnosMatriculados() == becaa.getCupo());
    }


}