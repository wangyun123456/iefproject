package com.ief.storeproject.videoplay.vo;

import com.ief.storeproject.videoplay.mapping.entity.HistoryVideo;

public class HistoryVideoVo extends HistoryVideo {

    private String videoName;

    private String userName;

    private Long videoTime;

    private String ended;

    private String isFirstPlay;

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(Long videoTime) {
        this.videoTime = videoTime;
    }

    public String getEnded() {
        return ended;
    }

    public void setEnded(String ended) {
        this.ended = ended;
    }

    public String getIsFirstPlay() {
        return isFirstPlay;
    }

    public void setIsFirstPlay(String isFirstPlay) {
        this.isFirstPlay = isFirstPlay;
    }
}
