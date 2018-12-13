import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, RouterLinkActive} from '@angular/router';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  readonly DEFAULT_CATEGORY = 'technology';
  readonly DEFAULT_COUNTRY = 'pl';

  newsList: any[];

  constructor(private http: HttpClient, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe( params => {
      const name = params.get('name');
      if (name) {
        this.http.get(`/news/${this.DEFAULT_COUNTRY}/${name}`).subscribe(data => console.log(data));
      } else {
        this.http.get(`/news/${this.DEFAULT_COUNTRY}/${this.DEFAULT_CATEGORY}`).subscribe(data => console.log(data));
      }
    });
  }

}
