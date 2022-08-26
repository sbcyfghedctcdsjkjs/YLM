import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiKeyDto_cl} from '../auth/model/api-key-dto';
import { AuthServicesService_cl } from '../auth/auth-services.service';
import { MyAdsDto_cl } from '../auth/model/my-ads-dto';
import { MessageList_cl } from '../commonUsed/util/message-list';
import { UserDto_cl } from '../auth/model/user-dto'; 
import { Subscription, Observable, timer} from 'rxjs';

import { SharedService_cl } from '../commonUsed/util/shared-service';
import { CartViewerMsg_cl } from './propertyComponent/cart-viewer-msg';
import { CartToolbarComponent_cl } from '../cart-toolbar/cart-toolbar.component';
import { ResponseSuccess_cl } from '../auth/model/response-success';

@Component({
  selector: 'app-cart-screen',
  templateUrl: './cart-screen.component.html',
  styleUrls: ['./cart-screen.component.css']
})
export class CartScreenComponent_cl implements OnInit {

  
  pc:number=0; imageIndex_vb: number=0;imageIndexInc_vb: number=0;
  emptyCart_vb:boolean;
  comma_vb:string=","
  currentSearch_vb:string="";
  userDto_vb:UserDto_cl=new UserDto_cl();
  authServicesService_vb: AuthServicesService_cl;

  apiKeyDto_vb: ApiKeyDto_cl=new ApiKeyDto_cl();
  pageNum_vb:number=1;
  static language_vb:string='en';
  favClicked_vb: boolean=false;
  awaitingSearchMsg_vb:string;

  showLoginRequiredMsg_vb:boolean=false;
  searchDone_vb:Boolean=false; 
  viewerScreenMsg_vb:CartViewerMsg_cl=new CartViewerMsg_cl();
  showSideNavToggle_vb:boolean=true;
  messageList_vb: MessageList_cl= new MessageList_cl();
  myAdsDto_vb:MyAdsDto_cl[];
  likedItemIds_vb: string=this.comma_vb;
  clickSearchEventsubscription_vb:Subscription;
  clickLikedAdsEventsubscription_vb:Subscription;
  logInOutEventsubscription_vb:Subscription;
  pageName_vb:string="x823uqwy21w";
  cartStatus_vb:string;

  constructor(apiKeyDto1_vb: ApiKeyDto_cl,private router_vb: Router,
               authServicesService_vb: AuthServicesService_cl,
               private sharedService_vb:SharedService_cl ,private route_vb: ActivatedRoute, ) {
    this.authServicesService_vb=authServicesService_vb;
    this.apiKeyDto_vb=authServicesService_vb.readApiKeyDto_mt();
    this.apiKeyDto_vb.apikey_vb=this.route_vb.snapshot.params.p1_vb;

    this.userDto_vb.userId_vb=this.route_vb.snapshot.params.p2_vb;
    this.apiKeyDto_vb.lang_vb="en";
    this.clickSearchEventsubscription_vb = this.sharedService_vb.getLoadAdsClickEvent_mt().subscribe(()=>{
      this.userDto_vb.search_vb= this.sharedService_vb.getSearch_mt();                   
      this.callLoadAdsForNewSearch_mt()  });
    this.logInOutEventsubscription_vb = this.sharedService_vb.getLogInOutClickEvent_mt().subscribe(()=>{       
       this.userDto_vb.userId_vb= this.sharedService_vb.getLoginId_mt();                   
       this.userDto_vb.userName_vb= this.sharedService_vb.getLoginName_mt();                   
    
       });
    this.clickLikedAdsEventsubscription_vb = this.sharedService_vb.getLoadLikedAdsClickEvent_mt().subscribe(()=>{
        //this.userDto_vb.search_vb= this.sharedService_vb.getSearch_mt();                   
        this.callLoadLikedAds_mt()  });   
  }

  private subscription_vb: Subscription;

  everySecond_vb: Observable<number> = timer(0, 2000);
  ngOnInit(): void {
    this.subscription_vb = this.everySecond_vb.subscribe((seconds) =>   {
        
        this.showLoginRequiredMsg_vb=false;

        if(this.myAdsDto_vb!=undefined && this.imageIndexInc_vb < this.myAdsDto_vb.length){
          this.sendGetReq_mt(this.imageIndexInc_vb);
        }
      });
     
      this.arrivalToThePage_mt(this.pageName_vb);
      this.callLoadAdsForNewSearch_mt();
      this.changeLang_mt(); 
  }

  ngOnDestroy(): void {
    this.subscription_vb.unsubscribe();  
    this.clickSearchEventsubscription_vb.unsubscribe;
    this.logInOutEventsubscription_vb.unsubscribe;    
    this.clickLikedAdsEventsubscription_vb.unsubscribe;
  }

