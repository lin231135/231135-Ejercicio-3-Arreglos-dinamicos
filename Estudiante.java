import java.util.ArrayList;

public class Estudiante {

    private String nombre;
    private String apellido;
    private int codigo;
    private String fechaNacimiento;
    private String correoElectronico;
    private ArrayList<Examen> examenes = new ArrayList<>();

    public Estudiante(String nombre, String apellido, int codigo, String fechaNacimiento, String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public ArrayList<Examen> getExamenes() {
        return examenes;
    }

    public void agregarExamen(Examen examen) {
        examenes.add(examen);
    }

    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", apellido=" + apellido + ", codigo=" + codigo + ", fechaNacimiento="
                + fechaNacimiento + ", correoElectronico=" + correoElectronico + ", examenes=" + examenes + "]";
    }
}
