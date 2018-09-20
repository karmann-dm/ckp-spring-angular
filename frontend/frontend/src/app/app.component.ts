import { Component } from '@angular/core';
declare var $:any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  constructor() {
    window.onscroll = function () {
      let isScrollOnTop = window.pageYOffset;
      if(isScrollOnTop !== 0) {
        let $header = $('.navbar-dark');
        if(isScrollOnTop > $header.innerHeight()) {
          $('.portal__left-menu-container').css('top', '0px');
        } else {
          $('.portal__left-menu-container').css('top', ($header.innerHeight() - isScrollOnTop) + 'px');
        }
      } else {
        $('.portal__left-menu-container').css('top', '');
      }
    }
  }
}