  newSearch_vb: boolean=false;showLikedAds_vb: boolean=false;
  scrollCalled_vb: boolean=false;
  scrollAns_vb: boolean=false;
  
  callLoadAdsForNewSearch_mt()  {
      {
        this.newSearch_vb=true;
        this.showLikedAds_vb=false;
        this.pageNum_vb=1;
        this.scrollCalled_vb=false;
        this.scrollAns_vb=false;
        this.currentSearch_vb=this.userDto_vb.search_vb;
        this.loadCartProd_mt(this.userDto_vb);
        //this.loadLikedItems_mt();    
      }
  }
  callLoadLikedAds_mt()  {
    {
      this.newSearch_vb=false;
      this.showLikedAds_vb=true;
      this.pageNum_vb=1;
      this.scrollCalled_vb=false;
      this.scrollAns_vb=false;
      //this.currentSearch_vb=this.userDto_vb.search_vb;
      //this.loadLikedAds_mt(this.userDto_vb);
      //this.loadLikedItems_mt();    
    }
}

   arrivalToThePage_mt(pageName_vb){
    const formData_vb = new FormData();

    formData_vb.append('p1', pageName_vb);

    this.authServicesService_vb.recordPlainTrack_vb(formData_vb)
            .subscribe((arrivalRes_vb: any) =>{
                    if(arrivalRes_vb.p3=="N"){
                        this.corruptEveryThing_mt();
                    }
             },

             (error_vb) => {console.log(error_vb);
                  this.corruptEveryThing_mt();
                              }      
            );  
   }
   
   corruptEveryThing_mt(){
   }  

  loadCartProd_mt(userDto_vb:UserDto_cl){
   //this.userDto_vb=userDto_vb;
   const formData_vb = new FormData();
   formData_vb.append('p1', this.userDto_vb.userId_vb);
   formData_vb.append('p2', this.pageNum_vb.toString());
   
   this.authServicesService_vb.getCartProds_mt(formData_vb)
   .subscribe((myAdsDto_vb: any[]) =>{
          if(myAdsDto_vb[0].p3=="N"){
            this.emptyCart_vb=true;
            return;
          }
          if(this.newSearch_vb && (myAdsDto_vb!=null || myAdsDto_vb.length>0)){
             this.myAdsDto_vb = undefined;
             this.myAdsDto_vb= myAdsDto_vb;
             this.pageNum_vb=2;
             this.imageIndexInc_vb=this.pageNum_vb-2;//JUST for
             this.newSearch_vb=false;
             this.searchDone_vb = true;  
             this.awaitingSearchMsg_vb='';  
             this.selectLikedAds_mt();    
          }
          if(myAdsDto_vb == undefined || myAdsDto_vb==null || myAdsDto_vb.length == 0 ){
             this.awaitingSearchMsg_vb=this.viewerScreenMsg_vb.getMsg_mt(this.messageList_vb.httpCodes_vb[1]);
          }
          if(this.scrollCalled_vb &&  myAdsDto_vb.length > 0 )
          {
            this.pageNum_vb++;
            this.myAdsDto_vb=this.myAdsDto_vb.concat(myAdsDto_vb); 
            this.selectLikedAds_mt();           
          }

          this.scrollAns_vb=false;
    
         },
       (error_vb) => {console.log(error_vb);
                   this.searchDone_vb = false; 
                   this.awaitingSearchMsg_vb=this.messageList_vb.httpCodes_vb[''+error_vb.status];  
                   
       }      
   );  
  }

  dontDelete_mt(order_seq_vb:number,i_vb:number){
    if(this.userDto_vb.userId_vb==undefined)
    {
      this.myAdsDto_vb[i_vb].p23=true;
      return;
    }
    if(order_seq_vb<3)
      this.myAdsDto_vb[i_vb].p22=null;
  }
  orderDelete_mt(order_seq_vb:number,i_vb:number){
    if(this.userDto_vb.userId_vb==undefined)
    {
      this.myAdsDto_vb[i_vb].p23=true;
      return;
    }
    if(order_seq_vb==3 && this.cartStatus_vb!='confirm_fx')
      this.myAdsDto_vb[i_vb].p22=4;
  }
  orderDeleteConfirm_mt(order_seq_vb:number,i_vb:number){
    if(this.userDto_vb.userId_vb==undefined)
    {
      this.myAdsDto_vb[i_vb].p23=true;
      return;
    }
    // if(order_seq_vb==4)
    //   {
    //     this.myAdsDto_vb[i_vb].p22=100;
        
    //   }
      const formData_vb = new FormData();
    formData_vb.append('p1', this.userDto_vb.userId_vb);
    formData_vb.append('p2', this.myAdsDto_vb[i_vb].p1);
    formData_vb.append('p3', "2");
    this.refreshCart_vb=true;
    this.authServicesService_vb.addProdToCart_mt(formData_vb)
    .subscribe((responseSuccess_vb: ResponseSuccess_cl) => {
        if(responseSuccess_vb.p3=="Y"){
          this.myAdsDto_vb[i_vb].p22=100;
        }
        //console.log(responseSuccess_vb)
      },
      (error_vb) => {console.log(error_vb)
              }
      );
  }
 processingAddToCart_vb:boolean;

