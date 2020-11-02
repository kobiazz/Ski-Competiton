package gui;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ColorImageChange {
    public static boolean isTransperent(BufferedImage img,int x,int y){
        int pixel = img.getRGB(x,y);
        if((pixel>>24)==0x00){return true;}
        return false;
    }
    public static ImageIcon changeColor(String c, String typeOfSportman) throws IOException, NoSuchFieldException, IllegalAccessException {
        Color color = (Color)Color.class.getField(c).get(null);
        BufferedImage image = null;
        try {
            image= ImageIO.read(new File("icons/"+typeOfSportman+".png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }

        for(int i=0;i<image.getHeight();i++){
            for(int j=0;j<image.getWidth();j++){
                if(isTransperent(image,j,i))continue;
                image.setRGB(j,i, color.getRGB());
            }
        }

        File outputfile = new File("icons/"+c+typeOfSportman+".png");
        ImageIO.write(image,"png",outputfile);
        ImageIcon im = new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage("icons/"+c+typeOfSportman+".png")).getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT));
        return im;
    }
}
