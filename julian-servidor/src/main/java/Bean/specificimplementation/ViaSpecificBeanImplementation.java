/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean.specificimplementation;

import Bean.genericimplementation.TableGenericBeanImplementation;


public class ViaSpecificBeanImplementation extends TableGenericBeanImplementation {

    private String via;

    public ViaSpecificBeanImplementation() {
    }

    public ViaSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public ViaSpecificBeanImplementation(Integer id, String via) {
        this.id = id;
        this.via = via;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

}
