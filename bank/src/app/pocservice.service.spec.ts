import { TestBed } from '@angular/core/testing';

import { PocserviceService } from './pocservice.service';

describe('PocserviceService', () => {
  let service: PocserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PocserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
