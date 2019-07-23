# template_backend_springboot_mybatis
Springboot, Spring Security, Mybatis 기반 템플릿

## 작업환경 설정
* Git 설치
* Java JDK 설치
* STS 설치
* lombok 설치
  * 다운로드: https://projectlombok.org/download (압축 풀지 않습니다.)
  * lombok jar 파일이 다운로드된 폴더 위치에서 cmd 창을 엽니다. 
  * 명령어 입력: `java -jar lombok.jar` (lombok.jar에 다운받은 파일의 이름을 넣습니다)
  * install 창이 뜨면 설치를 진행합니다.

## 프로젝트 실행하기
### 소스 다운로드
* cmd창 혹은 git bash 혹은 에디터의 터미널 창을 열고 원하는 폴더 위치로 이동합니다.  
* 해당 폴더 위치에서 템플릿 프로젝트 GitHub에서 소스를 clone하여 다운 받습니다.  
  `git clone https://github.com/hitechinfo/template_backend_springboot_mybatis.git`
  * Tip) Git bash를 사용하셔도 좋지만 sourcetree 등과 같은 Git Client Tool을 사용하시면 소스를 관리하기 편리합니다.   
### 서버 기동
* Application.java - 우클릭 - Spring Boot App


### 사용방법 및 기능 설명
MainController.java 함수를 사용
rest url 추가 할때마다 common/security/SecurityConfig.java 파일의 configure function에 해당 url 추가 (authorized)

### Sample REST API 가이드
* table은 local `template` DB의 `sv_common_codes`를 사용  

* URL : `/main`
  * MainTemplate  
  * get 호출 확인용
  * request : get  
  * reponse : 200, Hello World!-MainController-main  

* URL : `/dataget`
  * properties : MariaDB dev로 설정 
  * request : get  
  * Common Code select

  
* URL : `/datapost`
  * properties : MariaDB dev로 설정 
  * request : post  
  * Common Code insert

  
* URL : `/dataput`
  * properties : MariaDB dev로 설정 
  * request : put  
  * Common Code update


* URL : `/exception`
  * ExceptionTemplate  
  * Custom exception 확인용  
  * request : post  
  * response :  
    ```
    {  
    "status": "BAD_REQUEST",  
    "message": "Exception Test Error!"  
    }
    ```
