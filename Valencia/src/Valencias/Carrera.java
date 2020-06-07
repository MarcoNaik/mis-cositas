package Valencias;

import java.util.ArrayList;

public class Carrera {
    private final String name;
    private ArrayList<Alumno> arrayAlumnos = new ArrayList<Alumno>(0);

    public Carrera(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private ArrayList<Alumno> getArrayAlumnos() {
        return arrayAlumnos;
    }

    private int getAlumnosMatriculados() {
        if (this == null) return 0;
        return arrayAlumnos.size();
    }

    public boolean hasMoreAlumnosThan(Carrera c){
        if(c==null) return true;
        return getAlumnosMatriculados()>c.getAlumnosMatriculados();
    }

    public void addAlumno(Alumno a){
        getArrayAlumnos().add(a);
    }
    public void removeAlumno(Alumno a){
        getArrayAlumnos().remove(a);
    }

}
