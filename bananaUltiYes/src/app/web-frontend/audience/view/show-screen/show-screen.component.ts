import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-show-screen',
  templateUrl: './show-screen.component.html',
  styleUrls: ['./show-screen.component.css']
})
export class ShowScreenComponent_cl implements OnInit {

  title = 'frontendbanana';
  constructor() { }

  images_vb: string[] = [];

  ngOnInit() {
    this.images_vb[0]="assets/images/c1.png";
    this.images_vb[1]="assets/images/c6.jpg";
    this.images_vb[2]="assets/images/c3.jpg";
    this.images_vb[3]="assets/images/c4.jpg";
    this.images_vb[4]="assets/images/c5.jpg";
  }

}