 refreshCart_vb:boolean=false;
  addToCart_mt(plusOrMinus:number,i_vb:number){
    
    if(this.userDto_vb.userId_vb==undefined && this.processingAddToCart_vb==true)
    {
      this.myAdsDto_vb[i_vb].p23=true;
      return;
    }
    
        //this.userDto_vb=userDto_vb;        
    const formData_vb = new FormData();
    formData_vb.append('p1', this.userDto_vb.userId_vb);
    formData_vb.append('p2', this.myAdsDto_vb[i_vb].p1);
    formData_vb.append('p3', plusOrMinus+"");
    formData_vb.append('p4', i_vb+"");
    this.processingAddToCart_vb=true;
    this.refreshCart_vb=true;
    this.authServicesService_vb.addProdToCart_mt(formData_vb)
    .subscribe((responseSuccess_vb: ResponseSuccess_cl) => {

        if(responseSuccess_vb.p3=="Y"){
          this.myAdsDto_vb[responseSuccess_vb.p4].p15=responseSuccess_vb.p2;
          
        }
        this.processingAddToCart_vb=false;
        //console.log(responseSuccess_vb)
      },
      (error_vb) => {this.processingAddToCart_vb=false;
        console.log(error_vb);
              }
      );
  }
  cartOrderConfirm_mt(cart_seq_vb:string){
    if(this.userDto_vb.userId_vb==undefined)
    {
      this.cartStatus_vb=undefined;
      return;
    }
    if(cart_seq_vb=='confirm_fx')
    {
      var goto_vb="/xskdihhsdowqi2423156471hviwerocw017ewg1632jvhq2/deliveryAddress/"+this.apiKeyDto_vb.apikey_vb+"/"+this.userDto_vb.userId_vb;
      this.router_vb.navigate([goto_vb]);
    }   
  }

  loadLikedAds_mt(userDto_vb:UserDto_cl){
    this.userDto_vb=userDto_vb;
    const formData_vb = new FormData();
    formData_vb.append('p1', userDto_vb.userId_vb);
    formData_vb.append('p2', this.pageNum_vb.toString());
    formData_vb.append('p3', userDto_vb.search_vb);
    formData_vb.append('p4', this.sharedService_vb.getSelectedFilter_mt());
    formData_vb.append('p6', this.sharedService_vb.getSelectedAdType_mt());
    this.authServicesService_vb.getCartProds_mt(formData_vb)
    .subscribe((myAdsDto_vb: any[]) =>{
           if(this.showLikedAds_vb && (myAdsDto_vb!=null || myAdsDto_vb.length>0)){
              this.myAdsDto_vb = undefined;
              this.myAdsDto_vb= myAdsDto_vb
              this.pageNum_vb=2;
              this.imageIndexInc_vb=this.pageNum_vb-2;//JUST for
              this.showLikedAds_vb=false;
              this.searchDone_vb = true;  
              this.awaitingSearchMsg_vb='';  
              this.selectLikedAds_mt();    
           }
           if(myAdsDto_vb == undefined || myAdsDto_vb==null || myAdsDto_vb.length == 0 ){
              this.awaitingSearchMsg_vb=this.viewerScreenMsg_vb.getMsg_mt(this.messageList_vb.httpCodes_vb[1]);
           }
           if(this.scrollCalled_vb &&  myAdsDto_vb.length > 0 )
           {
             this.pageNum_vb++;
             this.myAdsDto_vb=this.myAdsDto_vb.concat(myAdsDto_vb); 
             this.showLikedAds_vb=true;
             this.selectLikedAds_mt();           
           }
 
           this.scrollAns_vb=false;
     
          },
        (error_vb) => {console.log(error_vb);
                    this.searchDone_vb = false; 
                    this.awaitingSearchMsg_vb=this.messageList_vb.httpCodes_vb[''+error_vb.status];  
                    
        }      
    );  
   }
  favClicked_mt(i_vb:number){
  
    if(this.userDto_vb.userId_vb==undefined)
    {
      this.showLoginRequiredMsg_vb=true;
      return;
    }
    
    this.showLoginRequiredMsg_vb=false;
    if(this.likedItemIds_vb.indexOf(","+this.myAdsDto_vb[i_vb].p1+",") > -1) {

      this.likedItemIds_vb =this.likedItemIds_vb.replace(","+this.myAdsDto_vb[i_vb].p1+",", ",");
    } else {
      this.likedItemIds_vb =this.likedItemIds_vb+this.myAdsDto_vb[i_vb].p1+",";
    }
    
    this.myAdsDto_vb[i_vb].p21 = !this.myAdsDto_vb[i_vb].p21;   
    
    this.saveLikedItems_mt(); 
  }

