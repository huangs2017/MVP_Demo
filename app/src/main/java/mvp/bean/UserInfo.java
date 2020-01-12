package mvp.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class UserInfo implements Parcelable {

    private String name;
    private String sex;

    public UserInfo(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


/*
    Serializable  (Java自带)
    优点：代码少
    缺点：读写存储在硬盘上。序列化过程使用了反射技术，期间产生临时对象

    Parcelable  (Android专有)
    优点：在内存中读写，Parcelable性能上要优于Serializable（内存的读写速度>硬盘读写速度）
    缺点：代码写起来麻烦
*/

    protected UserInfo(Parcel in) {
        name = in.readString();
        sex = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(sex);
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

}
