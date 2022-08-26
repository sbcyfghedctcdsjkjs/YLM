/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.SecureClient.ngCartViewerSecureClient;

import com.bananabkend.bananaBkEnd1A.SecureClient.ngOwnerSecureClient.SecureClientUtil;
import java.io.File;
import java.io.IOException;
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
public class MainCartViewerNames {

    //String trgtPathFull="/home/bunsiv/bunws/projectsWS/bananaWS/AngularWS/publishToGitEnc/CartViewerSecure/target/app/cart-viewer";
    String trgtPathFull="/home/bunsiv/bunws/projectsWS/bananaWS/AngularWS/publishToGitEnc/yesmdiremember/src/app/cart-viewer";
    String srcPathFull="/home/bunsiv/bunws/projectsWS/bananaWS/AngularWS/publishToGitEnc/Secure_appFile/source/app/cart-viewer";
    String appFile="/home/bunsiv/bunws/projectsWS/bananaWS/AngularWS/publishToGitEnc/Secure_appFile";
    Set<String> skipFile=new HashSet<String>();
    HashMap<String, String> fileMap = null;
    HashMap<String, String> folderMap = null;
    HashMap<String, String> classComponentMap = null;
    HashMap<String, String> i10Constants = null;
    HashMap<String, String> i10MsgAppProperties = null;
    HashMap<String, String> methods = null;
    LinkedHashMap<String, String> variables = null;
    
    
    public static void main(String[] args) throws Exception{
//        public static void cartVwr() throws Exception{
//        File src=new File("/home/sunjiv6/sunws/ProjectWS/bananaWS/AngularWS/frontendbanana/src/app/merchant/admin/view/owner-screen/owner-screen.component.ts");
//        File trgt=new File("/home/sunjiv6/sunws/ProjectWS/bananaWS/NetbeansWS/ws1/BananaBkEnd1A/src/main/java/com/"
//                + "bananabkend/bananaBkEnd1A/SecureClient/EncryptedFile/new-owner-screen.component2.ts");
//        updateFileContent(src,trgt);
        MainCartViewerNames ch = new MainCartViewerNames();
        ChangeFolderName cfldn = new ChangeFolderName();
        ChangeFileName cfn = new ChangeFileName();
        cfldn.trgtPathFull=ch.trgtPathFull;
        cfldn.srcPathFull=ch.srcPathFull;
        
        cfn.trgtPathFull=ch.trgtPathFull;
        cfn.srcPathFull=ch.srcPathFull;
        
        ch.folderMap=cfldn.createFolder(ch.srcPathFull);
        ch.fileMap=cfn.createFiles(ch.srcPathFull,ch.folderMap);
        ch.replaceFolderNamesInFile(ch.trgtPathFull,ch.folderMap,ch.fileMap);
        ch.replaceFolderNFileNamesInAppRoutingModule(ch.trgtPathFull,ch.folderMap,ch.fileMap);

        ch.classComponentMap= ch.replaceClassComponentNames(ch.trgtPathFull);
        ch.replaceFolderNamesInAppModule(ch.trgtPathFull,ch.folderMap,ch.fileMap,ch.classComponentMap);
       
        ch.replaceMethodNames(ch.trgtPathFull);        
        ch.replaceVariables(ch.trgtPathFull);
        
        ch.replaceMessageAppProperties(ch.trgtPathFull);
        ch.replaceConstantsInProperties(ch.trgtPathFull);        

        ch.replaceSelectorTags(ch.trgtPathFull);       
        //ch.replaceCssVariables(ch.trgtPathFull);
        //ch.replaceTest();
        
        //ch.putInSingleLine(ch.trgtPathFull);
        //ch.putAllInSingleLIne(trgtPathFull);
            //Back to Original
//          ch.variables=ch.replaceVariables("/home/sunjiv6/sunws/ProjectWS/bananaWS/AngularWS/ForNameChange/TargetNameChange/V_replace");
//          ch.replaceVariablesBackToOriginal("/home/sunjiv6/sunws/ProjectWS/bananaWS/AngularWS/ForNameChange/TargetNameChange/V_replace", 
//                          ch.variables);
          
    }
   
    
   HashMap<String, String> replaceFolderNamesInFile(String trgtPathFull,HashMap<String, String> folderMap,
           HashMap<String, String> fileMap) throws Exception{
       
       skipFile.add("app.component.css");skipFile.add("app.component.html");skipFile.add("app.component.spec.ts");
       skipFile.add("app.component.ts");skipFile.add("cart-viewer.module.ts");
       //skipFile.add("web-viewer-routing.module.ts");
        
       
        try (Stream<Path> paths = Files.walk(Paths.get(trgtPathFull))) {
            paths.filter(Files::isRegularFile)
                    .forEach((t) -> {
                try {
                    String fileContext;
                    
                    fileContext = FileUtils.readFileToString(t.toFile());
                    
                    for (Map.Entry<String, String> entry : folderMap.entrySet()) { 
                        //Replace folder names in "import" stratement       
                        if(t.getFileName().toString().lastIndexOf(".ts") > 0)
                        fileContext = fileContext.replaceAll("/"+entry.getKey()+"/","/"+entry.getValue()+"/");                    
                    }
                    FileUtils.write(t.toFile(), fileContext);
                    
                    fileContext = FileUtils.readFileToString(t.toFile());
                    for (Map.Entry<String, String> entry : fileMap.entrySet()) {
                        //System.out.println(entry.getKey());
                        //Replace filename in "templateUrl" statement i.e. (.html file)
                        if(t.getFileName().toString().lastIndexOf(".ts") > 0 && entry.getKey().lastIndexOf(".html") > 0)
                        fileContext = fileContext.replaceAll("/"+entry.getKey(),
                                                            "/"+ entry.getValue());//+entry.getKey().substring(entry.getValue().lastIndexOf(".")));           
                        
                        //Replace filename in "styleUrls" statement i.e. (.css file)
                        if(t.getFileName().toString().lastIndexOf(".ts") > 0 && entry.getKey().lastIndexOf(".css") > 0)
                        fileContext = fileContext.replaceAll("/"+entry.getKey(),
                                                            "/"+ entry.getValue());
                    }
                    FileUtils.write(t.toFile(), fileContext);
                    
                    
                    fileContext = FileUtils.readFileToString(t.toFile());
//                    if(t.getFileName().toString().indexOf("owner-screen.component.ts")>0)
//                    { 
//                        System.out.println(t.getFileName().toString());}
                    for (Map.Entry<String, String> entry : fileMap.entrySet()) { 
                        
                        //Replace file names in "import" stratement
                        if(t.getFileName().toString().lastIndexOf(".ts") > 0 && entry.getKey().lastIndexOf(".ts") > 0)
                        {
                            //System.out.println(t.getFileName().toString()+" |||  /"+entry.getKey().substring(0,entry.getKey().lastIndexOf(".")-1)+" >> "+"/"+entry.getValue().substring(0,entry.getValue().lastIndexOf(".")-1));
                            fileContext = fileContext.replaceAll("/"+entry.getKey().substring(0,entry.getKey().lastIndexOf("."))+"'",
                                                            "/"+ entry.getValue().substring(0,entry.getValue().lastIndexOf("."))+"'");                        
                        }
                    
                    }
                    FileUtils.write(t.toFile(), fileContext);
                    
                    //create file
                    

                } catch (Exception ex) {

                    Logger.getLogger(ChangeFileName.class.getName()).log(Level.SEVERE, null, ex);
                }
                    });
        }catch(Exception ex){            
        }
       return fileMap; 
    }
    
    
   void replaceFolderNFileNamesInAppRoutingModule(String trgtPathFull,HashMap<String, String> folderMap,
           HashMap<String, String> fileMap) throws Exception{
        String fileContext;
        fileContext = FileUtils.readFileToString(new File(srcPathFull+"/cart-viewer-routing.module.ts"));
        
        for (Map.Entry<String, String> entry : folderMap.entrySet()) {  
            //if(entry.getKey().lastIndexOf(".ts") > 0)
            fileContext = fileContext.replaceAll("/"+entry.getKey()+"/","/"+entry.getValue()+"/");                    }
        
        
        for (Map.Entry<String, String> entry : fileMap.entrySet()) {
            //System.out.println(entry.getKey());
            if(entry.getKey().lastIndexOf(".ts") > 0)
            fileContext = fileContext.replaceAll("/"+entry.getKey().substring(0,entry.getKey().lastIndexOf("."))+"'",
                                                "/"+ entry.getValue().substring(0,entry.getValue().lastIndexOf("."))+"'");                        

        }
        //create file
        FileUtils.write(new File(trgtPathFull+"/cart-viewer-routing.module.ts"), fileContext);
        
        ///start appfilesecure
        fileContext=null;
        fileContext = FileUtils.readFileToString(new File(this.appFile+"/source/app"+"/app-routing.module.ts"));
        
        for (Map.Entry<String, String> entry : folderMap.entrySet()) {  
            //if(entry.getKey().lastIndexOf(".ts") > 0)
            fileContext = fileContext.replaceAll("/"+entry.getKey()+"/","/"+entry.getValue()+"/");                    }
        
        
        for (Map.Entry<String, String> entry : fileMap.entrySet()) {
            //System.out.println(entry.getKey());
            if(entry.getKey().lastIndexOf(".ts") > 0)
            fileContext = fileContext.replaceAll("/"+entry.getKey().substring(0,entry.getKey().lastIndexOf("."))+"'",
                                                "/"+ entry.getValue().substring(0,entry.getValue().lastIndexOf("."))+"'");                        

        }
        //create file
        FileUtils.write(new File(this.appFile+"/target/app"+"/app-routing.module.ts"), fileContext);
   }
   
