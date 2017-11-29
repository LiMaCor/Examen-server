package Dao.specificimplementation;

import Bean.specificimplementation.UsuarioSpecificBeanImplementation;
import Dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;

public class NombrefemeninoSpecificDaoImplementation extends TableGenericDaoImplementation{
    
    public NombrefemeninoSpecificDaoImplementation(Connection oPooledConnection, UsuarioSpecificBeanImplementation oPuserBean_security, String strWhere) {
        super("nombrefemenino", oPooledConnection, oPuserBean_security, strWhere);
    }
    
}
