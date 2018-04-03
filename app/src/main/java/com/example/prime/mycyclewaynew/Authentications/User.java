package com.example.prime.mycyclewaynew.Authentications;

/**
 * Created by Nammi on 4/3/2018.
 */

public class User {
    private String mName;
    private String mImageUrl;

    public User() {
        //empty constructor needed
    }

    public User(String imageUrl) {

        mImageUrl = imageUrl;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

}
