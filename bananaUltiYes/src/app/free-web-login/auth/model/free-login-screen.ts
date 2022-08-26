import { FormGroup, FormControl } from '@angular/forms';
export class FreeLoginScreen_cl {
  loginForm_vb:FormGroup= new FormGroup({
        ownerPhone_vb: new FormControl(''),
        ownerEmail_vb: new FormControl(''),
        secretNumber_vb: new FormControl(''),   
        identify_vb: new FormControl(''),     
      });

}