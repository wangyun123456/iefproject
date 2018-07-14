package com.ief.storeproject.videoplay.mapping;

import com.ief.storeproject.videoplay.mapping.entity.VideoInfo;

public interface VideoInfoMapper extends BaseMapper<VideoInfo> {

    int updateByPrimaryKeySelective(VideoInfo videoInfo);

}
