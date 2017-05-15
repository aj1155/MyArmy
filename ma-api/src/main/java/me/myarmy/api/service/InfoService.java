package me.myarmy.api.service;

import me.myarmy.api.controller.exception.RestNotFoundTitleException;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.DataFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Manki KIM on 2017-05-15.
 */
@Service
public class InfoService {

    @Autowired
    private DataFrame rootDataFrame;

    @Autowired
    private RestService restService;

    public String getThumbUrl(String cygonggoNo) throws RestNotFoundTitleException {
        return this.restService.getThumb(getHmpg(cygonggoNo));
    }

    public String getHmpg(String cygonggoNo){
        System.out.println(cygonggoNo);
        Column cygonggoNo1 = this.rootDataFrame.col("cygonggoNo");
        Column hmpgAddr = this.rootDataFrame.col("hmpgAddr");
        String hmpg = this.rootDataFrame.filter(cygonggoNo1.equalTo(cygonggoNo)).select(hmpgAddr).collect()[0].toString();
        StringBuilder sb = new StringBuilder(hmpg);
        sb.deleteCharAt(0).deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
        return sb.toString();
    }
}
