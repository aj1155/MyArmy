import { TestBed, inject } from '@angular/core/testing';

import { MaFooterService } from './ma-footer.service';

describe('MaFooterService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MaFooterService]
    });
  });

  it('should ...', inject([MaFooterService], (service: MaFooterService) => {
    expect(service).toBeTruthy();
  }));
});
