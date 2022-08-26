/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.SecureClient.droidSecureClient;

import com.bananabkend.bananaBkEnd1A.SecureClient.ngOwnerSecureClient.SecureClientUtil;
import java.io.File;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author sunjiv6
 */

public class MainAndroidSecureClient {
    String trgtPathFull="/home/sunjiv6/sunws/ProjectWS/AndroidWs/FlutterWS/RenameWork/TargetNameChange/lib";
    String srcPathFull="/home/sunjiv6/sunws/ProjectWS/AndroidWs/FlutterWS/RenameWork/srcNameChange/lib";
    Set<String> skipFile=new HashSet<String>();
    HashMap<String, String> fileMap = null;
    HashMap<String, String> folderMap = null;
    HashMap<String, String> classComponentMap = null;
    HashMap<String, String> i10Constants = null;
    HashMap<String, String> i10MsgAppProperties = null;
    HashMap<String, String> methods = null;
    LinkedHashMap<String, String> variables = null;
    
    
    public static void main(String[] args) throws Exception{
        
        AndroidChangeFolderName cfldn = new AndroidChangeFolderName();
        AndroidChangeFileName cfn = new AndroidChangeFileName();
        MainAndroidSecureClient ch = new MainAndroidSecureClient();
        
        ch.folderMap=cfldn.createFolder(ch.srcPathFull);
        ch.fileMap=cfn.createFiles(ch.srcPathFull,ch.folderMap);
        ch.replaceFolderNamesInFile(ch.trgtPathFull,ch.folderMap,ch.fileMap);
        //ch.replaceFolderNamesInAppRoutingModule(ch.trgtPathFull,ch.folderMap,ch.fileMap);

        ch.classComponentMap= ch.replaceClassComponentNames(ch.trgtPathFull);
        ch.replaceMethodNames(ch.trgtPathFull);        
        ch.replaceVariables(ch.trgtPathFull);    
        ch.replaceVariablesInConstants(ch.trgtPathFull,ch.fileMap,ch.folderMap);
        ch.replaceLanguageI10nVariables(ch.trgtPathFull);    

    }
   
    HashMap<String, String> replaceFolderNamesInFile(String trgtPathFull,HashMap<String, String> folderMap,
           HashMap<String, String> fileMap) throws Exception{
        try (Stream<Path> paths = Files.walk(Paths.get(trgtPathFull))) {
      
            paths.filter(Files::isRegularFile)
                    .forEach((t) -> {
                        
                try {
                    String fileContext;
                    
                    fileContext = FileUtils.readFileToString(t.toFile());
                    
                    for (Map.Entry<String, String> entry : folderMap.entrySet()) { 
                        //Replace folder names in "import '/sd/dsfdv/dvd/wsjw.dart'" stratement       
                        //if(t.getFileName().toString().lastIndexOf(".ts") > 0)
                        fileContext = fileContext.replaceAll("/"+entry.getKey()+"/","/"+entry.getValue()+"/");                    
                    }
                    FileUtils.write(t.toFile(), fileContext);
                    
                    fileContext = FileUtils.readFileToString(t.toFile());

                    
                    for (Map.Entry<String, String> entry : fileMap.entrySet()) { 
                        //Replace file names in "import '/sd/dsfdv/dvd/wsjw.dart'" stratement
                        {
                            //System.out.println(t.getFileName().toString()+" |||  /"+entry.getKey().substring(0,entry.getKey().lastIndexOf(".")-1)+" >> "+"/"+entry.getValue().substring(0,entry.getValue().lastIndexOf(".")-1));
                            fileContext = fileContext.replaceAll("/"+entry.getKey()+"';", "/"+ entry.getValue()+"';");                        
                        }
                    
                    }
                    
                    for (Map.Entry<String, String> entry : fileMap.entrySet()) { 
                        //Replace file names in "import 'laksll.dart'" stratement
                        {
                            //System.out.println(t.getFileName().toString()+" |||  /"+entry.getKey().substring(0,entry.getKey().lastIndexOf(".")-1)+" >> "+"/"+entry.getValue().substring(0,entry.getValue().lastIndexOf(".")-1));
                            fileContext = fileContext.replaceAll("'"+entry.getKey()+"';", "'"+ entry.getValue()+"';");                        
                        }
                    
                    }
                    FileUtils.write(t.toFile(), fileContext);
                    
                    //create file
                    

                } catch (Exception ex) {

                    Logger.getLogger(AndroidChangeFileName.class.getName()).log(Level.SEVERE, null, ex);
                }
                    });
        }catch(Exception ex){            
        }
     
        return fileMap; 
    }    

