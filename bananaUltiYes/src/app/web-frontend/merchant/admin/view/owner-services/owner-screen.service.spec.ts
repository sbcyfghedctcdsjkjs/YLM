import { TestBed } from '@angular/core/testing';

import { OwnerScreenService_cl } from './owner-screen.service';

describe('OwnerScreenService', () => {
  let service: OwnerScreenService_cl;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OwnerScreenService_cl);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
