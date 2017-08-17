package egc.mercadolibre.examen.ws.entities.js;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que representa una respuesta de estadisticas del banco de ADN Mutante o Humano del WebService 
 * del sitio.
 * Sera mapeada a JSON
 * @author Eduardo
 */
@XmlRootElement(name = "DNARequest")
public class DNAStatsResponse {
    private String count_mutant_dna;
    private String count_human_dna;
    private String ratio;

    /**
     *
     * @return
     */
    public String getCount_mutant_dna() {
        return count_mutant_dna;
    }

    /**
     *
     * @param count_mutant_dna
     */
    public void setCount_mutant_dna(String count_mutant_dna) {
        this.count_mutant_dna = count_mutant_dna;
    }

    /**
     *
     * @return
     */
    public String getCount_human_dna() {
        return count_human_dna;
    }

    /**
     *
     * @param count_human_dna
     */
    public void setCount_human_dna(String count_human_dna) {
        this.count_human_dna = count_human_dna;
    }

    /**
     *
     * @return
     */
    public String getRatio() {
        return ratio;
    }

    /**
     *
     * @param ratio
     */
    public void setRatio(String ratio) {
        this.ratio = ratio;
    }
}