   void replaceFolderNamesInAppModule(String trgtPathFull,HashMap<String, String> folderMap,
           HashMap<String, String> fileMap,HashMap<String, String> classComponentMap) throws Exception{
        String fileContext;
        
        fileContext = FileUtils.readFileToString(new File(srcPathFull+"/cart-viewer.module.ts"));        
        for (Map.Entry<String, String> entry : folderMap.entrySet()) {  
            //if(entry.getKey().lastIndexOf(".ts") > 0)
            //change import statement folder name
            fileContext = fileContext.replaceAll("/"+entry.getKey()+"/","/"+entry.getValue()+"/");                    }
        
        
        for (Map.Entry<String, String> entry : fileMap.entrySet()) {
            System.out.println(entry.getKey());
            
            //change import statement file name
            if(entry.getKey().lastIndexOf(".ts") > 0)
            fileContext = fileContext.replaceAll("/"+entry.getKey().substring(0,entry.getKey().lastIndexOf("."))+"'",
                                                "/"+ entry.getValue().substring(0,entry.getValue().lastIndexOf("."))+"'");                        

        }
        //create file
        FileUtils.write(new File(trgtPathFull+"/cart-viewer.module.ts"), fileContext);
        //Change class name
        fileContext = FileUtils.readFileToString(new File(trgtPathFull+"/cart-viewer.module.ts"));
        for (Map.Entry<String, String> entry : classComponentMap.entrySet()) {
            fileContext = fileContext.replaceAll(entry.getKey(),entry.getValue());
        }
        //create file
        FileUtils.write(new File(trgtPathFull+"/cart-viewer.module.ts"), fileContext);
        
        ///--------------*********************************-----start 
        fileContext = FileUtils.readFileToString(new File(this.appFile+"/source/app"+"/app.module.ts"));        
        for (Map.Entry<String, String> entry : folderMap.entrySet()) {  
            //if(entry.getKey().lastIndexOf(".ts") > 0)
            //change import statement folder name
            fileContext = fileContext.replaceAll("/"+entry.getKey()+"/","/"+entry.getValue()+"/");                    }
        
        
        for (Map.Entry<String, String> entry : fileMap.entrySet()) {
            System.out.println(entry.getKey());
            
            //change import statement file name
            if(entry.getKey().lastIndexOf(".ts") > 0)
            fileContext = fileContext.replaceAll("/"+entry.getKey().substring(0,entry.getKey().lastIndexOf("."))+"'",
                                                "/"+ entry.getValue().substring(0,entry.getValue().lastIndexOf("."))+"'");                        

        }
        //create file
        FileUtils.write(new File(this.appFile+"/target/app"+"/app.module.ts"), fileContext);
        //Change class name
        fileContext = FileUtils.readFileToString(new File(this.appFile+"/target/app"+"/app.module.ts"));
        for (Map.Entry<String, String> entry : classComponentMap.entrySet()) {
            fileContext = fileContext.replaceAll(entry.getKey(),entry.getValue());
        }
        //create file
        FileUtils.write(new File(this.appFile+"/target/app"+"/app.module.ts"), fileContext);
        
   }
   
