package kata.PP.Task_3_1_1.service;


import kata.PP.Task_3_1_1.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    void save(User user);
    User getById(long id);
    void removeById(long id);


}
