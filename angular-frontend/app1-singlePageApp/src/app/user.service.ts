import { Injectable } from '@angular/core';
// This line imports the Injectable decorator from the Angular core library. The Injectable decorator is used to mark a class as a service that can be injected into other components.
import {HttpClient} from '@angular/common/http';
// This line imports the HttpClient class from the Angular common/http library. The HttpClient class is used to make HTTP requests to a server.
import { User } from './user';
// This line imports the User class from the user.ts file. The User class represents a user in the application.
import { Observable } from 'rxjs/internal/Observable';
// This line imports the Observable class from the rxjs library. The Observable class is used to represent an asynchronous stream of data.

@Injectable({
  providedIn: 'root'
})
// This is an @Injectable decorator which is used to mark the UserService class as a service that can be injected as a dependency to other components or services in the application. The { providedIn: 'root' } syntax tells Angular to provide this service at the root level of the application, meaning that it can be injected into any component or service throughout the app without any additional configuration.

export class UserService {
  // This line declares the UserService class as an exportable class.

  private baseUrl = "http://localhost:9091/api/users";
  // This is a private property baseUrl which holds the base URL of the API endpoint to retrieve users data.

  constructor(private http: HttpClient) { }
  // This is the constructor method for the UserService class, which takes an instance of the HttpClient class as a parameter. This is done through the use of dependency injection in Angular. The HttpClient instance will be used to make HTTP requests to the server to retrieve data.
  
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.baseUrl}`);
  }

// In summary, the getUsers method sends an HTTP GET request to the API endpoint using the HttpClient instance injected into the constructor and returns an Observable of User array. The method is asynchronous and non-blocking, allowing other parts of the application to continue running while the request is being made.

//   The getUsers method is a public method of the UserService class that returns an Observable of User array. This method makes use of the HttpClient instance injected into the constructor to make an HTTP GET request to the API endpoint at ${this.baseUrl}.

// The http.get method sends an HTTP GET request to the specified URL and returns an Observable of the response data. In this case, the get method is called with the generic type User[], which specifies that the response data is expected to be an array of User objects.

// The ${this.baseUrl} string is a template literal that resolves to the base URL of the API endpoint. The backticks () used to enclose the string allow for variable interpolation, which in this case allows the baseUrl` variable to be injected into the string.

// The Observable<User[]> return type indicates that this method will return an observable that emits an array of User objects when data is retrieved from the server. The use of Observable enables the method to be asynchronous and non-blocking, allowing other parts of the application to continue running while the request is being made.

}


// This class can be injected in any component
// we can use dependency feature to inject UserService in any component and component will invoke userService method

// In summary, the constructor in the UserService class is used to inject an instance of the HttpClient class, which allows the service to make HTTP requests to a server to retrieve data.