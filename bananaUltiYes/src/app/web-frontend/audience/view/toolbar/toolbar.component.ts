import { Component, OnInit } from '@angular/core';
import { SideNavComponent_cl } from '../side-nav/side-nav.component';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent_cl implements OnInit {
  title_vb = 'frontendbanana';
  showSideNavToggle_vb: boolean=false;  
  showLocationAtTopToggle_vb: boolean=false;
  constructor() { }
  
  ngOnInit(): void {
  
  }
  
  
  showSideNav_mt(){
    this.showSideNavToggle_vb=!this.showSideNavToggle_vb;
  }

  hideSideNav_mt(){
    this.showSideNavToggle_vb=false;
  }

  showLocationAtTop_mt(){
    this.showLocationAtTopToggle_vb=!this.showLocationAtTopToggle_vb;
  }

  hideLocationAtTop_mt(){
    this.showLocationAtTopToggle_vb=false;
  }
}
