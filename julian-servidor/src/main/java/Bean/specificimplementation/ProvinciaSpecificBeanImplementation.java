/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean.specificimplementation;

import Bean.genericimplementation.TableGenericBeanImplementation;


public class ProvinciaSpecificBeanImplementation extends TableGenericBeanImplementation {

    private String provincia;

    public ProvinciaSpecificBeanImplementation() {
    }

    public ProvinciaSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
 
}
