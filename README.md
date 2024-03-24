<aside>
<h1>Spring 심화 프로젝트</h1>

</aside>

<h2>프로젝트 협업 도구 Trello 제작</h2>

이번 프로젝트를 통해 Trello와 같은 유명한 서비스를 모방하여 진행할 예정입니다.
작업 생성, 관리, 상태 업데이트와 같은 다양한 기능을 개발하며 실무적인 경험을 쌓을 수 있습니다.
또한, 프로젝트 주제에 따라 개발 프로세스에 대한 깊은 이해를 높일 수 있으며, 이를 통해 효과적인 협업 능력을 향상시킬 수 있습니다.

### **🤔** 트렐로는 무엇일까?

Trello는 프로젝트 관리 및 작업 협업을 위한 온라인 시각적 협업 도구입니다. 사용자들은 보드(Board)라고 불리는 온라인 칸반 스타일의 작업 공간에서 리스트(Lists)와 카드(Cards)를 사용하여 작업을 관리합니다.

보드는 사용자가 원하는 대로 구성할 수 있으며, 각각의 보드는 여러 리스트로 구성됩니다. 리스트는 일반적으로 작업의 다른 단계나 카테고리를 나타내며, 각 리스트에는 여러 개의 카드가 포함됩니다. 이러한 카드는 각각의 작업이나 할 일을 나타냅니다.

카드는 사용자가 원하는 내용을 포함할 수 있으며, 라벨, 첨부 파일, 기한 등과 같은 추가 정보를 포함할 수 있습니다. 또한, 카드는 팀원과의 댓글 및 작업 첨부를 통한 실시간 협업이 가능합니다.

Trello의 주요 특징은 다음과 같습니다:

1. 시각적인 인터페이스: 칸반 스타일의 보드를 사용하여 작업을 시각적으로 관리할 수 있습니다.
2. 실시간 협업: 팀원들과의 실시간 협업을 위한 댓글, 첨부 파일 등의 기능을 제공합니다.
3. 유연한 구성: 사용자는 자신의 프로세스에 맞게 보드, 리스트, 카드를 구성할 수 있습니다.
4. 모바일 앱 지원: 모바일 애플리케이션을 통해 언제 어디서나 작업을 확인하고 업데이트할 수 있습니다.
5. 이러한 기능들을 통해 Trello는 팀의 협업과 프로젝트 관리를 보다 효율적으로 만들어 줍니다.

❕칸반 보드는 프로젝트 관리와 작업 흐름을 시각적으로 관리하는 데에 널리 사용되고 있습니다. 칸반 보드는 다양한 컬럼으로 구성되어 있어요. 먼저, Backlog에는 작업을 시작하기 전에 만들어진 카드들이 위치합니다.

그 다음으로는 In Progress로, 프로젝트가 진행되면서 작업자들이 해당 카드를 옮겨 작업을 진행합니다. 마지막으로 Done에는 작업이 완료된 카드들이 위치하게 됩니다.

이러한 구성은 명확한 작업 흐름을 시각적으로 보여줌으로써 팀원들이 현재 상황을 쉽게 파악할 수 있게 도와줍니다. 또한, In Progress 상태의 작업 수를 제한함으로써 팀의 집중력을 높이고 생산성을 향상시키는 데에 도움이 됩니다.

더불어, 각 개발자들 사이에 카드 이동량을 경쟁적으로 비교함으로써 실력 향상을 격려하고, 팀 내에서 협업과 소통을 촉진하는 역할도 합니다. 이러한 장점들을 통해 칸반 보드는 효율적인 프로젝트 관리와 높은 생산성을 실현하는 데에 큰 도움을 줍니다.

<br/>

### **🚀** 트렐로의 필수 기능 구현해보기!

이제 여러분들이 트렐로를 만들기 위해서 어떠한 기능을 만들어야 될 지 자세히 말씀드리겠습니다.

- **사용자 관리 기능**
    - [ ]  로그인 / 회원가입 기능
    - [ ]  사용자 정보 수정 및 삭제 기능
- **보드 관리 기능**
    - [ ]  보드 생성
    - [ ]  보드 수정
        - 보드 이름
        - 배경 색상
        - 설명
    - [ ]  보드 삭제
        - 생성한 사용자만 삭제를 할 수 있습니다.
    - [ ]  보드 초대
        - 특정 사용자들을 해당 보드에 초대시켜 협업을 할 수 있어야 합니다.
- **컬럼 관리 기능**
    - [ ]  컬럼 생성
        - 보드 내부에 컬럼을 생성할 수 있어야 합니다.
        - 컬럼이란 위 사진에서 Backlog, In Progress와 같은 것을 의미해요.
    - [ ]  컬럼 이름 수정
    - [ ]  컬럼 삭제
    - [ ]  컬럼 순서 이동
        - 컬럼 순서는 자유롭게 변경될 수 있어야 합니다.
            - e.g. Backlog, In Progress, Done → Backlog, Done, In Progress
- **카드 관리 기능**
    - [ ]  카드 생성
        - 컬럼 내부에 카드를 생성할 수 있어야 합니다.
    - [ ]  카드 수정
        - 카드 이름
        - 카드 설명
        - 카드 색상
        - 작업자 할당
        - 작업자 변경
    - [ ]  카드 삭제
- **카드 상세 기능**
    - [ ]  댓글 달기
        - 협업하는 사람들끼리 카드에 대한 토론이 이루어질 수 있어야 합니다.
    - [ ]  날짜 지정
        - 카드에 마감일을 설정하고 관리할 수 있어야 합니다.

         <br/>
         <br/>

- **동시성 제어 `난이도 중`**
    - **동시성 문제 이해하기**
        - 여러 사용자가 동시에 같은 데이터를 수정하려고 할 때 발생할 수 있는 문제를 이해하고, 이를 해결하기 위한 전략을 배워보세요.
        - 레이스 컨디션, 데드락과 같은 동시성 문제를 알아보고, 왜 동시성 제어가 필요한지 학습하세요.
    - **동시성 제어 기법 적용하기**
        - 백엔드 서버와 데이터베이스에서 동시성 제어를 위해 낙관적 락과 비관적 락과 적용해보세요.
        - 낙관적 락은 데이터베이스 레벨에서 제공하는 버전 관리 기능을 활용하여 충돌을 감지하고 처리하는 방식입니다.
        - 비관적 락은 전통적인 락 기법으로, 데이터를 수정하기 전에 명시적으로 락을 걸어 다른 트랜잭션의 접근을 차단합니다.


