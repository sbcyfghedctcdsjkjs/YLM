import { Component, OnInit, Input } from '@angular/core';
import { ToolbarPropertiesEn } from '../appPropertiesEn';
@Component({
  selector: 'app-message',
  template: `{{message_vb}}`,
  styleUrls: ['./properties.component.css']
})
export class PropertiesComponent_cl implements OnInit {

  constructor() { }
   
  @Input() message_vb;

  ngOnInit(): void {
    this.message_vb = ToolbarPropertiesEn[this.message_vb];
    
  }

}