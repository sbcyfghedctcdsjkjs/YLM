/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  sunjiv6
 * Created: 6 Jul, 2020
 */
/* BACKUP TO '/home/sunjiv6/sunws/ProjectWS/bananaWS/bananDB/SANJEEV_BANA2_DB_BKUP_14_SEPT_01.zip';  */
INSERT INTO USER_AD_VIEWER ( AD_VIEWER_PHONE , SECRET_NUMBER , USER_NAME , USER_STATUS,User_Type,create_limit,create_count ) VALUES ('2','3','uy','Y','O',4,0);
INSERT INTO USER_AD_VIEWER ( AD_VIEWER_PHONE , SECRET_NUMBER , USER_NAME , USER_STATUS,User_Type,create_limit,create_count ) VALUES ('6','6','Owner Shop','Y','O',4,0);
INSERT INTO USER_AD_VIEWER ( AD_VIEWER_PHONE , SECRET_NUMBER , USER_NAME , USER_STATUS,User_Type,create_limit,create_count ) VALUES ('2','2','Viewer Ji','Y','V',4,0);
insert into USER_OWNER(id,user_phone,secret_number_encoded,create_count,create_limit) values (1,2,3,0,4);
INSERT INTO OWNER_TARGET_AREA ( ALL_TARGETS , USER_OWNER_ID ) VALUES ( 'NOIDA,RAG,[][],NOIDA,DELHI	',1);
--INSERT INTO USER_AD_VIEWER_LIKED_IT ( LIKED_STATUS , OWNER_CONTENT_ID , USER_AD_VIEWER_ID ) VALUES ('Y',1,1);
--INSERT INTO USER_AD_VIEWER_LIKED_IT ( LIKED_STATUS , OWNER_CONTENT_ID , USER_AD_VIEWER_ID ) VALUES ('Y',2,1);
--INSERT INTO USER_AD_VIEWER_LIKED_IT ( LIKED_STATUS , OWNER_CONTENT_ID , USER_AD_VIEWER_ID ) VALUES ('Y',3,1);
--INSERT INTO USER_AD_VIEWER_LIKED_IT ( LIKED_STATUS , OWNER_CONTENT_ID , USER_AD_VIEWER_ID ) VALUES ('Y',4,1);
--INSERT INTO USER_AD_VIEWER_LIKED_IT ( LIKED_STATUS , OWNER_CONTENT_ID , USER_AD_VIEWER_ID ) VALUES ('Y',5,1);
--INSERT INTO USER_AD_VIEWER_LIKED_IT ( LIKED_STATUS , OWNER_CONTENT_ID , USER_AD_VIEWER_ID ) VALUES ('Y',6,1);


--INSERT INTO OWNER_CONTENT(  ACTIVE_DATE , AD_DISPLAY_TYPE , AD_TYPE , CONTENT_DESC , CREATED_ON , DIRECTORY_PATHS_ID , GENERATED_FILE_NAME ,  OWNER_USER_ID , STATUS , UPLOADED_FILE_NAME ) VALUES ( '1596288397748',1,4,'Dog 500,1 view 1 year','1596280447740',1,'1_1596288024059_1',1,'Y','SampleFIleName.png');
--INSERT INTO OWNER_CONTENT(  ACTIVE_DATE , AD_DISPLAY_TYPE , AD_TYPE , CONTENT_DESC , CREATED_ON , DIRECTORY_PATHS_ID , GENERATED_FILE_NAME ,  OWNER_USER_ID , STATUS , UPLOADED_FILE_NAME ) VALUES ( '1596288397748',2,3,'Dog 500,2 view 1 month','1596280447740',1,'1_1596280496410_1',1,'Y','SampleFIleName.png');


Insert into category_model(Category_name_en,status) values ('Instant Announcement(Don''t Miss) ','Y');
Insert into category_model(Category_name_en,status) values ('Weekly Announcement','Y');
Insert into category_model(Category_name_en,status) values ('Monthly Announcement','Y');
Insert into category_model(Category_name_en,status) values ('Yearly Announcement ','Y');
Insert into category_model(Category_name_en,status) values ('Fruit Shop','Y');
Insert into category_model(Category_name_en,status) values ('Vegetable Shop','Y');
Insert into category_model(Category_name_en,status) values ('Carpenter Shop','Y');
Insert into category_model(Category_name_en,status) values ('Furniture Shop','Y');
Insert into category_model(Category_name_en,status) values ('Mobile Shop','Y');
Insert into category_model(Category_name_en,status) values ('Property Dealer','Y');


