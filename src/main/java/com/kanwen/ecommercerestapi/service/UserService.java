package com.kanwen.ecommercerestapi.service;

import com.kanwen.ecommercerestapi.api.exception.UserAlreadyExistsException;
import com.kanwen.ecommercerestapi.api.model.LoginBody;
import com.kanwen.ecommercerestapi.api.model.RegistrationBody;
import com.kanwen.ecommercerestapi.model.LocalUser;
import com.kanwen.ecommercerestapi.model.dao.LocalUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private LocalUserDAO localUserDAO;
    @Autowired
    private EncryptionService encryptionService;
    @Autowired
    private JWTService jwtService;

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

        user.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
        return localUserDAO.save(user);
    }

    public String loginUser(LoginBody loginBody) {
        Optional<LocalUser> opUser = localUserDAO.findByUsernameIgnoreCase(loginBody.getUsername());
        if (opUser.isPresent()) {
            LocalUser user = opUser.get();
            if (encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())) {
                return jwtService.generateJWT(user);
            }
        }

        return null;
    }
}
