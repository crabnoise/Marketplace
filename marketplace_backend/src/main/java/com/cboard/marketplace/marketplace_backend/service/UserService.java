package com.cboard.marketplace.marketplace_backend.service;

import com.cboard.marketplace.marketplace_backend.dao.UserDao;
import com.cboard.marketplace.marketplace_backend.dao.UserItemsDao;
import com.cboard.marketplace.marketplace_backend.model.User;
import com.cboard.marketplace.marketplace_backend.model.UserItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService
{
    @Autowired
    UserDao userDao;




    public ResponseEntity<List<User>> getAllUsers()
    {
        try
        {
            return new ResponseEntity<>(userDao.findAll(), HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


}
