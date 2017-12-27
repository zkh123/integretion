package com.ppdai.demo.common.controller;

import com.ppdai.demo.数据迁移性能优化.dao.BatchUserListDao;
import com.ppdai.demo.数据迁移性能优化.dao.IKUserListDao;
import com.ppdai.demo.数据迁移性能优化.entity.BatchUserList;
import com.ppdai.demo.数据迁移性能优化.entity.IKUserList;
import com.ppdai.demo.随机随还接入黄金眼.GoldEyeData;
import com.ppdai.demo.随机随还接入黄金眼.GoldEyeInfo;
import com.ppdai.demo.随机随还接入黄金眼.GoldEyeOuter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by huanglijun on 2017/12/26.
 */
@RestController
public class TestController {

    @Autowired
    private BatchUserListDao batchUserListDao;
    @Autowired
    private IKUserListDao ikUserListDao;

    /**
     * http://localhost:8088/test1
     * @return
     */
    @GetMapping(value = "test1")
    public Object batchUserListDaoSelectAll(){
        return batchUserListDao.selectAll();
    }

    /**
     * http://localhost:8088/test2
     * @return
     */
    @GetMapping(value = "test2")
    public Object ikUserListDaoSelectAll(){
        return ikUserListDao.selectAll();
    }

    /**
     * http://localhost:8088/test3?insertTime=2017-12-27
     * @param insertTime
     * @return
     */
    @GetMapping(value = "test3")
    public Object ikUserListDaoGetCount(@RequestParam(value = "insertTime")String insertTime){
        return ikUserListDao.getCount(insertTime);
    }

    /**
     * http://localhost:8088/test4
     * @return
     */
    @GetMapping(value = "test4")
    public Object ikUserListDaoInit(){
        IKUserList ikUserList = new IKUserList();
        ikUserList.setUserId(666666);
        ikUserList.setFilterType(1);
        return ikUserListDao.init(ikUserList);
    }

    /**
     * http://localhost:8088/test5
     * @return
     */
    @GetMapping(value = "test5")
    public Object ikUserListDaoBatchInit(){
        List<IKUserList> list = new ArrayList<IKUserList>();
        for (int i = 1 ; i < 1000; i++){
            IKUserList ikUserList = new IKUserList();
            ikUserList.setUserId(i);
            ikUserList.setFilterType(1);
            ikUserList.setUserType(1);
            list.add(ikUserList);
        }
        return ikUserListDao.batchInit(list);
    }

    /**
     * http://localhost:8088/test6
     * @return
     */
    @GetMapping(value = "test6")
    public Object batchInsert(){
        List<BatchUserList> list = new ArrayList<BatchUserList>();
        for (int i = 0 ; i < 1000; i++){
            BatchUserList batchUserList = new BatchUserList();
            batchUserList.setUserId(i);
            batchUserList.setType(1);
            list.add(batchUserList);
        }
        return batchUserListDao.batchInsert(list);
    }
    /**
     *
     * @return
     */
    @GetMapping(value = "dispatchers")
    public Object dispatchersJshAuditNew(){
        GoldEyeInfo goldEyeInfo = new GoldEyeInfo();
        goldEyeInfo.setAppVer("0.01");
        goldEyeInfo.setAppId("10840004");

        GoldEyeData goldEyeData = new GoldEyeData();
        goldEyeData.setProcessFlag(1);  //通过
        goldEyeData.setPcOrApp(0);  //pc用户
        goldEyeData.setTimeStamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
        goldEyeData.setIsUsed(1);  //使用上次表中的结论
        goldEyeData.setBatch(true); //用户触发的
        goldEyeData.setOrderId("43574467444");
        goldEyeData.setUserId("666666");  //用户id

        GoldEyeOuter goldEyeOuter = new GoldEyeOuter();
        goldEyeOuter.setData(goldEyeData);
        goldEyeOuter.setInfo(goldEyeInfo);
        return goldEyeOuter;
    }

}