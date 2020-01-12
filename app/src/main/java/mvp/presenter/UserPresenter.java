package mvp.presenter;

import mvp.bean.UserInfo;
import mvp.model.IUserModel;
import mvp.model.UserModel;
import mvp.view.IUserView;

public class UserPresenter {

    private IUserView userView;
    private IUserModel userModel;

    public UserPresenter(IUserView view) {
        userView = view;
        userModel = new UserModel();
    }

    public void loadData() {
        UserInfo user = userModel.load();
        userView.setUser(user); // 通过调用IUserView的方法来更新显示
    }

    public void saveData(UserInfo user) {
        userModel.setUser(user);
    }

}
