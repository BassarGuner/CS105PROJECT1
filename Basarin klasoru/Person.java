abstract class Person {
    private String id;
    private String name;
    private String email;
    private static int idcount = 0001;
    
    public Person(String name){
        this.name = name;
        this.id = generateId(name);
        initEmail();
    }
    abstract void initEmail();

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    private String generateId(String name){
        String[] parts = name.split(" ");
        String initial = parts[0].substring(0,1) + parts[parts.length-1].substring(0,1);
        return initial + String.format("%04d", idcount++);
    }

    @Override
    public String toString(){
            return "";
        
    }
}
