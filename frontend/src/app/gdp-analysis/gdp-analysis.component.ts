import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs';
import { CountryService } from '../services/country.service';
import { MaxGdpStat } from '../models/max-gdp-stat';

@Component({
  selector: 'app-gdp-analysis',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './gdp-analysis.component.html',
  styleUrls: ['./gdp-analysis.component.css']
})
export class GdpAnalysisComponent implements OnInit {
  stats$!: Observable<MaxGdpStat[]>;

  constructor(private countryService: CountryService) {}

  ngOnInit(): void {
    this.stats$ = this.countryService.getMaxGdpStats();
  }
}