import { Injectable } from '@angular/core';
import { RequestHandler } from '../shared/handlers/requestHandler';
import { REGIST } from '../shared/constants/index';

@Injectable()
export class MaRegistService {

  constructor(private requestHandler:RequestHandler) { }

  regist() {
    console.log(REGIST);
    return this.requestHandler.get(REGIST);
  }
}
