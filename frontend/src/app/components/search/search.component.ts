import { Component, OnInit } from '@angular/core';
import {INews} from '../../models/news.interface';
import {NewsService} from '../../services/news.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  news: INews;
  timer;

  constructor(private newsService: NewsService) { }

  ngOnInit() {
  }

  onValueChange(value: string) {
    if (value.length > 0) {
      clearTimeout(this.timer);
      this.timer = setTimeout(() => {
        this.newsService.searchBy(value).subscribe(data => {
          this.news = data;
        });
      }, 250);
    } else {
      this.news = null;
    }
  }

}
