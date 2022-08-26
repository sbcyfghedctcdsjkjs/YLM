
import { FormGroup, FormControl,FormArray } from '@angular/forms';
export class TargetArea_cl {
    ownerTargetAreaForm_vb:FormGroup= new FormGroup({
        ownerPhone_vb: new FormControl(''),
        ownerEmail_vb: new FormControl(''),
        secretNumber_vb: new FormControl(''),
        identify_vb: new FormControl(''),
        targets_vb: new FormArray([])        
      });

}
