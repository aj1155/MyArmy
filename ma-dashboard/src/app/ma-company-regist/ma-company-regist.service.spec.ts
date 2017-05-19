import { TestBed, inject } from '@angular/core/testing';

import { MaCompanyRegistService } from './ma-company-regist.service';

describe('MaCompanyRegistService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MaCompanyRegistService]
    });
  });

  it('should ...', inject([MaCompanyRegistService], (service: MaCompanyRegistService) => {
    expect(service).toBeTruthy();
  }));
});
