package com.ief.storeproject.videoplay.mapping;


import com.ief.storeproject.videoplay.mapping.entity.HistoryVideo;
import com.ief.storeproject.videoplay.vo.HistoryVideoVo;

import java.util.List;

public interface HistoryVideoMapper extends BaseMapper<HistoryVideo> {

    List<HistoryVideoVo> selectVoByExample(HistoryVideo historyVideo);
}