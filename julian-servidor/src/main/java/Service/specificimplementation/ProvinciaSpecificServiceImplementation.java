package Service.specificimplementation;

import Service.genericimplementation.GenericTableService;
import javax.servlet.http.HttpServletRequest;

public class ProvinciaSpecificServiceImplementation extends GenericTableService{
    
    public ProvinciaSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }
    
}
