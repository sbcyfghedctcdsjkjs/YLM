/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.Utility;

import com.bananabkend.bananaBkEnd1A.Utility.property.ContentStatus;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageInputStreamImpl;
import org.apache.commons.collections4.IterableUtils;

/**
 *
 * @author sunjiv6
 */
public class ImageCompressStandalone {

    public ImageCompressStandalone() {
    }
    
    public static void main(String[] args) throws IOException {
        
        File diskFile =null;
        String rootPath = "/home/sunjiv6/sunws/ProjectWS/bananaWS/ImagesBananaApp/SizeTest/";
        File dir = new File(rootPath);
        //foreach (File fi dir.listFiles()
        int n=0;
        while ( n < ImageIO.getReaderFormatNames().length)
        {
            System.out.println(ImageIO.getReaderFormatNames()[n]);
            n++;
        }
       n=0;
        {
            System.out.println(n+"). File: "+dir.listFiles()[n].getName());
            File input = new File(rootPath+"1_Tree_Text_orig_1.png");
            System.out.println("input file: "+input.getPath());
            BufferedImage src = ImageIO.read(input);
            
            //BufferedImage target1 = Scalr.createOptimalImage(src );//Working
            long start = System.currentTimeMillis();
            System.out.println(System.currentTimeMillis());
            BufferedImage target = Scalr.resize(src,30 );            
            File output = new File(rootPath+"1_Tree_Text_Icon30_1_CHKNAME_noExtension");            
            ImageIO.write(target, "png", output);
            System.out.println("output file: "+output.getPath());
//            
//            target = Scalr.resize(src,250,250 );            
//            output = new File(rootPath+"1_Tree_Text_250x250_1.png");            
//            ImageIO.write(target, "png", output);
//            System.out.println("output file: "+output.getPath());
//            
//            target = Scalr.resize(src,500,500 );            
//            output = new File(rootPath+"1_Tree_Text_500x500_1.png");            
//            ImageIO.write(target, "png", output);
//            System.out.println("output file: "+output.getPath());
//            
//            target = Scalr.resize(src,750,750 );            
//            output = new File(rootPath+"1_Tree_Text_750x750_1.png");            
//            ImageIO.write(target, "png", output);
//            System.out.println("output file: "+output.getPath());
//            
            long end = System.currentTimeMillis();
            long finis = end-start;
            System.out.println("Finish time: "+finis);
            
            n++;
        }
        
          
        //diskFile = new File(dir.getAbsolutePath() + File.separator + dtoOwnerContent.getGeneratedFileName());
        
    }
}
