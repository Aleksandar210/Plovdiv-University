DELIMITER //
CREATE TRIGGER update_student_address_update_parent
AFTER UPDATE ON Parents
FOR EACH ROW
BEGIN
    IF OLD.address_id <> NEW.address_id THEN
        UPDATE Students
        SET address_id = NEW.address_id
        WHERE parent_id = NEW.parent_id;
    END IF;
END;
//

DELIMITER //
CREATE TRIGGER UpdateStudentAddress AFTER UPDATE ON Students
FOR EACH ROW
BEGIN
    DECLARE new_address_id INT;

    IF OLD.parent_id IS NULL AND NEW.parent_id IS NOT NULL THEN
        SELECT address_id INTO new_address_id FROM Parents WHERE parent_id = NEW.parent_id;
        UPDATE Students SET address_id = new_address_id WHERE student_id = NEW.student_id;
        
    ELSEIF OLD.parent_id <> NEW.parent_id THEN
        SELECT address_id INTO new_address_id FROM Parents WHERE parent_id = NEW.parent_id;
        UPDATE Students SET address_id = new_address_id WHERE student_id = NEW.student_id;
    END IF;
END;
//
DELIMITER ;


DELIMITER //
CREATE TRIGGER InsertUserID_Teachers BEFORE INSERT ON Teachers
FOR EACH ROW
BEGIN
    DECLARE new_id INT;
    
    -- Insert into Users table
    INSERT INTO Users (user_name, email, user_password)
    VALUES (NEW.user_name, NEW.email, NEW.user_password);
    
    -- Get the last inserted user_id
    SET new_id = LAST_INSERT_ID();
    
    -- Set the user_id for the Teachers table
    SET NEW.teacher_id = new_id;
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER InsertUserID_Students BEFORE INSERT ON Students
FOR EACH ROW
BEGIN
    DECLARE new_id INT;
    
    -- Insert into Users table
    INSERT INTO Users (user_name, email, user_password)
    VALUES (NEW.user_name, NEW.email, NEW.user_password);
    
    -- Get the last inserted user_id
    SET new_id = LAST_INSERT_ID();
    
    -- Set the user_id for the Students table
    SET NEW.student_id = new_id;
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER InsertUserID_Parents BEFORE INSERT ON Parents
FOR EACH ROW
BEGIN
    DECLARE new_id INT;
    
    -- Insert into Users table
    INSERT INTO Users (user_name, email, user_password)
    VALUES (NEW.user_name, NEW.email, NEW.user_password);
    
    -- Get the last inserted user_id
    SET new_id = LAST_INSERT_ID();
    
    -- Set the user_id for the Parents table
    SET NEW.parent_id = new_id;
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER transfer_to_users_after_delete AFTER DELETE ON Students
FOR EACH ROW
BEGIN
    DELETE FROM Users WHERE user_id = OLD.student_id;
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER transfer_to_users_parents_after_delete AFTER DELETE ON Parents
FOR EACH ROW
BEGIN
    DELETE FROM Users WHERE user_id = OLD.parent_id;
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER transfer_to_users_teachers_after_delete AFTER DELETE ON Teachers
FOR EACH ROW
BEGIN
    DELETE FROM Users WHERE user_id = OLD.teacher_id;
END;
//
DELIMITER ;
