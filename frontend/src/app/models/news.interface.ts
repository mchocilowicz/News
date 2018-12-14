import {IArticle} from './article.interface';

export interface INews {
  country: string;
  category: string;
  articles: Array<IArticle>;
}
