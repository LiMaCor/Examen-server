package Bean.specificimplementation;

import Bean.genericimplementation.TableGenericBeanImplementation;


public class ApellidoSpecificBeanImplementation extends TableGenericBeanImplementation {

    private String apellido;

    public ApellidoSpecificBeanImplementation() {
    }

    public ApellidoSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
}
