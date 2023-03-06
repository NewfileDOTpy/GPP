package com.gamepublishingproject.gpp.user.mapper;


import com.gamepublishingproject.gpp.user.dto.UserCreateDto;
import com.gamepublishingproject.gpp.user.dto.UserResponseDto;
import com.gamepublishingproject.gpp.user.dto.UserUpdateDto;

import com.gamepublishingproject.gpp.user.entity.Users;
import org.mapstruct.Mapper;

import java.util.List;



@Mapper(componentModel = "spring")
public interface UserMapper {

    Users userCreateDtoToUser(UserCreateDto userCreateDto);

    Users userUpdateDtoToUser(UserUpdateDto userUpdateDto);

    UserResponseDto UserToUserResponseDto(Users user);

    List<UserResponseDto> UsersToUsersResponseDtos(List<Users> users);



}
