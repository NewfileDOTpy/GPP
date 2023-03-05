package com.gamepublishingproject.gpp.user.service;


import com.gamepublishingproject.gpp.basket.Basket;
import com.gamepublishingproject.gpp.game.entity.Game;
import com.gamepublishingproject.gpp.game.repository.GameRepository;
import com.gamepublishingproject.gpp.game.service.GameService;
import com.gamepublishingproject.gpp.library.entity.Library;
import com.gamepublishingproject.gpp.related.LibraryGame;
import com.gamepublishingproject.gpp.user.entity.Users;
import com.gamepublishingproject.gpp.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final GameRepository gameRepository;

    private final GameService gameService;

    public UserService(UserRepository userRepository, GameRepository gameRepository, GameService gameService) {

        this.gameService = gameService;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    public Users getUser(Long userId){
        return findVerifiedUser(userId);
    }

    public Page<Users> getUsers(int page, int size){
        return userRepository.findAll(PageRequest.of(page, size,
                Sort.by("userId").descending()));
    }


    public Users createUser(Users user){

        verifyExistsEmail(user.getEmail());
        verifyExistsNickName(user.getNickName());
        user.setLibrary(new Library());
        user.setBasket(new Basket());


        return userRepository.save(user);
    }

    public Users updateUser(Users user){
        Users findUser = findVerifiedUser(user.getUsersId());

        Optional.ofNullable(user.getEmail())
                .ifPresent(email -> findUser.setEmail(email));

        Optional.ofNullable(user.getUserName())
                .ifPresent(name -> findUser.setUserName(name));

        Optional.ofNullable(user.getNickName())
                .ifPresent(nickName-> findUser.setUserName(nickName));

        return userRepository.save(findUser);
    }

    public void deleteUser(Long userId){
        Users deleteUser = findVerifiedUser(userId);
        userRepository.delete(deleteUser);
    }

    public Library getLibrary(Long userId){
            Users findUsers = findVerifiedUser(userId);
           Library games = findUsers.getLibrary();
        return games;
    }


    public Users postLibrary(Long userId, Long gameId){
        Users findUser = findVerifiedUser(userId);
        Game findGame = gameService.findVerifiedGame(gameId);

        LibraryGame libraryGame = new LibraryGame();
        libraryGame.addLibrary(findUser.getLibrary());
        libraryGame.addGame(findGame);
        findUser.getLibrary().addLibraryGame(libraryGame);

        return  userRepository.save(findUser);
    }








    public Users findVerifiedUser(long userId) {
        Optional<Users> optionalUsers =
                userRepository.findById(userId);
        Users findUser =
                optionalUsers.orElse(null);
        return findUser;
    }
    private void verifyExistsEmail(String email) {
        Optional<Users> member = userRepository.findByEmail(email);
//        if (member.isPresent())
//            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }

    private void verifyExistsNickName(String nickname) {
        Optional<Users> member = userRepository.findByNickName(nickname);
//        if (member.isPresent())
//            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }


}
