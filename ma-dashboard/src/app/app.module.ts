import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';


import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing.module';
import { MaHeaderComponent } from './ma-header/ma-header.component';
import { MaFooterComponent } from './ma-footer/ma-footer.component';
import { MaRegistComponent } from './ma-regist/ma-regist.component';
import { MaTopicsComponent } from './ma-topics/ma-topics.component';
import { MaCompanyListComponent } from './ma-company-list/ma-company-list.component';
import { MaCompanyInfoComponent } from './ma-company-info/ma-company-info.component';
import { InMemoryOverrideMockDbService } from './shared/mock-data/in-memory-override-mock-db.service';
import { RequestExceptionHandler } from './shared/handlers/requestExceptionHandler';
import { RequestHandler } from './shared/handlers/requestHandler';
import { MaCompanyInfoModule } from './ma-company-info/ma-company-info.module';
import { MaFooterModule } from './ma-footer/ma-footer.module';



@NgModule({
  declarations: [
    AppComponent,
    MaHeaderComponent,
    MaFooterComponent,
    MaRegistComponent,
    MaTopicsComponent,
    MaCompanyListComponent
  ],
  imports: [
    // MaFooterModule,
    MaCompanyInfoModule,
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    InMemoryWebApiModule.forRoot(InMemoryOverrideMockDbService, {delay: 100, passThruUnknownUrl: true})
  ],
  providers: [RequestHandler, RequestExceptionHandler],
  bootstrap: [AppComponent]
})
export class AppModule { }
