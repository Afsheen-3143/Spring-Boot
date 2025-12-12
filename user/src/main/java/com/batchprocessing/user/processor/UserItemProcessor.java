package com.batchprocessing.user.processor;

import org.springframework.batch.item.ItemProcessor;
import com.batchprocessing.user.entity.User;

public class UserItemProcessor implements ItemProcessor<User, User> {

    @Override
    public User process(User user) throws Exception {
        // Example processing
        user.setName(user.getName().toUpperCase());
        return user;
    }
}
