import { Component, OnInit } from '@angular/core';
import { MaCompanyInfoService } from './ma-company-info.service';

@Component({
  selector: 'app-ma-company-info',
  templateUrl: './ma-company-info.component.html',
  styleUrls: ['./ma-company-info.component.css']
})
export class MaCompanyInfoComponent implements OnInit {
  result: string

  constructor(private maCompanyInfoService: MaCompanyInfoService) { }

  ngOnInit() {
    this.maCompanyInfoService.test().subscribe(data => {
      console.log(data.result);
      this.result = data.result;
    })
  }

}
