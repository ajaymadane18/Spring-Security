package com.jwt.example.Services;

import com.jwt.example.Models.Login;
import com.jwt.example.Models.Register;

public interface HomeService {
  public void register(Register register );
  public String login(Login login);
}
