package Service.specificimplementation;

import Bean.ReplyBean;
import Bean.genericimplementation.ViewGenericBeanImplementation;
import Bean.specificimplementation.PacienteSpecificBeanImplementation;
import Bean.specificimplementation.UsuarioSpecificBeanImplementation;
import Connection.ConnectionInterface;
import Dao.specificimplementation.ApellidoSpecificDaoImplementation;
import Dao.specificimplementation.ComunidadSpecificDaoImplementation;
import Dao.specificimplementation.MunicipioSpecificDaoImplementation;
import Dao.specificimplementation.NombrefemeninoSpecificDaoImplementation;
import Dao.specificimplementation.NombremasculinoSpecificDaoImplementation;
import Dao.specificimplementation.PacienteSpecificDaoImplementation;
import Dao.specificimplementation.ProvinciaSpecificDaoImplementation;
import Dao.specificimplementation.ViaSpecificDaoImplementation;
import Helper.AppConfigurationHelper;
import Helper.Log4jConfigurationHelper;
import Service.genericimplementation.GenericTableService;
import com.google.gson.Gson;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Julian
 */
public class PacienteSpecificServiceImplementation extends GenericTableService {

    public PacienteSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }

    public ReplyBean cuenta() throws Exception {
        return this.getCount();
    }

    public ReplyBean vacia() throws Exception {
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        ReplyBean oReplyBean = null;
        try {
            oPooledConnection = AppConfigurationHelper.getSourceConnection();
            oConnection = oPooledConnection.newConnection();
            PacienteSpecificDaoImplementation oDao = new PacienteSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
            Integer resultado = oDao.vacia();
            if (resultado > 0) {
                oReplyBean = new ReplyBean(200, "OK");
            } else {
                oReplyBean = new ReplyBean(500, "Error de Conexion");
            }
            Gson oGson = AppConfigurationHelper.getGson();
            String strJson = oGson.toJson(resultado);
            oReplyBean = new ReplyBean(200, strJson);
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jConfigurationHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oConnection != null) {
                oConnection.close();
            }
            if (oPooledConnection != null) {
                oPooledConnection.disposeConnection();
            }
        }

        return oReplyBean;
    }

    public ReplyBean rellenar() throws Exception {
        int numReg = Integer.parseInt(oRequest.getParameter("num"));
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        ReplyBean oReplyBean = null;
        PacienteSpecificBeanImplementation oBean = new PacienteSpecificBeanImplementation();
        try {
            oPooledConnection = AppConfigurationHelper.getSourceConnection();
            oConnection = oPooledConnection.newConnection();
            PacienteSpecificDaoImplementation oDao = new PacienteSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
            for (int i = 1; i <= numReg; i++) {

                //Dni
                oBean.setDni("29210979J");

                //Sexo
                Random random_sexo = new Random();
                int sexo = random_sexo.nextInt(2) + 1;

                if (sexo == 1) {
                    Random random_nombre_male = new Random();
                    int numnombremasculino = random_nombre_male.nextInt(1177) + 1;
                    NombremasculinoSpecificDaoImplementation oNombremasculinoDao = new NombremasculinoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                    oBean.setNombre(oNombremasculinoDao.getNombre(numnombremasculino));
                } else {
                    Random random_nombre_female = new Random();
                    int numnombrefemenino = random_nombre_female.nextInt(1313) + 1;
                    NombrefemeninoSpecificDaoImplementation oNombrefemeninoDao = new NombrefemeninoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                    oBean.setNombre(oNombrefemeninoDao.getNombre(numnombrefemenino));
                }
                //Apellido 1
                Random random_apellido1 = new Random();
                int num_apellido1 = random_apellido1.nextInt(7662) + 1;

                ApellidoSpecificDaoImplementation oApellidoDao1 = new ApellidoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                oBean.setPrimer_apellido(oApellidoDao1.getNombre(num_apellido1));

                //Apellido 2               
                Random random_apellido2 = new Random();
                int num_apellido2 = random_apellido2.nextInt(7662) + 1;

                ApellidoSpecificDaoImplementation oApellidoDao2 = new ApellidoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                oBean.setSegundo_apellido(oApellidoDao2.getNombre(num_apellido2));

                //Direccion
                Random random_direccion = new Random();
                int num_via = random_direccion.nextInt(3) + 1;

                ViaSpecificDaoImplementation oViaDao = new ViaSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);

                String nombre_direccion = "";
                if (sexo == 1) {
                    Random random_nombre_male = new Random();
                    int numnombremasculino = random_nombre_male.nextInt(1177) + 1;

                    NombremasculinoSpecificDaoImplementation oNombremasculinoDao = new NombremasculinoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                    nombre_direccion = oNombremasculinoDao.getNombre(numnombremasculino);
                } else {
                    Random random_nombre_female = new Random();
                    int numnombrefemenino = random_nombre_female.nextInt(1313) + 1;

                    NombrefemeninoSpecificDaoImplementation oNombrefemeninoDao = new NombrefemeninoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                    nombre_direccion = oNombrefemeninoDao.getNombre(numnombrefemenino);
                }

                Random random_apellido3 = new Random();
                int num_apellido3 = random_apellido3.nextInt(7662) + 1;

                String apellido_direccion = oApellidoDao1.getNombre(num_apellido3);

                String Direccion = oViaDao.getNombre(num_via) + " de" + " " + nombre_direccion + " " + apellido_direccion;
                oBean.setDireccion(Direccion);

                //Municipio
                Random random_municipio = new Random();
                int num_municipio = random_municipio.nextInt(8926) + 1;
                
                MunicipioSpecificDaoImplementation oMunicipioDao = new MunicipioSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                
                String municipio = oMunicipioDao.getNombre(num_municipio);
                oBean.setCiudad(municipio);
                
                //Codigo Postal
                Long num_random_codpostal = (long) Math.floor(Math.random() * 1000);
                oBean.setCodigo_postal("46" + num_random_codpostal);
                
                //Provincia
                ProvinciaSpecificDaoImplementation oProvinciaDao = new ProvinciaSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                ComunidadSpecificDaoImplementation oComunidadDao = new ComunidadSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                
                int idProvincia = oMunicipioDao.getIdProvincia(municipio);
                int idComunidad = oMunicipioDao.getIdComunidad(municipio);
                
                String comunidad = oComunidadDao.getNombre(idComunidad);
                String provincia = oProvinciaDao.getNombre(idProvincia) + " " + "(" + comunidad + ")";
                oBean.setProvincia(provincia);
                
                //Pais
                oBean.setPais("España");

                //Email
                String email = oBean.getNombre().substring(0, 2) +
                        oBean.getPrimer_apellido().substring(0, 2) +
                        oBean.getSegundo_apellido().substring(0, 2) +
                        "@" + oBean.getPrimer_apellido() + ".es";
                oBean.setEmail(email);

                //Telefono 1
                Long num_telefono1 = (long) Math.floor(Math.random() * 10000000);
                Long num_telefono_random = (long) Math.floor(Math.random() * 3);
                if (num_telefono_random == 1) {
                    oBean.setTelefono1("64" + num_telefono1);
                } else {
                    oBean.setTelefono1("62" + num_telefono1);
                }
                
                //Telefono 2
                Long num_telefono2 = (long) Math.floor(Math.random() * 10000000);
                Long num_telefono_random2 = (long) Math.floor(Math.random() * 3);
                if (num_telefono_random2 == 1 && (oBean.getTelefono1() != ("64" + num_telefono2))) {
                    oBean.setTelefono2("64" + num_telefono2);
                } else {
                    oBean.setTelefono2("62" + num_telefono2);
                }
                
                //Nombre Padre
                Random random_nombrePadre = new Random();
                int num_padre = random_nombrePadre.nextInt(1004) + 1;
                
                NombremasculinoSpecificDaoImplementation oNombremasculinoDao = new NombremasculinoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                String nombrePadre = oNombremasculinoDao.getNombre(num_padre);
                oBean.setNombre_padre(nombrePadre);
                
                //Nombre Madre
                Random random_nombreMadre = new Random();
                int num_madre = random_nombreMadre.nextInt(1330) + 1;
                
                NombrefemeninoSpecificDaoImplementation oNombrefemeninoDao = new NombrefemeninoSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
                String nombreMadre = oNombrefemeninoDao.getNombre(num_madre);
                oBean.setNombre_madre(nombreMadre);
                
                //Fecha Nacimiento
                Date startDate = new GregorianCalendar(1945, Calendar.JANUARY, 1).getTime();
                Date endDate = new GregorianCalendar(2015, Calendar.JANUARY, 1).getTime();
                long random = ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime());
                Date date = new Date(random);
                oBean.setFecha_nacimiento(date);
                
                //Ciudad Nacimiento
                String ciudadNacimiento;
                
                num_municipio = random_municipio.nextInt(2255) + 1;
                municipio = oMunicipioDao.getNombre(num_municipio);
                idProvincia = oMunicipioDao.getIdProvincia(municipio);
                provincia = oProvinciaDao.getNombre(idProvincia);
                
                ciudadNacimiento = municipio + " " + "(" + provincia + ")";
                oBean.setCiudad_nacimiento(ciudadNacimiento);
                
                //Pais Nacimiento
                oBean.setPais_nacimiento("España");

                //Sip Aseguradora
                Long numRAseg = (long) Math.floor(Math.random() * (10 - 1 + 1) + 1);
                String strSIP = Long.toString(numRAseg);
                oBean.setSip_aseguradora(strSIP);
                
                //Id Tipo Pago
                Random random_num_tipopago = new Random();
                int num_tipopago = random_num_tipopago.nextInt(5) + 1;
                oBean.setId_tipopago(num_tipopago);
                
                //Id Sexo
                oBean.setId_sexo(sexo);
                
                //Id Paciente
                oBean.setId_usuario(1);

                //Crea Paciente
                oDao.set(oBean);
            }
            Gson oGson = AppConfigurationHelper.getGson();
            String strJson = oGson.toJson(numReg);
            oReplyBean = new ReplyBean(200, strJson);

        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jConfigurationHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oConnection != null) {
                oConnection.close();
            }
            if (oPooledConnection != null) {
                oPooledConnection.disposeConnection();
            }
        }
        return oReplyBean;
    }

    public ReplyBean dump() throws Exception {
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        ReplyBean oReplyBean = null;
        ArrayList<ViewGenericBeanImplementation> aloBean = null;
        try {
            oPooledConnection = AppConfigurationHelper.getSourceConnection();
            oConnection = oPooledConnection.newConnection();
            PacienteSpecificDaoImplementation oDao = new PacienteSpecificDaoImplementation(oConnection, (UsuarioSpecificBeanImplementation) oRequest.getSession().getAttribute("user"), null);
            aloBean = oDao.dump();
            Gson oGson = AppConfigurationHelper.getGson();
            String strJson = oGson.toJson(aloBean);
            oReplyBean = new ReplyBean(200, strJson);
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jConfigurationHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oConnection != null) {
                oConnection.close();
            }
            if (oPooledConnection != null) {
                oPooledConnection.disposeConnection();
            }
        }
        return oReplyBean;
    }

}
