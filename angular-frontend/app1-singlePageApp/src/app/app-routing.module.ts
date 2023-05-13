import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


// This code is an Angular module that defines the routing configuration for the application. It imports two modules from @angular/core and @angular/router.

// const routes: Routes = [] defines an array of routes that will be used to configure the router. In this case, the array is empty as there are no routes defined yet.

// @NgModule decorator is used to define an Angular module. The imports property imports the RouterModule.forRoot() method, which sets up the router by registering the routes defined in routes array. The exports property exports the RouterModule so that it can be used in other modules that import this module.

// Finally, AppRoutingModule is exported as a module so that it can be imported in the AppModule and used in the application.