package com.ssafy.IBG.User.Service;

import com.ssafy.IBG.User.domain.User;
import com.ssafy.IBG.User.Repository.UserRepository;
import com.ssafy.IBG.User.exception.NotFoundUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public boolean join(User user){
        userRepository.save(user);
        return true;
    }

    public boolean confirmEmail(String userEmail){
        userRepository.findByEmail(userEmail);
        return true;
    }

    public boolean confirmNick(String userNick){
        userRepository.findByNick(userNick);
        return true;
    }

    public User getUserByUserNo(Integer userNo){
        return userRepository.findById(userNo).orElseThrow(NotFoundUserException::new);
    }

    public Integer getUserSize() {
        User user = userRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).get(0);
        return user.getNo();
    }
}
