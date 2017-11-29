package Dao.specificimplementation;

import Bean.specificimplementation.UsuarioSpecificBeanImplementation;
import Dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;

public class ApellidoSpecificDaoImplementation extends TableGenericDaoImplementation{
    
    public ApellidoSpecificDaoImplementation(Connection oPooledConnection, UsuarioSpecificBeanImplementation oPuserBean_security, String strWhere) {
        super("apellido", oPooledConnection, oPuserBean_security, strWhere);
    }
    
}
