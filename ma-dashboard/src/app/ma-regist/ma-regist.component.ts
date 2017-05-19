import { Component, OnInit } from '@angular/core';
import { MaRegistService } from './ma-regist.service';

@Component({
  selector: 'app-ma-regist',
  templateUrl: './ma-regist.component.html',
  styleUrls: ['./ma-regist.component.css']
})

export class MaRegistComponent implements OnInit {
  result : string = "ssss"
  constructor(private maRegistService: MaRegistService) {

  }

  ngOnInit() {

  }

}
