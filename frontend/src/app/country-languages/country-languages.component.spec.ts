import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CountryLanguagesComponent } from './country-languages.component';

describe('CountryLanguages', () => {
  let component: CountryLanguagesComponent;
  let fixture: ComponentFixture<CountryLanguagesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CountryLanguagesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CountryLanguagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
