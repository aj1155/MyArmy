import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaRegistService } from './ma-regist.service';
import { MaRegistComponent } from './ma-regist.component';

@NgModule({
  imports: [CommonModule],
  declarations: [MaRegistComponent],
  providers: [MaRegistService],
  exports: [MaRegistComponent]
})
export class MaRegistModule { }
