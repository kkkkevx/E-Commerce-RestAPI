package com.kanwen.ecommercerestapi.service;

import com.kanwen.ecommercerestapi.api.exception.UserAlreadyExistsException;
import com.kanwen.ecommercerestapi.api.model.RegistrationBody;
import com.kanwen.ecommercerestapi.model.LocalUser;
import com.kanwen.ecommercerestapi.model.dao.LocalUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private LocalUserDAO localUserDAO;

    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {

        if (localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
                || localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setUsername(registrationBody.getUsername());
        // TO DO: Encrypt pass word
        user.setPassword(registrationBody.getPassword());
        return localUserDAO.save(user);
    }
}
