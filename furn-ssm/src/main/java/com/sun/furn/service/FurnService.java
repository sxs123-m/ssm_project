    package com.sun.furn.service;

    import com.sun.furn.bean.Furn;

    import java.util.List;

    /**
     * @author 孙显圣
     * @version 1.0
     */
    public interface FurnService {
        //增加一条记录
        public void save(Furn furn);
        //返回所有家居信息
        public List<Furn> findAll();
        //修改家居
        public void update(Furn furn);
        //删除家居
        public void del(Integer id);
        //根据id获取家居信息
        public Furn findById(Integer id);
    }
