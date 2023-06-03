import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ColoniesComponent } from './colonies/colonies.component';

const routes: Routes = [
  { path: '',   redirectTo: '/colonies', pathMatch: 'full' },
  { path: 'colonies', component: ColoniesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
