package com.ief.storeproject.videoplay.controller;

import com.ief.storeproject.videoplay.mapping.entity.HistoryVideo;
import com.ief.storeproject.videoplay.mapping.entity.VideoInfo;
import com.ief.storeproject.videoplay.service.HistoryVideoService;
import com.ief.storeproject.videoplay.service.VideoInfoService;
import com.ief.storeproject.videoplay.vo.VideoDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/video")
public class VideoInfoController {

    @Autowired
    VideoInfoService videoInfoServiceImpl;
    @Autowired
    HistoryVideoService historyVideoServiceImpl;

    @RequestMapping(value = "/videoList", method = RequestMethod.GET)
    public String videoList(Model model, @RequestParam(value = "pageNum", required = false) Integer pageNum, @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        List<VideoInfo> allVideos = videoInfoServiceImpl.findAll(pageNum, pageSize, null);
        model.addAttribute("videos", allVideos);
        return "video/videoList";
    }

    @RequestMapping(value = "/getVideo/{id}", method = RequestMethod.GET)
    public String getVideo(Model model, @PathVariable(value = "id") Integer id) {
        VideoInfo byId = videoInfoServiceImpl.getById(id);
        if(byId != null) {
            HistoryVideo historyVideo = new HistoryVideo();
            historyVideo.setUserId(1);
            historyVideo.setVideoId(byId.getId());
            List<HistoryVideo> historyVideos = historyVideoServiceImpl.findAll(null, null, historyVideo);
            VideoDetail videoDetail = new VideoDetail();
            BeanUtils.copyProperties(byId, videoDetail);

            if (!CollectionUtils.isEmpty(historyVideos)) {
                //同一个用户同一个视频最多只有一条记录
                videoDetail.setPlayTime(historyVideos.get(0).getPlayTime());
                videoDetail.setHistoryId(historyVideos.get(0).getId());
            } else {
                videoDetail.setPlayTime("0");
            }
            model.addAttribute("video", videoDetail);
        }
        return "video/videoInfo";
    }

}
