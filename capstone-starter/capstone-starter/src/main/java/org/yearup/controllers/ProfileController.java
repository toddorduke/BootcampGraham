package org.yearup.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.ProfileDao;
import org.yearup.data.mysql.MySqlProfileDao;
import org.yearup.data.mysql.MySqlUserDao;
import org.yearup.models.Profile;

public class ProfileController {
    private MySqlUserDao mySqlUserDao;
    private MySqlProfileDao mySqlProfileDao;
    private ProfileDao profileDao;

    @GetMapping("/{id}")
    Profile profileDetail(@PathVariable int id) {
        try{
          var profile = profileDao.getById(id);

          if(profile == null)
              throw new ResponseStatusException(HttpStatus.NOT_FOUND);

          return profile;
      }
      catch(Exception ex) {
          throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
      }
    }

    @PutMapping
    void updateprofile(){

    }
}
