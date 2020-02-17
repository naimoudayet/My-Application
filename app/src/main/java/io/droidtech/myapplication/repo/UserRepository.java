package io.droidtech.myapplication.repo;

import io.droidtech.myapplication.dao.UserDAO;
import io.droidtech.myapplication.model.User;

public class UserRepository implements UserDAO {

    @Override
    public boolean login(User user) {

        if (user.getEmail().equals("admin") && user.getPassword().equals("admin")) {
            return true;
        }

        return false;
    }

}
