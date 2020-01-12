package mvp.model;

import mvp.bean.UserInfo;

public interface IUserModel {
    UserInfo load();
    void setUser(UserInfo user);
}
