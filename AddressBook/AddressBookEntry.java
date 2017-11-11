class AddressBookEntry {
  
  private String name;
  private String emailAddress;
  private String phoneNumber;
  
  public AddressBookEntry(){}
  
  public void setName(String name){
    this.name = name;
  }  
  public String getName(){
    return this.name;
  }
  
  
  public void setEmailAddress(String email){
    this.emailAddress = email;
  }  
  public String getEmailAddress(){
    return this.emailAddress;
  }
  
  
  public void setPhoneNumber(String phone){
    this.phoneNumber = phone;
  }  
  public String getPhoneNumber(){
    return this.phoneNumber;
  }
  
}