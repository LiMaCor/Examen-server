package Helper;

import Bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import Bean.publicinterface.GenericBeanInterface;
import Bean.specificimplementation.PacienteSpecificBeanImplementation;
import Bean.specificimplementation.UsuarioSpecificBeanImplementation;


public class MappingBeanHelper {

    public static GenericBeanInterface getBean(String ob) {
        GenericBeanInterface oBean = null;

        switch (ob) {
            case "usuario":
                oBean = new UsuarioSpecificBeanImplementation();
                break;
            case "tipousuario":
                oBean = new TipousuarioSpecificBeanImplementation();
                break;
            case "paciente":
                oBean = new PacienteSpecificBeanImplementation();
                break;
            default:

                //oReplyBean = new ReplyBean(500, "Object not found : Please contact your administrator");
                break;
        }
        return oBean;
    }
}
