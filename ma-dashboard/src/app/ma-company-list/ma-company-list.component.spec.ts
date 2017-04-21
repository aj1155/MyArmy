import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MaCompanyListComponent } from './ma-company-list.component';

describe('MaCompanyListComponent', () => {
  let component: MaCompanyListComponent;
  let fixture: ComponentFixture<MaCompanyListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MaCompanyListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MaCompanyListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
