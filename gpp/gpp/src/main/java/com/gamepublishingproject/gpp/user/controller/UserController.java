package com.gamepublishingproject.gpp.user.controller;


import com.gamepublishingproject.gpp.basket.Basket;
import com.gamepublishingproject.gpp.library.Library;
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

    public UserController(UserService userService, UserMapper
                          userMapper){
        this.userService = userService;
        this.userMapper = userMapper;
    }


    @GetMapping
    public ResponseEntity getUsers(){
        return null;
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
        List<UserResponseDto> userResponseDtos =
                userMapper.UsersToUsersResponseDtos(users);
        return ResponseEntity.ok(userResponseDtos);
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


    @DeleteMapping("/user-id")
    public ResponseEntity deleteUser(@PathVariable("user-id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity(HttpStatus.OK);

    }




    @GetMapping("/library/{user-id")
    public ResponseEntity getLibrary(@PathVariable("user-id") Long userid){


        return null;
    }


    @PostMapping("/library/{user-id")
    public ResponseEntity addGameToLibrary (@PathVariable("user-id") Long userId, Basket basketPostDto){
        return null;
    }


    @PatchMapping("/library/{user-id")
    public ResponseEntity updatelibrary(@PathVariable("user-id") Long userId, Basket basketupdateDto){
        return null;
    }


    @GetMapping("/basket/{user-id")
    public ResponseEntity getBasket (@PathVariable("user-id") Long userid){
        return null;
    }


    @PostMapping("/basket/{user-id")
    public ResponseEntity addGameToBasket(@PathVariable("user-id") Long userId, Basket basketPostDto){
        return null;
    }


    @PatchMapping("/basket/{user-id")
    public ResponseEntity updateBasket(@PathVariable("user-id") Long userId, Basket basketupdateDto){
        return null;
    }







}
