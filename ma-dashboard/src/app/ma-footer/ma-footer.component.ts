import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ma-footer',
  templateUrl: './ma-footer.component.html',
  styleUrls: ['./ma-footer.component.css']
})
export class MaFooterComponent implements OnInit {
  win3win_info = "win3win정보"
  blog = '블로그';
  article = "관련기사";
  api = "API"
  employ_info = "채용"
  privacy_policy = "개인정보처리방침";
  terms = "약관";
  directory = "디렉터리"
  language = "언어"
  company = "win3win ⓒ 2017"
  constructor() {

  }

  ngOnInit() {
  }

}
