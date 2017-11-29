/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean.specificimplementation;

import Bean.genericimplementation.TableGenericBeanImplementation;
import com.google.gson.annotations.Expose;
import java.util.Date;


public class UsuarioSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose
    private String dni;
    @Expose
    private String nombre;
    @Expose
    private String primer_apellido;
    @Expose
    private String segundo_apellido;
    @Expose
    private String login;
    @Expose(serialize = false)
    private String pass;
    @Expose
    private String email;
    @Expose
    private Date fecha_nacimiento;
    @Expose(serialize = false)
    private Integer id_tipousuario = 0;
    @Expose(deserialize = false)
    private TipousuarioSpecificBeanImplementation obj_tipousuario = null;

    public UsuarioSpecificBeanImplementation() {
    }

    public UsuarioSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primerApellido) {
        this.primer_apellido = primerApellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundoApellido) {
        this.segundo_apellido = segundoApellido;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fechaNacimiento) {
        this.fecha_nacimiento = fechaNacimiento;
    }

    public Integer getId_tipousuario() {
        return id_tipousuario;
    }

    public void setId_tipousuario(Integer idTipousuario) {
        this.id_tipousuario = idTipousuario;
    }

}
