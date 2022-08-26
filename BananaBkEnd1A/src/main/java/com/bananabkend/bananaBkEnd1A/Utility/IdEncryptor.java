/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.Utility;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sunjiv6
 */
public class IdEncryptor {

    
    
    public IdEncryptor() {
        this.fillEncLength();
        this.fillEncIdDigits();
    }
    static HashMap<Integer,String> encLength=new HashMap<Integer,String>();
    static HashMap<Integer,String> encIdDigits=new HashMap<Integer,String>();
    static HashMap<String,Integer> decLength=new HashMap<String,Integer>();
    static HashMap<String,Integer> decIdDigits=new HashMap<String,Integer>();
    static Integer pos=0;
    public void fillEncLength() {
        encLength.put(1,"hwetdkjf42wbdcuyweqv");
        encLength.put(2,"dbcwkjed301hbwecuewb");
        encLength.put(3,"nsbkcdkjbck7832bweg8");
        encLength.put(4,"w2356cd2ws7hbcuybcee");
        encLength.put(5,"Clnkw672SfN3478gfwu7");
        encLength.put(6,"gwhjbeduvdsmvnelelee");
        encLength.put(7,"wghdv672vsUhbaqwd67r");
        encLength.put(8,"fajkwdbhwjihbaqodnqm");
        encLength.put(9,"zqskjwedjhdwhe8126fd");
        encLength.put(10,"x3jweqwy23wwhjbvdx6");
        encLength.put(11,"uwed623v67waghsxasxn");
        encLength.put(12,"hjwved7v237ahgsvxydv");
        encLength.put(13,"zxvcyt66ew2wehvd672e");
        encLength.put(14,"lNXYTQTC532wevd6723s");
        encLength.put(15,"ANBSXTY56Q2dcbuwbcuf");
        encLength.put(16,"236feqw5632wqy672vxr");
        encLength.put(17,"ascw332vdu2237dvdvww");
        encLength.put(18,"cbxzncwyew8qxbuywevq");
        encLength.put(19,"w8457hjbsd6fb347fiuf");
        encLength.put(20,"bdjuevrq263wehbwueik");
        decLength.put(encLength.get(1),1);decLength.put(encLength.get(11),11);
        decLength.put(encLength.get(2),2);decLength.put(encLength.get(12),12);
        decLength.put(encLength.get(3),3);decLength.put(encLength.get(13),13);
        decLength.put(encLength.get(4),4);decLength.put(encLength.get(14),14);
        decLength.put(encLength.get(5),5);decLength.put(encLength.get(15),15);
        decLength.put(encLength.get(6),6);decLength.put(encLength.get(16),16);
        decLength.put(encLength.get(7),7);decLength.put(encLength.get(17),17);
        decLength.put(encLength.get(8),8);decLength.put(encLength.get(18),18);
        decLength.put(encLength.get(9),9);decLength.put(encLength.get(19),19);
        decLength.put(encLength.get(10),10);decLength.put(encLength.get(20),20);
        
    }
    
    public void fillEncIdDigits() {
        encIdDigits.put(1,"kcbw3238dhb");
        encIdDigits.put(2,"mbbvs2q32gs");
        encIdDigits.put(3,"abxankjqvel");
        encIdDigits.put(4,"zb2we234erd");
        encIdDigits.put(5,"ubcgw782v28");
        encIdDigits.put(6,"ocsa67wvxc8");
        encIdDigits.put(7,"lawr3wd32f3");
        encIdDigits.put(8,"tebc873bb78");
        encIdDigits.put(9,"sasxvc673y8");
        encIdDigits.put(0,"rsadcb8737b");
        decIdDigits.put(encIdDigits.get(1),1);  
        decIdDigits.put(encIdDigits.get(2),2);  
        decIdDigits.put(encIdDigits.get(3),3);  
        decIdDigits.put(encIdDigits.get(4),4);  
        decIdDigits.put(encIdDigits.get(5),5);  
        decIdDigits.put(encIdDigits.get(6),6);  
        decIdDigits.put(encIdDigits.get(7),7);  
        decIdDigits.put(encIdDigits.get(8),8);  
        decIdDigits.put(encIdDigits.get(9),9);  
        decIdDigits.put(encIdDigits.get(0),0);            
    }

    public static void main(String[] args) {
        
        IdEncryptor gn = new IdEncryptor();
        Long id = 1234567890123456789L;

        try {
            
            System.out.println(gn.encryptId(id));
            System.out.println(gn.decryptId(gn.encryptId(id)));
        } catch (Exception ex) {
            Logger.getLogger(IdEncryptor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  String encryptId(Long id) throws Exception 
    { 
        //this.fillEncLength();
        //this.fillEncIdDigits();
        //GenerateEncryptId gn = new IdEncryptor();
        if(id==null) return null;
        StringBuilder encId=new StringBuilder();
        //String encLen=String.valueOf(String.valueOf(id).length());
        try {
            encId.append((encLength.get(String.valueOf(id).length())));
        } catch (Exception ex) {
            Logger.getLogger(IdEncryptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        int n=0;
        while (n< String.valueOf(id).length()) {
             encId.append(encIdDigits.get(Integer.parseInt(String.valueOf(id).substring(n,n+1))));
            n++;
        }
        //encId.append(this.generateNewKey("a"));
//        encLength=null;
//        decLength=null;                
//        encIdDigits=null;
//        decIdDigits=null;
        return encId.toString();
    }
    
 public  Long decryptId(String encId) throws Exception 
    { 
//        this.fillEncLength();
//        this.fillEncIdDigits();
       // IdEncryptor gn = new IdEncryptor();
        //StringBuilder key=new StringBuilder();
        System.out.println("encId:"+encId);
        if(encId==null) return null;
        Integer idLen = decLength.get(encId.substring(pos, encLength.get(1).length()+pos));
        String encIdDgts=encId.substring(pos+encLength.get(1).length());
        Integer n=0;
        Integer st=0;
        StringBuilder idStr = new StringBuilder();
        
        
        while (n< idLen) {
            st=n*encIdDigits.get(1).length();
            idStr.append(decIdDigits.get(encIdDgts.substring(st,(n+1)*encIdDigits.get(1).length())));
            n++;
        }
//        encLength=null;
//        decLength=null;                
//        encIdDigits=null;
//        decIdDigits=null;
        return Long.parseLong(idStr.toString());
    }   
    
    
    public  String generateNewKey(String enclen) throws Exception 
    { 
      // chose a Character random from this String 
        String AlphaNumericString = "ABFGbaHIb_JL55MNObsPwQR012VWxXYZ"
                                    + "0123556788";
                                     
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(); 
       
        
        for (int i = 0; i < 8; i++) { 
            // generate a random number between 

            // 0 to AlphaNumericString variable length 
            if(i==pos){
                sb.append(enclen);
            }else{
                int index 
                    = (int)(AlphaNumericString.length() 
                            * Math.random()); 

                // add Character one by one in end of sb 

                sb.append(AlphaNumericString 
                              .charAt(index)); 
            }
        } 

        return sb.toString(); 
     
    }
}
