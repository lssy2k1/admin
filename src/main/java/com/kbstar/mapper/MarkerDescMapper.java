package com.kbstar.mapper;

import com.kbstar.dto.MarkerDesc;
import com.kbstar.frame.KBMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//  스프링컨테이너 덕분이다~
@Repository
@Mapper
public interface MarkerDescMapper extends KBMapper<Integer, MarkerDesc> {
    public List<MarkerDesc> getmarkerdesc(int markerid);
}
