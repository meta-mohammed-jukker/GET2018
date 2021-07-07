function Stack() 
{
    this.size = -1;
    this.stackStorage = {};
}

Stack.prototype.push = function(data) 
{
    this.size++;
    this.stackStorage[this.size] = data;
};

Stack.prototype.pop = function() 
{
    var deletedData, message = 'Empty stack!';

    if(!this.isEmpty()) 
    {
        deletedData = this.stackStorage[this.size];
        delete this.stackStorage[this.size];
        this.size--;

        return deletedData;
    }
    else 
    {
        throw new Error(message);
    }
};

Stack.prototype.peek = function()
{
    return this.stackStorage[this.size];
}

Stack.prototype.isEmpty = function() 
{
    if(this.size == -1) 
        return true;
    else
        return false;
};

Stack.prototype.showStackElements = function()
{
    for(var i = 0; i <= this.size; i++)
    {
        console.log(this.stackStorage[i]);
    }
}; 