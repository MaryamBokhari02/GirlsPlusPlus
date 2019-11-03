<!DOCTYPE text/plain>
<?php
require_once "Database.php";
 
// get the HTTP method, path and body of the request
$method = $_SERVER['REQUEST_METHOD'];
$function = $_GET['function'];
//console_log("test", false);

//Instead of a switch statement, we can use a try catch block with the name of the function used as variable
try{
    $function();
}
catch(Throwable $e){
    //This will exit if there's no "function" key in the query string or if the function in the query string doesn't exist
    echo $e->getMessage();
    exit;
}

//Utility functions go here - md5Hash is an example. It's used by other functions, not as part of the API

function test(){
    foreach ($_GET as $key=> $value){
        $html .= "key = $key, value = $value<br>";
        $req[$key] = $value;
        //$req = $_GET['function'];
    }
    echo (json_encode($html));
    echo (json_encode($req));
}

function login(){
    $email = $_GET['email'];
    $password = $_GET['password'];
    $profileid = $_GET['profileid'];
    return checkCredentials($email, $password, $profileid);
}

function update_feedback(){
    $profile=$_GET['profile']; 
    $meeting=$_GET['meeting']; 
    $userfeedback= $_GET['feedback']; 
    $feedback = updateFeedback($profile, $meeting, $userfeedback);


}

function add_profile(){
    $profile = new Profile(0,
        $_GET['email'],
        $_GET['lastname'],
        $_GET['firstname'],
        $_GET['major'],
        $_GET['gender'],
        $_GET['classification'],
        $_GET['membertype'],
        $_GET['source'],
        $_GET['password']
    );
    $profile = addProfile($profile);
    echo(json_encode($profile->jsonSerialize()));


}
// If user requests all the meetings ever held 
function view_meeting_list(){
    if(login()){
        $list = viewMeetingList();
        echo (json_encode($list));
    }
    else{
        $err['Error Code'] = 1;
        $err['Message'] = 'Login Failed';
        echo (json_encode($err));
    }

}
// if meetingID is provided, then you can look at the attendence overallllll
function view_attendance_by_meeting(){
    if(login()){
        $meeting= $_GET['meeting'];
        $attendancelist = viewAttendanceByMeeting($meeting);
        echo (json_encode($attendancelist));
    }
    else{
        $err['Error Code'] = 1;
        $err['Message'] = 'Login Failed';
        echo (json_encode($err));
    }
}

function add_meeting(){
    if (login()){
        $meeting = new Meeting(0,
            $_GET['meetingdate'], 
            $_GET['title'],
            $_GET['description'],
            $_GET['location'],
            $_GET['latitude'],
            $_GET['longitude']
        ); 
        $meeting = addMeeting($meeting);
        if($meeting->get_tid() <= 0){
            $err['Error Code'] = 2;
            $err['Message'] = 'Meeting not added';
            echo (json_encode($err));                
        }
        else{
            echo(json_encode($meeting->jsonSerialize()));
        }
    }
    else{
        $err['Error Code'] = 1;
        $err['Message'] = 'Login Failed';
        echo (json_encode($err));
    }
    //date("Y-m-d H:i:s")

}
function attend_meeting(){
 // Y-m-d H:i:s 
    if(login())
    {
        $attendence = new Attendance(0,
        $_GET['profile'],
        $_GET['meeting'],
        $_SERVER['REMOTE_ADDR'], 
        $_GET['latitude'],
        $_GET['longitude'],
        date("Y-m-d h:i:s"),
        "" ); 
        $meeting = attendMeeting($attendence);
        echo(json_encode($meeting->jsonSerialize()));
    }
    else{
        $err['Error Code'] = 1;
        $err['Message'] = 'Login Failed';
        echo (json_encode($err));
    }

}

function getGenderList(){
    if(login())
    {
        $List = get_Gender_List();
        echo(json_encode($List));
    }
    else{
        $err['Error Code'] = 1;
        $err['Message'] = 'Login Failed';
        echo (json_encode($err));
    }
}

function getClassificationList(){
    if(login())
    {
        $List = get_Classification_List();
        echo(json_encode($List));
    }
    else{
        $err['Error Code'] = 1;
        $err['Message'] = 'Login Failed';
        echo (json_encode($err));
    }
}

function getMemberTypeList(){
    if(login())
    {
        $List = get_MemberType_List();
        echo(json_encode($List));
    }
    else{
        $err['Error Code'] = 1;
        $err['Message'] = 'Login Failed';
        echo (json_encode($err));
    }
}
?>