package atlas.santander_dev_week.service;

import atlas.santander_dev_week.domain.model.User;

public interface UserService {
    User findById(long id);
    User create(User user);
    User update(long id, User user);
    void delete(long id);
}
