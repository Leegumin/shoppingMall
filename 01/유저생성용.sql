--��������
CREATE USER GUMIN --������
IDENTIFIED BY 1234 --��й�ȣ
DEFAULT TABLESPACE USERS --�⺻ ���̺� �����̽�
TEMPORARY TABLESPACE TEMP; --�ӽ� ���̺� �����̽�

--���� ���� �ο�
GRANT CONNECT TO GUMIN; --�����ͺ��̽� ���� ���� ����
GRANT RESOURCE TO GUMIN; --���̺�, ������ �� ������ ���� ��ü ���� ����
GRANT DBA TO GUMIN; -- �ý��� �ڿ��� ������ ���, �ٸ� ����� ���� ���� ���� ������ ����

-- ���������
-- CMD, Ȥ�� �����ڰ������� ����
--* USER ������ ���� ���� �ο�
--grant create user to scott;
-- SCOTT ���� ���ѻ�� : ��(ROLE : ���� ���ѵ��� ��� ��Ƴ��� ��)
-- CONNECT(���ӿ� ���õ� ���� ������)
-- RESOURCE(���̺�, ��, ���ν��� ���� ���� ������)
-- DBA(����, DB���� ��� �ֻ��� ���� ������)

-- ���� ����
-- CREATE TABLE : ���̺� ���� ����
-- CREATE VIEW : �� ���� ����
-- CREATE SEQUENCE : ������ ���� ����

-- ���Ѻο� ��ɾ�
-- GRANT ����(��) TO ������

-- ������� ��ɾ�
-- REVOKE ����(��) FROM ������

-- ���Ǿ� : ���̺� : SELECT * FROM SCOTT3.EMPLOYEE
--                  ��Ī���� �����ؼ� �̸��� �������� �� ����
-- �㳪 �����ڸ� �����ؼ� �����ڴ� ��?�� �ص� ��