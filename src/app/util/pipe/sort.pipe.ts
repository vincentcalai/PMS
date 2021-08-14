import { Pipe, PipeTransform } from '@angular/core';
import { publishReplay } from 'rxjs/operators';

@Pipe({
  name: 'sort',
  pure: true
})
export class SortPipe implements PipeTransform {

  transform(list: any[], column: string, order: boolean): any[] {
    let sortedArray = list.sort((a,b) => {
      if(a[column] > b[column]){
        return 1;
      }
      if(a[column] < b[column]){
        return -1;
      }
      return 0;
    });
    if(order === true){
      return sortedArray
    } else {
      return sortedArray.reverse();
    }
  }

}
