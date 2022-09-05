/*
    프로시저
    
    1. PROCEDURE
    2. 여러 개의 쿼리문을 한 번에 실행
       (이체 : UPDATE문 2개)
    3. 작성된 프로시저는 EXECUTE문으로 실행
       EXECUTE 프로시저();
    4. 형식
        CREATE [OR REPLACE] 프로시저_이름[(매개변수)]
        IS  -- AS 가능
            변수선언
        BEGIN
            프로시저본문
        [EXCEPTION
            예외처리]
        END [프로시저_이름];
*/

-- 프로시저 PROC1 정의(만들기)
CREATE OR REPLACE PROCEDURE PROC1
IS
    NAME VARCHAR2(10 BYTE);
BEGIN
    NAME := '민경태';
    DBMS_OUTPUT.PUT_LINE(NAME);
END PROC1;
    
-- 프로시저 PROC1 호출(실행)
EXECUTE PROC1();



-- 프로시저 PROC2 정의
-- 사원번호=100인 사원의 FIRST_NAME 서버메시지로 출력하기
CREATE OR REPLACE PROCEDURE PROC2
IS
    FNAME EMPLOYEES.FIRST_NAME%TYPE;  -- 변수
BEGIN
    SELECT FIRST_NAME  -- FIRST_NAME 칼럼 값을
      INTO FNAME       -- FNAME 변수에 저장
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = 100;
    DBMS_OUTPUT.PUT_LINE(FNAME);
END PROC2;

-- 프로시저 PROC2 호출
EXECUTE PROC2();







