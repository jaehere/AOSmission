package com.mobileleader.android.assignment1;

public class InfoItem {


    private String mTitle;
    private String mContent;
    private int mResourceId;


    public InfoItem(int resourceId, String title, String content) {
        this.mResourceId = resourceId;
        this.mTitle = title;
        this.mContent = content;

    }

    public int getmResourceId() {
        return mResourceId;
    }

    public void setmResourceId(int mResourceId) {
        this.mResourceId = mResourceId;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmContent(String mContent) {this.mContent = mContent; }

    public String getmTitle() {
        return mTitle;
    }

    public String getmContent() {
        return mContent;
    }

}
