package semojelly.semojelly.User;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name = "userTBL")
public class User {
    @Id
    @GeneratedValue
    private long seq;

    @Column(unique = true)
    private String userId;

    @Column(nullable = false)
    private String userPwd;

    @Column(nullable = false)
    private String userName;
}
