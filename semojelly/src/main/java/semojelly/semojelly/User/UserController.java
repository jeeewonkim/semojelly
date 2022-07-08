package semojelly.semojelly.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value="user",method = {RequestMethod.GET, RequestMethod.POST})
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //회원가입
    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserRequest request) {
        log.info("userId = {}, password = {}, userName = {}", request.getUserId(),
                request.getUserPwd(), request.getUserName());
        if(userService.signup(request).equals("Success")) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserRequest request) {
        log.info("userId = {}, password = {}", request.getUserId(), request.getUserPwd());
        if(userService.login(request.getUserId(), request.getUserPwd()).equals("Success")) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}