package com.system.service.impl;

import com.system.mapper.ScoreMapper;
import com.system.po.Score;
import com.system.po.ScoreDTO;
import com.system.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper mapper;

    public ScoreDTO selectByTeacher(int teaId, int stuId, String semester) {
        return mapper.selectByTeacher(teaId, stuId, semester);
    }

    public void addScore(Score score) throws Exception {
        if (mapper.insert(score) != 1){
            throw new Exception("只能给你的老师打分哦");
        };
    }
}
