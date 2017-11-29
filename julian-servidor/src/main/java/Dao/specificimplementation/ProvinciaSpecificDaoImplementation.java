package Dao.specificimplementation;

import Bean.specificimplementation.UsuarioSpecificBeanImplementation;
import Dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;

public class ProvinciaSpecificDaoImplementation extends TableGenericDaoImplementation{
    
    public ProvinciaSpecificDaoImplementation(Connection oPooledConnection, UsuarioSpecificBeanImplementation oPuserBean_security, String strWhere) {
        super("provincia", oPooledConnection, oPuserBean_security, strWhere);
    }
    
}
