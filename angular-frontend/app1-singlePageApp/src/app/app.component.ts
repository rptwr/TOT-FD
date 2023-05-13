import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app4-singlePageApp';
}



// import { Component } from '@angular/core';: This line imports the Component decorator from the @angular/core module.

// @Component({ : This is a decorator that marks the following class as an Angular component and provides metadata about the component, such as its selector, template, and style.

// selector: 'app-root',: This property specifies the CSS selector that identifies the component when it is used in the template.

// templateUrl: './app.component.html',: This property specifies the URL of the component's template file. In this case, it is app.component.html.

// styleUrls: ['./app.component.css']: This property specifies the URLs of the component's stylesheet files. In this case, it is app.component.css.

// export class AppComponent {: This is the component class that defines the behavior and properties of the component. In this case, it defines a title property that is set to app4-singlePageApp.

// The AppComponent class is exported so that it can be used in other parts of the application. When this component is used in a template, the HTML and CSS files specified in the @Component decorator are used to render the component.