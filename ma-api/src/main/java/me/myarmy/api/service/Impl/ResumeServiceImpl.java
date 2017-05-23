package me.myarmy.api.service.Impl;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.controller.exception.ResumeNotFoundException;
import me.myarmy.api.controller.model.request.ResumeRequest;
import me.myarmy.api.domain.Resume;
import me.myarmy.api.repository.ResumeRepository;
import me.myarmy.api.service.custom.ResumeService;
import me.myarmy.api.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public Resume readResume() throws ResumeNotFoundException{
        Optional<Resume> resumeOptional = Optional.ofNullable(this.resumeRepository.findByUserId(this.userService.findCurrentUserId()));
        if(!resumeOptional.isPresent()){
            throw new ResumeNotFoundException("이력서를 등록해주세요");
        }else {
            Resume resume = resumeOptional.get();
            return resume;
        }
    }

    @Override
    public void updateResume(ResumeRequest resumeRequest){
        Resume resumeTmp = this.resumeRepository.findByUserId(this.userService.findCurrentUserId());
        Resume resume = new Resume();
        resume.setId(resumeTmp.getId());
        resume.setUserId(resumeTmp.getUserId());
        resume.setGrade(resumeRequest.getGrade());
        resume.setMiscellaneous(resumeRequest.getMiscellaneous());
        resume.setAddress(resumeRequest.getAddress());
        resume.setSpecialty(resumeRequest.getSpecialty());
        resume.setLicense(resumeRequest.getLicense());
        resume.setObjective(resumeRequest.getObjective());
        resume.setCreatedDate(resumeTmp.getCreatedDate());
        resume.setLastModifiedDate(resumeTmp.getLastModifiedDate());
        this.resumeRepository.save(resume);
    }
}
