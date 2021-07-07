function Queue()
{
    this.front = -1;
    this.rear = -1;
    this.queueStorage = {};
}

Queue.prototype.enqueue = function(data) 
{
    if(this.rear == -1)
    {
        this.front = this.rear = 0;
    }
    else
    {
        this.rear++;
    }

    this.queueStorage[this.rear] = data;
};

Queue.prototype.dequeue = function() 
{
    var deletedData;
    message = 'Empty queue!';
    if(this.front == -1)
    {
        throw new Error(message);
    }
    else
    { 
        deletedData = this.queueStorage[this.front]; 

        if(this.front == this.rear)
            this.front = this.rear = -1;
        else 
            this.front++;
        return deletedData; 
    }   
};

Queue.prototype.print = function() 
{

    for(var i = this.front; i <= this.rear; i++)
    {
        console.log(this.queueStorage[i]);
    }
}