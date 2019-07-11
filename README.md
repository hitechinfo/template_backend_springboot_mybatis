# template_backend_springboot_001
Springboot, Spring Security, JPA 기반 템플릿

# 서버기동 방법
Application.java - 우클릭 - Spring Boot App

# 사용방법 및 기능 설명
MainController.java 함수를 사용

## /main

MainTemplate  
get 호출 확인용

request : get  
reponse : 200, Hello World!-MainController-main  


## /data

MyBatisTemplate  
properties MariaDB로 설정, H2Runner run 메소드 내용 주석처리 후 테스트  
post 호출, MariaDB, Mybatis 확인용  

request : post  
response :  
{  
"rows":[  
{  
"TEST": "SUCCESS"  
}  
]  
}  

## /exception

ExceptionTemplate  
Custom exception 확인용  

request : post  
response :  
{  
"status": "BAD_REQUEST",  
"message": "Exception Test Error!"  
}
