import { Controller, Get, Render, Post, Req, Body } from '@nestjs/common';
import { AppService } from './app.service';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  @Render('index')
  root() {
    return;
  }

  @Post('/submit-credentials')
  @Render('main')
  submitCredentials(@Req() req) {
    console.log(req.body);
    return;
  }
}
