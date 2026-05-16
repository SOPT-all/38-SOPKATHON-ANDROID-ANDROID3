# 🚀 프로젝트 이름 (Service Name)
> 한 줄로 표현하는 서비스의 핵심 가치나 슬로건을 적어주세요.
> 예: "바쁜 대학생들을 위한 실시간 빈자리 예약 서비스, SeatNow"

## 📌 1. 기능 소개 (About Service)
- 서비스 Helper 리스트 확인 기능 : 원하는 서비스에 대한 Helper 들의 리스트를 받아옵니다.
- Helper 정보 보기 : 인증된 Helper 를 확인하기 위해 상세 정보를 불러옵니다.
- 서비스 예약 : 서비스 일시, 지역, 시간 등을 선택하여 서비스를 예약합니다.
- 서비스 결제 : 예약한 서비스에 대해 결제를 진행합니다.</br>

---

## 👥 2. 팀원 및 역할 분담 (Team & Roles)

|👑 안태훈 | 송서현 | 조예슬
|:---------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------:|
| <img width="200px" src="https://avatars.githubusercontent.com/u/113279387?v=4"/> | <img width="200px" src="https://avatars.githubusercontent.com/u/108921606?v=4"/> | <img width="200px" src="https://avatars.githubusercontent.com/u/130419090?v=4"/> | <img width="200px" src="https://avatars.githubusercontent.com/u/150934431?v=4"/> |
|`서비스 예약` | `헬퍼 정보 보기` | `진행률 확인` | `헬퍼 리스트` |
<br>

---

## ✨ 3. 주요 기능 (Key Features)
우리 서비스가 제공하는 핵심 기능 리스트입니다.

* **🔒 회원가입 및 로그인**: OAuth2 기반 소셜 로그인 및 JWT 토큰 관리
* **🔍 실시간 검색 및 필터링**: 사용자의 위치나 조건에 맞는 커스텀 필터링 기능
* **📅 실시간 예약 시스템**: 실시간 데이터 동기화를 통한 즉각적인 예약 처리
* **🔔 푸시 알림**: 예약 상태 변경 및 주요 이벤트 알림 송신

---

## 🛠 4. 기술 스택 (Tech Stack)
프로젝트에 사용된 주요 기술 및 라이브러리 목록입니다.

### Android
* **Language**: Kotlin
* **UI**: Jetpack Compose
* **Architecture**: Clean Architecture (Domain, Data, Presentation) + MVVM / MVI
* **DI**: Hilt
* **Asynchronous**: Coroutines & Flow
* **Network**: Retrofit2 & OkHttp3
* **Jetpack**: Navigation, Lifecycles, ViewModel

### Backend
* **Language**: Java
* **Framework**: Spring Boot
* **Database**: MySQL, Redis

---

## 📐 5. 아키텍처 구조 (Architecture)
본 프로젝트는 **Clean Architecture** 원칙을 준수하여, 관심사를 분리하고 확장성과 테스트 용이성을 극대화했습니다.

* **`domain`**: 비즈니스 로직의 핵심이며, 프레임워크나 외부 라이브러리에 의존하지 않습니다. (Entities, UseCases, Repository Interfaces)
* **`data`**: 데이터 소스(Local, Remote)와의 통신을 담당하며, Domain 영역의 인터페이스를 구현합니다. (Mappers, API Services, Repositories)
* **`presentation`**: UI와 사용자 상호작용을 처리합니다. (Compose Views, ViewModels, State/Effect)

---

## 🤝 6. 컨벤션 규칙 (Convention Rules)

### 💬 커밋 메시지 컨벤션 (Commit Message Convention)
[Feat]와 같이 태그를 붙여 커밋의 목적을 명확히 합니다.

* `[Feat]`: 새로운 기능 추가
* `[Fix]`: 버그 수정
* `[Design]`: UI 디자인 변경 (Compose 레이아웃 등)
* `[Refactor]`: 코드 리팩토링 (기능 변경 없음)
* `[Chore]`: 빌드 업무 수정, 패키지 매니저 설정, 패키지 구조 변경 등
* `[Docs]`: 문서 수정 (README 등)

> **커밋 예시**: `[Feat] #12 로그인 화면 Jetpack Compose 레이아웃 구현`

### 🧑‍💻 코드 컨벤션 (Code Convention)
* **Naming**: 클래스명은 `PascalCase`, 함수 및 변수명은 `camelCase`를 사용합니다.
* **Architecture 규칙**: Presentation 레이어는 Data 레이어에 직접 접근하지 않고, 항상 Domain 레이어의 UseCase를 거쳐 소통합니다.

---

## 🌿 7. 브랜치 전략 (Branch Strategy)
저희 팀은 안정적인 배포와 효율적인 협업을 위해 **Git Flow** 전략을 기반으로 브랜치를 운영합니다.

* **`main`**: 제품으로 출시될 수 있는 안정된 상태의 브랜치 (배포용)
* **`develop`**: 다음 출시 버전을 개발하는 상위 통합 브랜치
* **`feature/기능이름`**: 기능을 개발하는 브랜치 (ex: `feature/login`, `feature/search`)
    * `develop` 브랜치에서 분기하여 개발 완료 후 **Pull Request(PR)**를 통해 코드 리뷰를 받고 `develop`에 병합합니다.
* **`release`**: 배포를 준비하는 브랜치
* **`hotfix`**: 배포 버전에서 발생한 긴급 버그를 수정하는 브랜치

### 🔄 작업 흐름 (Workflow)
1. `develop` 브랜치에서 새로운 `feature/기능이름` 브랜치를 생성합니다.
2. 기능 구현 후 본인의 원격 저장소에 `push`합니다.
3. `develop` 브랜치로 **Pull Request(PR)**를 보냅니다.
4. **최소 1명 이상의 안드로이드 팀원에게 코드 리뷰**를 받고 승인(Approve)을 얻으면 병합(Merge)합니다.
