import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'countries', loadComponent: () => import('./countries/countries.component').then(c => c.CountriesComponent)},
  { path: 'countries/:id/languages', loadComponent: () => import('./country-languages/country-languages.component').then(c => c.CountryLanguagesComponent)},
  { path: 'gdp-analysis', loadComponent: () => import('./gdp-analysis/gdp-analysis.component').then(c => c.GdpAnalysisComponent)},
  { path: 'demographic-insights', loadComponent: () => import('./demographic-insights/demographic-insights.component').then(c => c.DemographicInsightsComponent)},
  { path: '**', redirectTo: '' }
];