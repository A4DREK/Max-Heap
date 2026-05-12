public class Paciente <T extends Comparable<T>> {

    private String nombre, enfermedad;
    private int prioridad;

    public Paciente(String nombre, String enfermedad, int prioridad){
        this.nombre = nombre;
        this.enfermedad = enfermedad;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getEnfermedad(){
        return this.enfermedad;
    }

    public void setEnfermedad(String enfermedad){
        this.enfermedad = enfermedad;
    }

    public int getPrioridad(){
        return this.prioridad;
    }

    public void setPrioridad(int prioridad){
        this.prioridad = prioridad;
    }


    

}