package stackfill;

/*
 *
 * @author Amelia Getty
 * CSCI 132
 * Mar 31, 2017
 */

/*
*   class PixelRegion stores the X, Y coordinate of the "current" pixel
*   starting with the pixel that was initially clicked
*/
public class PixelRegion {

    int xCoord;
    int yCoord;

    PixelRegion(int y, int x){
        xCoord = x;
        yCoord = y;
    }
    
    public int getXCoord(){
        return xCoord;
    }
    
    public int getYCoord(){
        return yCoord;
    }
}
