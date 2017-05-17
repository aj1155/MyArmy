import { Component, OnInit, Input } from '@angular/core';
import { MaCompanyInfoService } from './ma-company-info.service';

@Component({
  selector: 'app-ma-company-info',
  templateUrl: './ma-company-info.component.html',
  styleUrls: ['./ma-company-info.component.css']
})
export class MaCompanyInfoComponent implements OnInit {

  //@Input()
  //id:any

  companyName: any;
  infoTitle:any;
  deadline:any;
  experience:any;
  grade:any;
  homepage:any;
  occupation:any;
  dDay:any;




  constructor(private maCompanyInfoService: MaCompanyInfoService) { }

  ngOnInit() {
    this.maCompanyInfoService.getCompanyInfo().subscribe(data => {
      this.companyName = data.result.eopcheNm;
      this.infoTitle = data.result.cyjemokNm;
      this.deadline = data.result.magamDt;
      this.experience = data.result.gyeongryeokGbcdNm;
      this.grade = data.result.cjhakryeok;
      this.homepage = data.result.hmpgaddr;
      this.occupation = data.result.eopjongGbcdNm;

      let today = new Date;
      let dd = today.getDate().toString();
      let mm = String(today.getMonth() + 1);
      let yyyy= today.getFullYear().toString();

      if(dd.length == 1){
        dd = '0' + dd;
      }

      if(mm.length == 1){
        mm = '0' + mm;
      }

      let date = Number(yyyy + mm + dd);
      console.log(date);
      console.log(this.deadline);

      this.dDay = this.deadline - date;


    })
  }

}
