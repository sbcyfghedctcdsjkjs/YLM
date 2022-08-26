import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable()
export class SharedService_cl {
  private subject_vb = new Subject<any>();
  
  sendClickEvent_mt() {
    this.subject_vb.next();
  }
  getClickEvent_mt(): Observable<any>{ 
    return this.subject_vb.asObservable();
  }
}