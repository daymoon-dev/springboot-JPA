# Spring Boot + JPA + Thymeleaf

 ### 프로그램 설명
 - 사용자 등록과 조회가 가능한 웹어플리케이션


### 요구사항
- 사용자 속성
  - 아이디 : 필수(O) / max 10자 / 중복불가(unique)
  - 이름 : 필수(O) / max 10자 / 중복허용
  - 이메일 : 필수(O) / max 50 / 중복불가 (unique)
  - 별명 : 필수(X) / max 20 
  - 등록일시: 필수(O) / date type


- 기타 제한사항
  - 사용자 속성 에 대한 server side validation 은 반드시 존재해야 합니다.(validation rule은 사용자 속성에 나와 있는 부분)
  - server side validation check실패시 validation 실패 메세지를 front에 전달하여 alert(꼭 alert이 아니더라도 사용자가 식별할 수만 있으면 됩니다.) 으로 출력.
---
  

- Spring Boot (2.0.6.RELEASE)
- JPA(Hibernate 6.0.10.Final)
- Thymeleaf
- H2
- lombok
