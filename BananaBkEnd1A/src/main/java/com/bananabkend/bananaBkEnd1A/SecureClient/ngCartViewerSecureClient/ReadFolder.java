/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.SecureClient.ngCartViewerSecureClient;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
/**
 *
 * @author sunjiv6
 */
public class ReadFolder {
    
    
    public static void main(String[] args) {
        String path="/home/sunjiv6/sunws/ProjectWS/bananaWS/AngularWS/ForNameChange/srcNameChange/app/";
        
        
         //listFiles();
         listDir();
         //listDirOnlyName();
         
         
    }
    
    static HashMap<String, String> listDirOnlyName()
    {        
        HashMap<String, String> dirMap=new HashMap<String, String>();
        
         String path="/home/sunjiv6/sunws/ProjectWS/bananaWS/AngularWS/ForNameChange/srcNameChange/app";
        try (Stream<Path> paths = Files.walk(Paths.get(path))) {
            paths.filter(Files::isDirectory)
                    .forEach((t) -> {
                        dirMap.put(t.getFileName().toString(), "");
                        //System.out.println(t.getFileName().toString());
                    });
        }catch(Exception ex){
            
        }
        
        dirMap.remove("app");
        for (Map.Entry<String, String> entry : dirMap.entrySet()) {
            
                System.out.println(entry.getKey());

            }
        
        return dirMap;
    }
    
    static void listDir()
    {        
        String path="/home/sunjiv6/sunws/ProjectWS/bananaWS/AngularWS/ForNameChange/srcNameChange/app";
        try (Stream<Path> paths = Files.walk(Paths.get(path))) {
            paths.filter(Files::isDirectory)
                    .forEach(System.out::println);
        }catch(Exception ex){
            
        }
    }
    
    static void listFiles()
    {        
        String path="/home/sunjiv6/sunws/ProjectWS/bananaWS/AngularWS/ForNameChange/srcNameChange/app";
        try (Stream<Path> paths = Files.walk(Paths.get(path))) {
            paths.filter(Files::isRegularFile)
                    .forEach(System.out::println);
        }catch(Exception ex){
            
        }
    }
    
    static void listDir1(){
        int n=0;
        File[] dir = new File("/home/sunjiv6/sunws/ProjectWS/bananaWS/AngularWS/ForNameChange/srcNameChange/app").listFiles(File::isDirectory);
       
        while(n < dir.length){
            System.out.println(dir[n]);
            n++;
        }
        
    }
    
}
