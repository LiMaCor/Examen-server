package Dao.specificimplementation;

import Bean.specificimplementation.UsuarioSpecificBeanImplementation;
import Dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;

public class ViaSpecificDaoImplementation extends TableGenericDaoImplementation{
    
    public ViaSpecificDaoImplementation(Connection oPooledConnection, UsuarioSpecificBeanImplementation oPuserBean_security, String strWhere) {
        super("via", oPooledConnection, oPuserBean_security, strWhere);
    }
    
}
