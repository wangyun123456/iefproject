package com.ief.storeproject.videoplay.service.impl;


import com.github.pagehelper.PageHelper;
import com.ief.storeproject.videoplay.mapping.BaseMapper;
import com.ief.storeproject.videoplay.mapping.HistoryVideoMapper;
import com.ief.storeproject.videoplay.mapping.VideoInfoMapper;
import com.ief.storeproject.videoplay.mapping.entity.HistoryVideo;
import com.ief.storeproject.videoplay.mapping.entity.VideoInfo;
import com.ief.storeproject.videoplay.service.HistoryVideoService;
import com.ief.storeproject.videoplay.vo.HistoryVideoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class HistoryVideoServiceImpl extends BaseServiceImpl<HistoryVideo> implements HistoryVideoService {

    @Autowired
    BaseMapper<VideoInfo> videoInfoMapper;
    @Autowired
    HistoryVideoMapper historyVideoMapper;

    @Transactional
    public int udpateInfo(HistoryVideoVo historyVideoVo){
        int m = 0;
        HistoryVideo historyVideo = new HistoryVideo();
        BeanUtils.copyProperties(historyVideoVo,historyVideo);
        if(historyVideo.getStartTime() != null){ //开始播放
            historyVideo.setStartTime(new Date());
            //视频播放次数加1
            Integer videoId = null;
            if(historyVideo.getVideoId() != null) {
                videoId = historyVideo.getVideoId();
            }else{  //videoId为空，则id一定不为空
                HistoryVideo byId = getById(historyVideo.getId());
                videoId = byId.getVideoId();
            }
            if(historyVideoVo.getIsFirstPlay() != null) {
                int n = 0;
                while (n == 0) {
                    VideoInfo videoInfo = videoInfoMapper.selectByPrimaryKey(videoId);
                    videoInfo.setPlayNum((videoInfo.getPlayNum() == null ? 0 : videoInfo.getPlayNum()) + 1);
                    n = videoInfoMapper.updateByPrimaryKeySelective(videoInfo);
                }
            }
        }
        if(historyVideo.getId() == null){
            baseMapper.insert(historyVideo);
            List<HistoryVideo> hv = findAll(1, 1, historyVideo);
            historyVideoVo.setId(hv.get(0).getId());
        }else{
            if(historyVideoVo.getEnded() != null){
                HistoryVideo byId = getById(historyVideoVo.getId());
                if(byId.getStartTime() != null){
                    long time = (new Date().getTime() - byId.getStartTime().getTime())/1000/60;
                    long total = (byId.getTotalTime() == null ? 0 : byId.getTotalTime()) + time;
                    historyVideo.setTotalTime(total);
                }
            }
            super.update(historyVideo);
        }
        return m;
    }

    @Override
    public List<HistoryVideoVo> findAllVo(Integer pageNum, Integer pageSize, HistoryVideoVo historyVideoVo) {
        if(pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum,pageSize);
        }
        return historyVideoMapper.selectVoByExample(historyVideoVo);
    }
}
