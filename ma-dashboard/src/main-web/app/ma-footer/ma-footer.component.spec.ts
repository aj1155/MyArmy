import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MaFooterComponent } from './ma-footer.component';

describe('MaFooterComponent', () => {
  let component: MaFooterComponent;
  let fixture: ComponentFixture<MaFooterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MaFooterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MaFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
