package me.myarmy.api.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Manki Kim on 2017-04-09.
 */
@Component
public class SchedulerService {

    /* 매일 0시 0분 0초 실행 */
    @Scheduled(cron = "0 0 0 * * *")
    public void getArmyXmlApi(){

    }
}
