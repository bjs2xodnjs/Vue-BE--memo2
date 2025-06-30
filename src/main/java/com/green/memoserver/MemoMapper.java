package com.green.memoserver;

import com.green.memoserver.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemoMapper {
    // insert, update, delete => int
    int save(MemoPostReq p);
    List<MemoGetRes> findAll(MemoGetReq p);
    // select 일 때는 무조건 res
    MemoGetOneRes findById(int id);
    int modify(MemoPutReq p);
    int deleteById(int id);
}

