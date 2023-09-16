public class Examen{

    private String materia;
    private Float nota;
    
    public Examen(String materia, Float nota) {
        this.materia = materia;
        this.nota = nota;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Examen [materia=" + materia + ", nota=" + nota + "]";
    }
}