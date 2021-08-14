import { HttpClient, HttpErrorResponse, HttpEvent, HttpHeaders, HttpParams, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import * as fileSaver from 'file-saver';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  api_url: String = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  post(url, model): Observable<Object> {
    return this.http.post(this.api_url + url, model).pipe(
      catchError(this.handleError)
    );
  }

  get(url): Observable<Object> {
    return this.http.get(this.api_url + url).pipe(
      catchError(this.handleError)
    );
  }

  put(url,model): Observable<Object> {
    return this.http.put(this.api_url + url, model).pipe(
      catchError(this.handleError)
    );
  }

  delete(url): Observable<Object> {
    return this.http.delete(this.api_url + url).pipe(
      catchError(this.handleError)
    );
  }

  downloadTmplt(fileName){
    const param = new HttpParams().set('fileName', fileName);
    const url = '/downloadTmplt';
    return this.http.get(this.api_url + url,{
      params: param,
      responseType: 'arraybuffer'
    }).subscribe(res => {
      if (res) {
        var blob= new Blob([res], { type: 'application'});
        fileSaver.saveAs(blob, fileName);
      }
    })
  }

  downloadFile(fileId, url){
    const param = new HttpParams().set('fileId', fileId);

    console.log(this.api_url + url);
    return this.http.get(this.api_url + url,{
      observe: 'response',
      params: param,
      responseType: 'arraybuffer'
    }).subscribe(response => {
      if (response) {
        var blob= new Blob([response.body], { type: 'application'});
        var fileName = response.headers.get('Content-Disposition').split(';')[1].trim().split('=')[1].replace(/"/g, '');
        fileSaver.saveAs(blob, fileName);
      }
    })
  }


  uploadFile(file : File, url, param): Observable<HttpEvent<{}>>{
    let formdata: FormData = new FormData();
    let headers = new HttpHeaders();

    formdata.append('file', file);

    if (param) {
      formdata.append('param', new Blob([JSON.stringify(param)], {
        type: "application/json"
      }));

      headers = headers.delete('Content-Type');
    }

    const req = new HttpRequest('POST', this.api_url + url, formdata, {
      reportProgress: true,
      responseType: 'text',
      headers: headers
    });

    return this.http.request(req);
  }

  handleError(error){
    alert('An unexpected error has occured.')
    return throwError(error.message || "Server Error has occured.");
  }
}
