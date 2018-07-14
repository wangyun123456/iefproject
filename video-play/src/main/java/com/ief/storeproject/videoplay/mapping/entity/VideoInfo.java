package com.ief.storeproject.videoplay.mapping.entity;

public class VideoInfo {
    private Integer id;

    private String videoName;

    private Integer groupId;

    private String videoUrl;

    private String videoType;

    private String videoImg;

    private String videoProduce;

    private Long playNum;

    private Integer videoTime;

    private Long dataVersion;

    private Short deleteFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType == null ? null : videoType.trim();
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg == null ? null : videoImg.trim();
    }

    public String getVideoProduce() {
        return videoProduce;
    }

    public void setVideoProduce(String videoProduce) {
        this.videoProduce = videoProduce == null ? null : videoProduce.trim();
    }

    public Long getPlayNum() {
        return playNum;
    }

    public void setPlayNum(Long playNum) {
        this.playNum = playNum;
    }

    public Integer getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(Integer videoTime) {
        this.videoTime = videoTime;
    }

    public Long getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(Long dataVersion) {
        this.dataVersion = dataVersion;
    }

    public Short getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}