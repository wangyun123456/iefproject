package com.ief.storeproject.videoplay.vo;


import com.ief.storeproject.videoplay.mapping.entity.VideoInfo;

public class VideoDetail extends VideoInfo {

    //上次播放至
    private String playTime;
    //历史ID
    private Integer historyId;

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }
}
