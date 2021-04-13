# TDD 연습하기
간단한 http api server로 red - green - refactor 느낌 살려 보기  

기대하는 결과 :  
1. post /name       자신의 이름을 영어로 등록
2. get /name        등록한 이름과 그 이름 기반으로 3개의 의미 없는 애너그램을 보여줌
3. put /name        애너그램을 하나 선택해서 이름을 업데이트
4. delete /name     등록된 자신의 이름을 삭제  

_일단 콘튜랄라와 엔티티를 만든 뒤 애너그램 부분을 뤠드 그린 리펙터 해본다..._