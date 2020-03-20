import { Component, OnInit, ViewChild } from '@angular/core';
import { DashboardService } from '../dashboard.service';
import { MatTableDataSource, MatPaginator } from '@angular/material';

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}
const ELEMENT_DATA: PeriodicElement[] = [
  { position: 1, name: 'MSFT', weight: 1085.459, symbol: '1.65%' },
  { position: 2, name: 'AAPL', weight: 1071.03, symbol: '-0.77%' },
  { position: 3, name: 'AMZN', weight: 936.346, symbol: '2.78%' },
  { position: 4, name: 'GOOG', weight: 766.523, symbol: '1.69%' },
  { position: 5, name: 'BABA', weight: 764.035, symbol: '1.88%' },
  { position: 6, name: 'FB', weight: 482.891, symbol: '3.76%' },
  { position: 7, name: 'BRK.B', weight: 436.49, symbol: '4.20%' },
  { position: 8, name: 'BRK.A', weight: 424.621, symbol: '1.30%' },
  { position: 9, name: 'WMT', weight: 424.086, symbol: '2.10%' },
  { position: 10, name: 'VOD', weight: 338.901, symbol: '-5.12%' },
  { position: 11, name: 'JNJ', weight: 337.326, symbol: '8.33%' },
  { position: 12, name: 'V', weight: 338.901, symbol: '-5.86%' },
  { position: 13, name: 'PG', weight: 337.326, symbol: '2.54%' },
  { position: 14, name: 'CHT', weight: 334.948, symbol: '-5.64%' },
  { position: 15, name: 'JPM', weight: 327.081, symbol: '0.97%' },
  { position: 16, name: 'TBC', weight: 273.689, symbol: '1.68%' },
  { position: 17, name: 'TBB', weight: 270.657, symbol: '4.77%' },
  { position: 18, name: 'TSM', weight: 262.21, symbol: '0.82%' },
  { position: 19, name: 'MA', weight: 235.629, symbol: '-1.08%' },
  { position: 20, name: 'T', weight: 230.106, symbol: '5.24%' },
];

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  bigChart = [];
  cards = [];
  pieChart = [];

  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  dataSource = new MatTableDataSource<PeriodicElement>(ELEMENT_DATA);

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  constructor(private dashboardService: DashboardService) { }

  ngOnInit() {
    this.bigChart = this.dashboardService.bigChart();
    this.cards = this.dashboardService.cards();
    this.pieChart = this.dashboardService.pieChart();

    this.dataSource.paginator = this.paginator;
  }

}
