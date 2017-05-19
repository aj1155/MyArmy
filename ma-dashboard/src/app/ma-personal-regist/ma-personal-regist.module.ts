import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaPersonalRegistService } from './ma-personal-regist.service';
import { MaPersonalRegistComponent } from './ma-personal-regist.component';

@NgModule({
  imports: [CommonModule],
  declarations: [MaPersonalRegistComponent],
  providers: [MaPersonalRegistService],
  exports: [MaPersonalRegistComponent]
})
export class MaPersonalRegistModule { }
