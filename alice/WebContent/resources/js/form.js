function ucWords(string){
 var arrayWords;
 var returnString = "";
 var len;
 arrayWords = string.split(" ");
 len = arrayWords.length;
 for(i=0;i < len ;i++){
  if(i != (len-1)){
   returnString = returnString+ucFirst(arrayWords[i])+" ";
  }
  else{
   returnString = returnString+ucFirst(arrayWords[i]);
  }
 }
 return returnString;
}

function ucFirst(string){
 return string.substr(0,1).toUpperCase()+string.substr(1,string.length).toLowerCase();
}