   LinkedHashMap<String,String> replaceClassComponentNames(String trgtPathFull) throws Exception{

       System.out.println("\n\n\n\n classComponentMap >> \n\n");
       
       LinkedHashMap<String,String> classComponentMap1=(new AndroidContentMapKeys()).classComponentNames();
       LinkedHashMap<String,String> classComponentMap=SecureClientUtil.sortByLengthDesc(classComponentMap1);
       classComponentMap1=null;
       for (Map.Entry<String, String> entry : classComponentMap.entrySet()) {            
                String nq=generateNewKey();

                entry.setValue(nq);
                System.out.println(entry.getKey()+ " => "+entry.getValue());
        }
              
        try (Stream<Path> paths = Files.walk(Paths.get(trgtPathFull))) {
       
            paths.filter(Files::isRegularFile).forEach((t) -> {
                
                try {
                    String fileContext;
                    
                    fileContext = FileUtils.readFileToString(t.toFile());
                    for (Map.Entry<String, String> entry : classComponentMap.entrySet()) {
                       // System.out.println(entry.getKey());
                        fileContext = fileContext.replaceAll(entry.getKey(),entry.getValue());
                        //fileContext = fileContext.replaceAll(" "+entry.getKey()+"()"," "+entry.getValue()+"()");
//                        fileContext = fileContext.replaceAll("/:"+entry.getKey(),"/:"+entry.getValue());
//                        fileContext = fileContext.replaceAll("/: "+entry.getKey(),"/: "+entry.getValue());
//                        fileContext = fileContext.replaceAll(""+entry.getKey()+"/.",""+entry.getValue()+"/.");
                        
                    }
                    
                    //create file
                    FileUtils.write(t.toFile(), fileContext);

                } catch (Exception ex) {

                    Logger.getLogger(AndroidChangeFileName.class.getName()).log(Level.SEVERE, null, ex);
                }
                    });
        }catch(Exception ex){            
        }
      return classComponentMap;
   }
  
   
    void replaceVariablesInConstants(String trgtPathFull,HashMap<String, String> fileMap,HashMap<String, String> folderMap) throws Exception{
        
        System.out.println("\n\n\n\n ConstantsVariables >> \n\n");
       
        LinkedHashMap<String,String> constantsVariablesMap1=(new AndroidContentMapKeys()).ConstantsVariables();
        LinkedHashMap<String,String> constantsVariablesMap=SecureClientUtil.sortByLengthDesc(constantsVariablesMap1);
        constantsVariablesMap1=null;
        for (Map.Entry<String, String> entry : constantsVariablesMap.entrySet()) {            
                String nq=generateNewKey();

                entry.setValue(nq);
                System.out.println(entry.getKey()+ " => "+entry.getValue());
        }
        System.out.println("Path is: "+trgtPathFull+"/"+folderMap.get("mvvm2")+"/"+
                                                    folderMap.get("utils")+"/"+fileMap.get("constants.dart"));
        String fileContext;
        fileContext = FileUtils.readFileToString(new File(trgtPathFull+"/"+folderMap.get("mvvm2")+"/"+
                                                    folderMap.get("utils")+"/"+fileMap.get("constants.dart")));
        
        for (Map.Entry<String, String> entry : constantsVariablesMap.entrySet()) {  
            fileContext = fileContext.replaceAll(entry.getKey(),entry.getValue()); 
        }
        
        //create file
        FileUtils.write(new File(trgtPathFull+"/"+folderMap.get("mvvm2")+"/"+
                                                    folderMap.get("utils")+"/"+fileMap.get("constants.dart")), fileContext);
   }
   
    void replaceMethodNames(String trgtPathFull) throws Exception{
       System.out.println("\n\n\n\n replaceMethodNames >> \n\n");
       LinkedHashMap<String,String> methodNameKey1=(new AndroidContentMapKeys()).methodNames();
       LinkedHashMap<String,String> methodNameKey=SecureClientUtil.sortByLengthDesc(methodNameKey1);
        methodNameKey1=null;

       for (Map.Entry<String, String> entry : methodNameKey.entrySet()) {            
                String nq=generateNewKey();

                entry.setValue(nq);
                System.out.println(entry.getKey()+ " => "+entry.getValue());
        }
       
       
        try (Stream<Path> paths = Files.walk(Paths.get(trgtPathFull))) {

            paths.filter(Files::isRegularFile)

                    .forEach((t) -> {
                try {
                    String fileContext;
                    
                    //if(t.getFileName().toString().indexOf(".html")>0)
                    {
                        //fileContext = FileUtils.readFileToString(t.toFile());

                        for (Map.Entry<String, String> entry : methodNameKey.entrySet()) {
                           // System.out.println(entry.getKey());
                            //fileContext = fileContext.replaceAll(entry.getKey(),entry.getValue());

                            fileContext = new String(Files.readAllBytes(Paths.get(t.toString())));
                            fileContext=fileContext.replaceAll(entry.getKey(),entry.getValue());
                            Files.write(Paths.get(t.toString()), fileContext.getBytes());
                        
                        }

                        //create file
                        
                    }    

                } catch (Exception ex) {

                    Logger.getLogger(AndroidChangeFileName.class.getName()).log(Level.SEVERE, null, ex);
                }
                    });
        }catch(Exception ex){            
        }
      
   }
    
