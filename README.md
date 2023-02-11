# MyTestBook

## 프로젝트 목표
* API 동작 과정 완벽히 파악하기
  * View 만들까 말까 고민 중...
  * 일단은 **API만 만들고**, JSON 데이터 익숙해지기!
    * Front-End랑 협업할 준비연습이랄까...
* DTO 구조 익숙해지기
  * 더 나아가 DTO 세분화 해보기
* 연관관계 이해하기
  * DTO 구조가 복잡해지면서 연관관계 이해하기가 어려워졌음
  * 따라서 DTO 세분화와 함께 연관관계에 대한 학습을 하자!


## 요구사항 분석
* 게시판 기능
  * 게시글 조회
  * 게시글 등록
  * 게시글 수정
  * 게시글 삭제


* 게시물 댓글 기능
  * 댓글 등록
  * 댓글 수정
  * 댓글 삭제
  * 한 작성자가 여러 게시물을 올릴 수 있음
  * 작성자가 올린 게시물 모아보기


* Spring Security를 이용한 회원가입
  * 구글로 회원가입
    * 아 저번에 했을 때 문제가 있었는데 아직 해결 못함
      * 한번 '구글로 회원가입'하면 왜 다음부턴 확인 과정이 안 나올까...
  * 회원은 게시물을 여러 개 등록할 수 있다.
  * 비회원은 열람만 가능하다.
    * 이건 View단에서 하는 건가?


## API
* 게시글 생성 
  * POST : /api/v1/posts
* 게시글 조회
  * GET : /api/v1/posts/{id}
* 게시글 수정
  * PUT : /api/v1/posts/{id}
* 게시글 삭제
  * DELETE : /api/v1/posts/{id}

<br>

* 회원 가입
  * POST : /api/v1/user
* 회원 정보 전체 조회 (관리자 페이지)
  * GET : /api/v1/user/all
* 특정 회원 정보 조회 (마이페이지)
  * GET : /api/v1/user/{id}
* 회원 정보 수정
  * PUT : /api/v1/user/{id}
* 회원 탈퇴
  * DELETE : /api/v1/user/{id}

<br>

* 댓글 작성
  * POST : /api/v1/posts/{postId}/comments/{userId}
    * 예비...
    * SpringSecurity 인증 안 하고 Postman 실험할 수 있는 방법 없을까...
    * 뷰페이지 안 만들고 API 호출 테스트만 하고 싶은데ㅠ





