ALTER TABLE SMS 
ADD COLUMN SMS_MOD VARCHAR(45) NOT NULL DEFAULT 'smsmanager' AFTER SMS_USER,
ADD COLUMN SMS_MOD_ID VARCHAR(45) NULL DEFAULT NULL AFTER SMS_MOD;