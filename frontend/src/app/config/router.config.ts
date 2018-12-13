import {RouterModule, Routes} from '@angular/router';
import {NewsComponent} from '../components/news/news.component';
import {SearchComponent} from '../components/search/search.component';

const appRoutes: Routes = [
  { path: 'technology', component: NewsComponent },
  { path: ':name',      component: NewsComponent },
  { path: 'search',      component: SearchComponent },
  { path: '',
    redirectTo: '/technology',
    pathMatch: 'full'
  },
  {
    path: '**',
    redirectTo: '/technology',
    pathMatch: 'full'
  }
];

export const router = RouterModule.forRoot(appRoutes);

