import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup } from '@angular/forms';
import { Observable, BehaviorSubject, switchMap, startWith, debounceTime, combineLatest } from 'rxjs';
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

  private page$ = new BehaviorSubject<number>(0);
  sortColumn$ = new BehaviorSubject<string>('countryName');
  sortDirection$ = new BehaviorSubject<'asc' | 'desc'>('asc');
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
      debounceTime(300)
    );

    this.statsPage$ = combineLatest([
      filters$,
      this.page$,
      this.sortColumn$,
      this.sortDirection$
    ]).pipe(
      switchMap(([filters, page, sort, direction]) =>
        this.demographicService.getStats(filters, page, this.pageSize, sort, direction)
      )
    );
  }

  onPageChange(page: number): void {
    this.page$.next(page);
  }

  onSort(column: string): void {
    const currentSortColumn = this.sortColumn$.value;
    const currentSortDirection = this.sortDirection$.value;

    if (column === currentSortColumn) {
      this.sortDirection$.next(currentSortDirection === 'asc' ? 'desc' : 'asc');
    } else {
      this.sortColumn$.next(column);
      this.sortDirection$.next('asc');
    }

    this.page$.next(0);
  }
}
