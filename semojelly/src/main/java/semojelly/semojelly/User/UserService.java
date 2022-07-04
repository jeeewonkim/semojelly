package semojelly.semojelly.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserService{

    private final UserRepository userRepository;

//회원가입 userTBL DB에 넣는
public String signup(UserRequest request){
        userRepository.save(User.builder()
                .userId(request.getUserId())
                .userPwd(request.getUserPwd())
                .userName(request.getUserName())
                .build());

        return "Success";
    }

    public String login(String userId, String userPwd) {
        Optional<User> user = userRepository.findByUserId(userId);
        log.info("db password = {}, input password = {}", user.get().getUserPwd(), userPwd);
        if(user.get().getUserPwd().equals(userPwd)) {
            return "Success";
        }
        return "Failed";
    }

}


