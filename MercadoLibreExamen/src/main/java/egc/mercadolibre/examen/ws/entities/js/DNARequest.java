package egc.mercadolibre.examen.ws.entities.js;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que representa una solicitud de prueba de ADN Mutante o Humano al WebService del sitio.
 * Sera mapeada a JSON
 * @author Eduardo
 */
@XmlRootElement(name = "DNARequest")
public class DNARequest {
    ArrayList<String> dna = new ArrayList<String>();

    /**
     * La muestra de ADN en forma de matriz
     * @return
     */
    public ArrayList<String> getDna() {
        return dna;
    }

    /**
     *
     * @param dna
     */
    public void setDna(ArrayList<String> dna) {
        this.dna = dna;
    }
}