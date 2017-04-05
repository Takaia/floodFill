/**
 *
 * @author Takaia
 * CSCI 132
 * Last updated on Mar 4, 2017
 */
    private void fun2() {
        // get the combined int of color values of a pixel at some random location
        int startPixel = picture[colorY][colorX];

        // break down currentPixel into its red, green, blue, and alpha channel
        int rgbArray[] = new int[4];
        rgbArray = getPixelArray(startPixel);

        // PixelRegion object with x, y data
        PixelRegion region = new PixelRegion(colorY, colorX);

        // create a new stack, and put in above variable region as first item
        Stack<PixelRegion> pixelStack = new Stack();
        pixelStack.push(region);

        // loop runs while the stack has objects in it
        while (!pixelStack.empty()) {
            
            // pop the current pixel off of the stack
            PixelRegion popped = pixelStack.pop();
            int x = popped.getXCoord();
            int y = popped.getYCoord();
            
            // change the current (popped) pixel to black
            int[] blackArray = {255, 0, 0, 0};
            picture[y][x] = getPixels(blackArray);

            // nested for loops that go through all of the adjacent pixels as rows
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {

                    // add current pixel to the stack
                    PixelRegion currentPix = new PixelRegion(y + i, x + j);
                    
                    int[] checkingValue = getPixelArray(picture[currentPix.yCoord][currentPix.xCoord]);
                    
                    // push the next current pixel onto the stack
                    if (rgbArray[3] == checkingValue[3]) {
                        pixelStack.push(currentPix);
                        
                    }
                }
            }
        }
        resetPicture();
    }