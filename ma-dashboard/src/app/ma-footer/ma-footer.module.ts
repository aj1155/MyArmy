import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaFooterService } from './ma-footer.service'
import { MaFooterComponent } from './ma-footer.component';

@NgModule({
  imports: [CommonModule],
  declarations: [MaFooterComponent],
  providers: [MaFooterService],
  exports: [MaFooterComponent]
})
export class MaFooterModule { }
