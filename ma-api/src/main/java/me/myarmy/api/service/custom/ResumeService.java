package me.myarmy.api.service.custom;

import me.myarmy.api.controller.model.request.ResumeRequest;
import me.myarmy.api.domain.Resume;

/**
 * Created by gain on 2017. 5. 6..
 */
public interface ResumeService {
    void createResume(ResumeRequest resumeRequest);
    Resume readResume();
    void updateResume(ResumeRequest resumeRequest);
}
