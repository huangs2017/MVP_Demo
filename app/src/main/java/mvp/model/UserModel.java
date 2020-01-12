package mvp.model;

import mvp.bean.UserInfo;

public class UserModel implements IUserModel{

    UserInfo user = new UserInfo("张三", "男");

    @Override
    public UserInfo load() {
        return user;
    }

    @Override
    public void setUser(UserInfo user) {
        this.user = user;
    }

}