    void replaceLanguageI10nVariables(String trgtPathFull) throws Exception{
       System.out.println("\n\n\n\n replaceLanguageI10nVariables >> \n\n");
       LinkedHashMap<String,String> i10nVariableKey1=(new AndroidContentMapKeys()).languagei10nVariables();
       LinkedHashMap<String,String> i10nVariableKey=SecureClientUtil.sortByLengthDesc(i10nVariableKey1);
        i10nVariableKey1=null;

       for (Map.Entry<String, String> entry : i10nVariableKey.entrySet()) {            
                String nq=generateNewKey();

                entry.setValue(nq);
                System.out.println(entry.getKey()+ " => "+entry.getValue());
        }
       
       
        try (Stream<Path> paths = Files.walk(Paths.get(trgtPathFull))) {

            paths.filter(Files::isRegularFile)

                    .forEach((t) -> {
                try {
                    String fileContext;
                    
                    //if(t.getFileName().toString().indexOf(".html")>0)
                    {
                        //fileContext = FileUtils.readFileToString(t.toFile());

                        for (Map.Entry<String, String> entry : i10nVariableKey.entrySet()) {
                           // System.out.println(entry.getKey());
                            //fileContext = fileContext.replaceAll(entry.getKey(),entry.getValue());

                            fileContext = new String(Files.readAllBytes(Paths.get(t.toString())));
                            fileContext=fileContext.replaceAll(entry.getKey(),entry.getValue());
                            Files.write(Paths.get(t.toString()), fileContext.getBytes());
                        
                        }

                        //create file
                        
                    }    

                } catch (Exception ex) {

                    Logger.getLogger(AndroidChangeFileName.class.getName()).log(Level.SEVERE, null, ex);
                }
                    });
        }catch(Exception ex){            
        }
      
   }
   
    LinkedHashMap<String,String>  replaceVariables(String trgtPathFull) throws Exception{

       System.out.println("\n\n\n\n variablesNameKey >> \n\n");
       
       LinkedHashMap<String,String> variablesNameKey1=(new AndroidContentMapKeys()).variablesNames();
       LinkedHashMap<String,String> variablesNameKey=SecureClientUtil.sortByLengthDesc(variablesNameKey1);
        variablesNameKey1=null;
       for (Map.Entry<String, String> entry : variablesNameKey.entrySet()) {            
                String nq=generateNewKey();

                entry.setValue(nq);
                System.out.println(entry.getKey()+ " => "+entry.getValue());
        }
       
       
        try (Stream<Path> paths = Files.walk(Paths.get(trgtPathFull))) {
            paths.filter(Files::isRegularFile)
                    .forEach((t) -> {
                try {
                    String fileContext;
                    
                    //if(t.getFileName().toString().indexOf(".html")>0)
                    {
                        //fileContext = FileUtils.readFileToString(t.toFile());
                        
                        for (Map.Entry<String, String> entry : variablesNameKey.entrySet()) {
                           // System.out.println(entry.getKey());
                            //fileContext = fileContext.replaceAll(entry.getKey(),entry.getValue());

                            fileContext = new String(Files.readAllBytes(Paths.get(t.toString())));
                            fileContext=fileContext.replaceAll(entry.getKey(),entry.getValue());
                            Files.write(Paths.get(t.toString()), fileContext.getBytes());
                        
                        }
                        
                        //create file
                        
                    }    

                } catch (Exception ex) {

                    Logger.getLogger(AndroidChangeFileName.class.getName()).log(Level.SEVERE, null, ex);
                }
                    });
        }catch(Exception ex){            
        }
      return variablesNameKey;
   }

    
    public static String generateNewKey() throws Exception 
    { 
      // chose a Character random from this String 
        String AlphaNumericString = "ABbCDEFGbaHIbsJKldsLMNObsPwQRSTUVWxXYZ"
                                    + "0123556788"
                                    + "asbscdefghijlkqnlqmnbopqdsrstxuevxyz"; 
  
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
