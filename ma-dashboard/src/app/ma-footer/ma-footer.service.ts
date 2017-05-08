import { Injectable } from '@angular/core';
import { RequestHandler} from '../shared/handlers/requestHandler';
import { FOOTER } from '../shared/constants/index';

@Injectable()
export class MaFooterService {

  constructor(private requestHandler:RequestHandler) { }

  footer() {
    console.log(FOOTER);
    return this.requestHandler.get(FOOTER);
  }

}
