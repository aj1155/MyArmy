package me.myarmy.api.conf;

/**
 * Created by USER on 2017-05-22.
 */

import me.myarmy.api.domain.User;
import me.myarmy.api.repository.UserRepository;
import me.myarmy.api.service.custom.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecommendConfig {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecommendService recommendService;

    /***
     * 결과적으로 batch 서비스로 변경 해야 함
     */
    @Scheduled(cron="0 0 02 * * ?")
    public void predictCompany(){
        List<User> users = this.userRepository.findAll();
        for(User user : users){
            this.recommendService.trainingRating(user.getId());
        }
    }
}
