SET SERVEROUTPUT ON;

-- Create ACCOUNTS table
CREATE TABLE ACCOUNTS (
    acc_id       NUMBER PRIMARY KEY,
    cust_name    VARCHAR2(50),
    balance      NUMBER,
    acc_type     VARCHAR2(20)
);

-- Create Employee table
CREATE TABLE EMPLOYEES (
    emp_id       NUMBER PRIMARY KEY,
    name         VARCHAR2(50),
    department   VARCHAR2(30),
    salary       NUMBER
);

-- Insert in ACCOUNTS
INSERT INTO ACCOUNTS VALUES (1, 'Ravi Sharma', 10000, 'Savings');
INSERT INTO ACCOUNTS VALUES (2, 'Anjali Mehta', 8000, 'Current');
INSERT INTO ACCOUNTS VALUES (3, 'Neha Patil', 20000, 'Savings');
INSERT INTO ACCOUNTS VALUES (4, 'Suresh Kumar', 5000, 'Savings');

-- Insert in EMPLOYEES
INSERT INTO EMPLOYEES VALUES (101, 'Arun Joshi', 'Sales', 40000);
INSERT INTO EMPLOYEES VALUES (102, 'Kavita Rani', 'HR', 35000);
INSERT INTO EMPLOYEES VALUES (103, 'Sunil Deshmukh', 'Sales', 42000);
INSERT INTO EMPLOYEES VALUES (104, 'Meena Kapoor', 'IT', 50000);

COMMIT;

-- ======= Scenario 1 =======
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('======= Scenario 1 =======');
    FOR acc IN (SELECT acc_id, cust_name, balance FROM ACCOUNTS WHERE acc_type = 'Savings') LOOP
        UPDATE ACCOUNTS
        SET balance = balance + (balance * 0.01)
        WHERE acc_id = acc.acc_id;

        DBMS_OUTPUT.PUT_LINE('Interest added to account of ' || acc.cust_name);
    END LOOP;
END;
/

-- ======= Scenario 2 =======
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    dept_name IN VARCHAR2,
    bonus_percent IN NUMBER
) IS
BEGIN
    DBMS_OUTPUT.PUT_LINE(CHR(10) || '======= Scenario 2 =======');
    FOR emp IN (SELECT emp_id, name FROM EMPLOYEES WHERE department = dept_name) LOOP
        UPDATE EMPLOYEES
        SET salary = salary + (salary * bonus_percent / 100)
        WHERE emp_id = emp.emp_id;

        DBMS_OUTPUT.PUT_LINE('Bonus applied to ' || emp.name);
    END LOOP;
END;
/

-- ======= Scenario 3 =======
CREATE OR REPLACE PROCEDURE TransferFunds (
    from_acc IN NUMBER,
    to_acc IN NUMBER,
    amount IN NUMBER
) IS
    from_balance ACCOUNTS.balance%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE(CHR(10) || '======= Scenario 3 =======');
    
    SELECT balance INTO from_balance FROM ACCOUNTS WHERE acc_id = from_acc;

    IF from_balance < amount THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient balance.');
    ELSE
        UPDATE ACCOUNTS SET balance = balance - amount WHERE acc_id = from_acc;
        UPDATE ACCOUNTS SET balance = balance + amount WHERE acc_id = to_acc;
        DBMS_OUTPUT.PUT_LINE('Transfer of Rs. ' || amount || ' completed from Account ' || from_acc || ' to Account ' || to_acc);
    END IF;
    
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: One or both accounts not found.');
END;
/

-- ======= TEST CALLS BELOW =======

BEGIN
    ProcessMonthlyInterest;
END;
/

BEGIN
    UpdateEmployeeBonus('Sales', 10);
END;
/

BEGIN
    TransferFunds(3, 2, 5000);
END;
/
