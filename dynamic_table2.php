<html>
<center>
<TH>ATTENDANCE REVIEW FOR CFCA</TH>
<style>

th, td {
    padding: 2px;
}
th, td {
    text-align: center;
}
</style>


<body background="bg1.jpg">


<?php


$con = mysql_connect("localhost","attend_mysql","mysql");
			if (!$con)
			  {
			  die('Could not connect: ' . mysql_error());
			  }
			 
			mysql_select_db("attend_rec", $con);




?>
<table border='2'>

<tr>
<th>
<font size="3" color="red">ROLL NO</font>
</th>
<?php 
for($i=1;$i <= 10; $i++){
    ?><th><font size="3" color="red"><?php echo LECTURE." ".$i; ?></font></th><?php
}
?>
</tr>
<?php 
for($i=3401;$i<3411;$i++){

$sql="SELECT CFCA FROM attend WHERE ROLL = $i";
			$j++;
			$result = mysql_query($sql,$con);
 			$row = mysql_fetch_assoc($result);
 			$ab=$row['CFCA'];
 			
 			$split=str_split($ab);

			$length=strlen($ab);

    ?>
    <tr>
        <th><?php echo $i; ?></th>
        <?php
        for($j=1;$j <= $length; $j++){
            ?>
            <font size="3" color="red">
            <td>
                <?php
                
                
                echo $split[$j];
                
                ?>
                </font>
            </td>
            <?php
        } 
        ?>
     </tr>
    <?php
   
}
?>
</table>
</body>
</center>
</html>