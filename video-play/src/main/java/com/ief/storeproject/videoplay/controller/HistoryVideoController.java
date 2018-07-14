package com.ief.storeproject.videoplay.controller;

import com.ief.storeproject.videoplay.mapping.entity.HistoryVideo;
import com.ief.storeproject.videoplay.service.HistoryVideoService;
import com.ief.storeproject.videoplay.vo.HistoryVideoVo;
import com.ief.storeproject.videoplay.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/history")
public class HistoryVideoController {

    @Autowired
    HistoryVideoService historyVideoServiceImpl;

    @RequestMapping(value = "/listHistory", method = RequestMethod.GET)
    public String videoList(Model model, @RequestParam(value = "pageNum", required = false) Integer pageNum, @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        //添加登陆人员信息，判定是否有查看所有人员视频观看历史权限，有则查所有，无则查询自己
        List<HistoryVideoVo> allVideos = historyVideoServiceImpl.findAllVo(pageNum, pageSize, null);
        model.addAttribute("historyList", allVideos);
        return "history/historyVideoList";
    }

    @ResponseBody
    @RequestMapping(value = "/insertHv", method = RequestMethod.POST)
    public ResponseVo insertHv(HistoryVideoVo historyVideo) {
        System.out.println(historyVideo.getEnded());
        historyVideoServiceImpl.udpateInfo(historyVideo);
        ResponseVo responseVo = new ResponseVo();
        responseVo.setData(historyVideo.getId());
        return responseVo;
    }

}
