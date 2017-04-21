import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MaRegistComponent } from './ma-regist.component';

describe('MaRegistComponent', () => {
  let component: MaRegistComponent;
  let fixture: ComponentFixture<MaRegistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MaRegistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MaRegistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
