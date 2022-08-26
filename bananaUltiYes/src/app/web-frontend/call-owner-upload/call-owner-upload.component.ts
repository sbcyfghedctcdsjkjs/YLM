import { Component, OnInit } from '@angular/core';
import { ApiKeyDto_cl } from '../merchant/admin/view/owner-services/model/api-key-dto';
import { OwnerScreenService_cl } from '../merchant/admin/view/owner-services/owner-screen.service';
import { ActivatedRoute, Router } from '@angular/router';
import { SharedService_cl } from '../commonUsed/util/shared-service';

@Component({
  selector: 'app-call-owner-upload',
  templateUrl: './call-owner-upload.component.html',
  styleUrls: ['./call-owner-upload.component.css']
})
export class CallOwnerUploadComponent_cl implements OnInit {

  constructor(private router_vb: Router,
    private ownerScreenService_vb : OwnerScreenService_cl,
    private route_vb: ActivatedRoute,private sharedService_vb:SharedService_cl ) 
    { 
    
    
    this.ownerScreenService_vb.apiKeyDto_vb.apikey_vb = this.route_vb.snapshot.params.p1_vb;
    this.ownerScreenService_vb.language_vb = this.route_vb.snapshot.params.p2_vb;
    }
  ngOnInit(): void {
    this.router_vb.navigate(['/callOwner/',this.ownerScreenService_vb.apiKeyDto_vb.apikey_vb,
                                            this.ownerScreenService_vb.language_vb,
                        'owner',this.ownerScreenService_vb.apiKeyDto_vb.apikey_vb,'a']);    
  }
}