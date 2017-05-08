import { Component, OnInit } from '@angular/core';
import { MaFooterService } from './ma-footer.service'

@Component({
  selector: 'app-ma-footer',
  templateUrl: './ma-footer.component.html',
  styleUrls: ['./ma-footer.component.css']
})
export class MaFooterComponent implements OnInit {
  result : string
  // win3win_info : string = "win3win정보"
  // blog : string = '블로그';
  // article : string = "관련기사";
  // api : string = "API"
  // employ_info : string = "채용"
  // privacy_policy : string= "개인정보처리방침";
  // terms : string = "약관";
  // directory : string = "디렉터리"
  // language : string = "언어"
  // company : string = "win3win ⓒ 2017"
  constructor(private maFooterService: MaFooterService ) {

  }

  ngOnInit() {

  }
}
