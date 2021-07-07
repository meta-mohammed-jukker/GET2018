String.prototype.repeatify = function(count)
{
   var outputString = "";
   while(count > 0)
   {
       outputString += this;
       count--;
   }
   return outputString;
}; 
