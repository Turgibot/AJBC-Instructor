package ajbc.io.object_reader_writer;

import java.io.Serializable;

class Dog implements Serializable {

	private static final long serialVersionUID = 491320536947310540L;
	String name;
    String breed;

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

	@Override
	public String toString() {
		return "Dog [name=" + name + ", breed=" + breed + "]";
	}
    
    
}