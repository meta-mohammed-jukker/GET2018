function validateSignupForm()
{
    var firstName = document.forms["contact-us-form"]["firstName"];
    var lastName = document.forms["contact-us-form"]["lastName"];
    var contactNumber = document.forms["contact-us-form"]["phoneNumber"];
    var email = document.forms["contact-us-form"]["email"];

    if( validateName(firstName) && validateName(lastName) && validateContactNumber(contactNumber) && 
       validateEmail(email))
    {
        addToLocalStorage();
        return true;
    }
    else
    {
        validateName(firstName);
        validateName(lastName);
        validateEmail(email);
        validateContactNumber(contactNumber);
        return false;
    }
}

function addToLocalStorage()
{
    localStorage.clear();

    localStorage.setItem("First Name", document.getElementById("firstName").value);

    localStorage.setItem("Last Name", document.getElementById("lastName").value);

    localStorage.setItem("Email", document.getElementById("email").value);

    localStorage.setItem("Phone Number", document.getElementById("phoneNumber").value);

    var address = document.getElementById("address");
    if(address.value != "")
    {
        localStorage.setItem("Address", address.value);
    }

    var city = document.getElementById("city");
    if(city.value != "")
    {
        localStorage.setItem("City", city.value);
    }

    localStorage.setItem("State", document.getElementById("state").value);

    var project = document.getElementById("description");
    if(project != null) {
        localStorage.setItem("Project Description", project.value);
    }            

    var website = document.getElementById("website");
    if(website != null && website.value != "") {
        localStorage.setItem("Website or domain name", website.value);
    }

    var zipcode = document.getElementById("zipcode");
    if(zipcode != null) {
        localStorage.setItem("Zip Code", zipcode.value);
    }

    var yesHosting = document.getElementById("yesHosting");
    var noHosting = document.getElementById("noHosting");

    if(yesHosting != null && yesHosting.checked) {
        localStorage.setItem("Has Hosting", yesHosting.value);
    }
    else if(noHosting != null && noHosting.checked) {
        localStorage.setItem("Has Hosting", noHosting.value);
    }
}

function validateName(name)
{
    removeErrorMessage(name);

    var upperName = name.value.toUpperCase();

    if(upperName.length < 2)
    {
        showError("length should be greater than 2", name);
        validationResponse(false, name);
        return false;
    }

    var i;
    for(i=0; i<upperName.length; i++)
    {
        // if character is not alphabet or blank space then return false
        if((upperName.charCodeAt(i) < 65 || upperName.charCodeAt(i) > 90) && upperName.charCodeAt(i) != 32)
        {
            showError("Character other than alphabets not allowed", name);

            validationResponse(false, name);
            return false;
        }
    }
    validationResponse(true, name);
    return true;
}

function validateEmail(email)
{
    removeErrorMessage(email);
    
    if(email.value.length > 5 && email.value.indexOf("@") < email.value.lastIndexOf(".") &&
       email.value.indexOf("@") > 0 && email.value.indexOf("@") < (email.value.length - 4) && 
       email.value.indexOf(".") != -1 && email.value.indexOf(".") < (email.value.length - 2))
    {
        validationResponse(true, email);
        return true;
    }

    showError("Email not valid", email);

    validationResponse(false, email);
    return false;
}

function validateContactNumber(contactNumber)
{
    removeErrorMessage(contactNumber);

    if(contactNumber.value.length < 9)
    {
        showError("Length should be greater than 9", contactNumber);
        validationResponse(false, contactNumber);
        return false;
    }

    var i;
    for(i=0; i<contactNumber.value.length; i++)
    {
        if(contactNumber.value.charCodeAt(i) < 48 || contactNumber.value.charCodeAt(i) > 57)
        {
            showError("Characters other than numbers not allowed", contactNumber);
            validationResponse(false, contactNumber);
            return false;
        }
    }
    validationResponse(true, contactNumber);
    return true;

}

function validationResponse(response, object)
{
    if(response)
    {
        object.style.border = "3px solid green";
    }
    else
    {
        object.style.border = "3px solid red";
    }
}

function furtherOptions(event) 
{
    removeOptionalElements();

    if (this.options[this.selectedIndex].text == 'Rajasthan') 
    {
        addDomainName();
        addProjDesc();
    }

    if (this.options[this.selectedIndex].text == 'Haryana') 
    {
        addZipCode();
        addHosting();
    }

    if (this.options[this.selectedIndex].text == 'Maharashtra') 
    {
        addZipCode();
        addProjDesc();
    }
}


/*Shows error message*/
function showError(error, element)
{
    var span = document.createElement('span');

    span.className = 'error-message';

    var errorMessage = document.createTextNode(error);

    span.appendChild(errorMessage);

    element.parentNode.appendChild(span);
}

/*Remove elements*/
function removeErrorMessage(element) 
{

    var errorSpans = document.getElementsByClassName("error-message");

    var i;
    for(i=0; i<errorSpans.length; i++)
    {
        if(errorSpans[i].parentNode == element.parentNode)
        {
            element.parentNode.removeChild(errorSpans[i]);
            break;
        }
    }
}

/*Domain Name*/
function addDomainName() 
{

    var div = document.createElement('div');

    div.className = 'form-entry optional-element';

    div.innerHTML =
        '<div class="form-element title">\
Website or domain name\
</div>\
<div class="form-element form-entry-field">\
<div class="icon"><i class="fas fa-globe-asia"></i></div>\
<input class="input-field" type="url" name="website" id="website"   placeholder="Website or domain name" required />\
</div>';

    document.getElementById('contact-us-form').appendChild(div);
}

/*Project Description*/
function addProjDesc() 
{

    var div = document.createElement('div');

    div.className = 'form-entry optional-element';

    div.innerHTML =
        '<div class="form-element title">\
Project Description\
</div>\
<div class="form-element form-entry-field">\
<div class="icon"><i class="fa fa-pencil-alt"></i></div>\
<textarea class="input-field" name="description" id="description" placeholder="Project Description" rows="1" required></textarea>\
</div>';

    document.getElementById('contact-us-form').appendChild(div);
}

/*Zipcode*/
function addZipCode() 
{

    var div = document.createElement('div');

    div.className = 'form-entry optional-element';

    div.innerHTML =
        '<div class="form-element title">\
Zip Code\
</div>\
<div class="form-element form-entry-field">\
<div class="icon"><i class="fa fa-home"></i></div>\
<input class="input-field" type="number" name="zipCode" id="zipcode" placeholder="Zip Code" max="999999" min="100000" required />\
</div>';

    document.getElementById('contact-us-form').appendChild(div);
}

/*Hosting*/
function addHosting() 
{

    var div = document.createElement('div');

    div.className = 'form-entry optional-element';

    div.innerHTML =
        '<div class="form-element title">\
Do you have hosting?\
</div>\
<div class="form-element form-entry-field">\
<input class="input-field" type="radio" name="hosting" id="yesHosting" value="Yes" required />Yes\
<input class="input-field" type="radio" name="hosting" id="noHosting" value="No" required />No\
</div>';

    document.getElementById('contact-us-form').appendChild(div);
}

/*Remove elements*/
function removeOptionalElements() 
{

    var elements = document.getElementsByClassName("optional-element");
    while(elements.length > 0)
    {
        elements[0].parentNode.removeChild(elements[0]);
    }
}