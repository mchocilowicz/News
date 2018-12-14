import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, RouterLinkActive} from '@angular/router';
import {INews} from '../../models/news.interface';
import {NewsService} from '../../services/news.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  news: INews;

  constructor(private route: ActivatedRoute, private newsService: NewsService) {
  }

  ngOnInit() {
    this.route.url.subscribe(v => {
      this.newsService.getNews(v[0].path).subscribe(news => {
        this.news = news;
      });
    });
  }
}
