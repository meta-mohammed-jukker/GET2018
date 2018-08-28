function validateSignupForm()
{
	var firstName = document.forms["signupForm"]["firstName"];
	var lastName = document.forms["signupForm"]["lastName"];
	var contactNumber = document.forms["signupForm"]["contactNumber"];
	var email = document.forms["signupForm"]["email"];
	var password = document.forms["signupForm"]["password"];
	var confirmPassword = document.forms["signupForm"]["confirmPassword"];
	var signUpIncorrectPassword = document.getElementById("signUpIncorrectPassword");
	
	if( validateName(firstName) && validateName(lastName) && validateContactNumber(contactNumber) && 
		   validateEmail(email) && validatePassword(password, signUpIncorrectPassword) && checkPassword(confirmPassword, password))
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
			   if(!(validateContactNumber(contactNumber)))
			   {
				   response += "Contact Number ";
			   }
			   if(!(validateEmail(email)))
			   {
				   response += "Email ";
			   }
			   if(!(validatePassword(password, signUpIncorrectPassword)))
			   {
				   response += "Passoword ";
			   }
			   if(!(checkPassword(confirmPassword, password)))
			   {
				   response += "Confirm Password ";
			   }
			   alert(response);
			   return false;
		   }
}

function validateLoginForm()
{
	var email = document.forms["loginForm"]["email"];
	var password = document.forms["loginForm"]["password"];
	var loginIncorrectPassword = document.getElementById("loginIncorrectPassword");
	
	if (validateEmail(email) && validatePassword(password))
	{
		return true;
	}
	else
	{
		var response = "Values not added: ";
		if(!(validateEmail(email)))
		{
			response += "Email ";
		}
		if(!(validatePassword(password, loginIncorrectPassword)))
		{
			response += "Passoword ";
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

function validateContactNumber(contactNumber)
{
	if(contactNumber.value.length < 9)
	{
		validationResponse(false, contactNumber);
		return false;
	}
	
	var i;
	for(i=0; i<contactNumber.value.length; i++)
	{
		if(contactNumber.value.charCodeAt(i) < 48 || contactNumber.value.charCodeAt(i) > 57)
		{
			validationResponse(false, contactNumber);
			return false;
		}
	}
	validationResponse(true, contactNumber);
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

function validatePassword(passwordObject, incorrectPassword)
{
	var  password = passwordObject.value;
	
	if(password.length < 8)
	{
		validationResponse(false, passwordObject);
		incorrectPassword.innerHTML = "Password length should be more than 7";
		return false;
	}
	
	var checkUpperAlphabet = false;
	var checkLowerAlphabet = false;
	var checkNumber = false;
	var checkSpecialCaseCharacter = false;
	
	var i;
	for(i=0; i<password.length; i++)
	{
		if(password.charCodeAt(i) >= 65 && password.charCodeAt(i) <= 90)
		{
			checkUpperAlphabet = true;
			//alert("upper");
		}
		if(password.charCodeAt(i) >= 97 && password.charCodeAt(i) <= 122)
		{
			checkLowerAlphabet = true;
			//alert("lower");
		}
		if(password.charCodeAt(i) >= 48 && password.charCodeAt(i) <= 57)
		{
			checkNumber = true;
			//alert("number");
		}
		if((password.charCodeAt(i) >= 33 && password.charCodeAt(i) <= 47) || 
		   (password.charCodeAt(i) >= 58 && password.charCodeAt(i) <= 64) || 
		   (password.charCodeAt(i) >= 91 && password.charCodeAt(i) <= 96) || 
		   (password.charCodeAt(i) >= 123 && password.charCodeAt(i) <= 126))
		{
			checkSpecialCaseCharacter = true;
			//alert("character");
		}
	}
	
	if(checkUpperAlphabet && checkLowerAlphabet && checkNumber && checkSpecialCaseCharacter)
	{
		validationResponse(true, passwordObject);
		//alert("all true");
		return true;
	}
	else
	{
		var response = "Values not added: ";
		if(!(checkUpperAlphabet))
		{
		   response += "Capital Alphabet ";
	    }
	    if(!(checkLowerAlphabet))
	    {
			response += "Lower Alphabet ";
	    }
		if(!(checkNumber))
	    {
			response += "Number ";
	    }
		if(!(checkSpecialCaseCharacter))
	    {
			response += "Special Case Character ";
	    }
		validationResponse(false, passwordObject);
		incorrectPassword.innerHTML = response;
		//alert("all not true");
		return false;
	}
	
}

function checkPassword(password1, password2)
{
	debugger;
	if(password1.value == password2.value)
	{
		validationResponse(true, password2);
		return true;
	}
	validationResponse(false, password2);
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