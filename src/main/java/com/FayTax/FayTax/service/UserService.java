package com.FayTax.FayTax.service;

import com.FayTax.FayTax.model.User;
import com.FayTax.FayTax.repository.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
        import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }
    public Optional<User> findById(Long id) {
        return userDao.findById(id);
    }
    public User save(User stock) {
        return userDao.save(stock);
    }

    public void deleteById(Long id) {
        userDao.deleteById(id);
    }
}
