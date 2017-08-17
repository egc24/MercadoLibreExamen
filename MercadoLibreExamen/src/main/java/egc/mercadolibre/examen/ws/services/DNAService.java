package egc.mercadolibre.examen.ws.services;

import egc.mercadolibre.examen.db.daos.DNAStoreDAO;
import egc.mercadolibre.examen.db.entities.DNASample;
import egc.mercadolibre.examen.db.entities.DNAStoreStats;
import egc.mercadolibre.examen.domain.services.DNATester;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import egc.mercadolibre.examen.ws.entities.js.DNARequest;
import egc.mercadolibre.examen.ws.entities.js.DNAStatsResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Clase utilizada para brindar WebServices relacionados con el banco de ADN
 * @author Eduardo
 */
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DNAService {

    private DNAStoreDAO dnaStoreDAO;
    private DNATester dnaTester;
    
    /**
     *
     */
    public void init() {
    }
        
    /**
     * Metodo HTTP POST que provee estadisticas sobre el banco de ADN
     * @return
     */
    @POST
    @Path("/stats")
    public Object retrieveStats() {
        try {
            DNAStatsResponse response = new DNAStatsResponse();
            DNAStoreStats dnaStoreStats = dnaStoreDAO.getStoreStats();

            response.setCount_mutant_dna(dnaStoreStats.getMutantDNACount());
            response.setCount_human_dna(dnaStoreStats.getHumanDNACount());
            response.setRatio(dnaStoreStats.getRatio());

            return response;
        } catch (Exception e) {
            return Response.status(Status.FORBIDDEN).entity("Ocurrio un error interno").build();
        }
    }
    
    /**
     * Metodo HTTP POST que indica si una muestra de ADN es Mutante o Humana
     * y la almacena en el banco
     * @param dnaRequest
     * @return
     */
    @POST
    @Path("/mutant")
    public Response checkIfMutant(DNARequest dnaRequest) {
        try {
            Response response = null;
            DNASample dnaSample = new DNASample();

            String dnaChain = "";
            for (String dnaChainPart : dnaRequest.getDna()) 
                dnaChain += dnaChainPart;
            dnaSample.setDnaChain(dnaChain);

            if (dnaTester.isMutant(dnaRequest.getDna().toArray(new String[dnaRequest.getDna().size()]))) {
                response = Response.status(Status.OK).entity("The DNA sent is mutant").build();
                dnaSample.setValid(1);
            } else {
                response = Response.status(Status.FORBIDDEN).entity("The DNA sent is not mutant").build();
                dnaSample.setValid(0);
            }

            dnaStoreDAO.saveSample(dnaSample);
            return response;
        } catch (Exception e) {
            return Response.status(Status.FORBIDDEN).entity("Ocurrio un error interno").build();
        }
    }  

    /**
     * DAO utilizado para gestionar los pedidos a la base
     * @return
     */
    public DNAStoreDAO getDnaStoreDAO() {
        return dnaStoreDAO;
    }

    /**
     * 
     * @param dnaStoreDAO
     */
    public void setDnaStoreDAO(DNAStoreDAO dnaStoreDAO) {
        this.dnaStoreDAO = dnaStoreDAO;
    }

    /**
     * Servicio utilizado para indicar si una muestra de ADN es Mutante o Humana
     * @return
     */
    public DNATester getDnaTester() {
        return dnaTester;
    }

    /**
     *
     * @param dnaTester
     */
    public void setDnaTester(DNATester dnaTester) {
        this.dnaTester = dnaTester;
    }
}