Update  category_model    set  Category_name_en = 'Instant Announcement(Don''t Miss)'    where id =1;
Update  category_model    set  Category_name_en = 'Weekly Announcement'     where id =2;
Update  category_model    set  Category_name_en = 'Monthly Announcement'  where id =3;
Update  category_model    set  Category_name_en = 'Yearly Announcement '   where id =4;
Update  category_model    set  Category_name_en = 'Fruit Shop','Y'  where id =5;
Update  category_model    set  Category_name_en = 'Vegetable Shop','Y'  where id =6;
Update  category_model    set  Category_name_en = 'Carpenter Shop','Y'  where id =7;
Update  category_model    set  Category_name_en = 'Furniture Shop','Y'  where id =8;
Update  category_model    set  Category_name_en = 'Mobile Shop','Y'  where id =9;
Update  category_model    set  Category_name_en = 'Property Dealer','Y'  where id =10;


Update  category_model    set  Category_name_bn = 'তাত্ক্ষণিক ঘোষণা'     where id =1;
Update  category_model    set  Category_name_bn = 'সাপ্তাহিক ঘোষণা'     where id =2;
Update  category_model    set  Category_name_bn = 'মাসিক ঘোষণা'     where id =3;
Update  category_model    set  Category_name_bn = 'বার্ষিক ঘোষণা'     where id =4;
Update  category_model    set  Category_name_bn = 'ফলের দোকান'     where id =5;
Update  category_model    set  Category_name_bn = 'সবজির দোকান'     where id =6;
Update  category_model    set  Category_name_bn = 'কাঠমিস্ত্রি' where id =7;
Update  category_model    set  Category_name_bn = 'আসবাবপত্র' where id =8;
Update  category_model    set  Category_name_bn = 'মুঠোফোন দোকান' where id =9;
Update  category_model    set  Category_name_bn = 'সম্পত্তি ডিলার' where id =10;

Update  category_model     set  Category_name_gu = '12 કલાકની ઘોષણાઓ'     where id =1;
Update  category_model     set  Category_name_gu = 'સાપ્તાહિક ઘોષણા'     where id =2;;
Update  category_model     set  Category_name_gu = 'માસિક ઘોષણા'     where id =3;
Update  category_model     set  Category_name_gu = 'વાર્ષિક ઘોષણા'     where id =4;
Update  category_model     set  Category_name_gu = 'ફળ'     where id =5;
Update  category_model     set  Category_name_gu = 'શાકભાજી'     where id =6;
Update  category_model     set  Category_name_gu = 'સુથાર'     where id =7;
Update  category_model     set  Category_name_gu = 'ફર્નિચર'     where id =8;
Update  category_model     set  Category_name_gu = 'મોબાઇલ શોપ'     where id =9;
Update  category_model     set  Category_name_gu = 'સંપત્તિ વિક્રેતા'     where id =10;

Update  category_model      set  Category_name_hi = '12 घंटे की घोषणाएँ(ज़रूर देखें...)'     where id =1;
Update  category_model      set  Category_name_hi = 'साप्ताहिक घोषणा'     where id =2;
Update  category_model      set  Category_name_hi = 'मासिक घोषणा'     where id =3;
Update  category_model      set  Category_name_hi = 'वार्षिक घोषणा'     where id =4;
Update  category_model     set  Category_name_hi = 'फल'     where id =5;
Update  category_model     set  Category_name_hi = 'सबजी'     where id =6;
Update  category_model     set  Category_name_hi = 'बढ़ई'     where id =7;
Update  category_model     set  Category_name_hi = 'फर्नीचर'     where id =8;
Update  category_model     set  Category_name_hi = 'मोबाइल की दुकान'     where id =9;
Update  category_model     set  Category_name_hi = 'संपत्ति खरीदें /बेचें'     where id =10;

