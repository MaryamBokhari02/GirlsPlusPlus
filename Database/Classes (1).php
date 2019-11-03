<?
/*Logging function*/
function console_log($output, $with_script_tags = false) {
    $js_code = 'console.log(' . json_encode($output, JSON_HEX_TAG) . ');<br>';
    if ($with_script_tags) {
        $js_code = '<script>' . $js_code . '</script>';
    }
    echo $js_code;
}

class Profile{
	private $tid;
	public function set_tid($tid){$this->tid =  $tid;}
	public function get_tid(){return $this->tid;}
	private $email;
	public function set_email($email){$this->email =  $email;}
	public function get_email(){return $this->email;}
	private $lastname;
	public function set_lastname($lastname){$this->lastname =  $lastname;}
	public function get_lastname(){return $this->lastname;}
	private $firstname;
	public function set_firstname($firstname){$this->firstname =  $firstname;}
	public function get_firstname(){return $this->firstname;}
	private $major;
	public function set_major($major){$this->major =  $major;}
	public function get_major(){return $this->major;}
	private $gender;
	public function set_gender($gender){$this->gender =  $gender;}
	public function get_gender(){return $this->gender;}
	private $classification;
	public function set_classification($classification){$this->classification =  $classification;}
	public function get_classification(){return $this->classification;}
	private $membertype;
	public function set_membertype($membertype){$this->membertype =  $membertype;}
	public function get_membertype(){return $this->membertype;}
	private $source;
	public function set_source($source){$this->source =  $source;}
	public function get_source(){return $this->source;}
	private $password;
	public function set_password($password){$this->password =  $password;}
	public function get_password(){return $this->password;}
	public function __construct(){
		if(func_get_arg(0)){$this->tid = func_get_arg(0);}
		if(func_get_arg(1)){$this->email = func_get_arg(1);}
		if(func_get_arg(2)){$this->lastname = func_get_arg(2);}
		if(func_get_arg(3)){$this->firstname = func_get_arg(3);}
		if(func_get_arg(4)){$this->major = func_get_arg(4);}
		if(func_get_arg(5)){$this->gender = func_get_arg(5);}
		if(func_get_arg(6)){$this->classification = func_get_arg(6);}
		if(func_get_arg(7)){$this->membertype = func_get_arg(7);}
		if(func_get_arg(8)){$this->source = func_get_arg(8);}
		if(func_get_arg(9)){$this->password = func_get_arg(9);}
	}
    public function jsonSerialize()
    {
        $vars = get_object_vars($this);

        return $vars;
	}
}

class Gender{
	private $tid;
	public function set_tid($tid){$this->tid =  $tid;}
	public function get_tid(){return $this->tid;}
	private $type;
	public function set_type($type){$this->type =  $type;}
	public function get_type(){return $this->type;}
	public function __construct(){
		if(func_get_arg(0)){$this->tid = func_get_arg(0);}
		if(func_get_arg(1)){$this->type = func_get_arg(1);}
	}
    public function jsonSerialize()
    {
        $vars = get_object_vars($this);

        return $vars;
	}
}

class Classification{
	private $tid;
	public function set_tid($tid){$this->tid =  $tid;}
	public function get_tid(){return $this->tid;}
	private $classification;
	public function set_classification($classification){$this->classification =  $classification;}
	public function get_classification(){return $this->classification;}
	public function __construct(){
		if(func_get_arg(0)){$this->tid = func_get_arg(0);}
		if(func_get_arg(1)){$this->classification = func_get_arg(1);}
	}
    public function jsonSerialize()
    {
        $vars = get_object_vars($this);

        return $vars;
	}
}

class MemberType{
	private $tid;
	public function set_tid($tid){$this->tid =  $tid;}
	public function get_tid(){return $this->tid;}
	private $memberType;
	public function set_memberType($memberType){$this->memberType =  $memberType;}
	public function get_memberType(){return $this->memberType;}
	public function __construct(){
		if(func_get_arg(0)){$this->tid = func_get_arg(0);}
		if(func_get_arg(1)){$this->memberType = func_get_arg(1);}
	}
    public function jsonSerialize()
    {
        $vars = get_object_vars($this);

        return $vars;
	}
}

class Meeting{
	private $tid;
	public function set_tid($tid){$this->tid =  $tid;}
	public function get_tid(){return $this->tid;}
	private $meetingdate;
	public function set_meetingdate($meetingdate){$this->meetingdate =  $meetingdate;}
	public function get_meetingdate(){return $this->meetingdate;}
	private $title;
	public function set_title($title){$this->title =  $title;}
	public function get_title(){return $this->title;}
	private $description;
	public function set_description($description){$this->description =  $description;}
	public function get_description(){return $this->description;}
	private $location;
	public function set_location($location){$this->location =  $location;}
	public function get_location(){return $this->location;}
	private $latitude;
	public function set_latitude($latitude){$this->latitude =  $latitude;}
	public function get_latitude(){return $this->latitude;}
	private $longitude;
	public function set_longitude($longitude){$this->longitude =  $longitude;}
	public function get_longitude(){return $this->longitude;}
	public function __construct(){
		if(func_get_arg(0)){$this->tid = func_get_arg(0);}
		if(func_get_arg(1)){$this->meetingdate = func_get_arg(1);}
		if(func_get_arg(2)){$this->title = func_get_arg(2);}
		if(func_get_arg(3)){$this->description = func_get_arg(3);}
		if(func_get_arg(4)){$this->location = func_get_arg(4);}
		if(func_get_arg(5)){$this->latitude = func_get_arg(5);}
		if(func_get_arg(6)){$this->longitude = func_get_arg(6);}
	}
    public function jsonSerialize()
    {
        $vars = get_object_vars($this);

        return $vars;
	}
}

class Attendance{
	private $tid;
	public function set_tid($tid){$this->tid =  $tid;}
	public function get_tid(){return $this->tid;}
	private $profile;
	public function set_profile($profile){$this->profile =  $profile;}
	public function get_profile(){return $this->profile;}
	private $meeting;
	public function set_meeting($meeting){$this->meeting =  $meeting;}
	public function get_meeting(){return $this->meeting;}
	private $ipaddress;
	public function set_ipaddress($ipaddress){$this->ipaddress =  $ipaddress;}
	public function get_ipaddress(){return $this->ipaddress;}
	private $latitude;
	public function set_latitude($latitude){$this->latitude =  $latitude;}
	public function get_latitude(){return $this->latitude;}
	private $longitude;
	public function set_longitude($longitude){$this->longitude =  $longitude;}
	public function get_longitude(){return $this->longitude;}
	private $logintime;
	public function set_logintime($logintime){$this->logintime =  $logintime;}
	public function get_logintime(){return $this->logintime;}
	private $feedback;
	public function set_feedback($feedback){$this->feedback =  $feedback;}
	public function get_feedback(){return $this->feedback;}
	public function __construct(){
		if(func_get_arg(0)){$this->tid = func_get_arg(0);}
		if(func_get_arg(1)){$this->profile = func_get_arg(1);}
		if(func_get_arg(1)){$this->meeting = func_get_arg(2);}
		if(func_get_arg(2)){$this->ipaddress = func_get_arg(3);}
		if(func_get_arg(3)){$this->latitude = func_get_arg(4);}
		if(func_get_arg(4)){$this->longitude = func_get_arg(5);}
		if(func_get_arg(5)){$this->logintime = func_get_arg(6);}
		if(func_get_arg(7)){$this->feedback = func_get_arg(7);}
	}
    public function jsonSerialize()
    {
        $vars = get_object_vars($this);

        return $vars;
	}
}

?>
