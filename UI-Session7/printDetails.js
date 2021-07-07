function loadContent() 
{
    var details = document.getElementById("data");

    for(var i = 0; i < localStorage.length; i++) 
    {
        var key = localStorage.key(i);

        var parentDiv = document.createElement("div");
        parentDiv.className = "detail";
        details.appendChild(parentDiv);

        var newLabel = document.createElement("div");
        newLabel.className = "label";
        newLabel.innerHTML = key;
        parentDiv.appendChild(newLabel);

        var newValue = document.createElement("div");
        newValue.className = "value";
        newValue.innerHTML = localStorage.getItem(key);
        parentDiv.appendChild(newValue);
    }
}