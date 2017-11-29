/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean.specificimplementation;

import Bean.genericimplementation.TableGenericBeanImplementation;
import java.util.Date;

/**
 *
 * @author Julian
 */

public class PacienteSpecificBeanImplementation extends TableGenericBeanImplementation {

    private String dni;
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String direccion;
    private String ciudad;
    private String codigo_postal;
    private String provincia;
    private String pais;
    private String email;
    private String telefono1;
    private String telefono2;
    private String nombre_padre;
    private String nombre_madre;
    private Date fecha_nacimiento;
    private String ciudad_nacimiento;
    private String pais_nacimiento;
    private String sip_aseguradora;
    private Integer id_tipopago;
    private Integer id_sexo;
    private Integer id_usuario;

    public PacienteSpecificBeanImplementation() {
    }

    public PacienteSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public PacienteSpecificBeanImplementation(Integer id, int idTipopago, int idSexo, int idUsuario) {
        this.id = id;
        this.id_tipopago = idTipopago;
        this.id_sexo = idSexo;
        this.id_usuario = idUsuario;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigoPostal) {
        this.codigo_postal = codigoPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getNombre_padre() {
        return nombre_padre;
    }

    public void setNombre_padre(String nombrePadre) {
        this.nombre_padre = nombrePadre;
    }

    public String getNombre_madre() {
        return nombre_madre;
    }

    public void setNombre_madre(String nombreMadre) {
        this.nombre_madre = nombreMadre;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fechaNacimiento) {
        this.fecha_nacimiento = fechaNacimiento;
    }

    public String getCiudad_nacimiento() {
        return ciudad_nacimiento;
    }

    public void setCiudad_nacimiento(String ciudadNacimiento) {
        this.ciudad_nacimiento = ciudadNacimiento;
    }

    public String getPais_nacimiento() {
        return pais_nacimiento;
    }

    public void setPais_nacimiento(String paisNacimiento) {
        this.pais_nacimiento = paisNacimiento;
    }

    public String getSip_aseguradora() {
        return sip_aseguradora;
    }

    public void setSip_aseguradora(String sipAseguradora) {
        this.sip_aseguradora = sipAseguradora;
    }

    public int getId_tipopago() {
        return id_tipopago;
    }

    public void setId_tipopago(int idTipopago) {
        this.id_tipopago = idTipopago;
    }

    public int getId_sexo() {
        return id_sexo;
    }

    public void setId_sexo(int idSexo) {
        this.id_sexo = idSexo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int idUsuario) {
        this.id_usuario = idUsuario;
    }
    
}
