package egc.mercadolibre.examen.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Clase utilizada por hibernate para realizar el mapeo con la tabla DNASTORE
 * @author Eduardo
 */
@Entity
@Table(name = "DNASTORE")
public class DNASample {
    
    /**
     *  El id PK de DNASTORE
     */
    protected int id;

    /**
     *  La cadena de ADN completa (matriz de nxn)
     */
    protected String dnaChain;

    /**
     *  Si la cadena de ADN fue validada como ADN mutente es 1 si es humano 0
     */
    protected int valid;

    /**
     * Indica como incrementar el id (PK de la tabla) en funcion de la secuencia DNASTORE_SEQ
     * @return
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DNASTORE_SEQ")
    @SequenceGenerator(name = "DNASTORE_SEQ", sequenceName = "DNASTORE_SEQ", allocationSize = 1, initialValue = 1)    
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return
     */
    @Column(name = "DNA_CHAIN", length = 100)
    public String getDnaChain() {
        return dnaChain;
    }

    /**
     *
     * @param dnaChain
     */
    public void setDnaChain(String dnaChain) {
        this.dnaChain = dnaChain;
    }

    /**
     *
     * @return
     */
    @Column(name = "VALID", length = 1)
    public int getValid() {
        return valid;
    }

    /**
     *
     * @param valid
     */
    public void setValid(int valid) {
        this.valid = valid;
    }
    
    
    
}
