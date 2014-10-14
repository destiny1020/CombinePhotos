/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package combinephotos;

import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.*;
import java.awt.image.*;
import java.awt.event.*;
import java.awt.*;


/**
 *
 * @author Stephen
 * Building a java program that will allow me to concatenate images in Windows/Mac/Linux
 */
public class CombinePhotos extends Component{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        BufferedImage img1 = null;
        BufferedImage img2 = null;
        
        try {
            img1 = ImageIO.read(new File("J:/Photobook/A Weekend with Ellen Adarna/Screenshot_2014-06-29-01-17-07.png"));
        } catch (IOException e) {
            System.out.println("Can't find the file!");
        }
        
        try {
            img2 = ImageIO.read( new File("J:/Photobook/A Weekend with Ellen Adarna/Screenshot_2014-06-29-01-17-16.png"));
        } catch (IOException e) {
            System.out.println("Can't find the file!");
        }
        
        int WidthImg1 = img1.getWidth();
        int HeightImg1 = img1.getHeight();
        
        int WidthImg2 = img2.getWidth();
        int HeightImg2 = img2.getHeight();
        
        BufferedImage dest = img1.getSubimage(0, 8, WidthImg1, HeightImg1-8);
        
        
        BufferedImage combinedImg = new BufferedImage(WidthImg1+WidthImg2, HeightImg1, BufferedImage.TYPE_INT_RGB);
        
        boolean imageDrawn1 = combinedImg.createGraphics().drawImage(dest, 0, 0, null);
        
        boolean imageDrawn2 = combinedImg.createGraphics().drawImage(img2, WidthImg1, 0, null);
        
        File final_img = new File("J:/test_combine_image.jpg");
        
        try {
            boolean final_img_drawing = ImageIO.write(combinedImg, "jpeg", final_img);
        } catch (IOException e) {
            System.out.println("Problem Writing File");
        }
        
    }
    
}
