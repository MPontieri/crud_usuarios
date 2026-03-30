import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


const URL_BASE = ["http://localhost:8081"]
@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  postCustumer(customer:any): Observable<any> {
    return this.http.post(URL_BASE+"/api/cliente",customer);
  }

  getAllCustomer(): Observable<any>{
    return this.http.get(URL_BASE + "/api/clientes");
  }

  getCustomerById(id:number): Observable<any>{
    return this.http.get(URL_BASE + "/api/cliente/" + id);
  }

    updateCustomer(id:number, customer: any): Observable<any>{
    return this.http.put(URL_BASE + "/api/cliente/" + id, customer);
  }

  deleteCustomer(id:number): Observable<any>{
    return this.http.delete(URL_BASE + "/api/cliente/" + id);
  }
 
}
