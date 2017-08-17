package egc.mercadolibre.examen.domain.services;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio empleado para diferenciar una muestra de ADN Mutante de una de ADN Humano.
 * @author Eduardo
 */
public class DNATester {

    private int width = 6;
    private int height = 6;
    private int routeMaxSize = 4;
    private int validRoutesMaxSize = 1;
    private String[] matrix;
    private List<int[]> validRoutes= new ArrayList<int[]>();
    
    /**
     * Contiene la funcionalidad principal del Servicio.
     * Basicamente se recorre la matriz elemento por elemento obteniendo por cada subitem (x,y)
     * las que sean rutas validas y agregandolas a la lista de validRoutes hasta que halla tantas 
     * como validRoutesMaxSize. Si esa condicion se alcanza se esta en presencia de ADN Mutante,
     * de lo contrario el ADN sera considerado Humano. Una ruta valida parte de un subitem (x,y) y 
     * puede tener direccion horizontal (derecha o izquierda), vertical (arriba o abajo)
     * y diagonal (derecha arriba o abajo, o izquierda arriba o abajo), en definitiva las 8 posibles
     * rutas partiendo de una coordenada (x,y). La ruta sera valida siempre y cuando su extension dada
     * por routeMaxSize, y tomando como origen (x,y) no salga del marco de la matriz, y tenga todos sus 
     * elementos iguales. Como se dijo antes el metodo da positivo si la cantidad de rutas validas
     * encontradas recorriendo la matriz (elemento por elemento) es mayor a validRoutesMaxSize. Al ser esta
     * una condicion de corte ni bien esto se valide el metodo retornara verdadero dejando de lado las restantes 
     * rutas validas si las hubiera. Esta ultima situacion se puede regular modificando el parametro 
     * validRoutesMaxSize.
     * @param dna
     * @return
     */
    public boolean isMutant(String[] dna) {
        matrix = dna;
        validRoutes.clear();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (getValidRoutes(i,j))
                    return true;
            }
        }
        return false;
    }
    
    private boolean getValidRoutes(int x, int y) {
        char positionChar = getValueOfMatrixAtPosition(x, y);
        int[] horizontalLeft = null;
        int[] horizontalRight = null;
        int[] verticalUp = null;
        int[] verticalDown = null;
        int[] diagonalLeftUp = null;
        int[] diagonalLeftDown = null;
        int[] diagonalRightUp = null;
        int[] diagonalRightDown = null;

        horizontalLeftCheck:
        if (x + 1 - routeMaxSize >= 0) {
            horizontalLeft = new int[routeMaxSize*2];
            int i = 0;
            int j = 0;
            while (i < routeMaxSize*2) {
                if (positionChar != getValueOfMatrixAtPosition(x-j, y)) {
                    break horizontalLeftCheck;
                } else {
                    horizontalLeft[i] = x-j;
                    i++;
                    j++;
                    horizontalLeft[i] = y;
                    i++;
                }
            }
            validRoutes.add(horizontalLeft);
            if (validRoutes.size() >= validRoutesMaxSize)
                return true;            
        }
        
        horizontalRightCheck:
        if (x + routeMaxSize < width) {
            horizontalRight = new int[routeMaxSize*2];
            int i = 0;
            int j = 0;
            while (i < routeMaxSize*2) {
                if (positionChar != getValueOfMatrixAtPosition(x+j, y)) {
                    break horizontalRightCheck;
                } else {
                    horizontalRight[i] = x+j;
                    i++;
                    j++;
                    horizontalRight[i] = y;
                    i++;
                }
            } 
            validRoutes.add(horizontalRight);
            if (validRoutes.size() >= validRoutesMaxSize)
                return true;            
        }
        
        verticalUpCheck:
        if (y + 1 - routeMaxSize >= 0) {
            verticalUp = new int[routeMaxSize*2];
            int i = 0;
            int j = 0;
            while (i < routeMaxSize*2) {
                if (positionChar != getValueOfMatrixAtPosition(x, y-j)) {
                    break verticalUpCheck;
                } else {                
                    verticalUp[i] = x;
                    i++;
                    verticalUp[i] = y-j;
                    i++;
                    j++;
                }
            }   
            validRoutes.add(verticalUp);
            if (validRoutes.size() >= validRoutesMaxSize)
                return true;            
        }
        
        verticalDownCheck:
        if (y + routeMaxSize < height) {
            verticalDown = new int[routeMaxSize*2];
            int i = 0;
            int j = 0;
            while (i < routeMaxSize*2) {
                if (positionChar != getValueOfMatrixAtPosition(x, y+j)) {
                    break verticalDownCheck;
                } else {                
                    verticalDown[i] = x;
                    i++;
                    verticalDown[i] = y+j;
                    i++;
                    j++;
                }
            } 
            validRoutes.add(verticalDown);
            if (validRoutes.size() >= validRoutesMaxSize)
                return true;            
        }
        
        diagonalLeftUpCheck:
        if (((x + 1 - routeMaxSize >= 0)) && (y + 1 - routeMaxSize >= 0)) {
            diagonalLeftUp = new int[routeMaxSize*2];
            int i = 0;
            int j = 0;
            while (i < routeMaxSize*2) {
                if (positionChar != getValueOfMatrixAtPosition(x-j, y-j)) {
                    break diagonalLeftUpCheck;
                } else {                
                    diagonalLeftUp[i] = x-j;
                    i++;
                    diagonalLeftUp[i] = y-j;
                    i++;
                    j++;
                }
            } 
            validRoutes.add(diagonalLeftUp);
            if (validRoutes.size() >= validRoutesMaxSize)
                return true;            
        }
        
        diagonalLeftDownCheck:
        if (((x + 1 - routeMaxSize >= 0)) && (y + routeMaxSize < height)) {
            diagonalLeftDown = new int[routeMaxSize*2];
            int i = 0;
            int j = 0;
            while (i < routeMaxSize*2) {
                if (positionChar != getValueOfMatrixAtPosition(x-j, y+j)) {
                    break diagonalLeftDownCheck;
                } else {                
                    diagonalLeftDown[i] = x-j;
                    i++;
                    diagonalLeftDown[i] = y+j;
                    i++;
                    j++;
                }
            } 
            validRoutes.add(diagonalLeftDown); 
            if (validRoutes.size() >= validRoutesMaxSize)
                return true;
        }
        
        diagonalRightUpCheck:
        if ((x + routeMaxSize < width) && (y + 1 - routeMaxSize >= 0)) {
            diagonalRightUp = new int[routeMaxSize*2];
            int i = 0;
            int j = 0;
            while (i < routeMaxSize*2) {
                if (positionChar != getValueOfMatrixAtPosition(x+j, y-j)) {
                    break diagonalRightUpCheck;
                } else {                
                    diagonalRightUp[i] = x+j;
                    i++;
                    diagonalRightUp[i] = y-j;
                    i++;
                    j++;
                }   
            } 
            validRoutes.add(diagonalRightUp);
            if (validRoutes.size() >= validRoutesMaxSize)
                return true;
        }
        
        diagonalRightDownCheck:
        if ((x + routeMaxSize < width) && (y + routeMaxSize < height)) {
            diagonalRightDown = new int[routeMaxSize*2];
            int i = 0;
            int j = 0;
            while (i < routeMaxSize*2) {
                if (positionChar != getValueOfMatrixAtPosition(x+j, y+j)) {
                    break diagonalRightDownCheck;
                } else {                
                    diagonalRightDown[i] = x+j;
                    i++;
                    diagonalRightDown[i] = y+j;
                    i++;
                    j++;
                }
            }
            validRoutes.add(diagonalRightDown);
            if (validRoutes.size() >= validRoutesMaxSize)
                return true;            
        }

        return false;
    }
    
    private boolean isContainedInRoute(int x, int y, int[] route) {
        int i = 0;
        while (i < routeMaxSize*2) {
            int currentX = route[i++];
            int currentY = route[i++];
            
            if (x == currentX && y == currentY) {
                return true;
            }
        }
        
        return false;
    }
    
    private char getValueOfMatrixAtPosition(int x, int y) {
        return matrix[x].charAt(y);
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     *
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     *
     * @return
     */
    public int getRouteMaxSize() {
        return routeMaxSize;
    }

    /**
     *
     * @param routeMaxSize
     */
    public void setRouteMaxSize(int routeMaxSize) {
        this.routeMaxSize = routeMaxSize;
    }

    /**
     *
     * @return
     */
    public int getValidRoutesMaxSize() {
        return validRoutesMaxSize;
    }

    /**
     *
     * @param validRoutesMaxSize
     */
    public void setValidRoutesMaxSize(int validRoutesMaxSize) {
        this.validRoutesMaxSize = validRoutesMaxSize;
    }
    
    
}
