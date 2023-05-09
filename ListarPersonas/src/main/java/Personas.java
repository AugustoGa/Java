import java.util.ArrayList;

public class Personas {
    private String nombre;

    private String apellido;

    private final String[] nombres = {"Augusto", "Mili" , "Pau" , "Julian" , "Gonzalo"};

    private final String[] apellidos = {"Gallo", "Cabrera" , "Patinio" , "Merlo" , "Vita"};

    public Personas() {
        this.nombre = getRandom(nombres);
        this.apellido = getRandom(apellidos);
    }

    private String getRandom (String[]  listado){
        int randomIndex = (int) Math.round(Math.random() * (listado.length - 1));
                return listado[randomIndex];
    };

    public static ArrayList<Personas> sortPersona(ArrayList<Personas>Listado, String sortBy){
        switch (sortBy){
            case "nombre" -> Listado.sort(((o1, o2) -> o1.getNombre().compareTo(o2.getNombre())));
            case "apellido" -> Listado.sort((o1, o2) -> o1.getApellido().compareTo(o2.getApellido()));
            default -> {
            }
        }
        return Listado;
    }
    //toString = tipo de clase @ es el codigo hashcode
    @Override
    public String toString() {
        return "Personas{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personas personas = (Personas) o;

        if (!nombre.equals(personas.nombre)) return false;
        return apellido.equals(personas.apellido);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + apellido.hashCode();
        return result;
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
}
