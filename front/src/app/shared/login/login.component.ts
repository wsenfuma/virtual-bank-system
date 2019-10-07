import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../services/user.service';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  form: FormGroup;

  constructor(private fb: FormBuilder,
    private userService: UserService,
    private authService: AuthService,
    private router: Router) {
    this.form = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
    this.authService.clearToken();
  }

  ngOnInit() {
  }

  login() {
    this.userService.login(this.form.get('username').value, this.form.get('password').value)
      .subscribe(res => {
        if (res) {
          this.authService.saveToken(res.headers.get('Authorization'));
          alert('Zalogowano');
          this.router.navigateByUrl('/core/bankAccounts');
        }
      });
  }

}