package ImageEditor;

/**
 * Created by claudita on 5/5/18.
 */

public class Pixel {

    private int red, green, blue;

    public Pixel(int r, int g, int b){

        this.red = r;
        this.green = g;
        this.blue = b;
    }

    public int getRed(){
        return red;
    }
    public void setRed( int r){
        this.red = r;
    }

    public int getGreen(){
        return green;
    }
    public void setGreen( int g){
        this.green = g;
    }

    public int getBlue(){
        return blue;
    }

    public void setBlue( int b){
        this.blue = b;
    }

    public String toString(){
        return red + " " + green + " " + blue + " ";
    }
}
