import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Country } from '../models/country';
import { Language } from '../models/language';
import { MaxGdpStat } from '../models/max-gdp-stat';

@Injectable({
  providedIn: 'root'
})
export class CountryService {
  private apiUrl = 'http://localhost:8080/api/';

  constructor(private http: HttpClient) { }

  // Country-Languages Task
  getCountries(): Observable<Country[]> {
    return this.http.get<Country[]>(`${this.apiUrl}countries`);
  }

  // Country-Languages Task
  getLanguagesForCountry(countryId: number): Observable<Language[]> {
    return this.http.get<Language[]>(`${this.apiUrl}countries/${countryId}/languages`);
  }

  // Max GDP Ratio Task - Gdp Analysis
  getMaxGdpStats(): Observable<MaxGdpStat[]> {
    return this.http.get<MaxGdpStat[]>(`${this.apiUrl}stats/max-gdp-ratio`);
  }

  getCountryName(countryId: number): Observable<{ name: string }> {
    return this.http.get<{ name: string }>(`${this.apiUrl}countries/${countryId}/name`);
  }
}