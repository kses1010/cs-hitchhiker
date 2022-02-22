# System Structure & Program Execution 1

## 컴퓨터 시스템 구조

![image1](https://user-images.githubusercontent.com/49144662/154898073-f9ac6b7d-5fd8-45e7-8acd-c59a0619ab5d.png)

-   메모리는 CPU의 작업공간이라고 볼 수 있다.
-   각각의 I/O Device는 device controller라는 것이 있다. -> Local buffer에 저장

CPU

-   CPU 안에는 정보를 저장할 수 있는 공간이 있다 -> registers
-   mode bit: OS인지 프로그램인지 구분하는 역할
-   interrupt line: CPU에서 디스크, 키보드 등의 IO device 명령을 접근하는 역할
