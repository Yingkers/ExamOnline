package dao;

import entity.Single;

import java.util.List;

public interface SingleDao{
    //获取single列表
    List<Single> getSingleList();
    //通过科目获取single列表
    List<Single> getSingleListByPaper(String paper);
    //通过题目搜索题的信息
    List<String> getSubjectList();
    //通过科目获取答案列表
    List<String> getAnswerListByPaper(String paper);
}
