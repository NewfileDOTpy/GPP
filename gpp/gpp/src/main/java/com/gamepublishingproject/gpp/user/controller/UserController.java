package com.gamepublishingproject.gpp.user.controller;


import com.gamepublishingproject.gpp.basket.Basket;
import com.gamepublishingproject.gpp.game.entity.Game;
import com.gamepublishingproject.gpp.game.mapper.GameMapper;
import com.gamepublishingproject.gpp.game.service.GameService;
import com.gamepublishingproject.gpp.library.Library;
import com.gamepublishingproject.gpp.response.MultiResponseDto;
import com.gamepublishingproject.gpp.user.dto.BasketAddGameDto;
import com.gamepublishingproject.gpp.user.dto.UserCreateDto;
import com.gamepublishingproject.gpp.user.dto.UserResponseDto;
import com.gamepublishingproject.gpp.user.dto.UserUpdateDto;

import com.gamepublishingproject.gpp.user.entity.Users;
import com.gamepublishingproject.gpp.user.mapper.UserMapper;
import com.gamepublishingproject.gpp.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    private final GameMapper gameMapper;

    private final GameService gameService;

    public UserController(UserService userService, UserMapper userMapper, GameMapper gameMapper, GameService gameService) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.gameMapper = gameMapper;
        this.gameService = gameService;
    }

    @GetMapping("/{user-id}")
    public ResponseEntity getUser(@PathVariable("user-id") Long userId){

        return null;
    }

    @GetMapping
    public ResponseEntity getUsers(@RequestParam int page,
                                   @RequestParam int size){
        Page<Users> pageUsers = userService.getUsers(page-1, size);
        List<Users> users = pageUsers.getContent();

        return new ResponseEntity<>(
                new MultiResponseDto<>(userMapper.UsersToUsersResponseDtos(users), pageUsers),
                HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity createUser(@RequestBody UserCreateDto userCreateDto){

        Users user = userMapper.userCreateDtoToUser(userCreateDto);
        Users createdUser = userService.createUser(user);
        UserResponseDto responseDto = userMapper.UserToUserResponseDto(createdUser);

        return new ResponseEntity(responseDto, HttpStatus.CREATED);
    }


    @PatchMapping("/{user-id}")
    public ResponseEntity updateUser(@PathVariable("user-id") Long userId,
                                     @RequestBody UserUpdateDto userUpdateDto){
        userUpdateDto.setUserId(userId);
        userService.updateUser(userMapper.userUpdateDtoToUser(userUpdateDto));

        return new ResponseEntity(HttpStatus.OK);
    }


    @DeleteMapping("/{user-id}")
    public ResponseEntity deleteUser(@PathVariable("user-id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity(HttpStatus.OK);

    }



    @GetMapping("/library/{user-id}")
    public ResponseEntity getLibrary(@PathVariable("user-id") Long userid){


        return null;
    }


    @PostMapping("/library/{user-id}")
    public ResponseEntity addGameToLibrary (@PathVariable("user-id") Long userId){
        return null;
    }


    @PatchMapping("/library/{user-id}")
    public ResponseEntity updatelibrary(@PathVariable("user-id") Long userId, Basket basketupdateDto){
        return null;
    }


    @GetMapping("/basket/{user-id}")
    public ResponseEntity getBasket (@PathVariable("user-id") Long userid){
        return null;
    }


    @PostMapping("/basket/{user-id}")
    public ResponseEntity addGameToBasket(@PathVariable("user-id") Long userId, @RequestBody BasketAddGameDto basketAddGameDto){

        List<Game> gameList = gameService.gameList(basketAddGameDto);
        Users users = userService.updateBasket(userId, gameList);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PatchMapping("/basket/{user-id}")
    public ResponseEntity updateBasket(@PathVariable("user-id") Long userId, Basket basketupdateDto){
        return null;
    }







}
