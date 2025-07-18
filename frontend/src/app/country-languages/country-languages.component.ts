import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Observable, switchMap } from 'rxjs';
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

  constructor(
    private route: ActivatedRoute,
    private countryService: CountryService
  ) {}

  ngOnInit(): void {
    this.languages$ = this.route.paramMap.pipe(
      switchMap(params => {
        const countryId = Number(params.get('id'));
        return this.countryService.getLanguagesForCountry(countryId);
      })
    );
  }
}
