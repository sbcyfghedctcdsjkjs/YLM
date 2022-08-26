package com.bananabkend.bananaBkEnd1A.SecureClient.ngLoginSecureClient;


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
public class ChangeFolderName {
        
    
    String trgtPathFull;//="/home/bunsiv/bunws/projectsWS/bananaWS/AngularWS/publishToGitEnc/WebLoginSecure/target/app/web-login";
    //String srcPathFull="/home/bunsiv/bunws/projectsWS/bananaWS/AngularWS/publishToGitEnc/WebLoginSecure/source/app";
    
    HashMap<String, String> folderMap = null;
    public static void main(String[] args) throws Exception{
            //ChangeFolderName cfn = new ChangeFolderName();
            
            //File f = new File (cfn.trgtPathFull);
            //if(f.exists()) f.delete();
            
            //cfn.folderMap=cfn.createFolder(cfn.srcPathFull);
    }
    
    
    HashMap<String, String> getFolderNameInMap(String srcPathFull)
    {        
        HashMap<String, String> dirMap=new HashMap<String, String>();
        
        
        try (Stream<Path> paths = Files.walk(Paths.get(srcPathFull))) {
            paths.filter(Files::isDirectory)
                    .forEach((t) -> {
                        dirMap.put(t.getFileName().toString(), "");
                        //System.out.println(t.getFileName().toString());
                    });
        }catch(Exception ex){
            
        }
        
        dirMap.remove("app");
        
        return dirMap;
    }
    
     HashMap<String, String> createFolder(String srcPathFull) throws Exception{
        folderMap=getFolderNameInMap(srcPathFull);  
         System.out.println("Folders Name & Key");
        for (Map.Entry<String, String> entry : folderMap.entrySet()) {            
                //entry.setValue(generateNewKey()+"_Fd_"+entry.getKey());
                entry.setValue(generateNewKey());
                System.out.println(entry.getKey()+" >> "+entry.getValue());
        }    
       
        try (Stream<Path> paths = Files.walk(Paths.get(srcPathFull))) {
       
            paths.filter(Files::isDirectory)
                    .forEach((t) -> {
                try {
                    //String fileContext = FileUtils.readFileToString(t.toFile());
                    //FileUtils.write(new File(trgtPath+dirMap.get(t.getFileName().toString())), fileContext);
                    String path = t.toString();
                    for (Map.Entry<String, String> entry : folderMap.entrySet()) {
                        path=path.replaceFirst(srcPathFull, trgtPathFull); //Change Path
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
                    Logger.getLogger(ChangeFolderName.class.getName()).log(Level.SEVERE, null, ex);
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
