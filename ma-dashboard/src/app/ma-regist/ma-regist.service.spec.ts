import { TestBed, inject } from '@angular/core/testing';

import { MaRegistService } from './ma-regist.service';

describe('MaRegistService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MaRegistService]
    });
  });

  it('should ...', inject([MaRegistService], (service: MaRegistService) => {
    expect(service).toBeTruthy();
  }));
});
