import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MaHeaderComponent } from './ma-header.component';

describe('MaHeaderComponent', () => {
  let component: MaHeaderComponent;
  let fixture: ComponentFixture<MaHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MaHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MaHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
