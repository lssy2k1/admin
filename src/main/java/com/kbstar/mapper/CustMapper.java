package com.kbstar.mapper;

import com.kbstar.dto.Cust;
import com.kbstar.frame.KBMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//얘는 스프링 컨테이너 위에서 돌릴거다.
//JDBC에서는 class로 만들어서 고생했지만, 매퍼로 만들것. 그러기 위해 interface
//interface는 interface를 상속(extend)임.
@Repository
@Mapper
public interface CustMapper extends KBMapper<String, Cust> {
}
