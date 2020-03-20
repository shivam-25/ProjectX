import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor() { }

  bigChart() {
    return [{
      name: 'MSFT',
      data: [502, 635, 809, 947, 1402, 3634, 5268]
    }, {
      name: 'AAPL',
      data: [106, 107, 111, 133, 221, 767, 1766]
    }, {
      name: 'AMZN',
      data: [163, 203, 276, 408, 547, 729, 628]
    }, {
      name: 'GOOG',
      data: [18, 31, 54, 156, 339, 818, 1201]
    }, {
      name: 'FB',
      data: [2, 2, 2, 6, 13, 30, 46]
    }];
  }

  cards() {
    return [71, 78, 39, 66];
  }

  pieChart() {
    return [{
      name: 'MSFT',
      y: 61.41,
      sliced: true,
      selected: true
    }, {
      name: 'AAPL',
      y: 11.84
    }, {
      name: 'AMZN',
      y: 10.85
    }, {
      name: 'GOOG',
      y: 4.67
    }, {
      name: 'FB',
      y: 4.18
    }, {
      name: 'WMT',
      y: 1.64
    }, {
      name: 'V',
      y: 1.6
    }, {
      name: 'PG',
      y: 1.2
    }, {
      name: 'MA',
      y: 2.61
    }];
  }
}