  saveLikedItems_mt(){
   const formData_vb = new FormData();
   formData_vb.append('p1', this.userDto_vb.userId_vb);
   formData_vb.append('p2', this.likedItemIds_vb);
   formData_vb.append('p3', this.userDto_vb.likedItemRowId_vb);
   this.authServicesService_vb.getCartProds_mt(formData_vb)
   .subscribe((userDto_vb: any) =>{
                if(userDto_vb.p3==="Y")
                  this.userDto_vb.likedItemRowId_vb=userDto_vb.p1;
               },
       (error_vb) => {
       }      
   );  
  }

  loadLikedItems_mt(){
    if(this.userDto_vb.likedItemRowId_vb!=undefined){
      
     return ;
    }
    const formData_vb = new FormData();
    formData_vb.append('p1', this.userDto_vb.userId_vb);
    formData_vb.append('p2', this.likedItemIds_vb);
    formData_vb.append('p3', this.userDto_vb.likedItemRowId_vb);
    this.authServicesService_vb.getCartProds_mt(formData_vb)
    .subscribe((userDto_vb: any) =>{
                 if(userDto_vb.p3==="Y")
                   this.userDto_vb.likedItemRowId_vb=userDto_vb.p2;
                   this.likedItemIds_vb=userDto_vb.p4;
                   
                   this.selectLikedAds_mt();                   
                },
        (error_vb) => {
        }      
    );  


   }
   selectLikedAds_mt() {
    if(this.myAdsDto_vb == undefined) return;
    for(var n=0;n<this.myAdsDto_vb.length;n++){

      if(this.likedItemIds_vb.indexOf(","+this.myAdsDto_vb[n].p1+",")>-1)
        this.myAdsDto_vb[n].p21=true;
    }
  }

  createImageFromBlob_mt(image_vb: Blob) {
        let reader_vb = new FileReader();
        reader_vb.addEventListener("load", () => {
            this.myAdsDto_vb[this.imageIndex_vb].imageToShow_vb =reader_vb.result;         
        }, false);

        if (image_vb) {
            reader_vb.readAsDataURL(image_vb);
        }
  }

  sendGetReq_mt(i_vb:number){

    this.imageIndex_vb=i_vb;
    this.authServicesService_vb.getImageRequestCreated_mt(this.myAdsDto_vb[i_vb].p1).subscribe(data_vb => {
      this.createImageFromBlob_mt(data_vb);

    }, error_vb => {
      

    });
    this.imageIndexInc_vb+=1;
  }

  onScroll_mt() {
    this.scrollCalled_vb=true;    
    if(!this.scrollAns_vb){
      this.scrollAns_vb=true;
      this.showLikedAds_vb ? this.loadLikedAds_mt(this.userDto_vb) : this.loadCartProd_mt(this.userDto_vb);
    }
  }
  login_required_msg_vb:string;placeOrder_msg_vb:string;currency_msg_vb:string;

  orderPlaced_msg_vb:string;orderConfirm_msg_vb:string;
  orderRemove_msg_vb:string;dontDelete_msg_vb:string;
  confirmRemove_msg_vb:string;ru_sureDelete_msg_vb:string;
  changeLang_mt(){

    CartToolbarComponent_cl.language_vb=this.authServicesService_vb.language_vb;
    let cartScreenMsg_vb: CartViewerMsg_cl = new CartViewerMsg_cl();
      
    this.login_required_msg_vb = cartScreenMsg_vb.getMsg_mt("login_required_msg");

    this.placeOrder_msg_vb= cartScreenMsg_vb.getMsg_mt("placeOrder_msg");

    this.orderPlaced_msg_vb= cartScreenMsg_vb.getMsg_mt("orderPlaced_msg");
    this.orderConfirm_msg_vb= cartScreenMsg_vb.getMsg_mt("orderConfirm_msg");
    this.orderRemove_msg_vb= cartScreenMsg_vb.getMsg_mt("orderRemove_msg");
    this.dontDelete_msg_vb= cartScreenMsg_vb.getMsg_mt("dontDelete_msg");
    this.confirmRemove_msg_vb= cartScreenMsg_vb.getMsg_mt("confirmRemove_msg");
    this.ru_sureDelete_msg_vb= cartScreenMsg_vb.getMsg_mt("ru_sureDelete_msg");
    this.currency_msg_vb= cartScreenMsg_vb.getMsg_mt("currency_msg");
  }

}