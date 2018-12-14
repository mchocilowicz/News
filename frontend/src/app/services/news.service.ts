import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {INews} from '../models/news.interface';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  private country = environment.country;

  constructor(private http: HttpClient) { }

  getNews(category: string): Observable<INews> {
    return this.http.get<INews>(`/news/${this.country}/${category}`);
  }

  searchBy(query: string): Observable<INews> {
    return this.http.get<INews>(`/news/${this.country}?q=${query}`);
  }
}
