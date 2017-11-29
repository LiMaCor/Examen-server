package Dao.specificimplementation;

import Bean.specificimplementation.UsuarioSpecificBeanImplementation;
import Dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;

public class NombremasculinoSpecificDaoImplementation extends TableGenericDaoImplementation {
    
    public NombremasculinoSpecificDaoImplementation(Connection oPooledConnection, UsuarioSpecificBeanImplementation oPuserBean_security, String strWhere) {
        super("nombremasculino", oPooledConnection, oPuserBean_security, strWhere);
    }
    
}
