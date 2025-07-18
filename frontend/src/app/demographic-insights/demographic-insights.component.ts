import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup } from '@angular/forms';
import { Observable, Subject, switchMap, startWith, debounceTime, distinctUntilChanged } from 'rxjs';
import { DemographicService } from '../services/demographic.service';
import { Region } from '../models/region';
import { Page } from '../models/page';
import { DemographicStat } from '../models/demographic-stat';


@Component({
  selector: 'app-demographic-insights',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './demographic-insights.component.html',
  styleUrls: ['./demographic-insights.component.css']
})
export class DemographicInsightsComponent implements OnInit {
  filterForm: FormGroup;
  regions$: Observable<Region[]>;
  statsPage$: Observable<Page<DemographicStat>>;

  private page$ = new Subject<number>();
  private readonly pageSize = 15;

  constructor(private fb: FormBuilder, private demographicService: DemographicService) {
    this.filterForm = this.fb.group({
      regionId: [null],
      startYear: [null],
      endYear: [null]
    });

    this.regions$ = this.demographicService.getRegions();
    this.statsPage$ = new Observable();
  }

  ngOnInit(): void {
    const filters$ = this.filterForm.valueChanges.pipe(
      startWith(this.filterForm.value),
      debounceTime(300),
      distinctUntilChanged((prev, curr) => JSON.stringify(prev) === JSON.stringify(curr))
    );

    this.statsPage$ = filters$.pipe(
      switchMap(filters => this.page$.pipe(
        startWith(0),
        switchMap(page => this.demographicService.getStats(filters, page, this.pageSize))
      ))
    );
  }

  onPageChange(page: number): void {
    this.page$.next(page);
  }
}
