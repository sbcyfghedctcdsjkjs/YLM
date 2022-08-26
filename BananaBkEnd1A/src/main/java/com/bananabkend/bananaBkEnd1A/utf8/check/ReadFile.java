/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.utf8.check;

import com.bananabkend.bananaBkEnd1A.SecureClient.ngViewerSecureClient.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringEscapeUtils;

/**
 *
 * @author sunjiv6
 */
public class ReadFile {

    public static void main1(String[] args) {

        File src = new File("/home/sunjiv6/sunws/ProjectWS/bananaWS/AngularWS/frontendbanana/src/app/merchant/admin/view/owner-screen/owner-screen.component.ts");
        File trgt = new File("/home/sunjiv6/sunws/ProjectWS/bananaWS/NetbeansWS/ws1/BananaBkEnd1A/src/main/java/com/"
                + "bananabkend/bananaBkEnd1A/SecureClient/EncryptedFile/new-owner-screen.component2.ts");
        updateFileContent(src, trgt);

    }

    public static String generateNewKey() throws Exception {
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
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb 
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();

    }

    private static void updateFileContent(File src, File trgt) {

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("OwnerScreenService", "");
        map.put("OwnerScreen", "");
        map.put("ResponseSuccess", "");
        map.put("ApiKeyDto", "");
        map.put("MessageList", "");
        map.put("MyAdsDto", "");
        map.put("owner-screen", "");
        map.put("apiKeyDto", "");
        map.put("responseSuccess", "");
        map.put("selectedFile", "");
        map.put("imageSrc", "");
        map.put("showFileName", "");
        map.put("uploadMsg", "");
        map.put("contentDescMaxLength", "");
        map.put("contentDescCurrentLength", "");
        map.put("messageList", "");
        map.put("identifyPhoneValidator", "");
        map.put("identifyEmailValidator", "");
        map.put("secretNumberValidator", "");
        map.put("ownerFileValidator", "");
        map.put("adTypeValidator", "");
        map.put("showSampleView1Flag", "");
        map.put("showSampleView2Flag", "");
        map.put("showSampleView3Flag", "");
        map.put("isModify", "");
        map.put("isModifyId", "");
        map.put("myAdsDto", "");
        map.put("apiKeyDto1", "");
        map.put("ownerScreenService", "");
        map.put("togglePhoneActive", "");
        map.put("gotoTargetsAreaScreen", "");
        map.put("ownerScreen", "");
        map.put("ownerUploadForm", "");
//        map.put("",""); 
//        map.put("",""); 
//        map.put("",""); 
//        map.put("",""); 
//        map.put("",""); 
//        map.put("",""); 
//        map.put("",""); 

        fillMapWithKey(map);
        replaceFileTextWithKey(src, trgt, map);
    }

