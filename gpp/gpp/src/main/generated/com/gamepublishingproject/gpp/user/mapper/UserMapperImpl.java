package com.gamepublishingproject.gpp.user.mapper;

import com.gamepublishingproject.gpp.user.dto.UserCreateDto;
import com.gamepublishingproject.gpp.user.dto.UserResponseDto;
import com.gamepublishingproject.gpp.user.dto.UserResponseDto.UserResponseDtoBuilder;
import com.gamepublishingproject.gpp.user.dto.UserUpdateDto;
import com.gamepublishingproject.gpp.user.entity.Users;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-05T16:27:07+0900",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.16 (Azul Systems, Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public Users userCreateDtoToUser(UserCreateDto userCreateDto) {
        if ( userCreateDto == null ) {
            return null;
        }

        Users users = new Users();

        users.setEmail( userCreateDto.getEmail() );
        users.setUserName( userCreateDto.getUserName() );
        users.setNickName( userCreateDto.getNickName() );

        return users;
    }

    @Override
    public Users userUpdateDtoToUser(UserUpdateDto userUpdateDto) {
        if ( userUpdateDto == null ) {
            return null;
        }

        Users users = new Users();

        users.setNickName( userUpdateDto.getNickName() );
        users.setWallet( userUpdateDto.getWallet() );

        return users;
    }

    @Override
    public UserResponseDto UserToUserResponseDto(Users user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDtoBuilder userResponseDto = UserResponseDto.builder();

        userResponseDto.email( user.getEmail() );
        userResponseDto.userName( user.getUserName() );
        userResponseDto.nickName( user.getNickName() );
        userResponseDto.wallet( user.getWallet() );
        userResponseDto.library( user.getLibrary() );
        userResponseDto.basket( user.getBasket() );

        return userResponseDto.build();
    }

    @Override
    public List<UserResponseDto> UsersToUsersResponseDtos(List<Users> users) {
        if ( users == null ) {
            return null;
        }

        List<UserResponseDto> list = new ArrayList<UserResponseDto>( users.size() );
        for ( Users users1 : users ) {
            list.add( UserToUserResponseDto( users1 ) );
        }

        return list;
    }
}
