import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Observable, switchMap, map } from 'rxjs';
import { CountryService } from '../services/country.service';
import { Language } from '../models/language';

@Component({
  selector: 'app-country-languages',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './country-languages.component.html',
  styleUrl: './country-languages.component.css'
})
export class CountryLanguagesComponent implements OnInit {
  languages$!: Observable<Language[]>;
  countryName$!: Observable<string>;

  constructor(
    private route: ActivatedRoute,
    private countryService: CountryService
  ) {}

  ngOnInit(): void {
    const countryId$ = this.route.paramMap.pipe(
      map(params => Number(params.get('id')))
    );

    this.countryName$ = countryId$.pipe(
      switchMap(id => this.countryService.getCountryName(id)),
      map(response => response.name)
    );

    this.languages$ = countryId$.pipe(
      switchMap(id => this.countryService.getLanguagesForCountry(id))
    );
  }
}
