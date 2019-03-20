package rathakarn.th.co.gkrgroup.seafoodchampion;

import android.os.Parcel;
import android.os.Parcelable;

class ListVIdeoModel implements Parcelable{

    private String Detail, Duration, Image, Name;

    public ListVIdeoModel() {
    }

    public ListVIdeoModel(String detail, String duration, String image, String name) {
        Detail = detail;
        Duration = duration;
        Image = image;
        Name = name;
    }

    protected ListVIdeoModel(Parcel in) {
        Detail = in.readString();
        Duration = in.readString();
        Image = in.readString();
        Name = in.readString();
    }

    public static final Creator<ListVIdeoModel> CREATOR = new Creator<ListVIdeoModel>() {
        @Override
        public ListVIdeoModel createFromParcel(Parcel in) {
            return new ListVIdeoModel(in);
        }

        @Override
        public ListVIdeoModel[] newArray(int size) {
            return new ListVIdeoModel[size];
        }
    };

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Detail);
        dest.writeString(Duration);
        dest.writeString(Image);
        dest.writeString(Name);
    }
}