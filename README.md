# saba-backend
## 서비스 설명
* 개발 완료시 기재 예정
## 구현
### 1. DDD
* 각 도메인을 분리하여 관심사를 분리하여 비즈니스 로직에 집중할 수 있게 해주었습니다.

### 2. Hexagonal-architecture
![image](https://github.com/user-attachments/assets/6d3fcec1-deb7-4a99-bf08-e231ec0e5eb3)
* 헥사고날 아키텍처를 적용하여 애플리케이션 영역의 의존성을 줄여 유지보수하기 편한 로직을 구현했습니다.
* 멀티모듈 기술을 병합하여 application과 infrastructure영역을 분리하였습니다.
    *  **Infrastructure**: 주로 global, thirdparty, adapter와 관련된 내용을 담아 application의 의존성을 분리했습니다.
    *  **Application**: 핵심적인 로직인 UseCase, Port, Domain영역을 담아 비즈니스로직에 집중할 수 있도록 구현했습니다.

### 3. TDD
* Springboot에서 제공하고 있는 Junit으로 Unit test를 진행합니다.
* Test코드를 일부 추가하여 CI 작업을 할 때마다 Test코드가 실행되게 하여 코드 변경시 발생할 수 있는 회귀 버그를 발견할 수 있도록 하였습니다.

