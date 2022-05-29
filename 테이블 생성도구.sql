-- ���̺� ���� ����

--ȸ�� ������
CREATE TABLE MEMBER ( --���̺� �̸�
    USERID       NUMBER PRIMARY KEY, --���̵� PRIMARY KEY : ���� ����, NULL�� �Է��� ����
    USERPASSWORD VARCHAR2(100), --��й�ȣ
    USERNAME     VARCHAR2(30) NOT NULL, -- �̸�
    USERPHON     VARCHAR2(20) NOT NULL, --��ȭ��ȣ
    USERADDR1    VARCHAR2(20) NULL, --�ּ�1
    USERADDR2    VARCHAR2(50) NULL, --�ּ�2
    USERADDR3    VARCHAR2(50) NULL, --�ּ�3
    REGIDATE     DATE DEFAULT SYSDATE, --���Գ�¥
    VERIFY       NUMBER DEFAULT 0 --�̸��� ���� ����
);

--��ǰ ������
CREATE TABLE GOODS (
    GDSNUM   NUMBER PRIMARY KEY, --��ǰ��ȣ
    GDSNAME  VARCHAR2(50) NOT NULL, --��ǰ�̸�
    CATECODE VARCHAR2(30) NOT NULL, --�з�
    GDSPRICE NUMBER NOT NULL, --����
    GDSSTOCK NUMBER NULL, --����
    GDSDES   VARCHAR(500) NULL, --��ǰ����
    GDSIMG   VARCHAR(200) NULL, --�̹���
    GDSDATE  DATE DEFAULT SYSDATE --��ϳ�¥
);

--ī�װ� ������
CREATE TABLE GOODS_CATEGORY (
    CATENAME    VARCHAR2(20) NOT NULL,
    CATECODE    VARCHAR2(30) PRIMARY KEY,
    CATECODEREF VARCHAR2(30) NULL,
    FOREIGN KEY ( CATECODEREF )
        REFERENCES GOODS_CATEGORY ( CATECODE ) -- ī�װ� 2���з��� ���� �ܷ�Ű ����
);

--ī�װ� �����Ϳ��� ��ǰ �����͸� �����ϱ� ���� �ܷ�Ű ����
ALTER TABLE GOODS
    ADD CONSTRAINT FK_GOODS_CATEGORY FOREIGN KEY ( CATECODE )
        REFERENCES GOODS_CATEGORY ( CATECODE );
        
--��ǰ ��ȣ �ڵ� �Է��� ���� ������ ����
CREATE SEQUENCE GOODS_SEQ;