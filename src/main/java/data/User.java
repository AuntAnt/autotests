package data;

import lombok.Getter;
import utils.ConfReader;

@Getter
public enum User {

    CUSTOMER("customer.email", "customer.password"),
    ADMIN("admin.email", "admin.password");

    private final String login;
    private final String password;

    User(String login, String password) {
        this.login = ConfReader.getPropertyByPath(login);
        this.password = ConfReader.getPropertyByPath(password);
    }
}
