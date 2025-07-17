import { ComponentFixture, TestBed } from '@angular/core/testing';
import { GdpAnalysisComponent } from './gdp-analysis.component';

describe('GdpAnalysis', () => {
  let component: GdpAnalysisComponent;
  let fixture: ComponentFixture<GdpAnalysisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GdpAnalysisComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GdpAnalysisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
