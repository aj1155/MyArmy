package me.myarmy.api.service;

import me.myarmy.api.controller.model.response.CompanyResponse;
import me.myarmy.api.domain.Company;
import me.myarmy.api.domain.Predict;
import me.myarmy.api.domain.User;
import me.myarmy.api.repository.CompanyRepository;
import me.myarmy.api.repository.PredictRepository;
import me.myarmy.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Manki Kim on 2017-05-21.
 */
@Service
public class PredictionService {

    @Autowired
    private PredictRepository predictRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public List<CompanyResponse> predictCompany(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = this.userRepository.findByEmail(email);
        Optional<Predict> predict = Optional.ofNullable(this.predictRepository.findByUserId(user.getId()));
        if(!predict.isPresent()) return null;
        Predict isPredict = predict.get();
        String[] companys = isPredict.getCompanyIdText().split(",");
        List<Company> companies = new ArrayList<>();
        for(String cp : companys){
            companies.add(this.companyRepository.findOne(Integer.parseInt(cp)));
        }
        return convertCompanyEntityToResponse(companies);
    }

    private List<CompanyResponse> convertCompanyEntityToResponse(List<Company> companies){
        List<CompanyResponse> companyResponses = Optional.ofNullable(companies).orElse(Collections.emptyList()).stream()
                .map(company -> CompanyResponse.of(company))
                .collect(Collectors.toList());

        return companyResponses;
    }

}
