import { TestBed } from '@angular/core/testing';

import { DemographicService } from './demographic.service';

describe('Demographic', () => {
  let service: DemographicService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DemographicService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
