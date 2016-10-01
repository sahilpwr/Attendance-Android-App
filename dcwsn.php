<!DOCTYPE html>
<html>
<body>


<?php


$con = mysql_connect("localhost","attend_mysql","mysql");
			if (!$con)
			  {
			  die('Could not connect: ' . mysql_error());
			  }
			 
			mysql_select_db("attend_rec", $con);



$a='0';
$p='1';


$j=0;
$msg='message';
	
 $j++;


 for($i=3401;$i<3411;$i++)
 { 
 	$res=$msg.$j;
 	$accept=$_POST[$res];
 		if($accept==$i)
 		{
 			$sql="SELECT DCWN FROM attend WHERE ROLL = $i";
			$j++;
			$result = mysql_query($sql,$con);
 			$row = mysql_fetch_assoc($result);
 			$ab=$row['DCWN'];
 			$absent=$ab.$a;
 			
 			echo $absent;
 			$sql="UPDATE attend SET DCWN = $absent WHERE `ROLL` =  $i";
			
			 
			if (!mysql_query($sql,$con))
			  {
			  die('Error: ' . mysql_error());
			  }
			echo "1 record added to the database of sahilpwr_msql";
 			
 			
 			
 		}
 		else
 		{
 			$sql="SELECT DCWN FROM attend WHERE ROLL = $i";

			$result = mysql_query($sql,$con);
 			$row = mysql_fetch_assoc($result);
 			$pre=$row['DCWN'];
 			
 			$present=$pre.$p;
			$sql="UPDATE attend SET DCWN = $present WHERE `ROLL` =  $i";
			
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