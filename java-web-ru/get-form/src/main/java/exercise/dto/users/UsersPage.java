package exercise.dto.users;

import exercise.model.User;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
public class UsersPage {
    private final List<User> users;
    private final String term;

    public UsersPage(List<User> users, String term) {
        this.users = users;
        this.term = term;
    }

    public List<User> getUsers() {
        return users;
    }

    public String getTerm() {
        return term;
    }
}
// END
