import { Injectable } from '@angular/core';
import { RequestHandler } from '../shared/handlers/requestHandler';
//index.ts에 접근하려고 하는 서버 주소 설정 후 import
import { COMPANY_INFO } from '../shared/constants/index';

@Injectable()
export class MaCompanyInfoService {

  //requestHandler (get, post, pull, delete)
  constructor(private requestHandler:RequestHandler) { }

  test(){
    console.log(COMPANY_INFO);
    return this.requestHandler.get(COMPANY_INFO);
  }

}