   void replaceConstantsInProperties(String trgtPathFull) throws Exception{
       skipFile.add("app.component.css");skipFile.add("app.component.html");skipFile.add("app.component.spec.ts");
       skipFile.add("app.component.ts");skipFile.add("cart-viewer.module.ts");
       skipFile.add("cart-viewer-routing.module.ts");
        
       System.out.println("\n\n\n\n i10Constants>>> \n\n");
       
       LinkedHashMap<String,String> i10Constants1=(new CartViewerContentMapKeys()).constantsInPropertios();
       LinkedHashMap<String,String> i10Constants=SecureClientUtil.sortByLengthDesc(i10Constants1);
       i10Constants1=null;
       for (Map.Entry<String, String> entry : i10Constants.entrySet()) {            
                String nq=generateNewKey();

                entry.setValue(nq);
                System.out.println(entry.getKey()+ " => "+entry.getValue());
        }
       
       
        try (Stream<Path> paths = Files.walk(Paths.get(trgtPathFull))) {
            paths.filter(Files::isRegularFile)
                    .forEach((t) -> {
                try {
                    String fileContext;
                    
                    fileContext = FileUtils.readFileToString(t.toFile());
                    for (Map.Entry<String, String> entry : i10Constants.entrySet()) {
                       // System.out.println(entry.getKey());
                        fileContext = fileContext.replaceAll(entry.getKey(),entry.getValue());
                    
                    }
                    
                    //create file
                    FileUtils.write(t.toFile(), fileContext);

                } catch (Exception ex) {

                    Logger.getLogger(ChangeFileName.class.getName()).log(Level.SEVERE, null, ex);
                }
                    });
        }catch(Exception ex){            
        }
      
   }
   
