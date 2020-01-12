package mvp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import mvp.bean.UserInfo;
import mvp.presenter.UserPresenter;
import mvp.view.IUserView;

public class MainActivity extends AppCompatActivity implements IUserView {

    EditText edit_name, edit_sex;
    UserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_name = findViewById(R.id.edit_name);
        edit_sex = findViewById(R.id.edit_sex);
        presenter = new UserPresenter(this);
    }


    public void loadData(View view) {
        presenter.loadData();
    }

    public void saveData(View view) {
        presenter.saveData(getUser());
    }

    @Override
    public void setUser(UserInfo user) {
        edit_name.setText(user.getName());
        edit_sex.setText(user.getSex());
    }

    @Override
    public UserInfo getUser() {
        String name = edit_name.getText().toString();
        String sex = edit_sex.getText().toString();
        return new UserInfo(name, sex);
    }

}

/*

MVC
    M: 提供数据（Model）（数据和业务逻辑）
    V: 显示（xml）
    C: Activity和Fragment，（Activity需要交割业务逻辑至Model层处理）

MVP
    M: 数据层(数据库、文件操作、网络等...)
    V: View和Activity以及Fragment
    P: 负责View和Model的交互(Presenter)

    MVP设计目的: 将UI层和数据层进行分离


    MVC： 适用简单页面，不利于复杂页面。
    MVP： 解耦，结构清晰，使M层与V层分离。但文件较多，每一个页面基本要新建P层和V层的文件
    MVVM：文件相对MVP较少，少写接口，高效(ViewModel与对应宿主的生命周期相同，从而内存泄漏问题比MVP处理较好)




MVC的缺点:
Activity过于臃肿，View层的XML控制力其实非常弱，View的数据绑定、事件处理还是要放在Activity进行，
Activity就既包含了View又包含了Controller（当然了data-binding的出现，可能会让View更像View吧）。

MVP和MVVM区别就是P和VM区别。Presenter层是把UI无关的逻辑自己处理掉，最后把处理完的数据传输给View层展示；
ViewModel是把Model和View层关联起来的一个中间层，让View层可以响应式地展示数据。VM的核心思想是UI回调。
View层通过ViewModel可以直接动态地展示数据，我们不需要在数据改变时去回调UI，这样可以省去非常非常多的UI代码

对于小项目，Activity里的代码不重的话，没必要各种分层。
MVP并没有真正减少代码，只是把代码做了分层。而MVVM不但让代码分层的更加干净，还减少了大量的UI回调代码


*/
