package Authentication;

import com.Flyrank.project.Users.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
