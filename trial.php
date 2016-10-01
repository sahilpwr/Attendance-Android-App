<!DOCTYPE html>
<html>
<body>


<?php
// get the "message" variable from the post request
// this is the data coming from the Android app

$message0=$_POST["message0"];
$message1=$_POST["message1"]; 

// specify the file where we will save the contents of the variable message

$filename="androidmessages.html";

// write (append) the data to the file

file_put_contents($filename,$message0."<br />",FILE_APPEND);

// load the contents of the file to a variable

$androidmessages=file_get_contents($filename);

// display the contents of the variable (which has the contents of the file)

 
 
 $con = mysql_connect("localhost","attend_mysql","mysql");
if (!$con)
  {
  die('Could not connect: ' . mysql_error());
  }
 
mysql_select_db("attend_rec", $con);
 
$sql="INSERT INTO name
VALUES
('$_POST[message0]')";
 //the message name in the post and in $_POST in insert query should be same
if (!mysql_query($sql,$con))
  {
  die('Error: ' . mysql_error());
  }
echo "1 record added to the database of sahilpwr_msql";
 
 
 
 
 
 
 $j=0;
 $accept='id';
 $msg='message';
 for($i=3401;$i<3410;$i++)
 { 
 	$res=$msg.$j;
 	$accept=$_post[$res]
 		if($accept==$i)
 		{
 			$i++;
 			$j++
 		
 		}
 		else
 		{
 			$con = mysql_connect("localhost","attend_mysql","mysql");
			if (!$con)
			  {
			  die('Could not connect: ' . mysql_error());
			  }
			 
			mysql_select_db("attend_rec", $con);
			 
			$sql="UPDATE `attend` SET `ATTENDANCE` = 'ATTENDANCE + 1' WHERE `ROLL NO` =  $i";
			
			 //the message name in the post and in $_POST in insert query should be same
			if (!mysql_query($sql,$con))
			  {
			  die('Error: ' . mysql_error());
			  }
			echo "1 record added to the database of sahilpwr_msql";
			 
			
 		
 		}
 }
 
 


?>

</body>
</html>