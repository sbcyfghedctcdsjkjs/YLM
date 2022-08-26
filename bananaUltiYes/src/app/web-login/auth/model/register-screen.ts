import { FormGroup, FormControl } from '@angular/forms';
export class RegisterScreen_cl {
  registerForm_vb:FormGroup= new FormGroup({
        ownerPhone_vb: new FormControl(''),
        ownerEmail_vb: new FormControl(''),
        secretNumber_vb: new FormControl(''),      
        userName_vb: new FormControl(''),        
      });
}


