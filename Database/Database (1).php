<?php
require 'Classes.php';

mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT);
$db = new mysqli('localhost', 'attendin_prim', '28836346', 'attendin_girlsplusplus');
if ($db->connect_error) {
    echo 'Failed to connect to MySQL: ' . $db->connect_error;
    $db = NULL;
}

function viewAttendanceByMeeting($meeting)
{
    global $db;
    dbFlush();
    $query = 'CALL AttendanceByMeeting (\'' . 
    $meeting . '\')';

    //console_log("query = $query");
    $result = $db->query($query);
    if($result->num_rows > 0){
        $row = $result->fetch_array();
    }
    return $row; 

}
function get_Gender_List()
{
    global $db;
    dbFlush();
    $query = 'CALL Gender_List()';

    //console_log("query = $query");
    $result = $db->query($query);
    if($result->num_rows > 0){
        $row = $result->fetch_array();
    }
    return $row; 
}

function get_Classification_List()
{
    global $db;
    dbFlush();
    $query = 'CALL Classification_List()';

    //console_log("query = $query");
    $result = $db->query($query);
    if($result->num_rows > 0){
        $row = $result->fetch_array();
    }
    return $row; 
}
function get_MemberType_List()
{
    global $db;
    dbFlush();
    $query = 'CALL MemberType_List()';

    //console_log("query = $query");
    $result = $db->query($query);
    if($result->num_rows > 0){
        $row = $result->fetch_array();
    }
    return $row; 
}

function viewMeetingList(){
    global $db;
    dbFlush();
    $query = 'CALL Meeting ()';

    ////console_log("query = $query");
    $result = $db->query($query);
    if($result->num_rows > 0){
        $row = $result->fetch_array();
    }
    return $row; 

}

function updateFeedback($profile, $meeting, $userfeedback){
    global $db;
    dbFlush();
    $query = 'CALL updateFeedback (\'' . 
        $profile . '\',\'' .
        $meeting . '\',\'' .
        $userfeedback . '\')';

    //console_log("query = $query");
    $result = $db->query($query);
    if($result->num_rows > 0){
        $row = $result->fetch_array();
    }
    echo "Feedback Updated";

}

/*CREATE*/
function attendMeeting($attendence) {
    global $db;
    dbFlush();
    $query = 'CALL addAttendance (\'' . 
        $attendence->get_profile() . '\',\'' .
        $attendence->get_meeting() . '\',\'' .
        $attendence->get_ipaddress() . '\',\'' .
        $attendence->get_latitude() . '\',\'' .
        $attendence->get_longitude() . '\',\'' .
        $attendence->get_logintime() . '\',\'' .
        $attendence->get_feedback() . '\')';

    //console_log("query = $query");
    $result = $db->query($query);
    if($result->num_rows > 0){
        $row = $result->fetch_array();
        $attendence->set_tid($row[0]);
    }
    return $attendence;
}


function dbFlush(){
    global $db;
    do{
        if ($res = $db->store_result()) {
          $res->free();
        }
    } while ($db->more_results() && $db->next_result());
}

function checkCredentials(){return true;}

function addProfile($profile){
    global $db;
    dbFlush();
    $query = 'CALL addProfile(\'' . $profile->get_email() . '\',\'' .
        $profile->get_lastname() . '\',\'' .
        $profile->get_firstname() . '\',\'' .
        $profile->get_major() . '\',\'' .
        $profile->get_gender() . '\',\'' .
        $profile->get_classification() . '\',\'' .
        $profile->get_membertype() . '\',\'' .
        $profile->get_source() . '\',\'' .
        $profile->get_password() . '\')';
    //console_log("query = $query");
    $result = $db->query($query);
    if($result->num_rows > 0){
        $row = $result->fetch_array();
        $profile->set_tid($row[0]);
    }
    return $profile;

}
function addMeeting($meeting){
    global $db;
    dbFlush();
    $query = 'CALL addMeeting(\'' . $meeting->get_meetingdate() . '\',\'' .
        $meeting->get_title() . '\',\'' .
        $meeting->get_description() . '\',\'' .
        $meeting->get_location() . '\',\'' .
        $meeting->get_latitude() . '\',\'' .
        $meeting->get_longitude() . '\')';
    //console_log("query = $query");
    $result = $db->query($query);
    if($result->num_rows > 0){
        $row = $result->fetch_array();
        $meeting->set_tid($row[0]);
    }
    return $meeting;
}

?>

