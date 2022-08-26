package com.bananabkend.bananaBkEnd1A.SecureClient.droidSecureClient;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import org.apache.commons.io.FileUtils;
/**
 @author sunjiv6 */



public class AndroidChangeFileName {
        String trgtPathFull="/home/sunjiv6/sunws/ProjectWS/AndroidWs/FlutterWS/RenameWork/TargetNameChange/lib";
    String srcPathFull="/home/sunjiv6/sunws/ProjectWS/AndroidWs/FlutterWS/RenameWork/srcNameChange/lib";

    Set<String> skipFile=new HashSet<String>();
    HashMap<String, String> fileMap = null;
    HashMap<String, String> folderMap = null;
    public static void main(String[] args) throws Exception{
    
        AndroidChangeFolderName cfldn = new AndroidChangeFolderName();
            
            AndroidChangeFileName cfn = new AndroidChangeFileName();
            cfn.folderMap=cfldn.createFolder(cfn.srcPathFull);
            cfn.fileMap=cfn.createFiles(cfn.srcPathFull,cfn.folderMap);
//            cfn.fileMap=cfn.getFileNameInMap(cfn.srcPathFull);        
//            for (Map.Entry<String, String> entry : cfn.fileMap.entrySet()) {            
//                    
//                    String nf=cfn.generateNewKey()+entry.getKey().substring(entry.getKey().lastIndexOf("."));
//                    entry.setValue(nf);
//                    System.out.println(entry.getKey()+ " => "+entry.getValue()+"   && nf="+nf);
//            }
//            for (Map.Entry<String, String> entry : cfn.fileMap.entrySet()) {            
//                    //System.out.println(entry.getKey()+ " => "+entry.getValue());
//            }
            
    }
    
    
     HashMap<String, String> getFileNameInMap(String srcPathFull)
    {        
        HashMap<String, String> fileMap=new HashMap<String, String>();

        try (Stream<Path> paths = Files.walk(Paths.get(srcPathFull))) {
            paths.filter(Files::isRegularFile)
                    .forEach((t) -> {
                        if(!skipFile.contains(t.getFileName().toString()))
                            fileMap.put(t.getFileName().toString(), "");
                        //System.out.println(t.getFileName().toString());
                    });
        }catch(Exception ex){
            
        }
        
        fileMap.remove("app");
        
        return fileMap;
    }
    
     HashMap<String, String> createFiles(String srcPathFull,HashMap<String, String> folderMap) throws Exception{
//        fileMap=getFileNameInMap(srcPathFull);        
//        for (Map.Entry<String, String> entry : fileMap.entrySet()) {            
//                entry.setValue(generateNewKey());
//        }      
         System.out.println("\n\n\nFile Name & Key");
        fileMap=getFileNameInMap(srcPathFull);        
            for (Map.Entry<String, String> entry : fileMap.entrySet()) {        
                String nf=null;
                //String nf=generateNewKey(folderMap)+entry.getKey().substring(entry.getKey().lastIndexOf("."));
                //NOT rename file in 'l10n' 
                if(entry.getKey().indexOf(".arb")>0) nf=entry.getKey();
                else {
                    nf =generateNewKey(folderMap)+entry.getKey().substring(entry.getKey().lastIndexOf("."));
                    //nf =generateNewKey(folderMap)+"_Fi_"+entry.getKey(); //For testing
                }

                entry.setValue(nf);
                System.out.println(entry.getKey()+ " => "+entry.getValue());
        }
            
        try (Stream<Path> paths = Files.walk(Paths.get(srcPathFull))) {
            paths.filter(Files::isRegularFile)
                    .forEach((t) -> {
                try {
            
                    //String fileContext = FileUtils.readFileToString(t.toFile());
                    
                    //FileUtils.write(new File(trgtPathFull+dirMap.get(t.getFileName().toString())), fileContext);
                    String srcFilePath = t.toString();
                    String trgtFilePath = t.toString();

                    for (Map.Entry<String, String> entry : fileMap.entrySet()) {
                        
                        //path=path.replaceAll(srcPathFull, trgtPathFull); //Change Path
                        
                        trgtFilePath=trgtFilePath.replaceAll("/"+entry.getKey(),"/"+entry.getValue()); //Encrypt FileName
                    }
                    
                    for (Map.Entry<String, String> entry : folderMap.entrySet()) {
                        
                        trgtFilePath=trgtFilePath.replaceFirst(srcPathFull, trgtPathFull); //Change Path
                        
                        trgtFilePath=trgtFilePath.replaceAll("/"+entry.getKey(),"/"+entry.getValue()); //Encrypt FolderName
                    }
                    
                    
                    
                    //create file
                    if(!skipFile.contains(trgtFilePath.substring(trgtFilePath.lastIndexOf("/")+1))){
                        
                    String fileContext = FileUtils.readFileToString(t.toFile());                    
                    FileUtils.write(new File(trgtFilePath), fileContext);
                       // System.out.println(srcFilePath.substring(srcFilePath.lastIndexOf("/"))+" >>> "+trgtFilePath.substring(trgtFilePath.lastIndexOf("/")));
                    }
                    
                    
//                    File newDir= new File(path);                        
//                        if(!newDir.exists()){
//                            System.out.println("Flder created "+newDir);
//                            //newDir.mkdir();
//                        }
                    //System.out.println(t.getFileName().toString());
                    
                } catch (Exception ex) {
                    Logger.getLogger(AndroidChangeFileName.class.getName()).log(Level.SEVERE, null, ex);
                }
                    });
        }catch(Exception ex){
            
        }
       return fileMap; 
    }
    
    
    public  String generateNewKey(HashMap<String, String> folderMap) throws Exception 
    { 
      // chose a Character random from this String 
        String AlphaNumericString = "ABbCDEFGbaHIb_sJKldsLMNObsPwQRSTUVWxXYZ"
                                    + "012_3556788"
                                    + "asbscdefghijlkqnlqmn_bopqdsrstxuevxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(30); 
        sb.append("s");
        Boolean generateKey = true;
        while(generateKey){
            for (int i = 0; i < 10; i++) { 
                // generate a random number between 

                // 0 to AlphaNumericString variable length 
                int index 
                    = (int)(AlphaNumericString.length() 
                            * Math.random()); 

                // add Character one by one in end of sb 
                sb.append(AlphaNumericString 
                              .charAt(index)); 
            } 
           generateKey= keyExist(sb.toString(),folderMap);
        }    
        return sb.toString(); 
     
    }
    
    
    Boolean keyExist(String key, HashMap<String, String> folderMap){
        Boolean generateKey = true;
        
        if(!folderMap.containsKey(key)) generateKey =false;
        
        return generateKey;
    }
        
}
