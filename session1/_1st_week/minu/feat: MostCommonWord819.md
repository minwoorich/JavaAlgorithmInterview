## 알게 된 점

### 정규표현식
```java
String[] words = paragraph.toLowerCase().split("[!?',;\\.\\s]+");
```

``!`` ``?`` ``'`` ``,`` ``;`` ``.`` ``공백`` 을 만나면 구분자로 사용 하겠다 라는 뜻.
+ ``[ ] `` 는 대괄호 안에 포함된 문자 중 하나와 일치하는 문자를 찾겠다는 뜻
+ ``+`` 는 두 번이상 연속으로 나타나는것도 포함한다는 뜻
+ ``\\.`` 의 경우 정규표현식에서는 모든 문자라는 뜻을 가지고 있기 때문에 ``.`` 만을 나타내려면 ``\.`` 와 같이 역슬래시를 붙여줘야한다. 문제는 JAVA의 경우 역슬래시가 이스케이프 문자로 인식하기에 여기에 역슬래시를 하나 더 붙여줘야한다.
+ ``\\s`` 는 위와 똑같은 이유로 ``\s`` 가 정규표현식으로 공백을 뜻하는데 JAVA에서는 ``\`` 가 이스케이프 문자로 인식되기 때문에 역슬래시 하나를 더 붙여주었다.
