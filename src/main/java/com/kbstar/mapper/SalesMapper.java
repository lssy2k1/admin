package com.kbstar.mapper;

import com.kbstar.dto.Sales;
import com.kbstar.frame.KBMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SalesMapper extends KBMapper<String, Sales> {
    public List<Integer> getmonthlyprice();
    public List<Integer> getgenderprice(String gender);
}