package com.cboard.marketplace.marketplace_backend.controller;
import com.cboard.marketplace.marketplace_backend.model.UserSubscriptions;
import com.cboard.marketplace.marketplace_backend.service.UserSubscriptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user-subscriptions")
public class UserSubscriptionsController
{
    @Autowired
    UserSubscriptionsService service;

    @GetMapping("{id}/subscriptions")
    public ResponseEntity<List<UserSubscriptions>> getAllUserSubscriptions(@PathVariable("id") int userId)
    {
        return service.getAllUserSubscriptions(userId);
    }

}
