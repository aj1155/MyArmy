import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MaCompanyInfoComponent } from './ma-company-info/ma-company-info.component';

const appRoutes:Routes = <Routes>[
  //http://localhost:4200/test로 접근하면 MaCompanyInfoComponent 실행
  {path: 'test', /*canActivate: [], */component: MaCompanyInfoComponent},
  {path: '**', redirectTo: ''}
 ];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
