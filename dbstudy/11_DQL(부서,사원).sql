/*
    DQL
    
    1. Data Query Language
    2. 데이터 질의어
    3. 테이블의 데이터를 조회/검색
    4. 데이터베이스에 변화가 없으므로 COMMIT 없음
        (트랜잭션의 대상이 아님)
    5. 형식
        SELECT 칼럼1, 칼럼2, ...
          FROM 테이블
        [WHERE 조건식]
        [GROUP BY 그룹화]
        [HAVING 그룹화_조건식]
        [ORDER BY 정렬기준]
    6. 실행 순서
        ⑤  SELECT 칼럼
        ①    FROM 테이블
        ②   WHERE 조건식
        ③   GROUP BY 그룹화
        ④  HAVING 그룹화_조건식
        ⑥   ORDER BY 정렬기준
*/


-- 1. 사원 테이블에서 사원명 조회하기
SELECT NAME
  FROM EMPLOYEE;
  
-- 1) 테이블에 오너(OWNER) 명시
SELECT NAME
  FROM SCOTT.EMPLOYEE;

-- 2) 칼럼에 테이블 명시
SELECT EMPLOYEE.NAME
  FROM EMPLOYEE;

-- 3) 테이블에 별명 지정
SELECT EMP.NAME
  FROM EMPLOYEE EMP;  -- 별명 EMP 지정

-- 4) 칼럼에 별명(ALIAS) 지정
SELECT NAME AS 사원명  -- 별명 사원명 지정
  FROM EMPLOYEE;


-- 2. 사원 테이블의 모든 칼럼 조회하기
--    모든 칼럼 : *
--    중요 : 실무에서 * 사용 금지(성능문제있음)
SELECT *
  FROM EMPLOYEE;

-- 모든 칼럼이 필요하면 모두 명시
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE;


-- 3. 부서 테이블에서 지역명 조회하기
--    단, 동일한 지역은 한 번만 조회하기
--    중복 제거 : DISTINCT
SELECT DISTINCT LOCATION
  FROM DEPARTMENT;


/* WHERE절 활용하기 */

-- 4. 사원 테이블에서 직급이 '과장'인 사원 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE POSITION = '과장';

-- 5. 사원 테이블에서 급여가 2000000~5000000인 사원 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE SALARY >= 2000000
   AND SALARY <= 5000000;

SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE SALARY BETWEEN 2000000 AND 5000000;

-- 6. 사원 테이블에서 소속부서가 1,2인 사원 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE DEPART = 1
    OR DEPART = 2;

SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE DEPART IN(1, 2);

-- 7. 사원 테이블에서 성별이 없는 사원 조회
--    NULL 유무
--    1) NULL이다   : IS NULL
--    2) NULL아니다 : IS NOT NULL
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE GENDER IS NULL;

-- 8. 사원 테이블에서 김씨 조회하기
--    1) 만능문자(WILD CARD)
--       (1) % : 모든 문자, 글자수 제한 없음
--       (2) _ : 모든 문자, 한 글자로 제한
--    2) 예시    
--       (1) 김으로 시작하는 이름 찾기 : 김%
--       (2) 김으로 끝나는 이름 찾기   : %김
--       (3) 김을 포함하는 이름 찾기   : %김%
--    3) 만능문자 연산자
--       LIKE, NOT LIKE

SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE NAME LIKE '김%';

-- 9. 사원 테이블에서 사원번호가 1로 시작하는 사원 조회하기
SELECT EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY
  FROM EMPLOYEE
 WHERE EMP_NO LIKE '1%';
