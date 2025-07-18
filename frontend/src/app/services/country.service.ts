import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Country } from '../models/country';
import { Language } from '../models/language';

@Injectable({
  providedIn: 'root'
})
export class CountryService {
  private apiUrl = 'http://localhost:8080/api/countries';

  constructor(private http: HttpClient) { }

  getCountries(): Observable<Country[]> {
    return this.http.get<Country[]>(this.apiUrl);
  }

  getLanguagesForCountry(countryId: number): Observable<Language[]> {
    return this.http.get<Language[]>(`${this.apiUrl}/${countryId}/languages`);
  }
}