import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthServicesService_cl } from '../auth/auth-services.service';

@Component({
  selector: 'app-call-viewer',
  templateUrl: './call-viewer.component.html',
  styleUrls: ['./call-viewer.component.css']

})
export class CallViewerComponent_cl implements OnInit {
  constructor(private router_vb: Router, private route_vb: ActivatedRoute,
    private authServicesService_vb: AuthServicesService_cl, ) { 

    this.authServicesService_vb.apiKeyDto_vb.apikey_vb=this.route_vb.snapshot.params.p1_vb;
    
  }

  
  ngOnInit(): void {
    this.router_vb.navigate(['/xskdihhsdowqi2423156471hviweroqw017ewg1632jvhq2']);
  }
}