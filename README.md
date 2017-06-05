# androidStudy
php 와 mysql을 사용하여 로그인및 회원가입 기능을 구현해보자.

## DB Schema
~~~
CREATE TABLE 'USER'(
	userID VARCHAR(20) NOT NULL,
	userPassword VARCHAR(20) NOT NULL,
	userName VARCHAR(20) NOT NULL,
	userAge INT NOT NULL
	PRIMARY KEY(userID)
);
~~~
