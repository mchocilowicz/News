import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, RouterLinkActive} from '@angular/router';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  readonly DEFAULT_COUNTRY = 'pl';

  news: INews;

  constructor(private http: HttpClient, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.url.subscribe(v => {
      this.http.get(`/news/${this.DEFAULT_COUNTRY}/${v[0].path}`).subscribe((data: INews) => {
        this.news = data;
      });
    });
  }
}

interface INews {
  country: string;
  category: string;
  articles: Array<IArticle>;
}

interface IArticle {
  author: string;
  title: string;
  description: string;
  date: string;
  sourceName: string;
  articleUrl: string;
  imageUrl: string;
}
