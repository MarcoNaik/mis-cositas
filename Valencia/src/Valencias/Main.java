package Valencias;

public class Main {


        public static void main(String[] args) {

            SistemaDeBecas Junaeb = new SistemaDeBecas("Junaeb");



            Junaeb.addUniversidad("UCH");
            Junaeb.addCarrera("UCH", "CARRERACULIAXD");

            Junaeb.addUniversidad("UCN");
            Junaeb.addCarrera("UCN", "CARRERITA1");
            Junaeb.addCarrera("UCN", "CARRERITA2");
            Junaeb.addCarrera("UCN", "CARRERITA3");

            Junaeb.addAlumno("marco", "gomez", "20212043-1",  "alta" ,"UCH","CARRERACULIAXD");
            Junaeb.addAlumno("marcoxd", "gomez", "20312044-1",  "basica" ,"UCH","CARRERACULIAXD");
            Junaeb.addAlumno("marcolol", "gomez", "20412044-1",  "basica" ,"UCH","CARRERACULIAXD");
            Junaeb.addAlumno("marco1", "gomez", "20512044-1",  "basica" ,"UCH","CARRERACULIAXD");
            Junaeb.addAlumno("marco2", "gomez", "20612045-1",  "basica" ,"UCN","CARRERITA1");
            Junaeb.addAlumno("marco3", "gomez", "20712046-1",  "normal" ,"UCN","CARRERITA1");
            Junaeb.addAlumno("marco4", "gomez", "20812045-1",  "alta" ,"UCN","CARRERITA2");
            Junaeb.addAlumno("marco5", "gomez", "20912046-1",  "normal" ,"UCN","CARRERITA3");
            Junaeb.addAlumno("marco6", "gomez", "20282045-1",  "alta" ,"UCN","CARRERITA2");
            Junaeb.addAlumno("marco7", "gomez", "20252046-1",  "normal" ,"UCN","CARRERITA1");



            Junaeb.displayBecados();
            Junaeb.displayUniversidadesByBeca();
            Junaeb.displayBecadosEn("UCH");
            Junaeb.displayUniversidadMasBecada();
            Junaeb.displayCarreraMasBecada();
            Junaeb.displayCantidadBecadosPorBeca("alta");
            Junaeb.displayCantidadBecadosPorBeca("normal");
            Junaeb.displayCantidadBecadosPorBeca("basica");

            Junaeb.removeAlumno("20212043-1");



        }
}
