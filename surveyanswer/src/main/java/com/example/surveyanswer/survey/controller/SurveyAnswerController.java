package com.example.surveyanswer.survey.controller;

import com.example.surveyanswer.survey.domain.QuestionAnswer;
import com.example.surveyanswer.survey.response.SurveyDetailDto;
import com.example.surveyanswer.survey.response.SurveyResponseDto;
import com.example.surveyanswer.survey.service.SurveyAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class SurveyAnswerController {

    private final SurveyAnswerService surveyService;

    @GetMapping(value = "/survey/test")
    public String test() {

        return"test";
    }

    // 설문 참여
    @GetMapping(value = "/survey/load/{id}")
    public SurveyDetailDto participateSurvey(@PathVariable Long id) {
        return surveyService.getParticipantSurvey(id);
    }

    // 설문 응답 저장
    @PostMapping(value = "/survey/response/create")
    public String createResponse(@RequestBody SurveyResponseDto surveyForm) {
        // 설문 응답 저장
        System.out.println("survey answer");
        surveyService.createSurveyAnswer(surveyForm);
        return "Success";
    }

//    // 설문 응답 조회
//    @GetMapping(value = "/api/response/{id}")
//    public SurveyDetailDto readResponse(@PathVariable Long id){
//        return surveyService.getParticipantSurvey(id);
//    }

    // getQuestionAnswer
    @GetMapping(value = "/survey/question/list/{id}")
    public List<QuestionAnswer> getQuestionAnswers(@PathVariable Long id){
        return surveyService.getQuestionAnswers(id);
    }

    // getQuestionAnswerByCheckAnswerId
    @GetMapping(value = "/survey/getQuestionAnswerByCheckAnswerId/{id}")
    public List<QuestionAnswer> getQuestionAnswerByCheckAnswerId(@PathVariable Long id){
        return surveyService.getQuestionAnswerByCheckAnswerId(id);
    }


}
