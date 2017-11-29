package Service.specificimplementation;

import Service.genericimplementation.GenericTableService;
import javax.servlet.http.HttpServletRequest;

public class NombremasculinoSpecificServiceImplementation extends GenericTableService{
    
    public NombremasculinoSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }
    
}
