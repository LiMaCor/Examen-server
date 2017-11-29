
package Dao.specificimplementation;

import Bean.specificimplementation.UsuarioSpecificBeanImplementation;
import Dao.genericimplementation.TableGenericDaoImplementation;
import java.sql.Connection;

public class ComunidadSpecificDaoImplementation extends TableGenericDaoImplementation{
    
    public ComunidadSpecificDaoImplementation(Connection oPooledConnection, UsuarioSpecificBeanImplementation oPuserBean_security, String strWhere) {
        super("comunidad", oPooledConnection, oPuserBean_security, strWhere);
    }
    
}
