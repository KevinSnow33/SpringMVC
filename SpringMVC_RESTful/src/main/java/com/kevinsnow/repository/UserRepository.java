package com.kevinsnow.repository;

import com.kevinsnow.entity.User;

import java.util.Collection;

public interface UserRepository {
    //Create/Update
    public void addOrUpdate(User user);
    //Delete
    public void deleteById(long id);
    //Retrieve
    public Collection<User> findAll();
    public User findById(long id);
}