    private static void fillMapWithKey(HashMap<String, String> srcMap) {

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

    private static void replaceFileTextWithKey(File src, File trgt, HashMap<String, String> srcMap) {
        String fileContext;
        try {
            fileContext = FileUtils.readFileToString(src);

            for (Map.Entry<String, String> entry : srcMap.entrySet()) {

                fileContext = fileContext.replaceAll(entry.getKey(), entry.getValue());

            }
            fileContext = fileContext.replaceAll("\n", " ");
            FileUtils.write(trgt, fileContext);

        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        ReadFile f = new ReadFile();
        try {
            //f.tt();
            //sf.UseStream();
            f.UseCommonsLand();
        } catch (Exception ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void UseCommonsLand() throws Exception {

        byte[] usr_not_exist = "دیں".getBytes("UTF-8");
        String res = new String(usr_not_exist, "UTF-8");
        //System.out.println("\\u"+Integer.toHexString('+'| 0x10000).substring(1));

        String sJava = "\\u0628\\u0631\\u0627\\u06c1\\u0020\\u06a9\\u0631\\u0645\\u0020\\u0635\\u062d\\u06cc\\u062d\\u0020\\u0645\\u0639\\u0644\\u0648\\u0645\\u0627\\u062a\\u0020\\u062f\\u06cc\\u06ba\\u0020\\u0020\\u0020\\u0020";
        System.out.println("StringEscapeUtils.unescapeJava(sJava):\n" + StringEscapeUtils.unescapeJava(sJava));

        IntStream on = "براہ کرم صحیح معلومات دیں    ".chars();
        Stream<Character> chStrm = "براہ کرم صحیح معلومات دیں    ".chars().mapToObj(c -> (char) c);
        //Stream<Integer> chStrm1="براہ کرم صحیح معلومات دیں ".chars().mapToObj(c-> (int) c);

        //chStrm.forEach(p-> System.out.println(":::p"+p+") "+String.format("\\u%04x", (int)p)));
        StringBuffer sb = new StringBuffer();
        chStrm.forEach(p -> sb.append(String.format("\\u%04x", (int) p)));
        System.out.println(sb);
    }

    private static void UseStream() throws Exception {

        byte[] usr_not_exist = "دیں".getBytes("UTF-8");
        String res = new String(usr_not_exist, "UTF-8");
        //System.out.println("\\u"+Integer.toHexString('+'| 0x10000).substring(1));
        char c1 = '1';
        String str2 = "براہ کرم صحیح معلومات دیں    ";

        String s1 = String.format("\\u%04x", (int) '1');

        System.out.println("s1=" + String.format("\\u%04x", (int) '1'));
        System.out.println("s2=" + String.format("\\u%04x", (int) '2'));
        System.out.println("s3=" + String.format("\\u%04x", (int) '3'));
        IntStream on = "براہ کرم صحیح معلومات دیں    ".chars();
        Stream<Character> chStrm = "براہ کرم صحیح معلومات دیں    ".chars().mapToObj(c -> (char) c);
        //Stream<Integer> chStrm1="براہ کرم صحیح معلومات دیں ".chars().mapToObj(c-> (int) c);

        //chStrm.forEach(p-> System.out.println(":::p"+p+") "+String.format("\\u%04x", (int)p)));
        StringBuffer sb = new StringBuffer();
        chStrm.forEach(p -> sb.append(String.format("\\u%04x", (int) p)));
        System.out.println(sb);
    }

    private static void tt() throws Exception {

        byte[] usr_not_exist = "دیں".getBytes("UTF-8");
        String res = new String(usr_not_exist, "UTF-8");
        //System.out.println("\\u"+Integer.toHexString('+'| 0x10000).substring(1));
        char c1 = '1';
        String str2 = "براہ کرم صحیح معلومات دیں    ";

        String s1 = String.format("\\u%04x", (int) '1');

        System.out.println("s1=" + String.format("\\u%04x", (int) '1'));
        System.out.println("s2=" + String.format("\\u%04x", (int) '2'));
        System.out.println("s3=" + String.format("\\u%04x", (int) '3'));
        IntStream on = "براہ کرم صحیح معلومات دیں    ".chars();
        Stream<Character> chStrm = "براہ کرم صحیح معلومات دیں    ".chars().mapToObj(c -> (char) c);
        //Stream<Integer> chStrm1="براہ کرم صحیح معلومات دیں ".chars().mapToObj(c-> (int) c);

        //chStrm.forEach(p-> System.out.println(":::p"+p+") "+String.format("\\u%04x", (int)p)));
        StringBuffer sb = new StringBuffer();

        chStrm.forEach(p -> sb.append(String.format("\\u%04x", (int) p)));
        System.out.println(sb);
        //chStrm1.forEach(p-> System.out.println("::: "+p));

        System.out.println("123: " + on);
        System.out.println("usr_not_exist: " + usr_not_exist);
        BufferedReader in = new BufferedReader(new FileReader("src/main/resources/webViewer/webViewer_ur.properties"));
        String s = null;
        String utf8Str = null;
        while ((s = in.readLine()) != null) {
            utf8Str = new String(s.getBytes(), "UTF-8");
            System.out.println(utf8Str);

            int cnt = 1;
            if (utf8Str.equals(usr_not_exist)) {
                System.out.println(cnt + " :<><><><><><><><><><><><><><><><");
                cnt++;
            }
            utf8Str = null;
        }
    }
}
