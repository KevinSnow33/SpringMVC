package com.kevinsnow.repository.impl;

import com.kevinsnow.entity.User;
import com.kevinsnow.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static Map<Long,User> userMap;

    static {
        userMap = new HashMap<>();
        userMap.put(1L,new User(1L,"张三"));
        userMap.put(2L,new User(2L,"李四"));
        userMap.put(3L,new User(3L,"王五"));
    }


    @Override
    public void addOrUpdate(User user) {
        userMap.put(user.getId(),user);
    }

    @Override
    public void deleteById(long id) {
        userMap.remove(id);
    }

    @Override
    public Collection<User> findAll() {
        return userMap.values();
    }

    @Override
    public User findById(long id) {
        return userMap.get(id);
    }
}
