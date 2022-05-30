-- ���̺� ���� ����

--ȸ�� ������
CREATE TABLE MEMBER ( --���̺� �̸�
    USER_ID       NUMBER PRIMARY KEY, --���̵� PRIMARY KEY : ���� ����, NULL�� �Է��� ����
    USER_PASSWORD VARCHAR2(100), --��й�ȣ
    USER_NAME     VARCHAR2(30) NOT NULL, -- �̸�
    USER_PHON     VARCHAR2(20) NOT NULL, --��ȭ��ȣ
    USER_ADDR1    VARCHAR2(20) NULL, --�ּ�1
    USER_ADDR2    VARCHAR2(50) NULL, --�ּ�2
    USER_ADDR3    VARCHAR2(50) NULL, --�ּ�3
    REGI_DATE     DATE DEFAULT SYSDATE, --���Գ�¥
    VERIFY        NUMBER DEFAULT 0 --�̸��� ���� ����
);

--��ǰ ������
CREATE TABLE GOODS (
    GDS_NUM   NUMBER PRIMARY KEY, --��ǰ��ȣ
    GDS_NAME  VARCHAR2(50) NOT NULL, --��ǰ�̸�
    CATE_CODE VARCHAR2(30) NOT NULL, --�з�
    GDS_PRICE NUMBER NOT NULL, --����
    GDS_STOCK NUMBER NULL, --����
    GDS_DES   VARCHAR(500) NULL, --��ǰ����
    GDS_IMG   VARCHAR(200) NULL, --�̹���
    GDS_DATE  DATE DEFAULT SYSDATE --��ϳ�¥
);

--ī�װ� ������
CREATE TABLE GOODS_CATEGORY (
    CATE_NAME    VARCHAR2(20) NOT NULL,
    CATE_CODE    VARCHAR2(30) PRIMARY KEY,
    CATE_CODEREF VARCHAR2(30) NULL,
    FOREIGN KEY ( CATE_CODEREF )
        REFERENCES GOODS_CATEGORY ( CATE_CODE ) -- ī�װ� 2���з��� ���� �ܷ�Ű ����
);

--ī�װ� �����Ϳ��� ��ǰ �����͸� �����ϱ� ���� �ܷ�Ű ����
ALTER TABLE GOODS
    ADD CONSTRAINT FK_GOODS_CATEGORY FOREIGN KEY ( CATE_CODE )
        REFERENCES GOODS_CATEGORY ( CATE_CODE );
        
--��ǰ ��ȣ �ڵ� �Է��� ���� ������ ����
CREATE SEQUENCE GOODS_SEQ;

--ȸ������ �׽�Ʈ
INSERT INTO MEMBER(USER_ID, USER_PASSWORD, USER_NAME, USER_PHON)
VALUES (1, '��й�ȣ', '�г���', '��ȭ��ȣ')

