package Service.specificimplementation;

import Service.genericimplementation.GenericTableService;
import javax.servlet.http.HttpServletRequest;

public class ComunidadSpecificServiceImplementation extends GenericTableService{
    
    public ComunidadSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }
    
}
