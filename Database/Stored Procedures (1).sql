
/*
DELIMITER $$

CREATE PROCEDURE name(
    IN var1 varchar(15),
    IN var2 varchar(40),
    IN var3 integer,
    IN fn float,
)

BEGIN
    COMMAND Table(field1, field2, field3, field4)
    VALUES (var1, var2, var3,var4);
    SELECT return_info --LAST_INSERT_ID() object from table, etc;
END $$

DELIMITER ;
--End
*/

DELIMITER $$

CREATE PROCEDURE addProfile(
    IN _email varchar(40),
    IN _lastname varchar(40),
    IN _firstname varchar(40),
    IN _major varchar(40),
    IN _gender integer,
    IN _classification integer,
    IN _memberType integer,
    IN _source varchar(255),
    in _password varchar(40)
)

BEGIN
    INSERT INTO Profile(email, lastname, firstname, major, gender, classification, memberType, source, password)
    VALUES (_email, _lastname, _firstname, _major, _gender, _classification, _memberType, _source, _password);
    SELECT LAST_INSERT_ID();
END $$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE updateFeedback(
    IN _profileid varchar(40),
    IN _meetingid varchar(40),
    IN _feedback varchar(255)
)

BEGIN
    UPDATE Attendance
    SET  feedback= _feedback
    WHERE profile=_profileid AND meeting=_meetingid;

END $$

DELIMITER $$

CREATE PROCEDURE Gender_List()
BEGIN
    SELECT * from Gender;

END $$

DELIMITER $$

CREATE PROCEDURE Classification_List()
BEGIN
    SELECT * from Classification;

END $$

DELIMITER $$

CREATE PROCEDURE MemberType_List()
BEGIN
    SELECT * from MemberType;

END $$


DELIMITER $$

CREATE PROCEDURE Meeting()
BEGIN
    SELECT * from Meeting;

END $$

DELIMITER $$

CREATE PROCEDURE AttendanceByMeeting( IN _meeting integer )
BEGIN
   SELECT m.meetingdate, m.title, p.lastname, p.firstname, p.major, p.gender, p.classification, p.membertype 
   from Attendance a 
   INNER JOIN Meeting m ON a.meeting=m.tid 
   INNER JOIN Profile p ON a.profile=p.tid 
   where a.meeting=_meeting; 
    

END $$

DELIMITER $$

CREATE PROCEDURE addMeeting(
    IN _meetingdate datetime,
    IN _title varchar(40),
    IN _description varchar(255),
    IN _location varchar(255),
    IN _latitude float,
    IN _longitude float
)

BEGIN
    INSERT INTO Meeting(meetingdate, title, description, location, latitude, longitude)
    VALUES(_meetingdate, _title, _description, _location, _latitude, _longitude);
    SELECT LAST_INSERT_ID();
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE addAttendance(
    IN _profile integer,
    IN _meeting integer,
    IN _ipaddress varchar(24),
    IN _latitude float,
    IN _longitude float,
    IN _logintime datetime,
    IN _feedback varchar(255)
)

BEGIN
    INSERT INTO Attendance(profile, meeting, ipaddress, latitude, longitude, logintime, feedback)
    VALUES(_profile, _meeting, _ipaddress, _latitude, _longitude, _logintime, _feedback);
    SELECT LAST_INSERT_ID();
END $$

DELIMITER ;



