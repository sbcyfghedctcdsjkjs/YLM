import { Component, OnInit } from '@angular/core';
import { ApiKeyDto_cl } from '../owner-services/model/api-key-dto';
import { OwnerScreenService_cl } from '../owner-services/owner-screen.service';

@Component({
  selector: 'app-owner-side-nav',
  templateUrl: './owner-side-nav.component.html',
  styleUrls: ['./owner-side-nav.component.css']
})
export class OwnerSideNavComponent_cl implements OnInit {
  apiKeyDto_vb: ApiKeyDto_cl;

  constructor( apiKeyDto_vb: ApiKeyDto_cl,private ownerScreenService_vb : OwnerScreenService_cl) {    
    this.apiKeyDto_vb=apiKeyDto_vb;
}
  ngOnInit(): void {
    if(this.apiKeyDto_vb.apikey_vb==undefined)
    { 
      
      
      
    }
  }

}
