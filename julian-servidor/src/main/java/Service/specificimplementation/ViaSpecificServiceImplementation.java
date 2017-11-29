package Service.specificimplementation;

import Service.genericimplementation.GenericTableService;
import javax.servlet.http.HttpServletRequest;

public class ViaSpecificServiceImplementation extends GenericTableService{
    
    public ViaSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }
    
}
