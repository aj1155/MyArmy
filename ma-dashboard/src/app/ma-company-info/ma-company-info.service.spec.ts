import { TestBed, inject } from '@angular/core/testing';

import { MaCompanyInfoService } from './ma-company-info.service';

describe('MaCompanyInfoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MaCompanyInfoService]
    });
  });

  it('should ...', inject([MaCompanyInfoService], (service: MaCompanyInfoService) => {
    expect(service).toBeTruthy();
  }));
});
