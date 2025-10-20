package service;

import entity.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUserById (String id){
        return userRepository.findById(id);
    }

    public User updateUser (String id, User user) {
        return userRepository.findById(id).map(existingUser -> {
                    existingUser.setUserAddress(user.getUserAddress());
                    existingUser.setUserPassword(user.getUserPassword());
                    existingUser.setUserEmailId(user.getUserEmailId());
                    existingUser.setUserPhoneNumber(user.getUserPhoneNumber());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> {
                    log.error("Product not found with id: " + id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + id);
                });
                }
}
