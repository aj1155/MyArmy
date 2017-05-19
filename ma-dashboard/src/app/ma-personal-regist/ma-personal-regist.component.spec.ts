import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MaPersonalRegistComponent } from './ma-personal-regist.component';

describe('MaPersonalRegistComponent', () => {
  let component: MaPersonalRegistComponent;
  let fixture: ComponentFixture<MaPersonalRegistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MaPersonalRegistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MaPersonalRegistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
