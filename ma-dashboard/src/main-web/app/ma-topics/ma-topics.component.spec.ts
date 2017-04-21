import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MaTopicsComponent } from './ma-topics.component';

describe('MaTopicsComponent', () => {
  let component: MaTopicsComponent;
  let fixture: ComponentFixture<MaTopicsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MaTopicsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MaTopicsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