Update  category_model      set  Category_name_kn = '12 ಗಂಟೆಗಳ ಪ್ರಕಟಣೆಗಳು'     where id =1;
Update  category_model      set  Category_name_kn = 'ಸಾಪ್ತಾಹಿಕ ಪ್ರಕಟಣೆ'     where id =2;
Update  category_model      set  Category_name_kn = 'ಮಾಸಿಕ ಪ್ರಕಟಣೆ'     where id =3;
Update  category_model      set  Category_name_kn = 'ವಾರ್ಷಿಕ ಪ್ರಕಟಣೆ'     where id =4;
Update  category_model     set  Category_name_kn = 'ಹಣ್ಣು'     where id =5;
Update  category_model     set  Category_name_kn = 'ತರಕಾರಿ'     where id =6;
Update  category_model     set  Category_name_kn = 'ಬಡಗಿ'     where id =7;
Update  category_model     set  Category_name_kn = 'ಪೀಠೋಪಕರಣಗಳು'     where id =8;
Update  category_model     set  Category_name_kn = 'ಮೊಬೈಲ್ ಅಂಗಡಿ'     where id =9;
Update  category_model     set  Category_name_kn = 'ಆಸ್ತಿ ಖರೀದಿ / ಮಾರಾಟ'     where id =10;

Update  category_model      set  Category_name_ml = '12 മണിക്കൂർ പ്രഖ്യാപനങ്ങൾ'     where id =1;
Update  category_model      set  Category_name_ml = 'പ്രതിവാര പ്രഖ്യാപനം'     where id =2;
Update  category_model      set  Category_name_ml = 'പ്രതിമാസ പ്രഖ്യാപനം'     where id =3;
Update  category_model      set  Category_name_ml = 'വാർഷിക പ്രഖ്യാപനം'     where id =4;
Update  category_model     set  Category_name_ml = 'ഫലം'     where id =5;
Update  category_model     set  Category_name_ml = 'പച്ചക്കറി'     where id =6;
Update  category_model     set  Category_name_ml = 'ആശാരി'     where id =7;
Update  category_model     set  Category_name_ml = 'ഫർണിച്ചർ'     where id =8;
Update  category_model     set  Category_name_ml = 'മൊബൈൽ ഷോപ്പ്'     where id =9;
Update  category_model     set  Category_name_ml = 'പ്രോപ്പർട്ടി വാങ്ങുക /വിൽക്കുക'     where id =10;


Update  category_model      set  Category_name_mr = '12 तास घोषणा'     where id =1;
Update  category_model      set  Category_name_mr = 'साप्ताहिक घोषणा'     where id =2;
Update  category_model      set  Category_name_mr = 'मासिक घोषणा'     where id =3;
Update  category_model      set  Category_name_mr = 'वार्षिक घोषणा'     where id =4;
Update  category_model     set  Category_name_mr = 'फळ'     where id =5;
Update  category_model     set  Category_name_mr = 'भाजी'     where id =6;
Update  category_model     set  Category_name_mr = 'सुतार'     where id =7;
Update  category_model     set  Category_name_mr = 'फर्निचर'     where id =8;
Update  category_model     set  Category_name_mr = 'मोबाइल शॉप'     where id =9;
Update  category_model     set  Category_name_mr = 'मालमत्ता खरेदी /विक्री'     where id =10;


Update  category_model      set  Category_name_pa = '12 ਘੰਟੇ ਦੇ ਐਲਾਨ'     where id =1;
Update  category_model      set  Category_name_pa = 'ਹਫਤਾਵਾਰੀ ਘੋਸ਼ਣਾ'     where id =2;
Update  category_model      set  Category_name_pa = 'ਮਾਸਿਕ ਘੋਸ਼ਣਾ'     where id =3;
Update  category_model      set  Category_name_pa = 'ਸਲਾਨਾ ਘੋਸ਼ਣਾ'     where id =4;
Update  category_model     set  Category_name_pa = 'ਫਲ'     where id =5;
Update  category_model     set  Category_name_pa = 'ਵੈਜੀਟੇਬਲ'     where id =6;
Update  category_model     set  Category_name_pa = 'ਤਰਖਾਣ'     where id =7;
Update  category_model     set  Category_name_pa = 'ਫਰਨੀਚਰ'     where id =8;
Update  category_model     set  Category_name_pa = 'ਮੋਬਾਈਲ ਦੀ ਦੁਕਾਨ'     where id =9;
Update  category_model     set  Category_name_pa = 'ਜਾਇਦਾਦ ਖਰੀਦੋ / ਵੇਚੋ'     where id =10;


