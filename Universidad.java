import java.util.ArrayList;

public class Universidad {
    private ArrayList<Sede> sedes;

    public Universidad() {
        this.sedes = new ArrayList<>();
    }

    public void crearSede(String direccion) {
        Sede sede = new Sede(direccion);
        sedes.add(sede);
    }

    public Sede getSede(int index) {
        if (index >= 0 && index < sedes.size()) {
            return sedes.get(index);
        } else {
            return null;
        }
    }
}
