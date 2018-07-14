package com.ief.storeproject.videoplay.controller;

import com.ief.storeproject.videoplay.mapping.entity.VideoGroup;
import com.ief.storeproject.videoplay.service.BaseService;
import com.ief.storeproject.videoplay.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/group")
public class VideoGroupController {

    @Autowired
    BaseService<VideoGroup> videoGroupServiceImpl;

    @RequestMapping(value = "/addGroup",method = RequestMethod.GET)
    public String redirectAddGroup(){
        return "videoGroup/addGroup";
    }

    @RequestMapping(value = "/insertGroup",method = RequestMethod.POST)
    public String insertGroup(Model model, VideoGroup videoGroup){
        videoGroupServiceImpl.insert(videoGroup);
        return "redirect:/group/listGroups/1/10";
    }

    @RequestMapping(value = "/listGroups/{pageNum}/{pageSize}",method = RequestMethod.GET)
    public String listGroups(Model model, @PathVariable(value = "pageNum") Integer pageNum, @PathVariable(value = "pageSize") Integer pageSize, @RequestParam(value = "groupName",required = false) String groupName) {
        VideoGroup videoGroup = null;
        if(groupName != null){
            videoGroup = new VideoGroup();
            videoGroup.setGroupName(groupName);
        }
        List<VideoGroup> groups = videoGroupServiceImpl.findAll(pageNum, pageSize, videoGroup);
        model.addAttribute("groups",groups);
        return "videoGroup/groupList";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteGroup",method = RequestMethod.POST)
    public ResponseVo deleteGroup(@RequestParam(value = "id") Integer id){
        ResponseVo responseVo = new ResponseVo();
        responseVo.setData(videoGroupServiceImpl.delete(id));
        responseVo.setMsg("删除成功");
        return responseVo;
    }

    @ResponseBody
    @RequestMapping(value = "/updateGroup",method = RequestMethod.POST)
    public ResponseVo updateGroup(VideoGroup videoGroup) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setData(videoGroupServiceImpl.update(videoGroup));
        responseVo.setMsg("修改成功");
        return responseVo;
    }

}
