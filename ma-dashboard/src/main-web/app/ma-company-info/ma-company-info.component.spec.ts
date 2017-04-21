import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MaCompanyInfoComponent } from './ma-company-info.component';

describe('MaCompanyInfoComponent', () => {
  let component: MaCompanyInfoComponent;
  let fixture: ComponentFixture<MaCompanyInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MaCompanyInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MaCompanyInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
