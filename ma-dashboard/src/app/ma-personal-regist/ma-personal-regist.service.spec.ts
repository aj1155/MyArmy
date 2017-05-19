import { TestBed, inject } from '@angular/core/testing';

import { MaPersonalRegistService } from './ma-personal-regist.service';

describe('MaPersonalRegistService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MaPersonalRegistService]
    });
  });

  it('should ...', inject([MaPersonalRegistService], (service: MaPersonalRegistService) => {
    expect(service).toBeTruthy();
  }));
});
