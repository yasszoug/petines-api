package com.ensak.petines.controller;

import com.ensak.petines.model.Favourite;
import com.ensak.petines.model.Pets;
import com.ensak.petines.model.User;
import com.ensak.petines.repositories.FavouritesRepository;
import com.ensak.petines.repositories.PettyRepository;
import com.ensak.petines.services.FavouriteService;
import com.ensak.petines.services.PettyService;
import com.ensak.petines.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavouritesController {

    @Autowired
    FavouriteService favouriteService;

    @Autowired
    UserService userService;

    @RequestMapping(method= RequestMethod.GET, value="/favourites/user/{username}")
    public List<Favourite> getFavouritesByUsername(@PathVariable String username) {
        User u = userService.getUserByUsername(username);
        return favouriteService.findFavouritesByUser(u);
    }

    @PostMapping("/favourites/{fav_Id}")
    public Favourite updateLove(@PathVariable Integer fav_Id, @RequestBody boolean love){
        return favouriteService.updateLove(fav_Id, love);
    }

}
