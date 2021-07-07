function validateAddDetailsForm()
{
	var firstName = document.forms["addDetailsForm"]["firstName"];
	var lastName = document.forms["addDetailsForm"]["lastName"];
	var email = document.forms["addDetailsForm"]["email"];
	var age = document.forms["addDetailsForm"]["age"];
	
	if(validateName(firstName) && validateName(lastName) && 
			validateAge(age) && validateEmail(email))
		{
			return true;
		}
	else
		{
			var response = "Values not added: ";
			if(!(validateName(firstName)))
			   {
				   response += "First Name ";
			   }
			   if(!(validateName(lastName)))
			   {
				   response += "Last Name ";
			   }
			   if(!(validateAge(age)))
			   {
				   response += "Contact Number ";
			   }
			   if(!(validateEmail(email)))
			   {
				   response += "Email ";
			   }
			   alert(response);
			   return false;
		}
	
}


function validateName(name)
{
	var upperName = name.value.toUpperCase();
	
	if(upperName.length < 2)
	{
		validationResponse(false, name);
		return false;
	}
	
	var i;
	for(i=0; i<upperName.length; i++)
	{
		if((upperName.charCodeAt(i) < 65 || upperName.charCodeAt(i) > 90) && upperName.charCodeAt(i) != 32)
		{
			validationResponse(false, name);
			return false;
		}
	}
	validationResponse(true, name);
	return true;
}

function validateAge(age)
{
	if(age.value.length < 1)
	{
		validationResponse(false, age);
		return false;
	}
	
	var i;
	for(i=0; i<age.value.length; i++)
	{
		if(age.value.charCodeAt(i) < 48 || age.value.charCodeAt(i) > 57)
		{
			validationResponse(false, age);
			return false;
		}
	}
	validationResponse(true, age);
	return true;
	
}

function validateEmail(email)
{
	if(email.value.length > 5 && email.value.indexOf("@") < email.value.lastIndexOf(".") &&
		email.value.indexOf("@") > 0 && email.value.indexOf("@") < (email.value.length - 4) && 
		email.value.indexOf(".") != -1 && email.value.indexOf(".") < (email.value.length - 2))
	{
		validationResponse(true, email);
		return true;
	}
	validationResponse(false, email);
	return false;
}



function validationResponse(response, object)
{
	if(response)
	{
		object.style.border = "1px solid green";
	}
	else
	{
		object.style.border = "1px solid red";
	}
}