package Dao.specificimplementation;

import Bean.specificimplementation.UsuarioSpecificBeanImplementation;
import Dao.genericimplementation.TableGenericDaoImplementation;
import Helper.Log4jConfigurationHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Julian
 */

public class PacienteSpecificDaoImplementation extends TableGenericDaoImplementation{
    
    public PacienteSpecificDaoImplementation(Connection oPooledConnection, UsuarioSpecificBeanImplementation oPuserBean_security, String strWhere) {
        super("paciente", oPooledConnection, oPuserBean_security, strWhere);
    }
    
}
