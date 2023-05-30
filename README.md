# SurveyMSA
 SWAVE project to MSA
 https://malwareanalysis.tistory.com/91
 https://blog.naver.com/alice_k106/221502890249
 https://twofootdog.tistory.com/23
 https://seungjuitmemo.tistory.com/185
### 인그레스 설정
 1. 도메인 별로 나눈 모듈(스프링 프로젝트)을 각각 다른 포드로 쿠버네티스에 배포
 2. 각각의 포드를 가르키는 서비스를 배포
 3. 인그레스 컨트롤러를 설치해서 url에 따라 가르켜야 하는 서비스 지정
 4. 인그레스 ip로 접속 테스트
 5. 포드에서 포드끼리의 통신 테스트 (포드에서 서비스에게 가서 데이터 요청)
 6. 5번을 위해 스프링 프로젝트에서는    
`String url = "http://" + serviceBHost + "/api/resource";`
```java
@Value("${serviceB.host}")
private String serviceBHost;
```   
 7. 이런식으로 application.properties에 serviceBHost를 저장하고 가져다 사용