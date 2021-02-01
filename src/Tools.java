import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class Tools {

    static void takeSnapShot(JPanel panel) {
        BufferedImage bufImage = new BufferedImage(panel.getSize().width, panel.getSize().height, BufferedImage.TYPE_INT_RGB);
        panel.paint(bufImage.createGraphics());
        File imageFile = new File("saved_file.jpg");
        try {
            imageFile.createNewFile();
            ImageIO.write(bufImage, "BMP", imageFile);
        } catch (Exception ex) {
            System.out.println("File Saving Exception- Screen shoot");
        }
    }

    static void ConvertIMG(double[][] array, BufferedImage img) {
        for (int x = 0; x < img.getWidth(); x++)
            for (int y = 0; y < img.getHeight(); y++) {
                Color readColor = new Color(img.getRGB(x, y));
                int G = readColor.getGreen();
                array[x][y] = G;
            }
    }

    public static double findMin(double[][] matrix) {
        double min = matrix[0][0];
        for (double[] m : matrix) {
            for (double n : m) {
                if (min > n)
                    min = n;
            }
        }
        return min;
    }

    public static double findMax(double[][] matrix) {
        double max = matrix[0][0];
        for (double[] m : matrix) {
            for (double n : m) {
                if (max < n)
                    max = n;
            }
        }
        return max;
    }

    public static char [] DecChanger(String value){
        String dec=Integer.toString(Integer.parseInt(value),2);
        while (dec.length()<8)
            dec='0'+dec;
        return dec.toCharArray();
    }

}

