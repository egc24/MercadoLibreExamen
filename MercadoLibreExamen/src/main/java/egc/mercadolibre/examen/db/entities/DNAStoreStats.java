package egc.mercadolibre.examen.db.entities;

/**
 * Clase utilizada para retornar el resultado de la consulta estadistica sobre
 * el banco de ADN
 * @author Eduardo
 */
public class DNAStoreStats {
    
    private String mutantDNACount;
    private String humanDNACount;
    private String ratio;

    /**
     * Cantidad de muestras con ADN Mutante
     * @return
     */
    public String getMutantDNACount() {
        return mutantDNACount;
    }

    /**
     * 
     * @param mutantDNACount
     */
    public void setMutantDNACount(String mutantDNACount) {
        this.mutantDNACount = mutantDNACount;
    }

    /**
     * Cantidad de muestras con ADN Humano
     * @return
     */
    public String getHumanDNACount() {
        return humanDNACount;
    }

    /**
     *
     * @param humanDNACount
     */
    public void setHumanDNACount(String humanDNACount) {
        this.humanDNACount = humanDNACount;
    }

    /**
     * Cantidad de muestras con ADN Mutante vs Cantidad de muestras con ADN Humano
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
