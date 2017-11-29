package Service.specificimplementation;

import Service.genericimplementation.GenericTableService;
import javax.servlet.http.HttpServletRequest;

public class MunicipioSpecificServiceImplementation extends GenericTableService{
    
    public MunicipioSpecificServiceImplementation(HttpServletRequest request) {
        super(request);
    }
    
}
