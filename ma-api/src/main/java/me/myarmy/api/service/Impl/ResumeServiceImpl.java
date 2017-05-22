package me.myarmy.api.service.Impl;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.controller.model.request.ResumeRequest;
import me.myarmy.api.domain.Resume;
import me.myarmy.api.repository.ResumeRepository;
import me.myarmy.api.service.custom.ResumeService;
import me.myarmy.api.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gain on 2017. 5. 6..
 */

@Service
@Slf4j
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private UserService userService;

    @Override
    public void createResume(ResumeRequest resumeRequest){
        Resume resume = Resume.of(this.userService.findCurrentUserId(), resumeRequest.getObjective(), resumeRequest.getSpecialty(), resumeRequest.getLicense(),
                resumeRequest.getGrade(), resumeRequest.getAddress(), resumeRequest.getMiscellaneous());
        this.resumeRepository.save(resume);
    }
}
