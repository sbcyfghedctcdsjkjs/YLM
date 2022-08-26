import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl,FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.css']
})
export class LocationComponent_cl implements OnInit {

  showLocationAtTopToggle_vb: boolean=false;
  locationForm_vb:FormGroup = new FormGroup({
  street_vb: new FormControl(''),
  sectorOrAreaOrIlaka_vb: new FormControl(''),
  city_vb: new FormControl(''),
  state_vb: new FormControl(''),
  pincode_vb: new FormControl('')
  });
  
  constructor(private formBuilder_vb: FormBuilder) {this.createForm_mt(); } 

  ngOnInit(): void {
  }

  showLocationAtTop_mt(){
    this.showLocationAtTopToggle_vb=!this.showLocationAtTopToggle_vb;
  }

  hideLocationAtTop_mt(){
    this.showLocationAtTopToggle_vb=false;
  }

  createForm_mt() {
    this.locationForm_vb = this.formBuilder_vb.group({
      street_vb: '',
      sectorOrAreaOrIlaka_vb: '',
      city_vb: '',
      state_vb: '',
      pincode_vb: ''
    });
}


  

  onSubmit_mt() {
     console.debug('<<<<<<<<<<<< submit hit >>>>>>>>>>>>>..',this.locationForm_vb.controls.city_vb.value);
     this.locationForm_vb.controls.city_vb.setValue("citykjsd");
     if (this.locationForm_vb.invalid) {
        return;
    }

    const formData_vb = new FormData();
  
  }
}
