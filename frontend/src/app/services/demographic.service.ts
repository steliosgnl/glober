import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Region } from '../models/region';
import { Page } from '../models/page';
import { DemographicStat } from '../models/demographic-stat';

@Injectable({
  providedIn: 'root'
})
export class DemographicService {
  private apiUrl = 'http://localhost:8080/api/demographics';

  constructor(private http: HttpClient) { }

  // Demographic Insights Task - Loading Region filter list
  getRegions(): Observable<Region[]> {
    return this.http.get<Region[]>(`${this.apiUrl}/regions`);
  }

  // Demographic Insights Task - Loading stats with filters and pagination
  getStats(filters: any, page: number, size: number, sort: string, direction: string): Observable<Page<DemographicStat>> {
    let httpParams = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString());

    if (sort && direction) {
      httpParams = httpParams.append('sort', `${sort},${direction}`);
    }

    if (filters.regionId) {
      httpParams = httpParams.append('regionId', filters.regionId);
    }
    if (filters.startYear) {
      httpParams = httpParams.append('startYear', filters.startYear);
    }
    if (filters.endYear) {
      httpParams = httpParams.append('endYear', filters.endYear);
    }

    return this.http.get<Page<DemographicStat>>(`${this.apiUrl}/stats`, { params: httpParams });
  }
}