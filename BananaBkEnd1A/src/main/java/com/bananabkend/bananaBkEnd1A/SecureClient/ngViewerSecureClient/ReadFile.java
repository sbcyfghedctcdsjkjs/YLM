/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.SecureClient.ngViewerSecureClient;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author sunjiv6
 */
public class ReadFile {
    
    public static void main(String[] args) {
        
        File src=new File("/home/sunjiv6/sunws/ProjectWS/bananaWS/AngularWS/frontendbanana/src/app/merchant/admin/view/owner-screen/owner-screen.component.ts");
        File trgt=new File("/home/sunjiv6/sunws/ProjectWS/bananaWS/NetbeansWS/ws1/BananaBkEnd1A/src/main/java/com/"
                + "bananabkend/bananaBkEnd1A/SecureClient/EncryptedFile/new-owner-screen.component2.ts");
        updateFileContent(src,trgt);
        
    }
    
    public static String generateNewKey() throws Exception 
    { 
      // chose a Character random from this String 
        String AlphaNumericString = "ABbCDEFGbaHIbsJKldsLMNObsPwQRSTUVWxXYZ"
                                    + "0123556788"
                                    + "asbscdefghijlkqnlqmnbopqdsrstxuevxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(30); 
  
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
    
 
    
    private static void updateFileContent(File src,File trgt) {
        
        
        
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("OwnerScreenService",""); map.put("OwnerScreen","");
        map.put("ResponseSuccess",""); 
        map.put("ApiKeyDto",""); 
        map.put("MessageList",""); 
        map.put("MyAdsDto",""); 
        map.put("owner-screen",""); 
        map.put("apiKeyDto",""); 
        map.put("responseSuccess",""); 
        map.put("selectedFile",""); 
        map.put("imageSrc",""); 
        map.put("showFileName",""); 
        map.put("uploadMsg",""); 
        map.put("contentDescMaxLength",""); 
        map.put("contentDescCurrentLength",""); 
        map.put("messageList",""); 
        map.put("identifyPhoneValidator",""); 
        map.put("identifyEmailValidator",""); 
        map.put("secretNumberValidator",""); 
        map.put("ownerFileValidator",""); 
        map.put("adTypeValidator",""); 
        map.put("showSampleView1Flag",""); 
        map.put("showSampleView2Flag",""); 
        map.put("showSampleView3Flag",""); 
        map.put("isModify",""); 
        map.put("isModifyId",""); 
        map.put("myAdsDto",""); 
        map.put("apiKeyDto1",""); 
        map.put("ownerScreenService",""); 
        map.put("togglePhoneActive",""); 
        map.put("gotoTargetsAreaScreen",""); 
        map.put("ownerScreen",""); 
        map.put("ownerUploadForm",""); 
//        map.put("",""); 
//        map.put("",""); 
//        map.put("",""); 
//        map.put("",""); 
//        map.put("",""); 
//        map.put("",""); 
//        map.put("",""); 

            fillMapWithKey(map);
            replaceFileTextWithKey(src,trgt,map);
    }
    
    
    private  static void fillMapWithKey(HashMap<String,String> srcMap){
        
        String key;
            try {
                for (Map.Entry<String, String> entry : srcMap.entrySet()) {
            
                key = generateNewKey();
                entry.setValue(key);
                System.out.println(entry.getKey() + "/" + entry.getValue());
                }
            } catch (Exception ex) {
                Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        


    }    
    
    
    private static void replaceFileTextWithKey(File src,File trgt,HashMap<String,String> srcMap) {   
        String fileContext;
        try {
            fileContext = FileUtils.readFileToString(src);
            
            for (Map.Entry<String, String> entry : srcMap.entrySet()) {
            
                fileContext = fileContext.replaceAll(entry.getKey(),entry.getValue());

            }
            fileContext = fileContext.replaceAll("\n"," ");
            FileUtils.write(trgt, fileContext);
            
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
