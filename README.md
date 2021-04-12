# TDD 연습하기
간단히 red - green - refactor 를 유념하면서 HTTP API 서버를 하나를 만들며 TDD를 연습해 봤읍니다.  

단순히 CRUD만 있다면 테스트할 필요가 없지 않은가 싶어서 테스트 할 법 한 로직을 추가해 봤습니다.  

어플리케이션의 기능 :  
1. 사용자가 자신의 이름을 영어로 등록할 수 있습니다.
2. 사용자가 등록한 이름을 기반으로 3개의 의미 없는 애너그램을 보여줍니다.
3. 사용자가 3개의 애너그램 중 하나를 선택하여 자신의 이름을 업데이트 할 수 있습니다.
4. 사용자가 등록된 자신의 이름을 삭제할 수 있습니다.

---------------
### 메모  

*_일단 아무리 생각해봐도 엔티티는 테스트 코드 전에 쓰는게 맞지 싶어서 엔티티를 먼저 쓰고 테스트 코드를 쓰기 시작했음_  

*_잠만 근데 콘트롤러랑 서비스도 만들어 놓고 테스트 코드를 써야하나?_  

*_수;발_