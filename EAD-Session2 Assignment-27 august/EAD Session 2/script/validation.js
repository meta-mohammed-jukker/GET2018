function validateSignupForm()
{
	var firstName = document.forms["signupForm"]["firstName"];
	var lastName = document.forms["signupForm"]["lastName"];
	var contactNumber = document.forms["signupForm"]["contactNumber"];
	var email = document.forms["signupForm"]["email"];
	var password = document.forms["signupForm"]["password"];
	var confirmPassword = document.forms["signupForm"]["confirmPassword"];
	
	return validateName(firstName) && validateName(lastName) && validateContactNumber(contactNumber) && 
		   validateEmail(email) && validatePassword(password) && checkPassword(confirmPassword, password);
}

function validateLoginForm()
{
	var email = document.forms["loginForm"]["email"];
	var password = document.forms["loginForm"]["password"];
	
	return validateEmail(email) && validatePassword(password);
}

function validateName(name)
{
	var upperName = name.value.toUpperCase();
	
	if(upperName.length < 2)
	{
		name.style.border = "1px solid red";
		return false;
	}
	
	var i;
	for(i=0; i<upperName.length; i++)
	{
		if((upperName.charCodeAt(i) < 65 || upperName.charCodeAt(i) > 90) && upperName.charCodeAt(i) != 32)
		{
			name.style.border = "1px solid red";
			return false;
		}
	}
	name.style.border = "1px solid green";
	return true;
}

function validateContactNumber(contactNumber)
{
	if(contactNumber.value.length < 9)
	{
		contactNumber.style.border = "1px solid red";
		return false;
	}
	
	var i;
	for(i=0; i<contactNumber.value.length; i++)
	{
		if(contactNumber.value.charCodeAt(i) < 48 || contactNumber.value.charCodeAt(i) > 57)
		{
			contactNumber.style.border = "1px solid red";
			return false;
		}
	}
	contactNumber.style.border = "1px solid green";
	return true;
	
}

function validateEmail(email)
{
	if(email.value.length > 5 && email.value.indexOf("@") < email.value.lastIndexOf(".") &&
		email.value.indexOf("@") > 0 && email.value.indexOf("@") < (email.value.length - 4) && 
		email.value.indexOf(".") != -1 && email.value.indexOf(".") < (email.value.length - 2))
	{
		email.style.border = "1px solid green";
		return true;
	}
	email.style.border = "1px solid red";
	return false;
}

function validatePassword(passwordObject)
{
	var  password = passwordObject.value;
	
	if(password.length < 8)
	{
		passwordObject.style.border = "1px solid red";
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
		passwordObject.style.border = "1px solid green";
		//alert("all true");
		return true;
	}
	passwordObject.style.border = "1px solid red";
	//alert("all not true");
	return false;
}

function checkPassword(password1, password2)
{
	debugger;
	if(password1.value == password2.value)
	{
		password2.style.border = "1px solid green";
		return true;
	}
	password2.style.border = "1px solid red";
	return false;
}