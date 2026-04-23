package atlas.santander_dev_week.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import atlas.santander_dev_week.Repository.UserRepository;
import atlas.santander_dev_week.domain.model.User;
import atlas.santander_dev_week.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new IllegalArgumentException("User with account number " + user.getAccount().getNumber() + " already exists.");
        }
        return userRepository.save(user);
    }
    
}
