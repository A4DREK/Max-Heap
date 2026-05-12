public class Paciente implements Comparable<Paciente> {

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

    @Override
    public int compareTo(Paciente compara){

        if(this.prioridad > compara.prioridad){
            return 1;
        }else if(this.prioridad < compara.prioridad){
            return -1;
        }
        return 0;

    }
    
    @Override
    public String toString(){
        return "|| Paciente: " + this.nombre + "|| \n"
                + "|| Enfermedad: " + this.enfermedad + "|| \n"
                + "|| Prioridad: " + this.prioridad + "|| \n"; 
    }

}