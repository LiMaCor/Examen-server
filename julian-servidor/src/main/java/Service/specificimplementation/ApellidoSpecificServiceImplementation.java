package Service.specificimplementation;

import Service.genericimplementation.GenericTableService;
import javax.servlet.http.HttpServletRequest;

public class ApellidoSpecificServiceImplementation extends GenericTableService{
    
    public ApellidoSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }
    
}
