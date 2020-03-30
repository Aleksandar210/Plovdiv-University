
public class Message {
private String title;
private String message;
private String dateOfEntry;
private String activationDate;
private String expireDate;
private String activationHour;
private String purposeOfMessage;

public Message(String title, String message,String dateOfEntry,String expireDate,String activationHour) {
	this.title = title;
	this.message = message;
	this.dateOfEntry =dateOfEntry;
	this.expireDate = expireDate;
	
	this.activationHour = activationHour;
	
}

@Override
public String toString() {
	return getTitle() + ". "+getMessage()+". "+ getActivationHour() +". " + getDateOfEntry()+ ". "+ getExpireDate();
	
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public String getDateOfEntry() {
	return dateOfEntry;
}

public void setDateOfEntry(String dateOfEntry) {
	this.dateOfEntry = dateOfEntry;
}

public String getActivationDate() {
	return activationDate;
}

public void setActivationDate(String activationDate) {
	this.activationDate = activationDate;
}

public String getExpireDate() {
	return expireDate;
}

public void setExpireDate(String expireDate) {
	this.expireDate = expireDate;
}

public String getActivationHour() {
	return activationHour;
}

public void setActivationHour(String activationHour) {
	this.activationHour = activationHour;
}

public String getPurposeOfMessage() {
	return purposeOfMessage;
}

public void setPurposeOfMessage(String purposeOfMessage) {
	this.purposeOfMessage = purposeOfMessage;
}
}
