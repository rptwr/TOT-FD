import { Component, OnInit } from '@angular/core';
// This line imports the Component and OnInit interfaces from the Angular core library. The Component interface is used to mark a class as a component, and the OnInit interface is used to mark a class as a component that can be initialized.

import { UserService } from '../user.service';
// This line imports the UserService class from the user.service file. The UserService class is a service that provides access to user data.

import { User } from '../user';
// This line imports the User class from the user file. The User class represents a user in the application.

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
// This line decorates the UserComponent class with the Component decorator. The Component decorator specifies the selector, templateUrl, and styleUrls for the component. The selector is used to identify the component in the HTML markup, the templateUrl is the path to the component's template file, and the styleUrls is an array of paths to the component's style sheets.

export class UserComponent implements OnInit {
  // This line declares the UserComponent class as an exportable class that implements the OnInit interface.
    
  users!: User[];
  // This line declares a public property named users of type User[]. The ! symbol indicates that the property is non-nullable.

   constructor(private userService: UserService) { }
  //  This line declares the constructor for the UserComponent class. The constructor takes a single parameter of type UserService. The UserService parameter is injected into the constructor by Angular.

   ngOnInit(): void {
     this.userService.getUsers().subscribe((data: User[]) => {
      console.log(data);
      this.users = data;
     });
   }
}
// This line defines the ngOnInit() method for the UserComponent class. The ngOnInit() method is called by Angular when the component is initialized. The ngOnInit() method calls the getUsers() method on the UserService class and subscribes to the Observable returned by the getUsers() method. The getUsers() method returns an Observable of User objects. When the Observable emits an event, the ngOnInit() method logs the User objects to the console and sets the users property to the User objects.