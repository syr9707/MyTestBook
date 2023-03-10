# MyTestBook
> Spring 게시만 API 만들기 ver2

<br>

## 🛠️ 사용 기술
* Java
* Spring Boot
* Spring Security
* Spring Data JPA

<br>

## 📌 프로젝트 목표
* API 동작 과정 완벽히 파악하기
  * View 만들까 말까 고민 중...
  * 일단은 **API만 만들고**, JSON 데이터 익숙해지기!
    * Front-End랑 협업할 준비연습이랄까...
* DTO 구조 익숙해지기
  * 더 나아가 DTO 세분화 해보기
* 연관관계 이해하기
  * DTO 구조가 복잡해지면서 연관관계 이해하기가 어려워졌음
  * 따라서 DTO 세분화와 함께 연관관계에 대한 학습을 하자!

<br>

## ✔ 요구사항 분석
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

<br>

## ✔ API
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
  * POST : /api/v1/posts/{postId}/comments
* 댓글 조회
  * GET : /api/v1/posts/{postId}/comments/{commentId}
* 댓글 수정
  * PUT : /api/v1/posts/{postId}/comments/{commentId}
* 댓글 삭제
  * DELETE : /api/v1/posts/{postId}/comments/{commentId}
* 게시글의 댓글 목록 조회
  * POST : /api/v1/posts/{id}

<br>

## ❓ Why?
1. 왜 DTO를 사용했나?
   * Entity가 아닌 DTO를 전달함으로써 각 레이어 간 역할을 분리할 수 있기 때문이다.
   * 데이터를 묶어서 하나의 요청으로 보내면, 검증과 로직 처리 역시 한 번에 할 수 있겠다.
   * 직렬화를 캡슐화함으로써, DTO는 이 로직을 코드에서 제외하고, 원하는 경우 직렬화를 변경할 수 있는 명확한 지점을 제공한다.
2. 요청과 응답으로 엔티티(Entity) 대신 DTO를 사용하자
   1. 엔티티 내부 구현을 캡슐화 할 수 있다.
      * 엔티티가 getter와 setter를 갖게 된다면, controller와 같은 비즈니스 로직과 크게 상관없는 곳에서 자원의 속성이 실수로라도 변경될 수 있다.
      * Entity를 UI계층에 노출하는 것은 테이블 설계를 화면에 공개하는 것이나 다름 없다.
   2. 화면에 필요한 데이터를 선별할 수 있다.
      * API 스펙이 많아지면, 요청하는 화면에 필요한 속성만 보낸다. -> 속도 빨라짐
   3. 순환 참조를 예방할 수 있다.
      * 양방향 참조가 부득이한 상황이라면, 순환참조가 일어나지 않도록 응답의 return으로 DTO로 두는 것이 더 안전하다.
   4. validation 코드와 모델링 코드를 분리할 수 있다.
      * 각각의 요청에 필요한 validation을 DTO에서 정의한다면, 엔티티 클래스를 좀 더 모델링과, 비즈니스 로직에만 집중되도록 만들 수 있다.

<br>

## 💡 나의 결론
API 스펙과 엔티티 사이에 의존성이 생기는 문제도 있다.

우리는 UI와 도메인이 서로 의존성을 갖지 않고, 독립적으로 개발하는 것을 지향하기 때문에
이를 중간에서 연결시켜주는 DTO의 역할이 중요하다.

요청과 응답으로 DTO를 사용하면,
각각의 DTO 클래스가 데이터를 전송하는 클래스로서의 역할을 명확히 가질 수 있게 되고,
이는 하나의 클래스가 하나의 역할을 해야 한다는 객체지향의 정신과도 부합한다.

∴ 하나의 엔티티에 너무 많은 책임을 주지 말자.

<br>

## ▶️DB 구조
![](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/8cc77a17-6baa-4a50-9c6a-832c547cf02a/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230310%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230310T051901Z&X-Amz-Expires=86400&X-Amz-Signature=467d2acf8efb66497f86128fbc457c534483b6f7a9b930a34ab179f9b9127b45&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

<br>

