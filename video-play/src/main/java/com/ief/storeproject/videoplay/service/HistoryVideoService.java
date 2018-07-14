package com.ief.storeproject.videoplay.service;

import com.ief.storeproject.videoplay.mapping.entity.HistoryVideo;
import com.ief.storeproject.videoplay.vo.HistoryVideoVo;

import java.util.List;

public interface HistoryVideoService extends BaseService<HistoryVideo> {

    int udpateInfo(HistoryVideoVo historyVideoVo);

    List<HistoryVideoVo> findAllVo(Integer pageNum, Integer pageSize, HistoryVideoVo historyVideoVo);
}
