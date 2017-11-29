/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean.specificimplementation;

import Bean.genericimplementation.TableGenericBeanImplementation;

public class NombremasculinoSpecificBeanImplementation extends TableGenericBeanImplementation {

    private String nombre;

    public NombremasculinoSpecificBeanImplementation() {
    }

    public NombremasculinoSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
