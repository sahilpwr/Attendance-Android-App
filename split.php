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

$i=3401;
$sql="SELECT CFCA FROM attend WHERE ROLL = $i";
			$j++;
			$result = mysql_query($sql,$con);
 			$row = mysql_fetch_assoc($result);
 			$ab=$row['CFCA'];
 			
 			$split=str_split($ab);
			echo $split[0];
			echo $length=strlen($ab);


$a='0';
$p='1';



?>

</body>
</html>