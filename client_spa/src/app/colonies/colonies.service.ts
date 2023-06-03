import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Colonie } from './colonie';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ColoniesService {
  constructor(private http: HttpClient) { }

  public getColonies(): Observable<Colonie[]> {
    return this.http.get<Colonie[]>('/api/colonies');
  }

  create(data: Colonie): Observable<Colonie> {
    // Chybí ID v typu Colonie
    return this.http.post<Colonie>('/api/colonies', data);
  }

  upddate(data: Colonie): Observable<Colonie> {
    // Chybí ID v typu Colonie
    return this.http.put<Colonie>(`/api/colonies/${data.name}`, data);
  }

  deleteColony(id: number): Observable<void> {
    // Chybí ID v typu Colonie
    return this.http.delete<void>(`/api/colonies/${id}`);
  }
}
