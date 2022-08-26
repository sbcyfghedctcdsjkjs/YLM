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
public class AngularPageNameEncryptor {

    public AngularPageNameEncryptor() {
    }
    
            
    static HashMap<Character,String> encCharToStr=new HashMap<Character,String>();
    static HashMap<String,Character> decStrToChar=new HashMap<String,Character>();
    static Integer pos=0;
    public static void fillEncChar() {
        encCharToStr.put(new Character('A'),"x823uqwy21w");//AdViewerScreen
        encCharToStr.put(new Character('b'),"zqsdxw2387d");//ResetScecret
        encCharToStr.put(new Character('C'),"fasSBVuJQni");//loginScreen
        encCharToStr.put(new Character('D'),"gasxb26662s");//registerScreen_vb
        encCharToStr.put(new Character('E'),"cAKd8wjASKN");//AskToResetS
        encCharToStr.put(new Character('F'),"wBQBAkqbws7");//
        encCharToStr.put(new Character('G'),"vqxsdcNgvsU");//OwnerTargetArea
        encCharToStr.put(new Character('h'),"ns76qfVFSS2");//OwnerListAd
        encCharToStr.put(new Character('I'),"dbcb2dsf301");//ownerScreenUploadAds
        encCharToStr.put(new Character('t'),"ewedwe2342w");//opsView
        encCharToStr.put(new Character('u'),"b32125ca51c");//payThruQRCode
        decStrToChar.put(encCharToStr.get('A'),new Character('A'));
        decStrToChar.put(encCharToStr.get('b'),new Character('b'));
        decStrToChar.put(encCharToStr.get('C'),new Character('C'));
        decStrToChar.put(encCharToStr.get('D'),new Character('D'));
        decStrToChar.put(encCharToStr.get('E'),new Character('E'));
        decStrToChar.put(encCharToStr.get('F'),new Character('F'));
        decStrToChar.put(encCharToStr.get('G'),new Character('G'));
        decStrToChar.put(encCharToStr.get('h'),new Character('h'));
        decStrToChar.put(encCharToStr.get('I'),new Character('I'));
        decStrToChar.put(encCharToStr.get('t'),new Character('t'));
        decStrToChar.put(encCharToStr.get('u'),new Character('u'));
    }
        
    public static  String encryptPageName(String str) throws Exception 
    { 
        Character chr = str.charAt(0);
        
        return new String(String.valueOf(encCharToStr.get(chr)));
    }
    
    public static String decryptPageName(String str) throws Exception 
    {
        fillEncChar();
        return new String(String.valueOf(decStrToChar.get(str)));
    }

    public static void main(String[] args) {
        try {
            AngularPageNameEncryptor ng= new AngularPageNameEncryptor();
            //ng.fillEncChar();
            System.out.println(ng.decryptPageName("ewedwe23421w"));
        } catch (Exception ex) {
            Logger.getLogger(AngularPageNameEncryptor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}