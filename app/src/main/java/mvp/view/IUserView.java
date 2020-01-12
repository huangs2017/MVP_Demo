package mvp.view;

import mvp.bean.UserInfo;

public interface IUserView {
    void setUser(UserInfo user);
    UserInfo getUser();
}
