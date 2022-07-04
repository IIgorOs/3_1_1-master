package kata.PP.Task_3_1_1.service;

import kata.PP.Task_3_1_1.entity.User;
import kata.PP.Task_3_1_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getById(long id) {
        return userRepository.getReferenceById(id);
    }
}