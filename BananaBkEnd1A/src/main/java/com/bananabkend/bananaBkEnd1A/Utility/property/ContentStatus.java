/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bananabkend.bananaBkEnd1A.Utility.property;
/**
 * @author sunjiv6
 */
public class ContentStatus {
    //Only add to the array. Do NOT Delete or Modify.
    public static final String[] DirPathArray={"Only add to the array. Do NOT Delete or Modify.",
                                                "/home/sunbiv/bananaproj/ImagesBananaApp/",
                                                "/home/bunsiv/bunws/projectsWS/bananaWS/ImagesBananaApp/"};    
    public static final Integer DirPathIndex_prod=1;  
    public static final Integer DirPathIndex_dev=2;    
    public static final Integer DirPathIndex=DirPathIndex_dev;  


    public static final Integer AdCreationLimitForOwner=4;// change 1 for Prod 
    public static final Integer TargetAreasLimitForOwner=5;  

//    public static final Integer UserTypeOwner=1;//Owner
//    public static final Integer UserTypeOperator=2;//Operator
//    public static final Integer UserTypeFieldExecutive=3;//Operator
//    public static final Integer Ad2Hrs =1;
//    public static final Integer Ad4Hrs =2;
//    public static final Integer Ad8Hrs =3;
    public static final Integer AdType12Hrs =1;
    public static final Integer AdType1Week =2;
    public static final Integer AdType1Month =3;
    public static final Integer AdType1Year =4;
    public static final Integer InstantAdsFlash =5;
    
    //Ad Status
    public static final Integer ActiveAd =1;
    public static final Integer AdDurationIsComplete =2;
    public static final Integer NotYetStarted =3;
    public static final Integer StoppedInBetween=4;
    
    //adDisplayType
    public static final Integer PX250 =1;
    public static final Integer PX500 =2;
    public static final Integer PX800 =3;    
    
    public static final Long FileSize =50000001L;  //public static final Long FileSize =50000001L;  //50MB
    
    public static final Integer TargetAreaCount=5;  //TA to be show in UI to user
    public static final Integer minRecordCount=1; //the number at which response is sent to mobile
    public static final Integer PageSizeOrTotalRecordsSentToUI =2;  
    public static final Integer WebPageSizeOrTotalRecordsSentToUI =10;  
    
    //UserType
    public static final String OwnerUser ="O";
    public static final String ViewerUser ="V";
    public static final String AdminUser ="A";
    public static final String AdminTransaction ="T";
    public static final String OpsUser ="P";
    
    //Filters
    public static final String All_Category ="ALL";
    public static final String All_AdType ="ALL";
    
    //SecretPhrase
    public static final String[] SecretPhrase={"Hum1Hamarey2",
                                               "Hum2Hamarey4"};    
    //Limit
    public static final Integer RegistrationLimit =300;
    
    public static final Integer ExtraCartProdQuantity =10; /// this is used to be safe from single digits
    
    
    public static final String CartStatus_OrderPlaced="P";
    public static final String CartStatus_OrderAwaited="W";
    public static final String ProductOrder_Status_OrderReceived="PO1";
    public static final String ProductOrder_Status_Processing="PO2";
    public static final String ProductOrder_Status_Packaging="PO3";
    public static final String ProductOrder_Status_PreparingForDispatch="PO4";
    public static final String ProductOrder_Status_Dispatched="PO5";
    public static final String ProductOrder_Status_OutForDelivery="PO6";
    
    public static final String ProductOrder_Status_Delivered="PO7";
    public static final String ProductOrder_Status_Returned="PO8";
    public static final String[] deliveryStatusName={"0","OrderReceived","Processing","Packaging","Preparing For Dispatch"
                                        ,"Dispatched","Out For Delivery","Delivered","Returned"} ;
    public static final String ContentType_Ads="A";
    public static final String ContentType_Product="P";
}