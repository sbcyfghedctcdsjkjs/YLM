/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.SecureClient.ngOwnerSecureClient;

import com.bananabkend.bananaBkEnd1A.SecureClient.ngViewerSecureClient.ViewerContentMapKeys;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author sunjiv6
 */
public class SecureClientUtil {

    public SecureClientUtil() {
    }
    
    public static void main(String[] args) {
        SecureClientUtil s = new SecureClientUtil();
        ViewerContentMapKeys c= new ViewerContentMapKeys();
        LinkedHashMap<String, String> fileMap = c.variables();
        fileMap = s.sortByLengthDesc(fileMap);
        System.out.println("Result:::: ");
        for (Map.Entry<String, String> entry : fileMap.entrySet()) { 
                System.out.println(entry.getKey()+" >>  "+entry.getValue());
                        //fileMap.put(entry.getKey(),entry.getValue());                        
                        
            }
    }
    
    public static LinkedHashMap<String, String> sortByLengthDesc(LinkedHashMap<String, String> fileMap){
    
        Map<String, String> treeMap = new TreeMap<String, String>(
                                                                new Comparator<String>() {
                                                                    @Override
                                                                    public int compare(String s1, String s2) {
                                                                        if (s1.length() > s2.length()) {
                                                                            return -1;
                                                                        } else if (s1.length() < s2.length()) {
                                                                            return 1;
                                                                        } else {
                                                                            return s1.compareTo(s2);
                                                                        }
                                                                    }
                
                                                                });
            
            
            for (Map.Entry<String, String> entry : fileMap.entrySet()) { 
                        treeMap.put(entry.getKey(),entry.getValue());                        
                        
            }
            fileMap=new LinkedHashMap<String, String>();
            for (Map.Entry<String, String> entry : treeMap.entrySet()) { 
                //System.out.println(entry.getKey()+" >>  "+entry.getValue());
                        fileMap.put(entry.getKey(),entry.getValue());                        
                        
            }
            return fileMap;
            
    }
    
    
}
