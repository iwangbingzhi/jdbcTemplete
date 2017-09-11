package cn.utils.c3p0;

/**
 * Created by 王炳智 on 2017/8/23.
 */
public class Service {
    private Dao dao;
    public void setDao(Dao dao) {
        this.dao = dao;
    }



    public void add(){
        dao.add();
    }
}
