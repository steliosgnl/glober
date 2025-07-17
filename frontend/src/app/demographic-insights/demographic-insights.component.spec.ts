import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DemographicInsightsComponent } from './demographic-insights.component';

describe('DemographicInsightsComponent', () => {
  let component: DemographicInsightsComponent;
  let fixture: ComponentFixture<DemographicInsightsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DemographicInsightsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DemographicInsightsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
