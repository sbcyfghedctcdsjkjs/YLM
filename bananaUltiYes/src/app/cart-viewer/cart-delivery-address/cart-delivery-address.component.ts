import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthServicesService_cl } from '../auth/auth-services.service';
import { ApiKeyDto_cl } from '../auth/model/api-key-dto';
import { NewAddressForm_cl } from '../auth/model/new-address';
import { UserDto_cl } from '../auth/model/user-dto';
import { CartToolbarComponent_cl } from '../cart-toolbar/cart-toolbar.component';
import { CartDeliveryAddressMsg_cl } from './propertyComponent/cart-delivery-address-msg';
@Component({
  selector: 'app-cart-delivery-address',
  templateUrl: './cart-delivery-address.component.html',
  styleUrls: ['./cart-delivery-address.component.css']
})
export class CartDeliveryAddressComponent_cl implements OnInit {
  newAddressFormCl_vb =new NewAddressForm_cl();
  userDto_vb:UserDto_cl=new UserDto_cl();
  authServicesService_vb: AuthServicesService_cl;


  newAddressForm_vb = this.newAddressFormCl_vb.newAddressForm_vb;
  apiKeyDto_vb: ApiKeyDto_cl=new ApiKeyDto_cl();
  constructor(private router_vb: Router,private route_vb: ActivatedRoute,
    authServicesService_vb: AuthServicesService_cl,) {
    this.apiKeyDto_vb.apikey_vb=this.route_vb.snapshot.params.p1_vb;
    this.authServicesService_vb=authServicesService_vb;
    this.userDto_vb.userId_vb=this.route_vb.snapshot.params.p2_vb;
   }
  deliveryAddresses_vb:string[];
  confirmAddress_vb:string;
  addressCnt:string;
  newAddress_vb:string="TEst";
  addressCurrentLength_vb:number=0;
  
  ngOnInit(): void {
    this.changeLang_mt();
    this.deliveryAddresses_vb=new Array();
    
    this.deliveryAddresses_vb[0]="G-55, 2nd Floor Gali No. 2 GovindPuram Uttar Pradesh Pincode: 120021";
    this.deliveryAddresses_vb[1]="G-56, 2nd Floor Gali No. 2 GovindPuram Uttar Pradesh Pincode: 120021";
    this.addressConfirm_mt(0);  
  }

  addressConfirm_mt(i_vb:number){
    this.confirmAddress_vb=this.deliveryAddresses_vb[i_vb];
    this.addressCnt=i_vb +1+ '';
  }

  newAddressConfirm_mt(){
    this.addressCnt='New';
    this.confirmAddress_vb=this.newAddressForm_vb.get('newAddress_vb').value;
  }


  finalAddressConfirm_mt(){
    if(this.confirmAddress_vb==undefined || this.confirmAddress_vb.length < 10){
      this.addressConfirm_mt(0);

    }
    var goto_vb="/xskdihhsdowqi2423156471hviwerocw017ewg1632jvhq2/orderCompleted/"+this.apiKeyDto_vb.apikey_vb+"/"+this.userDto_vb.userId_vb;
    this.router_vb.navigate([goto_vb]);    
  }

  onKeyCountChar_mt(event_vb: any) {
    const eTarget_vb = event_vb.target;
    const maxLength_vb = eTarget_vb.getAttribute("maxlength");
    const currentLength_vb = eTarget_vb.value.length;
    this.addressCurrentLength_vb=eTarget_vb.value.length;
    if (currentLength_vb >= maxLength_vb) {
        return ;
    }    
  }
    confirm_address_heading_msg_vb:string; address_heading_msg_vb:string; 
    deliver_to_address_btn_msg_vb:string; new_address_msg_vb:string;     
    deliver_to_new_address_btn_msg_vb:string; delivery_address_heading_msg_vb:string; 

    confirm_address_btn_msg_vb:string; 
  changeLang_mt(){

    CartToolbarComponent_cl.language_vb=this.authServicesService_vb.language_vb;
    CartToolbarComponent_cl.language_vb='en';
    let cartDeliveryAddressMsg_vb: CartDeliveryAddressMsg_cl = new CartDeliveryAddressMsg_cl();      
    this.confirm_address_heading_msg_vb = cartDeliveryAddressMsg_vb.getMsg_mt("confirm_address_heading_msg");
    this.address_heading_msg_vb= cartDeliveryAddressMsg_vb.getMsg_mt("address_heading_msg");
    this.deliver_to_address_btn_msg_vb= cartDeliveryAddressMsg_vb.getMsg_mt("deliver_to_address_btn_msg");
    this.new_address_msg_vb= cartDeliveryAddressMsg_vb.getMsg_mt("new_address_msg");

    this.deliver_to_new_address_btn_msg_vb= cartDeliveryAddressMsg_vb.getMsg_mt("deliver_to_new_address_btn_msg");
    
    this.delivery_address_heading_msg_vb= cartDeliveryAddressMsg_vb.getMsg_mt("delivery_address_heading_msg");
    this.confirm_address_btn_msg_vb= cartDeliveryAddressMsg_vb.getMsg_mt("confirm_address_btn_msg");
    
  }
}