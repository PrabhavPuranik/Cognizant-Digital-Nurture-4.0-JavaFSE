SET SERVEROUTPUT ON;

-- Create CUSTOMERS table
CREATE TABLE CUSTOMERS (
    cust_id     NUMBER PRIMARY KEY,
    name        VARCHAR2(50),
    age         NUMBER,
    balance     NUMBER,
    isVIP       VARCHAR2(5) DEFAULT 'FALSE'
);

-- Create LOANS table
CREATE TABLE LOANS (
    loan_id         NUMBER PRIMARY KEY,
    cust_id         NUMBER REFERENCES CUSTOMERS(cust_id),
    interest_rate   NUMBER,
    due_date        DATE
);

-- Insert in CUSTOMERS
INSERT INTO CUSTOMERS VALUES (1, 'Ravi Sharma', 65, 15000, 'FALSE');
INSERT INTO CUSTOMERS VALUES (2, 'Anjali Mehta', 45, 9500, 'FALSE');
INSERT INTO CUSTOMERS VALUES (3, 'Suresh Kumar', 70, 12000, 'FALSE');
INSERT INTO CUSTOMERS VALUES (4, 'Neha Patil', 34, 8000, 'FALSE');
INSERT INTO CUSTOMERS VALUES (5, 'Vikram Joshi', 62, 11000, 'FALSE');

-- Insert in LOANS
INSERT INTO LOANS VALUES (101, 1, 7.5, SYSDATE + 10);
INSERT INTO LOANS VALUES (102, 2, 8.0, SYSDATE + 40);
INSERT INTO LOANS VALUES (103, 3, 6.5, SYSDATE + 20);
INSERT INTO LOANS VALUES (104, 4, 9.0, SYSDATE + 5);
INSERT INTO LOANS VALUES (105, 5, 7.0, SYSDATE + 15);

COMMIT;

-- ======= Scenario 1 =======
BEGIN
    DBMS_OUTPUT.PUT_LINE('======= Scenario 1 =======');
    FOR c IN (SELECT cust_id, name FROM CUSTOMERS WHERE age > 60) LOOP
        UPDATE LOANS
        SET interest_rate = interest_rate - 1
        WHERE cust_id = c.cust_id;
        
        DBMS_OUTPUT.PUT_LINE('Discount applied for ' || c.name);
    END LOOP;
END;
/

-- ======= Scenario 2 =======
BEGIN
    DBMS_OUTPUT.PUT_LINE(CHR(10) || '======= Scenario 2 =======');
    FOR c IN (SELECT cust_id, name FROM CUSTOMERS WHERE balance > 10000) LOOP
        UPDATE CUSTOMERS
        SET isVIP = 'TRUE'
        WHERE cust_id = c.cust_id;
        
        DBMS_OUTPUT.PUT_LINE(c.name || ' promoted to VIP');
    END LOOP;
END;
/

-- ======= Scenario 3 =======
BEGIN
    DBMS_OUTPUT.PUT_LINE(CHR(10) || '======= Scenario 3 =======');
    FOR l IN (
        SELECT L.loan_id, C.name, L.due_date
        FROM LOANS L
        JOIN CUSTOMERS C ON L.cust_id = C.cust_id
        WHERE L.due_date <= SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || l.loan_id || ' for ' || l.name || ' is due on ' || TO_CHAR(l.due_date, 'DD-MON-YYYY'));
    END LOOP;
END;
/
