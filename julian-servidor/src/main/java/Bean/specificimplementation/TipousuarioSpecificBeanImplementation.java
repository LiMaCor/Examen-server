/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean.specificimplementation;

import Bean.genericimplementation.TableGenericBeanImplementation;
import com.google.gson.annotations.Expose;


public class TipousuarioSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose
    private String descripcion;

    public TipousuarioSpecificBeanImplementation() {
    }

    public TipousuarioSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
