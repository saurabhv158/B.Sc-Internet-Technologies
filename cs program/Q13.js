function validate(this_){
	var name=this_.elements[0].value;
	var dob=this_.elements[1].value;
	var rollnumber=this_.elements[2].value;
	if(rollnumber.length<7){
	alert("roll number less than 7");
	return false;
	}
	if(!isNaN(name)){
		alert("Please enter String name");
		return false;
		}
	if(dob==""){
	alert("Please Enter dob");
	return false;
	}
}