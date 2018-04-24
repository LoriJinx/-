package com.system.service;

import com.system.po.Score;
import com.system.po.ScoreDTO;

public interface ScoreService {

    ScoreDTO selectByTeacher(int teaId, int stuId, String semester);

    void addScore(Score score) throws Exception;
}
