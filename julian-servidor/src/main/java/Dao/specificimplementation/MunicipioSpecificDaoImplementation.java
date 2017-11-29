package Dao.specificimplementation;

import Bean.specificimplementation.UsuarioSpecificBeanImplementation;
import Dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;

public class MunicipioSpecificDaoImplementation extends TableGenericDaoImplementation{
    
    public MunicipioSpecificDaoImplementation(Connection oPooledConnection, UsuarioSpecificBeanImplementation oPuserBean_security, String strWhere) {
        super("municipio", oPooledConnection, oPuserBean_security, strWhere);
    }
    
}