   LinkedHashMap<String,String> replaceClassComponentNames(String trgtPathFull) throws Exception{
       skipFile.add("app.component.css");skipFile.add("app.component.html");skipFile.add("app.component.spec.ts");
       skipFile.add("app.component.ts");skipFile.add("cart-viewer.module.ts");
       skipFile.add("cart-viewer-routing.module.ts");
        
       System.out.println("\n\n\n\n classComponentMap >> \n\n");
       
       LinkedHashMap<String,String> classComponentMap1=(new CartViewerContentMapKeys()).classComponentNames();
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

                    Logger.getLogger(ChangeFileName.class.getName()).log(Level.SEVERE, null, ex);
                }
                    });
        }catch(Exception ex){            
        }
      return classComponentMap;
   }
   
   
   void replaceMessageAppProperties(String trgtPathFull) throws Exception{
       skipFile.add("app.component.css");skipFile.add("app.component.html");skipFile.add("app.component.spec.ts");
       skipFile.add("app.component.ts");skipFile.add("cart-viewer.module.ts");
       skipFile.add("cart-viewer-routing.module.ts");
        
       System.out.println("\n\n\n\n i10MsgAppProperties >> \n\n");
       
       LinkedHashMap<String,String> i10MsgAppProperties1=(new CartViewerContentMapKeys()).messageAppProperties();
       LinkedHashMap<String,String> i10MsgAppProperties=SecureClientUtil.sortByLengthDesc(i10MsgAppProperties1);
       i10MsgAppProperties1=null;
       for (Map.Entry<String, String> entry : i10MsgAppProperties.entrySet()) {            
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

                        for (Map.Entry<String, String> entry : i10MsgAppProperties.entrySet()) {
                           // System.out.println(entry.getKey());
                            //fileContext = fileContext.replaceAll(entry.getKey(),entry.getValue());

                            fileContext = new String(Files.readAllBytes(Paths.get(t.toString())));
                            fileContext=fileContext.replaceAll(entry.getKey(),entry.getValue());
                            Files.write(Paths.get(t.toString()), fileContext.getBytes());
                        
                        }

                        //create file
                        
                    }    

                } catch (Exception ex) {

                    Logger.getLogger(ChangeFileName.class.getName()).log(Level.SEVERE, null, ex);
                }
                    });
        }catch(Exception ex){            
        }
      
   }
   
   
   void replaceMethodNames(String trgtPathFull) throws Exception{
       skipFile.add("app.component.css");skipFile.add("app.component.html");skipFile.add("app.component.spec.ts");
       skipFile.add("app.component.ts");skipFile.add("cart-viewer.module.ts");
       skipFile.add("cart-viewer-routing.module.ts");
        
       System.out.println("\n\n\n\n methodNameKey >> \n\n");
       
       LinkedHashMap<String,String> methodNameKey1=(new CartViewerContentMapKeys()).methods();
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

                    Logger.getLogger(ChangeFileName.class.getName()).log(Level.SEVERE, null, ex);
                }
                    });
        }catch(Exception ex){            
        }
      
   }
   
   
    void replaceSelectorTags(String trgtPathFull) throws Exception{

        
       System.out.println("\n\n\n\n selectorTagsKey >> \n\n");
       
       LinkedHashMap<String,String> selectorTagsKey1=(new CartViewerContentMapKeys()).selectorTags();
       LinkedHashMap<String,String> selectorTagsKey=SecureClientUtil.sortByLengthDesc(selectorTagsKey1);
       selectorTagsKey1=null;
       for (Map.Entry<String, String> entry : selectorTagsKey.entrySet()) {            
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
                        for (Map.Entry<String, String> entry : selectorTagsKey.entrySet()) {
                            fileContext = new String(Files.readAllBytes(Paths.get(t.toString())));
                           // System.out.println(entry.getKey());
                            //fileContext = fileContext.replaceAll(entry.getKey(),entry.getValue());
                            if(t.getFileName().toString().lastIndexOf(".ts") > 0)
                                fileContext = fileContext.replaceAll("'"+entry.getKey()+"'","'"+entry.getValue()+"'"); 
                            
                            
                            if(t.getFileName().toString().lastIndexOf(".html") > 0)
                            {
//                                fileContext=fileContext.replaceAll("<"+entry.getKey(),"<"+entry.getValue()); 
//                                fileContext=fileContext.replaceAll("</"+entry.getKey()+">","</"+entry.getValue()+">"); 
                                  fileContext=fileContext.replaceAll(entry.getKey(),entry.getValue()); 
                            }
                            Files.write(Paths.get(t.toString()), fileContext.getBytes());                        
                        }                                               
                    }    

                } catch (Exception ex) {
                    Logger.getLogger(ChangeFileName.class.getName()).log(Level.SEVERE, null, ex);
                }
                    });
        }catch(Exception ex){            
        }
      
   }
   
   
   LinkedHashMap<String,String>  replaceVariables(String trgtPathFull) throws Exception{
       skipFile.add("app.component.css");skipFile.add("app.component.html");skipFile.add("app.component.spec.ts");
       skipFile.add("app.component.ts");skipFile.add("cart-viewer.module.ts");
       skipFile.add("cart-viewer-routing.module.ts");
        
       System.out.println("\n\n\n\n variablesNameKey >> \n\n");
       
       LinkedHashMap<String,String> variablesNameKey1=(new CartViewerContentMapKeys()).variables();
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

                    Logger.getLogger(ChangeFileName.class.getName()).log(Level.SEVERE, null, ex);
                }
                    });
        }catch(Exception ex){            
        }
      return variablesNameKey;
   }
   
   LinkedHashMap<String,String>  replaceCssVariables(String trgtPathFull) throws Exception{
     
       System.out.println("\n\n\n\n replaceCssVariables >> \n\n");
       
       LinkedHashMap<String,String> variablesCssNameKey1=(new CartViewerContentMapKeys()).cssVariables();
       LinkedHashMap<String,String> variablesCssNameKey=SecureClientUtil.sortByLengthDesc(variablesCssNameKey1);
       variablesCssNameKey1=null;
       for (Map.Entry<String, String> entry : variablesCssNameKey.entrySet()) {            
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
                        
                        for (Map.Entry<String, String> entry : variablesCssNameKey.entrySet()) {
                           // System.out.println(entry.getKey());
                            //fileContext = fileContext.replaceAll(entry.getKey(),entry.getValue());

                            fileContext = new String(Files.readAllBytes(Paths.get(t.toString())));
                            if(t.getFileName().toString().lastIndexOf(".css") > 0){
                                fileContext=fileContext.replaceAll("."+entry.getKey(),"."+entry.getValue());
                            }
                            
                            if(t.getFileName().toString().lastIndexOf(".html") > 0){
                                fileContext=fileContext.replaceAll("class=\""+entry.getKey(),"class=\""+entry.getValue());
                            }
                            Files.write(Paths.get(t.toString()), fileContext.getBytes());
                        
                        }
                        
                        //create file
                        
                    }    

                } catch (Exception ex) {

                    Logger.getLogger(ChangeFileName.class.getName()).log(Level.SEVERE, null, ex);
                }
                    });
        }catch(Exception ex){            
        }
      return variablesCssNameKey;
   }
   
   void replaceVariablesBackToOriginal(String v_ReplacePath,LinkedHashMap<String,String> variablesNameKey) throws Exception{
        
       System.out.println("\n\n\n\n replaceVariablesBackToOriginal >> \n\n");
       this.createFiles(v_ReplacePath);
       String backToOrigPath="/home/sunjiv6/sunws/ProjectWS/bananaWS/AngularWS/ForNameChange/TargetNameChange/V_bak_Original";
       
        try (Stream<Path> paths = Files.walk(Paths.get(backToOrigPath))) {
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
                            //System.out.println(entry.getValue()+" >>> "+entry.getKey());
                            //fileContext=fileContext.replaceAll(entry.getValue(),entry.getKey());
                            Files.write(Paths.get(t.toString()), fileContext.getBytes());
                        
                        }
                        
                        //create file
                        
                    }    

                } catch (IOException ex) {

                    Logger.getLogger(ChangeFileName.class.getName()).log(Level.SEVERE, null, ex);
                }
                    });
        }catch(IOException ex){            
        }
      
   }
   
   
   void createFiles(String v_ReplacePath) throws Exception{
        try (Stream<Path> paths = Files.walk(Paths.get(v_ReplacePath))) {
            paths.filter(Files::isRegularFile)
                    .forEach((t) -> {
                    
                    //FileUtils.write(new File(trgtPathFull+dirMap.get(t.getFileName().toString())), fileContext);
                try {
                    String fileContext;       
                
                    fileContext = FileUtils.readFileToString(t.toFile());
                
                    String trgtFilePath = t.toString();
                    trgtFilePath=trgtFilePath.replaceAll("V_replace","V_bak_Original");
                
                    FileUtils.write(new File(trgtFilePath), fileContext);
                    
                 } catch (IOException ex) {
                    Logger.getLogger(MainCartViewerNames.class.getName()).log(Level.SEVERE, null, ex);
                }   
            
                    });
        }catch(Exception ex){
            
        }
       //return fileMap; 
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
    
     private  void putInSingleLine(String trgtPathFull) {        
       System.out.println("\n\n\n\n putAllInSingleLIne >> \n\n");   
       skipFile.add("cart-viewer-routing.module.ts");skipFile.add("cart-viewer.module.ts");
        try (Stream<Path> paths = Files.walk(Paths.get(trgtPathFull))) {
            paths.filter(Files::isRegularFile)
                    .forEach((t) -> {
                try {
                    String fileContext;
                    if(!skipFile.contains(t.getFileName().toString())){
                    fileContext = new String(Files.readAllBytes(Paths.get(t.toString())));
                    fileContext=fileContext.replaceAll("\n"," ");
                    Files.write(Paths.get(t.toString()), fileContext.getBytes());
                    }
                } catch (Exception ex) {

                    Logger.getLogger(ChangeFileName.class.getName()).log(Level.SEVERE, null, ex);
                }
                    });
        }catch(Exception ex){            
        }
    }
    
    void replaceLanguageSigns(String trgtPathFull) throws Exception{
        
       System.out.println("\n\n\n\n LanguageName Hiding>> \n\n");
       
       LinkedHashMap<String,String> langName1=(new CartViewerContentMapKeys()).languageHiding();
       LinkedHashMap<String,String> langName=SecureClientUtil.sortByLengthDesc(langName1);
       langName1=null;
       for (Map.Entry<String, String> entry : langName.entrySet()) {            
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
                        for (Map.Entry<String, String> entry : langName.entrySet()) {
                            fileContext = new String(Files.readAllBytes(Paths.get(t.toString())));
                            // System.out.println(entry.getKey());
                            //fileContext = fileContext.replaceAll(entry.getKey(),entry.getValue());
                            if(t.getFileName().toString().lastIndexOf(".ts") > 0)
                                fileContext = fileContext.replaceAll("=='"+entry.getKey()+"'","=='"+entry.getValue()+"'"); 
                            
                            
                            if(t.getFileName().toString().lastIndexOf(".html") > 0)
                            {
//                                fileContext=fileContext.replaceAll("<"+entry.getKey(),"<"+entry.getValue()); 
//                                fileContext=fileContext.replaceAll("</"+entry.getKey()+">","</"+entry.getValue()+">"); 
                                  fileContext=fileContext.replaceAll("changeLang_mt('"+entry.getKey()+"')","changeLang_mt('"+entry.getValue()+"')"); 
                            }
                            Files.write(Paths.get(t.toString()), fileContext.getBytes());                        
                        }                                               
                    }    

                } catch (Exception ex) {
                    Logger.getLogger(ChangeFileName.class.getName()).log(Level.SEVERE, null, ex);
                }
                    });
        }catch(Exception ex){            
        }
   }

    
}
