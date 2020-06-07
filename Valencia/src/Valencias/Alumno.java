package Valencias;

public class Alumno {

    private String nombre;
    private String apellido;
    private String rut;
    private IBeca beca;
    private Universidad U;
    private Carrera carrera;


    public Alumno(String nombre, String apellido, String rut, IBeca beca, Universidad u, Carrera carrera) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.beca = beca;
        this.U = u;
        this.carrera = carrera;
    }



    private void setU(Universidad u) {
        U = u;
    }

    private void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    private Carrera getCarrera() {
        return carrera;
    }

    private String getRut() {
        return rut;
    }

    public String getName() {
        return nombre + " " + apellido;
    }

    private Universidad getU() {
        return U;
    }

    private String typeBeca() {
        return beca.type();
    }

    private IBeca getBeca() {
        return beca;
    }

    public void eliminarDeUniversidad(){
        getCarrera().removeAlumno(this);
        getU().removeAlumno(this);
    }

    public void cambioUniversidad(Universidad uDestino) {
        if (uDestino.quedanCuposDe(getBeca())) {
            eliminarDeUniversidad();
            return;
        }

        Carrera carreraDestino = uDestino.searchCarrera(getCarrera());

        if (carreraDestino == null){
            carreraDestino = new Carrera(getCarrera().getName());
            uDestino.addCarrera(carreraDestino);
        }

        carreraDestino.addAlumno(this);
        uDestino.addAlumno(this);

        eliminarDeUniversidad();

        setCarrera(carreraDestino);
        setU(uDestino);
    }

    public void cambioCarrera(String nombreCarreraDestino){
        Carrera carreradestino = getU().searchCarrera(nombreCarreraDestino);

        if (carreradestino == null){
            carreradestino = new Carrera(nombreCarreraDestino);
            getU().addCarrera(carreradestino);
        }

        carreradestino.addAlumno(this);

        getCarrera().removeAlumno(this);
        setCarrera(carreradestino);
    }

    public boolean hasRut(String rut) {
        return getRut().equals(rut);
    }

    public boolean hasBeca(String tipoDeBeca) {
        return typeBeca().equals(tipoDeBeca);
    }
}
