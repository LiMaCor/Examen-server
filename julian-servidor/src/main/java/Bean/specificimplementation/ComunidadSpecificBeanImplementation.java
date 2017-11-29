package Bean.specificimplementation;

import Bean.genericimplementation.TableGenericBeanImplementation;


public class ComunidadSpecificBeanImplementation extends TableGenericBeanImplementation {

    private String comunidad;

    public ComunidadSpecificBeanImplementation() {
    }

    public ComunidadSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }
    
}
