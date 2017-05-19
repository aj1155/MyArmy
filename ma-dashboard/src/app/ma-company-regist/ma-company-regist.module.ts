import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaCompanyRegistService } from './ma-company-regist.service';
import { MaCompanyRegistComponent } from './ma-company-regist.component';

@NgModule({
  imports: [CommonModule],
  declarations: [MaCompanyRegistComponent],
  providers: [MaCompanyRegistService],
  exports: [MaCompanyRegistComponent]
})
export class MaCompanyRegistModule { }
