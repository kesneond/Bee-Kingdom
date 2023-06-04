import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ColoniesDialogComponent } from './colonie-dialog.component';

describe('ColoniesDialogComponent', () => {
  let component: ColoniesDialogComponent;
  let fixture: ComponentFixture<ColoniesDialogComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ColoniesDialogComponent]
    });
    fixture = TestBed.createComponent(ColoniesDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
