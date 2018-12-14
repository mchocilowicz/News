import {RouterModule, Routes} from '@angular/router';
import {NewsComponent} from '../components/news/news.component';
import {SearchComponent} from '../components/search/search.component';
import {environment} from '../../environments/environment';

const appRoutes: Routes = [
  { path: 'search', component: SearchComponent },
  { path: '',
    redirectTo: 'search',
    pathMatch: 'full'
  }
];

environment.routes.forEach( route => {
  appRoutes.push({ path: route, component: NewsComponent });
});


export const router = RouterModule.forRoot(appRoutes);

