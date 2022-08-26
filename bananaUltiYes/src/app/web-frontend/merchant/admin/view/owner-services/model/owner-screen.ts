
import { FormGroup, FormControl,FormArray,Validators } from '@angular/forms';
export class OwnerScreen_cl {
    ownerUploadForm_vb:FormGroup= new FormGroup({
        ownerPhone_vb: new FormControl(''),
        ownerEmail_vb: new FormControl(''),
        secretNumber_vb: new FormControl(''),
        contentDesc_vb: new FormControl(''),
        adType_vb: new FormControl(''),
        status_vb: new FormControl(''),
        identify_vb: new FormControl(''),
        adDisplayType_vb: new FormControl(''),
        file_vb: new FormControl(''),
        categoryType_vb: new FormControl(''),      
      });
}


