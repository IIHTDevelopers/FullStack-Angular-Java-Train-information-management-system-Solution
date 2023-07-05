import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Train } from '../model/train';

@Injectable({
  providedIn: 'root'
})
export class TrainService {
  private baseUrl = 'http://127.0.0.1:8081/traininfo/trains';

  constructor(private http: HttpClient) { }

  createTrain(train: Train): Observable<Train> {
    return this.http.post<Train>(this.baseUrl, train);
  }

  updateTrain(train: Train): Observable<Train> {
    return this.http.put<Train>(`${this.baseUrl}/${train.id}`, train);
  }

  deleteTrain(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  getTrainById(id: number): Observable<Train> {
    return this.http.get<Train>(`${this.baseUrl}/${id}`);
  }

  getAllTrains(): Observable<Train[]> {
   
    return this.http.get<Train[]>(this.baseUrl);
  }

  getTrainByNumber(number: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/number/${number}`);
  }

  getTrainsByName(name: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/name/${name}`);
  }

  getTrainsBySeatsAvailable(seatsAvailable: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/seats-available/${seatsAvailable}`);

  }

}
