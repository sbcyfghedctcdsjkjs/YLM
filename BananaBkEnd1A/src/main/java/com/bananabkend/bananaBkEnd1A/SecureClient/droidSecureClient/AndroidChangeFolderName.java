package com.bananabkend.bananaBkEnd1A.SecureClient.droidSecureClient;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author sunjiv6
 */


public class AndroidChangeFolderName {
        
    String trgtPath="/home/sunjiv6/sunws/ProjectWS/AndroidWs/FlutterWS/RenameWork/TargetNameChange/lib";
    String srcPath="/home/sunjiv6/sunws/ProjectWS/AndroidWs/FlutterWS/RenameWork/srcNameChange/lib";
    
    HashMap<String, String> folderMap = null;
    public static void main(String[] args) throws Exception{
            AndroidChangeFolderName cfn = new AndroidChangeFolderName();
            
            File f = new File (cfn.trgtPath);
            if(f.exists()) f.delete();
            
            cfn.folderMap=cfn.createFolder(cfn.srcPath);
    }   
    
    HashMap<String, String> getFolderNameInMap(String srcPath)    {        
        
        HashMap<String, String> dirMap=new HashMap<String, String>();
        
        
        try (Stream<Path> paths = Files.walk(Paths.get(srcPath))) {
            paths.filter(Files::isDirectory)
                    .forEach((t) -> {
                        dirMap.put(t.getFileName().toString(), "");
                        //System.out.println(t.getFileName().toString());
                    });
        }catch(Exception ex){
            
        }
        dirMap.remove("lib");
        return dirMap;
    }
    
     HashMap<String, String> createFolder(String srcPath) throws Exception{
        folderMap=getFolderNameInMap(srcPath);  
         System.out.println("Folders Name & Key");
        for (Map.Entry<String, String> entry : folderMap.entrySet()) { 
            //NOT rename folder 'l10n'  and 'intl15'
            if(entry.getKey().equals("l10n") || entry.getKey().equals("intl15")) entry.setValue(entry.getKey());
            else {
                // entry.setValue(generateNewKey()+"_Fd_"+entry.getKey()); //For testing
                entry.setValue(generateNewKey());
            }
                System.out.println(entry.getKey()+" >> "+entry.getValue());
                
        }    
       
        try (Stream<Path> paths = Files.walk(Paths.get(srcPath))) {
       
            paths.filter(Files::isDirectory)
                    .forEach((t) -> {
                try {
                    //String fileContext = FileUtils.readFileToString(t.toFile());
                    //FileUtils.write(new File(trgtPath+dirMap.get(t.getFileName().toString())), fileContext);
                    String path = t.toString();
                    for (Map.Entry<String, String> entry : folderMap.entrySet()) {
                        path=path.replaceFirst(srcPath, trgtPath); //Change Path
                        path=path.replaceAll("/"+entry.getKey(), "/"+entry.getValue()); //Encrypt FolderName
                    
                    }
                    
                    //create folder
                    
                    File newDir= new File(path);                        
                        if(!newDir.exists()){
                            System.out.println(t.toString().substring(t.toString().lastIndexOf("/"))+" >>> "+path.substring(path.lastIndexOf("/")));
                            newDir.mkdir();
                        }
                    //System.out.println(t.getFileName().toString());
                    
                } catch (Exception ex) {
                    Logger.getLogger(AndroidChangeFolderName.class.getName()).log(Level.SEVERE, null, ex);
                }
                    });
        }catch(Exception ex){
            
        }
       return folderMap; 
    }
    
    
    public  String generateNewKey() throws Exception 
    { 
      // chose a Character random from this String 
        String AlphaNumericString = "ABbCDEFGbaHIb_sJKldsLMNObsPwQRSTUVWxXYZ"
                                    + "012_3556788"
                                    + "asbscdefghijlkqnlqmn_bopqdsrstxuevxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(30); 
        sb.append("s");
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
  
        return sb.toString(); 
     
    }
    
}
