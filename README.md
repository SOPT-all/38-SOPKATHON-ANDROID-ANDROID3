# 🚀 프로젝트 이름 (Service Name)
> 한 줄로 표현하는 서비스의 핵심 가치나 슬로건을 적어주세요.
> 예: "바쁜 대학생들을 위한 실시간 빈자리 예약 서비스, SeatNow"

## 📌 1. 간단한 소개 (Service Brief)
> 인간만이 할 수 있는 망각을 서비스화한 []

</br>

---

## 👥 2. 팀원 및 역할 분담 (Team & Roles)

<br>

| 👑안태훈 | 송서현 | 조예슬 |
|-------|-------|-------|
| <img width="200" height="250" alt="image" src="https://github.com/user-attachments/assets/13d120ca-f354-4770-8cf0-002959c7d62c" /> | <img width="200" height="280" alt="image" src="https://github.com/user-attachments/assets/e93551ee-4251-4d46-83e0-4224c995f06f" /> | <img width="200" height="250" alt="화면 캡처 2026-05-16 224452" src="https://github.com/user-attachments/assets/12a9c4ff-b0db-4eee-b087-d1ffdba25144" /> |
| `소각해 주기 화면` | `망각 기록 확인 화면` | `망각하기 화면` |

---

## ✨ 3. 주요 기능 및 기술 스택 (Key Features & Tech Stack)
우리 서비스가 제공하는 핵심 기능 리스트입니다.

* **망각하고 싶은 기억 보내기**: 사용자가 망각하고 싶은 기억을 메시지 형태로 전송
* **누군가의 기억 소거해 주기**: 익명의 누군가가 보낸 기억에 간단하게 답글
* **받은 답글 확인하기**: 익명의 누군가가 보낸 답글을 모아서 확인

프로젝트에 사용된 주요 기술 및 라이브러리 목록입니다.

### Android
* **Language**: Kotlin
* **UI**: Jetpack Compose
* **Architecture**: MVVM + 구글 권장 아키텍쳐
* **DI**: 수동 주입
* **Asynchronous**: Coroutines & Flow
* **Network**: Retrofit2 & OkHttp3
* **Jetpack**: Navigation, Lifecycles, ViewModel

---

## 🤝 4. 컨벤션 규칙과 브랜치 전략 (Convention Rules & Branch Strategy)

### 💬 커밋 메시지 컨벤션 (Commit Message Convention)
[feat]와 같이 태그를 붙여 커밋의 목적을 명확히 합니다.

* `[feat]`: 새로운 기능 추가
* `[mod]` : 코드 수정
* `[add]` : 파일 추가
* `[del]` : 파일 삭제
* `[fix]`: 버그 수정
* `[refactor]`: 코드 리팩토링 (기능 변경 없음)

> **커밋 예시**: `[feat] #12 로그인 화면 Jetpack Compose 레이아웃 구현`

### 🧑‍💻 코드 컨벤션 (Code Convention)
* **Naming**: 클래스명은 `Upper Camel Case`, 함수 및 변수명은 `lower Camel Case`를 사용합니다.

### 브랜치 전략 (Branch Strategy)
저희 팀은 안정적인 배포와 효율적인 협업을 위해 **Git Flow** 전략을 기반으로 브랜치를 운영합니다.

* **`main`**: 최종적으로 개발을 완성하는 상위 통합 브랜치
* **`feature/#이슈번호-where-기능`**: 기능을 개발하는 브랜치 (ex: `feature/#1-main-login`, `feature/#2-home-search`)
    * `main` 브랜치에서 분기하여 개발 완료 후 **Pull Request(PR)**를 통해 코드 리뷰를 받고 `main`에 병합합니다.

### 🔄 작업 흐름 (Workflow)
1. `main` 브랜치에서 새로운 `feature/#이슈번호-where-기능` 브랜치를 생성합니다.
2. 기능 구현 후 본인의 원격 저장소에 `push`합니다.
3. `main` 브랜치로 **Pull Request(PR)**를 보냅니다.
4. 상호 소통 및 협의 이후 병합(Merge)합니다.

--

## 🍪 5. 안드로이드 팀원들의 사진 (before)

<img width="1546" height="2061" alt="image" src="https://github.com/user-attachments/assets/03994b84-8135-4136-b36b-14ffb9071587" />