Update  category_model      set  Category_name_ta = '12 மணி நேர அறிவிப்புகள்'     where id =1;
Update  category_model      set  Category_name_ta = 'வாராந்திர அறிவிப்பு'     where id =2;
Update  category_model      set  Category_name_ta = 'மாத அறிவிப்பு'     where id =3;
Update  category_model      set  Category_name_ta = 'ஆண்டு அறிவிப்பு'     where id =4;
Update  category_model     set  Category_name_ta = 'பழம்'     where id =5;
Update  category_model     set  Category_name_ta = 'காய்கறி'     where id =6;
Update  category_model     set  Category_name_ta = 'தச்சு'     where id =7;
Update  category_model     set  Category_name_ta = 'தளபாடங்கள்'     where id =8;
Update  category_model     set  Category_name_ta = 'மொபைல் கடை'     where id =9;
Update  category_model     set  Category_name_ta = 'சொத்து வாங்க / விற்க'     where id =10;


Update  category_model       set  Category_name_te = '12 గంటల ప్రకటనలు'     where id =1;
Update  category_model       set  Category_name_te = 'వారపు ప్రకటన'     where id =2;
Update  category_model       set  Category_name_te = 'నెలవారీ ప్రకటన'     where id =3;
Update  category_model       set  Category_name_te = 'వార్షిక ప్రకటన'     where id =4;
Update  category_model     set  Category_name_te = 'పండు'     where id =5;
Update  category_model     set  Category_name_te = 'కూరగాయ'     where id =6;
Update  category_model     set  Category_name_te = 'వడ్రంగి'     where id =7;
Update  category_model     set  Category_name_te = 'ఫర్నిచర్'     where id =8;
Update  category_model     set  Category_name_te = 'మొబైల్ షాప్'     where id =9;
Update  category_model     set  Category_name_te = 'ఆస్తి కొనండి / అమ్మండి'     where id =10;


Update  category_model       set  Category_name_ur = '12 گھنٹے کے اعلانات'     where id =1;
Update  category_model       set  Category_name_ur = 'ہفتہ وار اعلان'     where id =2;
Update  category_model       set  Category_name_ur = 'ماہانہ اعلان'     where id =3;
Update  category_model       set  Category_name_ur = 'سالانہ اعلان'     where id =4;
Update  category_model     set  Category_name_ur = 'پھل'     where id =5;
Update  category_model     set  Category_name_ur = 'سبزی'     where id =6;
Update  category_model     set  Category_name_ur = 'بڑھئی'     where id =7;
Update  category_model     set  Category_name_ur = 'فرنیچر'     where id =8;
Update  category_model     set  Category_name_ur = 'موبائل شاپ'     where id =9;
Update  category_model     set  Category_name_ur = 'پراپرٹی خریدیں / فروخت کریں'     where id =10;


-- select count(*) as col_0_0_ from owner_target_area ownertarge0_ where ownertarge0_.all_targets like '% NOIDA';   //SPace LAST WORD
-- select count(*) as col_0_0_ from owner_target_area ownertarge0_ where ownertarge0_.all_targets like 'NOIDA %';   //SPace First WORD
-- select count(*) as col_0_0_ from owner_target_area ownertarge0_ where ownertarge0_.all_targets like '% NOIDA %'; //SPace Middle WORD
-- select count(*) as col_0_0_ from owner_target_area ownertarge0_ where ownertarge0_.all_targets like '%,NOIDA';   //COmma Last Word
-- select count(*) as col_0_0_ from owner_target_area ownertarge0_ where ownertarge0_.all_targets like 'NOIDA,%';   //COmma First Word
-- select count(*) as col_0_0_ from owner_target_area ownertarge0_ where ownertarge0_.all_targets like '%,NOIDA';   //COmma Middle Word
-- 
-- all_targets like '% NOIDA'
-- all_targets like 'NOIDA %'
-- all_targets like '% NOIDA %'
-- all_targets like '%,NOIDA'
-- all_targets like 'NOIDA,%'
-- all_targets like '%,NOIDA'
Update  category_model    set  Category_name_en = 'Instant Announcement(Don''t Miss)'    where id =1;
Update  category_model    set  Category_name_en = 'Weekly Announcement'     where id =2;
Update  category_model    set  Category_name_en = 'Monthly Announcement'  where id =3;
Update  category_model    set  Category_name_en = 'Yearly Announcement '   where id =4;
Update  category_model    set  Category_name_bn = 'তাত্ক্ষণিক ঘোষণা'     where id =1;
Update  category_model    set  Category_name_bn = 'সাপ্তাহিক ঘোষণা'     where id =2;
Update  category_model    set  Category_name_bn = 'মাসিক ঘোষণা'     where id =3;
Update  category_model    set  Category_name_bn = 'বার্ষিক ঘোষণা'     where id =4;


