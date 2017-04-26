import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaCompanyInfoService } from './ma-company-info.service';
import { MaCompanyInfoComponent } from './ma-company-info.component';

@NgModule({
  imports: [CommonModule],
  declarations: [MaCompanyInfoComponent],
  providers: [MaCompanyInfoService],
  exports: [MaCompanyInfoComponent]
})
export class MaCompanyInfoModule { }
