package egc.mercadolibre.examen.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
/**
 * Controlador utilizado para obtener el javadoc del sitio y el script de base de datos
 * @author Eduardo
 */
@Controller
public class DocumentationController {
 
    /**
     * Esta ruta retorna el javadoc del sitio
     * @return
     */
    @RequestMapping(value="/javadoc", method = RequestMethod.GET)
    public String javadoc(){
                
        return "javadoc";
    }
    
    /**
     * Esta ruta retorna el script del sitio
     * @return
     */
    @RequestMapping(value="/script", method = RequestMethod.GET)
    public String script(){
        return "script";
    }    
}