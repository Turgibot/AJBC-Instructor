package ajbc.json;

import com.google.gson.annotations.SerializedName;

public class User {
	@SerializedName("full_name")
    private String name;
	
	@SerializedName("e_mail")
    private String email;
	
    private int age;
    private boolean isDeveloper;
    
    //for GSON : https://stackoverflow.com/questions/18645050/is-default-no-args-constructor-mandatory-for-gson 
    public User() {}
    
	public User(String name, String email, int age, boolean isDeveloper) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.isDeveloper = isDeveloper;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", age=" + age + ", isDeveloper=" + isDeveloper + "]";
	}
    
                  
}
