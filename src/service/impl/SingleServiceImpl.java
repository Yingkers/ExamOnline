package service.impl;

import dao.SingleDao;
import dao.impl.SingleDaoImpl;
import entity.Single;
import service.SingleService;

import java.util.List;

public class SingleServiceImpl implements SingleService{
    SingleDao singleDao=new SingleDaoImpl();

    //过去题目列表
    @Override
    public List<Single> getSingleList(){
        return this.singleDao.getSingleList();
    }

    //通过科目获取single列表
    @Override
    public List<Single> getSingleListByPaper(String paper){
        return this.singleDao.getSingleListByPaper(paper);
    }

    //获取科目表
    @Override
    public List<String> getSubjectList(){
        return this.singleDao.getSubjectList();
    }

    //通过科目获取答案列表
    @Override
    public List<String> getAnswerListByPaper(String paper){
        return this.singleDao.getAnswerListByPaper(paper);
    }

}
