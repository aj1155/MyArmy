import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MaCompanyInfoComponent } from './ma-company-info/ma-company-info.component';
import { MaFooterComponent } from './ma-footer/ma-footer.component';
import { MaRegistComponent } from './ma-regist/ma-regist.component';
import { MaPersonalRegistComponent} from './ma-personal-regist/ma-personal-regist.component';
import { MaCompanyRegistComponent } from './ma-company-regist/ma-company-regist.component';

const appRoutes:Routes = <Routes>[
  //http://localhost:4200/test로 접근하면 MaCompanyInfoComponent 실행
  {path: 'test', /*canActivate: [], */component: MaCompanyInfoComponent},
  {path: 'footer', component : MaFooterComponent}, // footer routes connect 작성자 : cheoljin 작성일 : 2017.05.01
  {path: 'regist', component : MaRegistComponent}, // regist routes connect 작성자 : cheoljin 작성일 : 2017.05.10
  {path: 'regist/personal', component : MaPersonalRegistComponent},
  {path: 'regist/company', component : MaCompanyRegistComponent},
  {path: '**', redirectTo: ''}
 ];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
