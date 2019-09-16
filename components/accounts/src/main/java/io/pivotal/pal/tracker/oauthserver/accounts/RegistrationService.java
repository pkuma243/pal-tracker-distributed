package io.pivotal.pal.tracker.oauthserver.accounts;

import io.pivotal.pal.tracker.oauthserver.accounts.data.AccountDataGateway;
import io.pivotal.pal.tracker.oauthserver.users.data.UserDataGateway;
import io.pivotal.pal.tracker.oauthserver.users.data.UserRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    private final UserDataGateway userDataGateway;
    private final AccountDataGateway accountDataGateway;

    public RegistrationService(UserDataGateway userDataGateway, AccountDataGateway accountDataGateway) {
        this.userDataGateway = userDataGateway;
        this.accountDataGateway = accountDataGateway;
    }

    @Transactional
    public UserRecord createUserWithAccount(String name) {
        UserRecord user = userDataGateway.create(name);
        accountDataGateway.create(user.id, String.format("%s's account", name));
        return user;
    }
}
