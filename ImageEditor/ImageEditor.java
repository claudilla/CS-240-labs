package ImageEditor;

/**
 * Created by claudita on 5/5/18.
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.IOException;


//regular class
public class ImageEditor {
    //scope. you can access this everywhere
    private Pixel[][] image2D;
    String input;
    String output;
    String motionBlur;
    int height = 0;
    int width = 0;

    int blur_length = 1;


    public static void main(String args[]) {
        //this is how to create an instance

        ImageEditor ie = new ImageEditor();
        ie.run(args);
        //ie.Invert();
        //ie.Grayscale();
        //ie.Emboss();
        ie.Motionblur();
        ie.printImage();

    }

    public void run(String args[]) {
        //perform the correct image manipulation
        input = args[0];
        output = args[1];

        try {
            //delimiter
            String delim = "((#[^\\n]*\\n)|(\\s+))+";
            //Read data from the input file
            File file = new File(input);
            //read the file
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(delim);

            //int height =0;
            //int width =0;

            scanner.next(); // magic number P3
            width = scanner.nextInt(); // width
            height = scanner.nextInt(); // height
            scanner.nextInt(); // 255 //max_val

            image2D = new Pixel[height][width];
            //we need to iterate through the 2D image or 2D Array of Pixels
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {

                    int red = scanner.nextInt();
                    int green = scanner.nextInt();
                    int blue = scanner.nextInt();

                    image2D[i][j] = new Pixel(red, green, blue);
                }
            }
            scanner.close();

        } catch (Exception exception) {
            //capital e exception .. ask ta
            exception.printStackTrace();
            // System.out.print("Exception");
        }
        if (args[2].equals("invert")) {
            Invert();

        }
        if (args[2].equals("grayscale")) {
            Grayscale();

        }
        if (args[2].equals("emboss")) {
            Emboss();

        }

        if (args[2].equals("motionblur")) {
            blur_length = Integer.parseInt(args[3]);
        }
    }


    public void Invert() {
        for (int i = 0; i < image2D.length; i++) { //height
            for (int j = 0; j < image2D[0].length; j++) { //width
                int newRedValue = 255 - image2D[i][j].getRed(); //red
                int newGreenValue = 255 - image2D[i][j].getGreen(); //green
                int newBlueValue = 255 - image2D[i][j].getBlue(); //blue
                image2D[i][j].setRed(newRedValue);
                image2D[i][j].setGreen(newGreenValue);
                image2D[i][j].setBlue(newBlueValue);

            }
        }
    }

    public void Grayscale() {
        for (int i = 0; i < image2D.length; i++) { //height
            for (int j = 0; j < image2D[0].length; j++) { //width
                int newRedValAverage = (image2D[i][j].getRed() + image2D[i][j].getGreen() + image2D[i][j].getBlue()) / 3;
                int newGreenValAverage = (image2D[i][j].getRed() + image2D[i][j].getGreen() + image2D[i][j].getBlue()) / 3;
                int newBlueValAverage = (image2D[i][j].getRed() + image2D[i][j].getGreen() + image2D[i][j].getBlue()) / 3;
                image2D[i][j].setRed(newRedValAverage);
                image2D[i][j].setGreen(newGreenValAverage);
                image2D[i][j].setBlue(newBlueValAverage);
            }
        }
    }

    //noon to one

    public void Emboss() {

        for (int i = image2D.length - 1; i >= 0; i--) { //height -1
            for (int j = image2D[0].length - 1; j >= 0; j--) { //width -1
                int newVal = 0;
                int maxDifference = 0;

                if (i == 0 || j == 0) {
                    maxDifference = 128;
                    image2D[i][j].setRed(maxDifference);
                    image2D[i][j].setGreen(maxDifference);
                    image2D[i][j].setBlue(maxDifference);
                } else {
                    int redDiff = image2D[i][j].getRed() - image2D[i - 1][j - 1].getRed();
                    int greenDiff = image2D[i][j].getGreen() - image2D[i - 1][j - 1].getGreen();
                    int blueDiff = image2D[i][j].getBlue() - image2D[i - 1][j - 1].getBlue();

                    int maxValRed = Math.abs(redDiff); //2
                    int maxValBlue = Math.abs(blueDiff);//1
                    int maxValGreen = Math.abs(greenDiff);//-2


                    if (maxValRed >= maxValBlue && maxValRed >= maxValGreen) {
                        newVal = redDiff;

                    } else if (maxValGreen >= maxValBlue && maxValGreen >= maxValRed) {
                        newVal = greenDiff;
                    } else {
                        newVal = blueDiff;
                    }
                    maxDifference = 128 + newVal;


                    if (maxDifference < 0) {
                        maxDifference = 0;
                    }
                    if (maxDifference > 255) {
                        maxDifference = 255;
                    }
                    image2D[i][j].setRed(maxDifference);
                    image2D[i][j].setGreen(maxDifference);
                    image2D[i][j].setBlue(maxDifference);

                }
            }
        }
    }

    public void Motionblur() {

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int redVal = 0;
                int greenVal = 0;
                int blueVal = 0;

                if (j + blur_length > width) {

                    for (int k = j; k < width; k++) {

                        redVal += image2D[i][k].getRed();
                        greenVal += image2D[i][k].getGreen();
                        blueVal += image2D[i][k].getBlue();

                    }
                    redVal = redVal / (width - j);
                    greenVal = greenVal / (width - j);
                    blueVal = blueVal / (width - j);
                    image2D[i][j].setRed(redVal);
                    image2D[i][j].setGreen(greenVal);
                    image2D[i][j].setBlue(blueVal);


                }

                else {

                    if (i == 0 && j == 0) {
                        System.out.println("First Pixel");
                    }



                    for (int k = 0; k < blur_length; k++) {

                        redVal += image2D[i][j+ k].getRed();
                        //System.out.println(redVal);
                        greenVal += image2D[i][j+k].getGreen();
                        blueVal += image2D[i][j+k].getBlue();

                        if (i == 0 && j == 0) {
                            System.out.println("Sum #" + k + " redVal: " + redVal);
                        }

                    }

                        redVal = redVal / blur_length;

                    if (i == 0 && j == 0) {
                        System.out.println("After Division: " + redVal);
                    }

                        greenVal = greenVal / blur_length;
                        blueVal = blueVal / blur_length;
                        image2D[i][j].setRed(redVal);
                        image2D[i][j].setGreen(greenVal);
                        image2D[i][j].setBlue(blueVal);

                }
            }
        }

    }

    //gives this function a sting to use
    public void printImage() {
        try {

            File file = new File(output);
            PrintWriter printWriter = new PrintWriter(file);

            printWriter.write("P3\n");
            printWriter.write(image2D[0].length + ""); //how long is my row //width
            printWriter.write(" ");
            printWriter.write(String.valueOf(image2D.length)); //height
            printWriter.write("\n"); //new line
            printWriter.write("255");
            printWriter.write("\n");

            for (int i = 0; i < image2D.length; i++) {
                for (int j = 0; j < image2D[0].length; j++) {
                    printWriter.write(image2D[i][j].toString());


                   // System.out.println(image2D[i][j].toString());
                }
            }
            printWriter.close();

        } catch (Exception exception) {
            //capital e exception .. ask ta
            exception.printStackTrace();
        }
    }
}