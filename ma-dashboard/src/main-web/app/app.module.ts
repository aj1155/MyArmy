import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { MaHeaderComponent } from './ma-header/ma-header.component';
import { MaFooterComponent } from './ma-footer/ma-footer.component';
import { MaRegistComponent } from './ma-regist/ma-regist.component';
import { MaTopicsComponent } from './ma-topics/ma-topics.component';
import { MaCompanyListComponent } from './ma-company-list/ma-company-list.component';
import { MaCompanyInfoComponent } from './ma-company-info/ma-company-info.component';

@NgModule({
  declarations: [
    AppComponent,
    MaHeaderComponent,
    MaFooterComponent,
    MaRegistComponent,
    MaTopicsComponent,
    MaCompanyListComponent,
    MaCompanyInfoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
