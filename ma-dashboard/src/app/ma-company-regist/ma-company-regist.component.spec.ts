import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MaCompanyRegistComponent } from './ma-company-regist.component';

describe('MaCompanyRegistComponent', () => {
  let component: MaCompanyRegistComponent;
  let fixture: ComponentFixture<MaCompanyRegistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MaCompanyRegistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MaCompanyRegistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