Update  category_model     set  Category_name_gu = '12 કલાકની ઘોષણાઓ'     where id =1;
Update  category_model     set  Category_name_gu = 'સાપ્તાહિક ઘોષણા'     where id =2;;
Update  category_model     set  Category_name_gu = 'માસિક ઘોષણા'     where id =3;
Update  category_model     set  Category_name_gu = 'વાર્ષિક ઘોષણા'     where id =4;




Update  category_model      set  Category_name_hi = '12 घंटे की घोषणाएँ(ज़रूर देखें...)'     where id =1;
Update  category_model      set  Category_name_hi = 'साप्ताहिक घोषणा'     where id =2;
Update  category_model      set  Category_name_hi = 'मासिक घोषणा'     where id =3;
Update  category_model      set  Category_name_hi = 'वार्षिक घोषणा'     where id =4;


Update  category_model      set  Category_name_kn = '12 ಗಂಟೆಗಳ ಪ್ರಕಟಣೆಗಳು'     where id =1;
Update  category_model      set  Category_name_kn = 'ಸಾಪ್ತಾಹಿಕ ಪ್ರಕಟಣೆ'     where id =2;
Update  category_model      set  Category_name_kn = 'ಮಾಸಿಕ ಪ್ರಕಟಣೆ'     where id =3;
Update  category_model      set  Category_name_kn = 'ವಾರ್ಷಿಕ ಪ್ರಕಟಣೆ'     where id =4;


Update  category_model      set  Category_name_ml = '12 മണിക്കൂർ പ്രഖ്യാപനങ്ങൾ'     where id =1;
Update  category_model      set  Category_name_ml = 'പ്രതിവാര പ്രഖ്യാപനം'     where id =2;
Update  category_model      set  Category_name_ml = 'പ്രതിമാസ പ്രഖ്യാപനം'     where id =3;
Update  category_model      set  Category_name_ml = 'വാർഷിക പ്രഖ്യാപനം'     where id =4;



Update  category_model      set  Category_name_mr = '12 तास घोषणा'     where id =1;
Update  category_model      set  Category_name_mr = 'साप्ताहिक घोषणा'     where id =2;
Update  category_model      set  Category_name_mr = 'मासिक घोषणा'     where id =3;
Update  category_model      set  Category_name_mr = 'वार्षिक घोषणा'     where id =4;



Update  category_model      set  Category_name_pa = '12 ਘੰਟੇ ਦੇ ਐਲਾਨ'     where id =1;
Update  category_model      set  Category_name_pa = 'ਹਫਤਾਵਾਰੀ ਘੋਸ਼ਣਾ'     where id =2;
Update  category_model      set  Category_name_pa = 'ਮਾਸਿਕ ਘੋਸ਼ਣਾ'     where id =3;
Update  category_model      set  Category_name_pa = 'ਸਲਾਨਾ ਘੋਸ਼ਣਾ'     where id =4;



Update  category_model      set  Category_name_ta = '12 மணி நேர அறிவிப்புகள்'     where id =1;
Update  category_model      set  Category_name_ta = 'வாராந்திர அறிவிப்பு'     where id =2;
Update  category_model      set  Category_name_ta = 'மாத அறிவிப்பு'     where id =3;
Update  category_model      set  Category_name_ta = 'ஆண்டு அறிவிப்பு'     where id =4;



Update  category_model       set  Category_name_te = '12 గంటల ప్రకటనలు'     where id =1;
Update  category_model       set  Category_name_te = 'వారపు ప్రకటన'     where id =2;
Update  category_model       set  Category_name_te = 'నెలవారీ ప్రకటన'     where id =3;
Update  category_model       set  Category_name_te = 'వార్షిక ప్రకటన'     where id =4;



Update  category_model       set  Category_name_ur = '12 گھنٹے کے اعلانات'     where id =1;
Update  category_model       set  Category_name_ur = 'ہفتہ وار اعلان'     where id =2;
Update  category_model       set  Category_name_ur = 'ماہانہ اعلان'     where id =3;
Update  category_model       set  Category_name_ur = 'سالانہ اعلان'     where id =4;


