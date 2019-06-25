# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## STEP2 기능 요구 사항
 - InputView 객체 구현
   - `Scanner` 클래스를 이용한다.
   - `로또 총 구입금액`을 입력받고 출력한 후, 금액을 리턴한다.
   - `로또 개수`를 입력받고 몇개를 구입했는지 출력한다.
   - `당첨 번호`를 입력 받은 후 `당첨 번호`를 리턴한다.
   
 - RottoFactory 객체 구현
   - `로또 총 구입금액` 값 을 받는다.
   - `로또 총 구입금액으로` 생성할 `로또 개수`를 구한다.
   - `로또 개수` 만큼 Rotto 객체를 만들어 `읽기전용 List`로 리턴한다.
   - 
   
 - Rotto 객체 구현
   - 클래스 변수로 로또번호 1~45까지 입력된 List를 구현한다.
   - `Collections.shuffle()`로, 랜덤 6자리 숫자를 구하여 인스턴스 변수 `List`에 넣는다.
   - `읽기전용 List를` 리턴한다.
   - `숫자 List`를 받은 후, 요소를 하나씩 탐색하면서 `포함된 숫자 개수`를 구하고 리턴한다.
   
 - RottoAmount 객체 구현
   - `5_000`, `50_000`, `1_500_000`, `2_000_000_000` 상수로 `Enum` 타입으로 구현한다.  
   - 상수에 매칭되는 실제 `금액 변수`도 만든다.
   - 일치 번호를 입력시 해당하는 `금액 변수`를 리턴한다.
     - 인자가 3~6 사이가 아니라면, `Exception`를 호출한다.
   
 - RottoResults 객체 구현
   - `당첨 번호 List`를 받는다.
   - `Rotto 객체 List`를 받는다. 
   - 크기 4`배열`을 생성한다. 이는 로또 3~6개 일치 하는 개수를 저장할 공간이다.
   - 입력 받은 Rotto 객체를 순회하면서 당첨 번호를 이용해 몇개의 번호가 포함 되어 있는지를 구하고 `배열`에 저장한다.
   - 인자를 3~6까지 받으며, 해당 인자에 일치하는 배열 값을 리턴한다.
     - 인자 범위가 넘어가면 `Exception`를 호출한다.
   - 총 수익률을 계산한다.
     - 받은 Rotto 객체 개수 * 1000 으로 로또를 구입한 금액을 구한다.
     - `배열`에 저장된 일치 개수와 통해, 이윤 금액을 구한다.
     - `이윤금액 / 로또 금액` 값을 구하고, 소수점 두자리 까지 저장한다.  
   
 - ResultView 구현
   - RottoResults 객체를 받습니다.
   - 로또 일치번호 3~6 개를 RottoResults 객체를 통해 당첨 개수를 구합니다.
   - 당첨 개수와 RottoAmount Enum를 통해, 결과값 문자열을 만든다.
   - 총 수익률을 RottoResults로 받아, 결과값 문자열을 만든다.